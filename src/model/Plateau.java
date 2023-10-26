package model;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class Plateau extends AbstractModel {
	private TypeContinent typeCase;
	private Territoire[][] plateau = new Territoire[50][30];
	static private int idPlateau = 0;
	private int tour = 0;
	private Joueur joueurActif;
	private String etatPlateu;
	private ArrayList<Continent> continents;
	private ArrayList<Joueur> listeJoueurs;
//Larissa
	private ArrayList<Territoire> listeTerritoireVoisin;
	private ArrayList<Joueur> joueurs;
//Fin Larissa
	private ArrayList<CarteRisk> pile;
	
	public Plateau(int idPlateau) {
		/*this.creerContinents();
		this.creerJoueurs();
		this.creerPlile();
		this.idPlateau+=1;
		
	 for (int x = 0; x < plateau.length; x++) { 
		 for (int y=0; y < plateau[x].length; y++) {
			 plateau[x][y] = new Territoire("Ocean",TypeCase.OCEAN);
			}
		}
		for (int x = 1; x < plateau.length - 1; x++) {
			for (int y = 1; y < plateau[x].length - 1; y++) {
				plateau[x][y] = new Territoire("Test",TypeCase.CHEMIN);

	public Plateau(int idPlateau) {
		super();
		// Larissa : création de la carte 
		//1. On crée les oceans
		for (int x = 0; x < plateau.length; x++) {
			for (int y = 0; y < plateau[x].length; y++) {
				plateau[x][y] = new Territoire("Ocean", typeCase.OCEAN);
			}
		}
		//2. Ajout des territoires par continent 
		//Amerique : groenland
		for (int x = 8; x < 14; x++) {
			for (int y = 2; y < 4; y++) {
				this.plateau[x][y] = groenland;
			}
		}*/
	
	
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
		//Amerique : Alaska
		for (int x = 2; x < 5; x++) {
			for (int y = 5; y < 7; y++) {
				this.plateau[x][y] = alaska;
			}
		}
		//Amerique : nord Est
		for (int x = 5; x < 10; x++) {
			for (int y = 5; y < 7; y++) {
				this.plateau[x][y] = territoireNordOuest; 
				
			}
		}
		//Territoire de Ontario
		for (int x = 10; x < 12; x++) {
			for (int y = 5; y < 7; y++) {
				this.plateau[x][y] = ontario; 
				
			}
		}
		for (int x = 8; x < 12; x++) {
			for (int y = 7; y < 9; y++) {
				this.plateau[x][y] = ontario; 
				
			}
		}
		//Amerique : canada
		for (int x = 12; x < 15; x++) {
			for (int y = 5; y < 9; y++) {
				this.plateau[x][y] = canada; 
				
			}
		}
		//Alberta
		for (int x = 3; x < 8; x++) {
			for (int y = 7; y < 9; y++) {
				this.plateau[x][y] = alberta; 
				
			}
		}		
		//USA EST 
		for (int x = 9; x < 15; x++) {
			for (int y = 9; y < 13; y++) {
				this.plateau[x][y]= etatUnisEst; 
				
			}
		}
		//Amerique central
		for (int x = 3; x < 7; x++) {
			for (int y = 11; y < 13; y++) {
				this.plateau[x][y] = ameriqueCentrale; 
				
			}
		}
		//Amerique l'ouest
		for (int x = 3; x < 9; x++) {
			for (int y = 8; y < 11; y++) {
				this.plateau[x][y] = etatUnisOuest; 
				
			}
		}
		for (int x = 6; x < 9; x++) {
			for (int y = 11; y < 13; y++) {
				this.plateau[x][y] = etatUnisOuest; 
				
			}
		}
		
		//////////////AMERIQUE DU SUD /////////////
		//bresil 
		for (int x = 8; x < 16; x++) {
			for (int y = 14; y < 20; y++) {
				this.plateau[x][y] = bresil;
			}
		}
		//venezuela en deux partie 
		for (int x = 3; x < 8; x++) {
			for (int y = 14; y < 18; y++) {
				this.plateau[x][y] = venezuela;
			}
		}
		for (int x = 4; x < 7; x++) {
			for (int y = 13; y < 14; y++) {
				this.plateau[x][y] = venezuela;
			}
		}
		//perou
		for (int x = 3; x < 8; x++) {
			for (int y = 18; y < 21; y++) {
				this.plateau[x][y] = perou;
			}
		}
		//argentine en deux partie 
		for (int x = 3; x < 12; x++) {
			for (int y = 21; y < 27; y++) {
				this.plateau[x][y] = argentine;
			}
		}
		for (int x = 8; x < 12; x++) {
			for (int y = 20; y < 22; y++) {
				this.plateau[x][y] = argentine;
			}
		}
		//////////////EUROPE/////////////
		//scandinavie 
		for (int x = 21; x < 25; x++) {
			for (int y = 2; y < 5; y++) {
				this.plateau[x][y] = scandinavie;
			}
		}
		//russie en deux parties
		for (int x = 25; x < 31; x++) {
			for (int y = 2; y < 11; y++) {
				this.plateau[x][y] = russie;
			}
		}
		for (int x = 23; x < 25; x++) {
			for (int y = 5; y < 11; y++) {
				this.plateau[x][y] = russie;
			}
		}
		//europe du nord 
		for (int x = 17; x < 23; x++) {
			for (int y = 6; y < 8; y++) {
				this.plateau[x][y] = europeNord;
			}
		}
		//europe du l'ouest 
		for (int x = 17; x < 20; x++) {
			for (int y = 8; y < 11; y++) {
				this.plateau[x][y] = europeOuest;
			}
		}
		//europe du sud 
		for (int x = 20; x < 23; x++) {
			for (int y = 8; y < 11; y++) {
				this.plateau[x][y] = europeSud;
			}
		}
		
		// islande
		for (int x = 18; x < 20; x++) {
			for (int y = 2; y < 3; y++) {
				this.plateau[x][y] = islande;
			}
		}
		// RU
		for (int x = 16; x < 18; x++) {
			for (int y = 4; y < 5; y++) {
				this.plateau[x][y] = grandeBretagne;
			}
		}

		////////////// AFRIQUE /////////////
		//afrique du nord 
		for (int x = 17; x < 23; x++) {
			for (int y = 12; y < 17; y++) {
				this.plateau[x][y] = nordAfrique;
			}
		}
		//egypte 
		for (int x = 22; x < 27; x++) {
			for (int y = 12; y < 15; y++) {
				this.plateau[x][y] = egypte;
			}
		}
		//afrique centrale 
		for (int x = 17; x < 23; x++) {
			for (int y = 17; y < 20; y++) {
				this.plateau[x][y] = afriqueCentrale;
			}
		}
		//afrique orientale 
		for (int x = 22; x < 27; x++) {
			for (int y = 15; y < 20; y++) {
				this.plateau[x][y] = afriqueOrientale;
			}
		}
		//afrique du sud 
		for (int x = 23; x < 27; x++) {
			for (int y = 20; y < 28; y++) {
				this.plateau[x][y] = afriqueSud;
			}
		}
		// madagascar
		for (int x = 28; x < 30; x++) {
			for (int y = 22; y < 27; y++) {
				this.plateau[x][y] = madagascar;
			}
		}
		
		//////////////  ASIE  /////////////	
		//oural 
		for (int x = 31; x < 35; x++) {
			for (int y = 2; y < 7; y++) {
				this.plateau[x][y] = oural;
			}
		}
		//afghanistan
		for (int x = 31; x < 35; x++) {
			for (int y = 7; y < 12; y++) {
				this.plateau[x][y] = afghanistan;
			}
		}
		//siberia
		for (int x = 35; x < 38; x++) {
			for (int y = 2; y < 7; y++) {
				this.plateau[x][y] = siberie;
			}
		}
		//yajoutie 
		for (int x = 38; x < 41; x++) {
			for (int y = 2; y < 4; y++) {
				this.plateau[x][y] = yajoutie;
			}
		}
		//irtousk 
		for (int x = 38; x < 42; x++) {
			for (int y = 4; y < 7; y++) {
				this.plateau[x][y] = irtoutsk;
			}
		}
		//mongolie en deux partie
		for (int x = 38; x < 42; x++) {
			for (int y = 7; y < 10; y++) {
				this.plateau[x][y] = mongolie;
			}
		}
		for (int x = 42; x < 44; x++) {
			for (int y = 8; y < 10; y++) {
				this.plateau[x][y] = mongolie;
			}
		}
		//chine en trois partie 
		for (int x = 34; x < 38; x++) {
			for (int y = 7; y < 12; y++) {
				this.plateau[x][y] = chine;
			}
		}
		for (int x = 38; x < 42; x++) {
			for (int y = 10; y < 14; y++) {
				this.plateau[x][y] = chine;
			}
		}
		for (int x = 37; x < 38; x++) {
			for (int y = 12; y < 14; y++) {
				this.plateau[x][y] = chine;
			}
		}
		// moyen orient en deux partie 
		for (int x = 28; x < 31; x++) {
			for (int y = 11; y < 16; y++) {
				this.plateau[x][y] = moyenOrient;
			}
		}
		for (int x = 27; x < 28; x++) {
			for (int y = 11; y < 14; y++) {
				this.plateau[x][y] = moyenOrient;
			}
		}
		// inde en deux parties
		for (int x = 31; x < 37; x++) {
			for (int y = 12; y < 14; y++) {
				this.plateau[x][y] = inde;
			}
		}
		for (int x = 33; x < 37; x++) {
			for (int y = 13; y < 17; y++) {
				this.plateau[x][y] = inde;
			}
		}
		
		// asie du sud
		for (int x = 39; x < 42; x++) {
			for (int y = 13; y < 16; y++) {
				this.plateau[x][y] = asieSudEst;
			}
		}
		// japon
		for (int x = 45; x < 47; x++) {
			for (int y = 7; y < 10; y++) {
				this.plateau[x][y] = japon;
			}
		}
		// karou en trois partie 
		for (int x = 42; x < 47; x++) {
			for (int y = 2; y < 6; y++) {
				this.plateau[x][y] = kamchatka;
			}
		}
		for (int x = 42; x < 44; x++) {
			for (int y = 6; y < 8; y++) {
				this.plateau[x][y] = kamchatka;
			}
		}
		for (int x = 41; x < 42; x++) {
			for (int y = 2; y < 4; y++) {
				this.plateau[x][y] = kamchatka;
			}
		}
		
		//////////////  OCEANIE  /////////////
		//indonesie 
		for (int x = 37; x < 41; x++) {
			for (int y = 18; y < 20; y++) {
				this.plateau[x][y] = indonesie;
			}
		}
		//nouvelle guinée 
		for (int x = 42; x < 47; x++) {
			for (int y = 18; y < 20; y++) {
				this.plateau[x][y] = nouvelleGuinee;
			}
		}
		//autralie orientale 
		for (int x = 42; x < 47; x++) {
			for (int y = 21; y < 26; y++) {
				this.plateau[x][y] = australieOrientale;
			}
		}
		//autralie occidentale 
		for (int x = 37; x < 42; x++) {
			for (int y = 21; y < 26; y++) {
				this.plateau[x][y] = australieOccidentale;
			}
		}

		//les vois maritimes 
		// groenland
		this.plateau[9][4] = new Territoire(" ",typeCase.FLECHE_HAUT);
		this.plateau[11][4] = new Territoire(" ",typeCase.FLECHE_HAUT);
		this.plateau[13][4]= new Territoire(" ",typeCase.FLECHE_HAUT);
		this.plateau[0][5]= new Territoire(" ",typeCase.FLECHE_DROITE);
		this.plateau[1][5]= new Territoire(" ",typeCase.FLECHE_DROITE);
		//oceanie 
		this.plateau[41][18] = new Territoire(" ",typeCase.FLECHE_DROITE);
		this.plateau[44][20] = new Territoire(" ",typeCase.FLECHE_BAS);
		this.plateau[39][20] = new Territoire(" ",typeCase.FLECHE_BAS);
		this.plateau[39][16] = new Territoire(" ",typeCase.FLECHE_HAUT);
		this.plateau[39][17] = new Territoire(" ",typeCase.FLECHE_HAUT);
		//asie
		this.plateau[44][7].setTypeT(typeCase.FLECHE_DROITE);;
		this.plateau[44][9] = new Territoire(" ",typeCase.FLECHE_DROITE);
		for (int x = 47; x <= 49; x++) {
				this.plateau[x][3] = new Territoire(" ",typeCase.FLECHE_DROITE);
		}
		//afrique 
		this.plateau[16][15]= new Territoire(" ",typeCase.FLECHE_DROITE);
		this.plateau[18][11]= new Territoire(" ",typeCase.FLECHE_HAUT);
		this.plateau[21][11]= new Territoire(" ",typeCase.FLECHE_HAUT);
		this.plateau[23][11]= new Territoire(" ",typeCase.FLECHE_HAUT);
		this.plateau[27][23]= new Territoire(" ",typeCase.FLECHE_DROITE);
		this.plateau[27][15]= new Territoire(" ",typeCase.FLECHE_HAUT);
		//europe 
		
		
	
		/////// TERRITOIRE VOISIN ///
		
		islande.ajouterTerritoireVoisin(scandinavie);
		islande.ajouterTerritoireVoisin(groenland);
		islande.ajouterTerritoireVoisin(grandeBretagne);
		scandinavie.ajouterTerritoireVoisin(russie);
		scandinavie.ajouterTerritoireVoisin(islande);
		scandinavie.ajouterTerritoireVoisin(grandeBretagne);
		scandinavie.ajouterTerritoireVoisin(europeNord);
		grandeBretagne.ajouterTerritoireVoisin(scandinavie);
		grandeBretagne.ajouterTerritoireVoisin(europeOuest);
		grandeBretagne.ajouterTerritoireVoisin(islande);
		grandeBretagne.ajouterTerritoireVoisin(europeNord);
		europeNord.ajouterTerritoireVoisin(scandinavie);
		europeNord.ajouterTerritoireVoisin(europeSud);
		europeNord.ajouterTerritoireVoisin(russie);
		europeNord.ajouterTerritoireVoisin(islande);
		europeNord.ajouterTerritoireVoisin(grandeBretagne);
		russie.ajouterTerritoireVoisin(scandinavie);
		russie.ajouterTerritoireVoisin(europeNord);
		russie.ajouterTerritoireVoisin(europeSud);
		russie.ajouterTerritoireVoisin(afghanistan);
		russie.ajouterTerritoireVoisin(oural);
		russie.ajouterTerritoireVoisin(moyenOrient);
		europeOuest.ajouterTerritoireVoisin(europeNord);
		europeOuest.ajouterTerritoireVoisin(europeSud);
		europeOuest.ajouterTerritoireVoisin(nordAfrique);
		europeSud.ajouterTerritoireVoisin(moyenOrient);
		europeSud.ajouterTerritoireVoisin(europeNord);
		europeSud.ajouterTerritoireVoisin(russie);
		europeSud.ajouterTerritoireVoisin(nordAfrique);
		europeSud.ajouterTerritoireVoisin(egypte);
		
		nordAfrique.ajouterTerritoireVoisin(egypte);
		nordAfrique.ajouterTerritoireVoisin(europeOuest);
		nordAfrique.ajouterTerritoireVoisin(europeSud);
		nordAfrique.ajouterTerritoireVoisin(bresil);
		nordAfrique.ajouterTerritoireVoisin(afriqueOrientale);
		nordAfrique.ajouterTerritoireVoisin(afriqueCentrale);
		egypte.ajouterTerritoireVoisin(moyenOrient);
		egypte.ajouterTerritoireVoisin(europeSud);
		egypte.ajouterTerritoireVoisin(afriqueOrientale);
		afriqueOrientale.ajouterTerritoireVoisin(moyenOrient);
		afriqueOrientale.ajouterTerritoireVoisin(madagascar);
		afriqueOrientale.ajouterTerritoireVoisin(afriqueCentrale);
		afriqueOrientale.ajouterTerritoireVoisin(nordAfrique);
		afriqueOrientale.ajouterTerritoireVoisin(afriqueSud);
		afriqueOrientale.ajouterTerritoireVoisin(egypte);
		afriqueCentrale.ajouterTerritoireVoisin(afriqueOrientale);
		afriqueCentrale.ajouterTerritoireVoisin(nordAfrique);
		afriqueCentrale.ajouterTerritoireVoisin(afriqueSud);
		afriqueSud.ajouterTerritoireVoisin(afriqueCentrale);
		afriqueSud.ajouterTerritoireVoisin(afriqueOrientale);
		afriqueSud.ajouterTerritoireVoisin(madagascar);
		madagascar.ajouterTerritoireVoisin(afriqueOrientale);
		madagascar.ajouterTerritoireVoisin(afriqueSud);
		
		bresil.ajouterTerritoireVoisin(nordAfrique);
		bresil.ajouterTerritoireVoisin(venezuela);
		bresil.ajouterTerritoireVoisin(perou);
		bresil.ajouterTerritoireVoisin(argentine);
		venezuela.ajouterTerritoireVoisin(bresil);
		venezuela.ajouterTerritoireVoisin(perou);
		venezuela.ajouterTerritoireVoisin(ameriqueCentrale);
		perou.ajouterTerritoireVoisin(bresil);
		perou.ajouterTerritoireVoisin(venezuela);
		perou.ajouterTerritoireVoisin(argentine);
		argentine.ajouterTerritoireVoisin(perou);
		argentine.ajouterTerritoireVoisin(bresil);
		
		ameriqueCentrale.ajouterTerritoireVoisin(venezuela);
		ameriqueCentrale.ajouterTerritoireVoisin(etatUnisEst);
		ameriqueCentrale.ajouterTerritoireVoisin(etatUnisOuest);
		etatUnisEst.ajouterTerritoireVoisin(ameriqueCentrale);
		etatUnisEst.ajouterTerritoireVoisin(etatUnisOuest);
		etatUnisEst.ajouterTerritoireVoisin(canada);
		etatUnisEst.ajouterTerritoireVoisin(ontario);
		etatUnisOuest.ajouterTerritoireVoisin(etatUnisEst);
		etatUnisOuest.ajouterTerritoireVoisin(alberta);
		etatUnisOuest.ajouterTerritoireVoisin(ontario);
		etatUnisOuest.ajouterTerritoireVoisin(ameriqueCentrale);
		ontario.ajouterTerritoireVoisin(etatUnisEst);
		ontario.ajouterTerritoireVoisin(etatUnisOuest);
		ontario.ajouterTerritoireVoisin(alberta);
		ontario.ajouterTerritoireVoisin(canada);
		ontario.ajouterTerritoireVoisin(territoireNordOuest);
		ontario.ajouterTerritoireVoisin(groenland);
		
		canada.ajouterTerritoireVoisin(groenland);
		canada.ajouterTerritoireVoisin(ontario);
		canada.ajouterTerritoireVoisin(etatUnisEst);
		alberta.ajouterTerritoireVoisin(alaska);
		alberta.ajouterTerritoireVoisin(territoireNordOuest);
		alberta.ajouterTerritoireVoisin(ontario);
		alberta.ajouterTerritoireVoisin(etatUnisOuest);
		alaska.ajouterTerritoireVoisin(kamchatka);
		alaska.ajouterTerritoireVoisin(territoireNordOuest);
		alaska.ajouterTerritoireVoisin(alberta);
		territoireNordOuest.ajouterTerritoireVoisin(alaska);
		territoireNordOuest.ajouterTerritoireVoisin(alberta);
		territoireNordOuest.ajouterTerritoireVoisin(groenland);
		territoireNordOuest.ajouterTerritoireVoisin(ontario);
		groenland.ajouterTerritoireVoisin(territoireNordOuest);
		groenland.ajouterTerritoireVoisin(ontario);
		groenland.ajouterTerritoireVoisin(canada);
		groenland.ajouterTerritoireVoisin(islande);
		
		moyenOrient.ajouterTerritoireVoisin(europeSud);
		moyenOrient.ajouterTerritoireVoisin(russie);
		moyenOrient.ajouterTerritoireVoisin(afghanistan);
		moyenOrient.ajouterTerritoireVoisin(egypte);
		moyenOrient.ajouterTerritoireVoisin(afriqueOrientale);
		moyenOrient.ajouterTerritoireVoisin(inde);
		inde.ajouterTerritoireVoisin(moyenOrient);
		inde.ajouterTerritoireVoisin(afghanistan);
		inde.ajouterTerritoireVoisin(chine);
		inde.ajouterTerritoireVoisin(asieSudEst);
		asieSudEst.ajouterTerritoireVoisin(chine);
		asieSudEst.ajouterTerritoireVoisin(inde);
		asieSudEst.ajouterTerritoireVoisin(indonesie);
		chine.ajouterTerritoireVoisin(inde);
		chine.ajouterTerritoireVoisin(asieSudEst);
		chine.ajouterTerritoireVoisin(afghanistan);
		chine.ajouterTerritoireVoisin(mongolie);
		chine.ajouterTerritoireVoisin(siberie);
		chine.ajouterTerritoireVoisin(oural);
		mongolie.ajouterTerritoireVoisin(japon);
		mongolie.ajouterTerritoireVoisin(kamchatka);
		mongolie.ajouterTerritoireVoisin(irtoutsk);
		mongolie.ajouterTerritoireVoisin(siberie);
		japon.ajouterTerritoireVoisin(kamchatka);
		japon.ajouterTerritoireVoisin(mongolie);
		oural.ajouterTerritoireVoisin(russie);
		oural.ajouterTerritoireVoisin(afghanistan);
		oural.ajouterTerritoireVoisin(siberie);
		oural.ajouterTerritoireVoisin(chine);
		siberie.ajouterTerritoireVoisin(oural);
		siberie.ajouterTerritoireVoisin(yajoutie);
		siberie.ajouterTerritoireVoisin(irtoutsk);
		siberie.ajouterTerritoireVoisin(mongolie);
		siberie.ajouterTerritoireVoisin(chine);
		irtoutsk.ajouterTerritoireVoisin(yajoutie);
		irtoutsk.ajouterTerritoireVoisin(siberie);
		irtoutsk.ajouterTerritoireVoisin(kamchatka);
		irtoutsk.ajouterTerritoireVoisin(mongolie);
		yajoutie.ajouterTerritoireVoisin(siberie);
		yajoutie.ajouterTerritoireVoisin(kamchatka);
		yajoutie.ajouterTerritoireVoisin(irtoutsk);
		kamchatka.ajouterTerritoireVoisin(yajoutie);
		kamchatka.ajouterTerritoireVoisin(mongolie);
		kamchatka.ajouterTerritoireVoisin(irtoutsk);
		kamchatka.ajouterTerritoireVoisin(alaska);
		
		indonesie.ajouterTerritoireVoisin(asieSudEst);
		indonesie.ajouterTerritoireVoisin(nouvelleGuinee);
		indonesie.ajouterTerritoireVoisin(australieOccidentale);
		nouvelleGuinee.ajouterTerritoireVoisin(indonesie);
		nouvelleGuinee.ajouterTerritoireVoisin(australieOrientale);
		australieOccidentale.ajouterTerritoireVoisin(indonesie);
		australieOccidentale.ajouterTerritoireVoisin(australieOrientale);
		australieOrientale.ajouterTerritoireVoisin(nouvelleGuinee);
		australieOrientale.ajouterTerritoireVoisin(australieOccidentale);
		
		
		
	}
	
	//1. Créer les territoires et leur territoire voisin 
			//EUROPE 
			Territoire islande = new Territoire("Islande", TypeContinent.EUROPE);
			Territoire scandinavie = new Territoire("Scandinavie", TypeContinent.EUROPE);
			Territoire grandeBretagne = new Territoire("Grande-Bretagne", TypeContinent.EUROPE);
			Territoire europeOuest = new Territoire("Europe de l'Ouest", TypeContinent.EUROPE);
			Territoire europeNord = new Territoire("Europe du Nord", TypeContinent.EUROPE);
			Territoire europeSud = new Territoire("Europe du Sud", TypeContinent.EUROPE);
			Territoire russie = new Territoire("Russie", TypeContinent.EUROPE);


			//AMERIQUE NORD 
			Territoire alaska = new Territoire("Alaska", TypeContinent.AMERIQUEN);
			Territoire alberta = new Territoire("Alberta", TypeContinent.AMERIQUEN);
			Territoire ontario = new Territoire("Ontario", TypeContinent.AMERIQUEN);
			Territoire canada = new Territoire("Canada de l'Est", TypeContinent.AMERIQUEN);
			Territoire groenland = new Territoire("Groenland", TypeContinent.AMERIQUEN);
			Territoire territoireNordOuest = new Territoire("Territoire du Nord-Ouest", TypeContinent.AMERIQUEN);
			Territoire etatUnisOuest = new Territoire("Etats-Unis de l'Ouest", TypeContinent.AMERIQUEN);
			Territoire etatUnisEst = new Territoire("Etats-Unis de l'Est", TypeContinent.AMERIQUEN);
			Territoire ameriqueCentrale = new Territoire("Amerique Centrale", TypeContinent.AMERIQUEN);
			//AMERIQUE DU SUD 
			Territoire venezuela = new Territoire("Venezuela", TypeContinent.AMERIQUESUD);
			Territoire bresil = new Territoire("Brésil", TypeContinent.AMERIQUESUD);
			Territoire perou = new Territoire("Pérou", TypeContinent.AMERIQUESUD);
			Territoire argentine = new Territoire("Argentine", TypeContinent.AMERIQUESUD);
			//ASIE 
			Territoire oural = new Territoire("Oural", TypeContinent.ASIE);
			Territoire siberie = new Territoire("Sibérie", TypeContinent.ASIE);
			Territoire yajoutie = new Territoire("Yakoutie", TypeContinent.ASIE);
			Territoire kamchatka = new Territoire("Kamchatka", TypeContinent.ASIE);
			Territoire mongolie = new Territoire("Mongolie", TypeContinent.ASIE);
			Territoire japon = new Territoire("Japon", TypeContinent.ASIE);
			Territoire chine = new Territoire("Chine", TypeContinent.ASIE);
			Territoire moyenOrient = new Territoire("Moyen-Orient", TypeContinent.ASIE);
			Territoire afghanistan = new Territoire("Afghanistan", TypeContinent.ASIE);
			Territoire inde = new Territoire("Inde", TypeContinent.ASIE);
			Territoire asieSudEst = new Territoire("Asie du Sud Est", TypeContinent.ASIE);
			Territoire irtoutsk = new Territoire("Irtoutsk", TypeContinent.ASIE);
			//AFRIQUE
			Territoire nordAfrique = new Territoire("Nord de l'Afrique", TypeContinent.AFRIQUE);
			Territoire egypte = new Territoire("Égypte", TypeContinent.AFRIQUE);
			Territoire afriqueOrientale = new Territoire("Afrique Orientale", TypeContinent.AFRIQUE);
			Territoire afriqueCentrale = new Territoire("Afrique Centrale", TypeContinent.AFRIQUE);
			Territoire afriqueSud = new Territoire("Afrique du Sud", TypeContinent.AFRIQUE);
			Territoire madagascar = new Territoire("Madagascar", TypeContinent.AFRIQUE);
			//OCEANIE
			Territoire nouvelleGuinee = new Territoire("Nouvelle-Guinée", TypeContinent.OCEANIE);
			Territoire australieOccidentale = new Territoire("Australie Occidentale", TypeContinent.OCEANIE);
			Territoire australieOrientale = new Territoire("Australie Orientale", TypeContinent.OCEANIE);
			Territoire indonesie = new Territoire("Indonesie", TypeContinent.OCEANIE);
/*
	private void creerJoueurs() {
		String[] couleurs = new String[] { "bleu", "jaune", "rouge", "vert", "noir" };
		for (String couleur : couleurs) {
			this.joueurs.add(new Joueur(this.idPlateau, couleur));
		}
	}*/



	
	
	
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

	@Override
	public String getTerritoire(int x, int y) {
		// TODO Auto-generated method stub
		return plateau[x][y].getNomTerritoire();
	}

	@Override
	public TypeContinent getContinent(int x, int y) {
		// TODO Auto-generated method stub
		return plateau[x][y].getContinent();
	}

	@Override
	public ArrayList<Territoire> getVoisin(int x, int y) {
		// TODO Auto-generated method stub
		return plateau[x][y].getListeTerritoireVoisin();
	}
	
	public Joueur getVainqueur(Joueur attaquant, Joueur defendant) {
		ArrayList<Integer> resAttaquant = attaquant.getResultatDe();
		ArrayList<Integer> resDefendant = attaquant.getResultatDe();
		
		for (int a : resAttaquant) {
			//comparer valeur 'a' avec la valeur au mm index que 'a' dans resDefendant
			if (a <= resDefendant.get(resDefendant.indexOf(a))) {
				return defendant;

			} else {
				return attaquant;
			}
		 }
		return null;
		 
	}
	
	public void combattre(Joueur attaquant, Joueur defendant) {
		attaquant.setNbAttaque(attaquant.getNbAttaque()+1);
		defendant.setNbDefense(defendant.getNbDefense()+1);
	
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

	public ArrayList<Joueur> getListeJoueurs() {
		return this.listeJoueurs;
	}

	public ArrayList<CarteRisk> getPile() {
		return pile;
	}

	public void setPile(ArrayList<CarteRisk> pile) {
		this.pile = pile;
	}

    
	



//Larissa


	@Override
	public String getNom(int x, int y) {
		// TODO Auto-generated method stub
		return plateau[x][y].getNomTerritoire();
	}

//Fin Larissa

}
