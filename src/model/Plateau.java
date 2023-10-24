package model;

import java.util.ArrayList;

public class Plateau extends AbstractModel{
	private TypeTerritoire TypeCase; 
	private Territoire [][] plateau  = new Territoire [100][100];
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
	 for (int x = 0; x < plateau.length; x++) { 
		 for (int y=0; y < plateau[x].length; y++) {
			 plateau[x][y] = new Territoire("Ocean",TypeCase.CHEMIN);
			}
		}
	 for (int x = 1; x < plateau.length - 1; x++) {
			for (int y = 1; y < plateau[x].length - 1; y++) {
				plateau[x][y] = new Territoire("Test",TypeCase.OCEAN);

			}
	 }
		
//		plateau[0][0] = new Territoire("France", TypeCase.CHEMIN);
	}
	
	private void creerJoueurs() {
		String[] couleurs = new String[]{"bleu","jaune","rouge","vert","noir"};
		for (String couleur : couleurs) {
			this.joueurs.add(new Joueur(this.idPlateau,couleur));
		}
	}
	
	private void creerContinents() {
		String[] nomsCont = new String[]{
				"Europe",
				"Asie",
				"Amérique du Nord",
				"Amérique du Sud",
				"Afrique",
				"Océanie"};
		
		for (String nomCont : nomsCont) {
			this.continents.add(new Continent(nomCont));
		}
	}
	
	private void creerTerritoires() {
		
		String[] nomsTerEurope = new String[] {
				"Grande-Bretagne",
				"Islande",
				"Europe du Nord",
				"Scandinavie",
				"Europe du Sud",
				"RUSSIE",
				"Europe de l'ouest"};
		String[] nomsTerAsie = new String[] {
				"Afghanistan",
				"Chine",
				"Inde",
				"Asie du sud-est",
				"Japon",
				"Kamtchatka",
				"Moyen-Orient",
				"Mongolie",
				"IRKOUTSK",
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
				"CANADA DE L'EST",
				"États de l'Ouest"};
		String[] nomsTerAmeriqueS = new String[] {
				"Argentine",
				"Brésil",
				"Pérou",
				"Venezuela"};
		String[] nomsTerAfrique = new String[] {
				"AFRIQUE CENTRALE",
				"Afrique orientale",
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
	
	// Je crée la pile de 
	private void creerPlile() {
	     
		//EUROPE
		 pile.add(new CarteRisk("Grande-Bretagne", TypeCarte.ARTILLERIE));
	     pile.add(new CarteRisk("Islande", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Europe du Nord", TypeCarte.ARTILLERIE));
	     pile.add(new CarteRisk("Scandinavie", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Europe du Sud", TypeCarte.ARTILLERIE));
	     pile.add(new CarteRisk("RUSSIE", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Europe de l'ouest", TypeCarte.ARTILLERIE));


		 //ASIE
	     pile.add(new CarteRisk("Afghanistan", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Chine", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Inde", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Asie du sud-est", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Japon", TypeCarte.ARTILLERIE));
	     pile.add(new CarteRisk("Kamtchatka", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Moyen-Orient", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Mongolie", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("IRKOUTSK", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Sibérie", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Oural", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Yakoutie", TypeCarte.CAVALERIE));
	     
	     // AMÉRIQUE DU NORD
	     pile.add(new CarteRisk("Alaska", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Alberta", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Amérique centrale", TypeCarte.ARTILLERIE));
	     pile.add(new CarteRisk("États de l'Est", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Groenland", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Territoires du Nord-Ouest", TypeCarte.ARTILLERIE));
	     pile.add(new CarteRisk("Ontario", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("CANADA DE L'EST", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("États de l'Ouest", TypeCarte.ARTILLERIE));
	     
	     //AMÉRIQUE DU SUD 
	     pile.add(new CarteRisk("Argentine", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Brésil", TypeCarte.ARTILLERIE));
	     pile.add(new CarteRisk("Pérou", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Venezuela", TypeCarte.INFANTERIE));
	     
	     
	     //AFRIQUE
	     pile.add(new CarteRisk("AFRIQUE CENTRALE", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Afrique orientale", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Égypte", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Madagascar", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Afrique du Nord", TypeCarte.CAVALERIE));
	     pile.add(new CarteRisk("Afrique du Sud", TypeCarte.ARTILLERIE));
	     
	     //AUSTRALIE
	     pile.add(new CarteRisk("Australie Orientale", TypeCarte.ARTILLERIE));
	     pile.add(new CarteRisk("Indonésie", TypeCarte.ARTILLERIE));
	     pile.add(new CarteRisk("Nouvelle-Guinée", TypeCarte.INFANTERIE));
	     pile.add(new CarteRisk("Australie Occidentale", TypeCarte.ARTILLERIE));
	     
	     //JOKER
	     pile.add(new CarteRisk("JOKER", TypeCarte.JOKER));
	     pile.add(new CarteRisk("JOKER", TypeCarte.JOKER));
	     
	     
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
		return plateau[x][y].getTypeTerritoire();
	}

	@Override
	public Joueur getVainqueur(int x, int y) {
		// TODO Auto-generated method stub
		return this.plateau[x][y].getVainqueur();
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

