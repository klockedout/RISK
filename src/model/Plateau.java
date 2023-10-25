package model;

import java.util.ArrayList;

public class Plateau extends AbstractModel {
	private TypeTerritoire TypeCase;
	private Continent[][] plateau = new Continent[50][30];
	static private int idPlateau = 0;
	private int tour = 0;
	private Joueur joueurActif;
	private String etatPlateu;
	private ArrayList<Territoire> listeTerritoire;
	private ArrayList<Joueur> joueurs;
	private ArrayList<CarteRisk> pile;

	public Plateau(int idPlateau) {
		/*
		 * this.creerContinents(); this.creerJoueurs(); this.creerPlile();
		 * this.idPlateau+=1;
		 */

		// Larissa : ajout de bordure et ocean
		for (int x = 0; x < plateau.length; x++) {
			for (int y = 0; y < plateau[x].length; y++) {
				plateau[x][y] = new Continent("Bordure", TypeCase.BORDURE);
			}
		}
		for (int x = 1; x < plateau.length - 1; x++) {
			for (int y = 1; y < plateau[x].length - 1; y++) {
				plateau[x][y] = new Continent("Ocean", TypeCase.OCEAN);

			}
		}
		// Larissa : ajout continent
		for (int x = 3; x < 16; x++) {
			for (int y = 5; y < 13; y++) {
				this.plateau[x][y] = ameriqueNord;
			}
		}
		// groenland
		for (int x = 8; x < 14; x++) {
			for (int y = 2; y < 4; y++) {
				this.plateau[x][y] = ameriqueNord;
				this.plateau[x][y].setTerritoire(new Territoire("Groenland"));
			}
		}
		// alaska
		for (int x = 2; x < 3; x++) {
			for (int y = 5; y < 7; y++) {
				this.plateau[x][y] = ameriqueNord;
				
			}
		}
		for (int x = 3; x < 17; x++) {
			for (int y = 13; y < 27; y++) {
				this.plateau[x][y] = ameriqueSud;
			}
		}
		for (int x = 18; x <= 30; x++) {
			for (int y = 2; y < 11; y++) {
				this.plateau[x][y] = europe;
			}
		}

		// continent afrique
		for (int x = 18; x < 27; x++) {
			for (int y = 12; y < 27; y++) {
				this.plateau[x][y] = afrique;
			}
		}
		// madagascar
		for (int x = 28; x < 30; x++) {
			for (int y = 22; y < 27; y++) {
				this.plateau[x][y] = afrique;
				this.plateau[x][y].setTerritoire(new Territoire("Madagascar"));
			}
		}
		for (int x = 31; x < 44; x++) {
			for (int y = 2; y < 14; y++) {
				this.plateau[x][y] = asie;
			}
		}
		// moyen orient
		for (int x = 27; x < 31; x++) {
			for (int y = 11; y < 16; y++) {
				this.plateau[x][y] = asie;
				this.plateau[x][y].setTerritoire(new Territoire("Moyen Orient"));
			}
		}
		// inde
		for (int x = 34; x < 37; x++) {
			for (int y = 13; y < 17; y++) {
				this.plateau[x][y] = asie;
				this.plateau[x][y].setTerritoire(new Territoire("Inde"));
			}
		}
		// asie du sud
		for (int x = 39; x < 42; x++) {
			for (int y = 13; y < 16; y++) {
				this.plateau[x][y] = asie;
				this.plateau[x][y].setTerritoire(new Territoire("Asie du Sud"));
			}
		}
		// japon
		for (int x = 45; x < 47; x++) {
			for (int y = 7; y < 10; y++) {
				this.plateau[x][y] = asie;
				this.plateau[x][y].setTerritoire(new Territoire("Japon"));
			}
		}
		// karou
		for (int x = 44; x < 47; x++) {
			for (int y = 2; y < 6; y++) {
				this.plateau[x][y] = asie;
				this.plateau[x][y].setTerritoire(new Territoire("Kamtchatka"));
			}
		}
		for (int x = 37; x < 47; x++) {
			for (int y = 17; y < 27; y++) {
				this.plateau[x][y] = oceanie;
			}
		}
		

		// bout d'ocean
		for (int x = 7; x < 12; x++) {
			for (int y = 13; y < 14; y++) {
				this.plateau[x][y] = new Continent("Ocean", TypeCase.OCEAN);
			}
		}

		this.plateau[3][13] = new Continent("Ocean", TypeCase.OCEAN);

		for (int x = 18; x <= 21; x++) {
			for (int y = 2; y <= 5; y++) {
				this.plateau[x][y] = new Continent("Ocean", TypeCase.OCEAN);
			}
		}
		for (int x = 12; x <= 16; x++) {
			this.plateau[x][13] = new Continent("Ocean", TypeCase.OCEAN);
		}
		for (int x = 13; x <= 17; x++) {
			for (int y = 20; y <= 27; y++) {
				this.plateau[x][y] = new Continent("Ocean", TypeCase.OCEAN);
			}
		}
		this.plateau[22][5] = new Continent("Ocean", TypeCase.OCEAN);
		this.plateau[23][5] = new Continent("Ocean", TypeCase.OCEAN);

		// islande
		for (int x = 19; x <= 20; x++) {
			for (int y = 2; y < 3; y++) {
				this.plateau[x][y] = europe;
				this.plateau[x][y].setTerritoire(new Territoire("Islande"));
			}
		}
		// RU
		for (int x = 17; x <= 18; x++) {
			for (int y = 4; y < 5; y++) {
				this.plateau[x][y] = europe;
				this.plateau[x][y].setTerritoire(new Territoire("Grande Bretagne"));
			}
		}
		for (int x = 18; x < 22; x++) {
			for (int y = 20; y < 27; y++) {
				this.plateau[x][y] = new Continent("Ocean", TypeTerritoire.OCEAN);
			}
		}
		//les vois maritimes 
		// groenland
		this.plateau[9][4] = new Continent(" ",TypeCase.FLECHE_HAUT);
		this.plateau[11][4] = new Continent(" ",TypeCase.FLECHE_HAUT);
		this.plateau[13][4]= new Continent(" ",TypeCase.FLECHE_HAUT);


	}

