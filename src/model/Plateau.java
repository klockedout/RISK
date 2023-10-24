package model;

import java.util.ArrayList;

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
	
	private void creerJoueurs() {
		String[] couleurs = new String[]{"bleu","jaune","rouge","vert","noir"};
		for (String couleur : couleurs) {
			this.joueurs.add(new Joueur(this.idPlateau,couleur));
		}
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

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public Joueur getJoueurActif() {
		return joueurActif;
	}

	public void setJoueurActif(Joueur joueurActif) {
		this.joueurActif = joueurActif;
	}

	public String getEtatPlateu() {
		return etatPlateu;
	}

	public void setEtatPlateu(String etatPlateu) {
		this.etatPlateu = etatPlateu;
	}

	public ArrayList<Continent> getContinents() {
		return continents;
	}

	public void setContinents(ArrayList<Continent> continents) {
		this.continents = continents;
	}

	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public ArrayList<CarteRisk> getPile() {
		return pile;
	}

	public void setPile(ArrayList<CarteRisk> pile) {
		this.pile = pile;
	}

    
	
}

