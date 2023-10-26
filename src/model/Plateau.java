package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Plateau extends AbstractModel{
	private TypeTerritoire TypeCase; 
	private Continent [][] plateau  = new Continent [70][50];
	static private int idPlateau=0;
	private int tour=0;
	private Joueur joueurActif;
	private String etatPlateu;
	private ArrayList<Continent> continents;
	private ArrayList<Joueur> listeJoueurs;
	private ArrayList<CarteRisk> pile;
	HashMap<Joueur,Territoire> territoiresControles = new HashMap<Joueur, Territoire>();
	HashMap<String, Integer> territoiresConquis = new HashMap<String, Integer>();
	HashMap<Continent, Territoire[]> continentTerritoires= new HashMap<Continent, Territoire[]>();

	public Plateau(int idPlateau) {
		
		/*this.creerContinents();
		this.creerJoueurs();
		this.creerPlile();
		this.idPlateau+=1;*/
		
	//Larissa : ajout de bordure et ocean 
	 for (int x = 0; x < plateau.length; x++) { 
		 for (int y=0; y < plateau[x].length; y++) {
			 plateau[x][y] = new Continent("Bordure",TypeCase.BORDURE);
			}
		}
	 for (int x = 1; x < plateau.length - 1; x++) {
			for (int y = 1; y < plateau[x].length - 1; y++) {
				plateau[x][y] = new Continent("Ocean",TypeCase.OCEAN);

			}
	 }
	}
	//FARKI Imane
	private void creerJoueurs(String couleur, int nbRegiment) {
		this.listeJoueurs.add(new Joueur(this.idPlateau, couleur, nbRegiment));
		/*String[] couleurs = new String[]{"bleu","jaune","rouge","vert","noir"};
		for (String couleur : couleurs) {
			this.joueurs.add(new Joueur(this.idPlateau,couleur));
		}*/
	}
//	Larissa 
//	private void creerContinents() {
//		String[] nomsCont = new String[]{
//				"Europe",
//				"Asie",
//				"Amérique du Nord",
//				"Amérique du Sud",
//				"Afrique",
//				"Océanie"};
//		for (String nomCont : nomsCont) {
//			this.continents.add(new Continent(nomCont));
//		}
//	}
	
	
//Larissa(+)
	//Larissa : creation continent
	 Continent afrique = new Continent("Afrique", TypeTerritoire.AFRIQUE); //couleur : rouge
	 Continent europe = new Continent("Europe", TypeTerritoire.EUROPE); // couleur : bleu
	 Continent asie = new Continent("Asie", TypeTerritoire.ASIE); //vert
	 Continent ameriqueSud = new Continent("Amerique du Sud", TypeTerritoire.AMERIQUESUD); //orange
	 Continent ameriqueNord = new Continent("Amerique du Nord", TypeTerritoire.AMERIQUEN); //jaune
	 Continent oceanie = new Continent("Oceanie", TypeTerritoire.OCEANIE); // rose
	 // creation territoire 
	
	private void creerTerritoires() {
		String[] nomsTerEurope = new String[] {
				"Grande-Bretagne",
				"Islande",
				"Europe du Nord",
				"Scandinavie",
				"Europe du Sud",
				"Ukraine",
				"Europe occidentale"};
		String[] nomsTerAsie = new String[] {
				"Afghanistan",
				"Chine",
				"Inde",
				"Tchita",
				"Japon",
				"Kamtchatka",
				"Moyen-Orient",
				"Mongolie",
				"Siam",
				"Sibérie",
				"Oural",
				"Yakoutie"
				};
		String[] nomsTerAmeriqueN = new String[] {
				"Alaska",
				"Alberta",
				"Amérique centrale",
				"États de l'Est",
				"Groenland",
				"Territoires du Nord-Ouest",
				"Ontario",
				"Québec",
				"États de l'Ouest"};
		String[] nomsTerAmeriqueS = new String[] {
				"Argentine",
				"Brésil",
				"Pérou",
				"Venezuela"};
		String[] nomsTerAfrique = new String[] {
				"Congo",
				"Afrique de l’Est",
				"Égypte",
				"Madagascar",
				"Afrique du Nord",
				"Afrique du Sud"};
		String[] nomsTerOceanie = new String[] {
				"Australie Orientale",
				"Indonésie",
				"Nouvelle-Guinée",
				"Australie Occidentale"
};
		//for (String nomTerEu : th )
	}
	
	//FARKI Imane
    public void attribuerTerritoire(Territoire territoire, Joueur joueur) {
        territoiresControles.put(joueur, territoire);
    }

    /*//FARKI Imane
     * public boolean territoireControle(Territoire territoire, Joueur joueur) {
		
		return territoiresControles.containsKey(joueur);
    }

    public ArrayList<Territoire> getTerritoiresControles(Joueur joueur) {
        ArrayList<Territoire> listTer = new ArrayList<Territoire>();
        for (Territoire territoire : territoiresControles.keySet()) {
            if (territoireControle(territoire, joueur)) {
            	listeTer.add(territoire);
            }
        }
        return listTer;
    }*/
    
  //FARKI Imane : retourner le nombre de continents conquis par un joueur donné
	public int getContinentJoueur(Joueur joueur) {
		int cpt = 0;
        ArrayList<Territoire> territoiresJoueur = joueur.getListeTerritoire();
		for (Continent continent : continentTerritoires.keySet()) {
            ArrayList<Territoire> territoires = continent.getListTerritoire();
			if (territoiresJoueur.contains((Object)territoires))
				cpt = cpt+1;
		}
        return cpt;
    }
	//FARKI Imane : retourner le nombre de territoires conquis par un joueur donné
	    public int getNombreTerritoiresControles(Joueur joueur) {
           return  joueur.getListeTerritoire().size();
    }
           
	  //FARKI Imane 
	    public void calculerScore(Joueur joueur) {
			int score = 0;
			
	    	//Connection connection;
			//connection = ConnexionBD.getConnexion();

	    	int nombreContinent = getContinentJoueur(joueur);
			 
			if(nombreContinent >= 3)
				score = 10;
			else {
				Collections.sort(listeJoueurs,(j1,j2) -> j1.getListeTerritoire().size() - j2.getListeTerritoire().size());
				for(int i=0; i<listeJoueurs.size(); i++) {
					if(listeJoueurs.get(i).equals(joueur)) {
					switch (i) {
			        case 1:
			            score = 8;
			            break;
			        case 2:
			            score = 6;
			            break;
			        case 3:
			            score = 4;
			            break;
			        case 4:
			            score = 2;
			            break;
			        case 5:
			            score = 0;
			            break;
			        
					
				}      
			}
				}
	    	
	        String req = "INSERT INTO scorejoueur (scoreJoueur, joueur) VALUES (?, joueur = (SELECT numInscription FROM joueur WHERE nomJoueur = ?)))";
	        //PreparedStatement statement = null;

			String url = "jdbc:mysql://localhost:3306/risk";
	        String utilisateur = "root";
	        String motDePasse = "";

	            try {
	            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

	            PreparedStatement statement = connexion.prepareStatement(req);
	        	        
	            statement = connexion.prepareStatement(req);
	            statement.setInt(1, score);
	            statement.setString(2, joueur.getNom());
	            statement.executeUpdate();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	    }
	    
	    }
	    
	   /*for(Joueur joueur : listeJoueurs) {
        territoiresConquis.put(joueur, getNombreTerritoiresControles(joueur));}*/
	    
	    
	  //FARKI Imane : afficher les resultats des joueurs
	  public void afficherRes() {
		
		//Connection connection;
		//connection = ConnexionBD.getConnexion();
		
    	String url = "jdbc:mysql://localhost:3306/risk";
        String utilisateur = "root";
        String motDePasse = "";

            try {
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            Statement statement = connexion.createStatement();
		            
	         String req = "SELECT j.nomJoueur, s.scoreJoueur FROM scorejoueur s, joueur j WHERE j.numInscription = s.joueur ORDER BY scoreJoueur DESC";
	    
	        //statement = connexion.prepareStatement(req);
	            ResultSet resultSet = statement.executeQuery(req);
	            System.out.println("Classement des joueurs :");
	            while (resultSet.next()) {
	                String nomJoueur = resultSet.getString("nomJoueur");
	                int score = resultSet.getInt("scoreJoueur");
	                System.out.println("Joueur : " + nomJoueur + ", Score : " + score);
	            }
	            statement.close();
	           } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}
	//FARKI Imane 
	//Le territoire de départ c'est le territoire qui a 2 regiments
	public ArrayList<Territoire> getTerritoireDepart(Joueur joueurActif) {
	    ArrayList<Territoire> territoiresDepart = new ArrayList<>();

	    for (Territoire territoire : joueurActif.getListeTerritoire()) {
	        if (territoire.getNbRegTer() == 2) {
	        	territoiresDepart.add(territoire);
	        }
	    }

	    return territoiresDepart;
	}
	    
	//FARKI Imane   
	public TypeTerritoire getTypeTerritoire() {
		return this.TypeCase;
	}
	
	private void creerPlile() {
		
	}

	@Override
	public int getLargeur() {
		// TODO Auto-generated method stub
		return this.plateau[0].length;
	}

	@Override
	public int getHauteur() {
		// TODO Auto-generated method stub
		return this.plateau.length;
	}

	public boolean partieTerminer() {
		return false;
	}
	//FARKI Imane
	public static int getIdPlateau() {
		return idPlateau;
	}
	@Override
	public TypeTerritoire getTypeTerritoire(int x, int y) {
		//return plateau[x][y].getTypeTerritoire();
		return null;
	}

	@Override
	public Joueur getVainqueur(int x, int y) {
		// TODO Auto-generated method stub
		//return this.plateau[x][y].getVainqueur();
		return null;
	}

	@Override
	public int getNbRegimentPlacés() {
		// on parcourt la liste des joueur et on prendre le nombre de regiment
		return 0; 
	}

	@Override
	public int getNbRegiment() {
		// TODO Auto-generated method stub
		return 0;
	}


	public static void setIdPlateau(int idPlateau) {
		Plateau.idPlateau = idPlateau;
	}
	//FARKI Imane
	public int getTour() {
		return tour;
	}
	//FARKI Imane
	public void setTour(int tour) {
		this.tour = tour;
	}
	//FARKI Imane
	public Joueur getJoueurActif() {
		return joueurActif;
	}
	//FARKI Imane
	public void setJoueurActif(Joueur joueurActif) {
		this.joueurActif = joueurActif;
	}
	//FARKI Imane
	public String getEtatPlateu() {
		return etatPlateu;
	}
	//FARKI Imane
	public void setEtatPlateu(String etatPlateu) {
		this.etatPlateu = etatPlateu;
	}
	//FARKI Imane
	public ArrayList<Continent> getContinents() {
		return continents;
	}
	//FARKI Imane
	public void setContinents(ArrayList<Continent> continents) {
		this.continents = continents;
	}

	/*public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}*/
	//FARKI Imane
	public ArrayList<CarteRisk> getPile() {
		return pile;
	}
	//FARKI Imane
	public void setPile(ArrayList<CarteRisk> pile) {
		this.pile = pile;
	}
	
}