	private void creerJoueurs() {
		String[] couleurs = new String[] { "bleu", "jaune", "rouge", "vert", "noir" };
		for (String couleur : couleurs) {
			this.joueurs.add(new Joueur(this.idPlateau, couleur));
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
	// Larissa : creation continent
	Continent afrique = new Continent("Afrique", TypeTerritoire.AFRIQUE); // couleur : rouge
	Continent europe = new Continent("Europe", TypeTerritoire.EUROPE); // couleur : bleu
	Continent asie = new Continent("Asie", TypeTerritoire.ASIE); // vert
	Continent ameriqueSud = new Continent("Amerique du Sud", TypeTerritoire.AMERIQUESUD); // orange
	Continent ameriqueNord = new Continent("Amerique du Nord", TypeTerritoire.AMERIQUEN); // jaune
	Continent oceanie = new Continent("Oceanie", TypeTerritoire.OCEANIE); // rose

//	private void creerTerritoires() {
//		String[] nomsTerEurope = new String[] { "Grande-Bretagne", "Islande", "Europe du Nord", "Scandinavie",
//				"Europe du Sud", "Ukraine", "Europe occidentale" };
//		String[] nomsTerAsie = new String[] { "Afghanistan", "Chine", "Inde", "Tchita", "Japon", "Kamtchatka",
//				"Moyen-Orient", "Mongolie", "Siam", "Sibérie", "Oural", "Yakoutie" };
//		String[] nomsTerAmeriqueN = new String[] { "Alaska", "Alberta", "Amérique centrale", "États de l'Est",
//				"Groenland", "Territoires du Nord-Ouest", "Ontario", "Québec", "États de l'Ouest" };
//		String[] nomsTerAmeriqueS = new String[] { "Argentine", "Brésil", "Pérou", "Venezuela" };
//		String[] nomsTerAfrique = new String[] { "Congo", "Afrique de l’Est", "Égypte", "Madagascar", "Afrique du Nord",
//				"Afrique du Sud" };
//		String[] nomsTerOceanie = new String[] { "Australie Orientale", "Indonésie", "Nouvelle-Guinée",
//				"Australie Occidentale" };
//		// for (String nomTerEu : th )
//	}

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

	@Override
	public TypeTerritoire getTypeTerritoire(int x, int y) {
		return plateau[x][y].getTypeTerritoire();
	}

	@Override
	public Joueur getVainqueur(int x, int y) {
		// TODO Auto-generated method stub
		// return this.plateau[x][y].getVainqueur();
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

}
