package model;

import java.util.ArrayList;

public class Plateau extends AbstractModel{
	private TypeTerritoire TypeCase; 
	private Territoire [][] plateau  = new Territoire [10][10];
	static private int idPlateau=0;
	private int tour=0;
	private Joueur joueurActif;
	private String etatPlateu;
	private ArrayList<Continent> continents;
	private ArrayList<Joueur> joueurs;
	private ArrayList<CarteRisk> pile;
	
	public Plateau(int idPlateau) {
		/*this.creerContinents();
		this.creerJoueurs();
		this.creerPlile();
		this.idPlateau+=1;*/
	 for (int x = 0; x < plateau.length; x++) { 
		 for (int y=0; y < plateau[x].length; y++) {
			 plateau[x][y] = new Territoire("Ocean",TypeCase.OCEAN);
			}
		}
		/*for (int x = 1; x < plateau.length - 1; x++) {
			for (int y = 1; y < plateau[x].length - 1; y++) {
				plateau[x][y] = new Territoire("Test",TypeCase.CHEMIN);

			}
		}*/
	}
	
	private void creerJoueurs() {
		String[] couleurs = new String[]{"bleu","jaune","rouge","vert","noir"};
		for (String couleur : couleurs) {
			this.joueurs.add(new Joueur(this.idPlateau,couleur));
		}
	}
	
	/*private void creerContinents() {
		String[] nomsCont = new String[]{
				"Europe",
				"Aise",
				"Amérique du Nord",
				"Amérique du Sud",
				"Afrique",
				"Océanie"};
		for (String nomCont : nomsCont) {
			this.continents.add(new Continent(nomCont));
		}
	}*/
	
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
		return plateau[x][y].getTypeTerritoire();
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

