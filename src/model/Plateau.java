package model;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
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

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class Plateau extends AbstractModel {
	private TypeContinent typeCase;
	private Territoire[][] plateau = new Territoire[50][30];
	static private int idPlateauTotal = 0;
	private int tour = 0;
	private Joueur joueurActif;
	private String etatPlateu;
	private ArrayList<Continent> continents;
	private ArrayList<CarteRisk> pile = new ArrayList<CarteRisk>();
	private int idPlateau;
	private ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	private Territoire territoireDept; //NA
	private Territoire territoireVoisin; //NA
//Larissa
	private ArrayList<Territoire> listeTerritoireVoisin;
	private Manche manche; 
//Fin Larissa
	private int phase;
	Scanner scanner = new Scanner(System.in); //NA
	
	private ArrayList<Territoire> territoiresEurope;
	private ArrayList<Territoire> territoiresAfrique;
	private ArrayList<Territoire> territoiresAsie;
	private ArrayList<Territoire> territoiresOceanie;
	private ArrayList<Territoire> territoiresAmeriqueSud;
	private ArrayList<Territoire> territoiresAmeriqueNord;
	public Continent europe; 
	public Continent afrique; 
	public Continent ameriqueNord; 
	public Continent ameriqueSud; 
	public Continent asie; 
	public Continent australie; 
	
	
	
	HashMap<Joueur,Territoire> territoiresControles = new HashMap<Joueur, Territoire>();
	HashMap<Continent, ArrayList<Territoire>> continentTerritoires = new HashMap<Continent, ArrayList<Territoire>>();

	public Plateau() {
		super();
		this.idPlateau=Plateau.idPlateauTotal++;
		this.tour = 0;
		this.joueurActif = this.listeJoueurs.get(0);
		//CREATION DU JOUEURS
		Joueur joueur1 = new Joueur(0, "rouge", 25);
		Joueur joueur2 = new Joueur(0, "jaune", 25);
	
		this.listeJoueurs.add(joueur1);
		this.listeJoueurs.add(joueur2);
		gererTour();
		
		do {
			australieOrientale.setNbRegTer(4);
			ameriqueCentrale.setNbRegTer(4);
			etatUnisEst.setNbRegTer(6);
			canada.setNbRegTer(4);
			ontario.setNbRegTer(3);
			chine.setNbRegTer(1);
		}
		while(this.joueurActif.getNbRegimentJoueur() > 0);
		
		joueur1.getListeTerritoire().add(ameriqueCentrale);
		joueur1.getListeTerritoire().add(australieOrientale);
		joueur1.getListeTerritoire().add(etatUnisEst);
		joueur1.getListeTerritoire().add(canada);
		joueur1.getListeTerritoire().add(ontario);
		
		
		
		
		this.joueurActif = joueur1;
		
		this.listeJoueurs.add(joueur1);
		this.listeJoueurs.add(joueur2);
		
		
		
		//test trophé conquérent
		System.out.println(conquerant());

		
		// Larissa : création de la carte 
		//1. On crée les oceans
		
        //Cration liete territoire continent
		territoiresEurope = new ArrayList<Territoire>();
		territoiresAfrique = new ArrayList<Territoire>();
		territoiresAsie = new ArrayList<Territoire>();
		territoiresOceanie = new ArrayList<Territoire>();
		territoiresAmeriqueSud = new ArrayList<Territoire>();
		territoiresAmeriqueNord = new ArrayList<Territoire>();
		continents = new ArrayList<Continent>(); 
		//2.Créer Continent 
		afrique = new Continent(TypeContinent.AFRIQUE, 3); 
		europe = new Continent(TypeContinent.EUROPE, 2); 
		ameriqueNord = new Continent(TypeContinent.AMERIQUEN, 5); 
		ameriqueSud = new Continent(TypeContinent.AMERIQUESUD, 7); 
		asie = new Continent(TypeContinent.ASIE, 7); 
		australie = new Continent(TypeContinent.AUSTRALIE, 7); 
	

	
		System.out.println("\n---------------" + proprietaireDeTer(ontario));
		// Larissa : création de la carte
		// 1. On crée les oceans
		for (int x = 0; x < plateau.length; x++) {
			for (int y = 0; y < plateau[x].length; y++) {
				plateau[x][y] = new Territoire("Ocean", typeCase.OCEAN);
  
			}
		}

		
//		plateau[0][0] = new Territoire("France", TypeCase.CHEMIN);
	
		// 2. Ajout des territoires par continent
		// Amerique : groenland
		for (int x = 8; x < 14; x++) {
			for (int y = 2; y < 4; y++) {
				this.plateau[x][y] = groenland;
			}

		}
	
		//Amerique : Alaska
		for (int x = 2; x < 5; x++) {
			for (int y = 5; y < 7; y++) {
				this.plateau[x][y] = alaska;
			}
		}
		// Amerique : nord Est
		for (int x = 5; x < 10; x++) {
			for (int y = 5; y < 7; y++) {
				this.plateau[x][y] = territoireNordOuest;

			}
		}
		// Territoire de Ontario
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
		// Amerique : canada
		for (int x = 12; x < 15; x++) {
			for (int y = 5; y < 9; y++) {
				this.plateau[x][y] = canada;

			}
		}
		// Alberta
		for (int x = 3; x < 8; x++) {
			for (int y = 7; y < 9; y++) {
				this.plateau[x][y] = alberta;

			}
		}
		// USA EST
		for (int x = 9; x < 15; x++) {
			for (int y = 9; y < 13; y++) {
				this.plateau[x][y] = etatUnisEst;

			}
		}
		// Amerique central
		for (int x = 3; x < 7; x++) {
			for (int y = 11; y < 13; y++) {
				this.plateau[x][y] = ameriqueCentrale;

			}
		}
		// Amerique l'ouest
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

		////////////// AMERIQUE DU SUD /////////////
		// bresil
		for (int x = 8; x < 16; x++) {
			for (int y = 14; y < 20; y++) {
				this.plateau[x][y] = bresil;
			}
		}
		// venezuela en deux partie
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
		// perou
		for (int x = 3; x < 8; x++) {
			for (int y = 18; y < 21; y++) {
				this.plateau[x][y] = perou;
			}
		}
		// argentine en deux partie
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
		////////////// EUROPE/////////////
		// scandinavie
		for (int x = 21; x < 25; x++) {
			for (int y = 2; y < 5; y++) {
				this.plateau[x][y] = scandinavie;
			}
		}
		// russie en deux parties
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
		// europe du nord
		for (int x = 17; x < 23; x++) {
			for (int y = 6; y < 8; y++) {
				this.plateau[x][y] = europeNord;
			}
		}
		// europe du l'ouest
		for (int x = 17; x < 20; x++) {
			for (int y = 8; y < 11; y++) {
				this.plateau[x][y] = europeOuest;
			}
		}
		// europe du sud
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
		// afrique du nord
		for (int x = 17; x < 23; x++) {
			for (int y = 12; y < 17; y++) {
				this.plateau[x][y] = nordAfrique;
			}
		}
		// egypte
		for (int x = 22; x < 27; x++) {
			for (int y = 12; y < 15; y++) {
				this.plateau[x][y] = egypte;
			}
		}
		// afrique centrale
		for (int x = 17; x < 23; x++) {
			for (int y = 17; y < 20; y++) {
				this.plateau[x][y] = afriqueCentrale;
			}
		}
		// afrique orientale
		for (int x = 22; x < 27; x++) {
			for (int y = 15; y < 20; y++) {
				this.plateau[x][y] = afriqueOrientale;
			}
		}
		// afrique du sud
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

		////////////// ASIE /////////////
		// oural
		for (int x = 31; x < 35; x++) {
			for (int y = 2; y < 7; y++) {
				this.plateau[x][y] = oural;
			}
		}
		// afghanistan
		for (int x = 31; x < 35; x++) {
			for (int y = 7; y < 12; y++) {
				this.plateau[x][y] = afghanistan;
			}
		}
		// siberia
		for (int x = 35; x < 38; x++) {
			for (int y = 2; y < 7; y++) {
				this.plateau[x][y] = siberie;
			}
		}
		// yajoutie
		for (int x = 38; x < 41; x++) {
			for (int y = 2; y < 4; y++) {
				this.plateau[x][y] = yajoutie;
			}
		}
		// irtousk
		for (int x = 38; x < 42; x++) {
			for (int y = 4; y < 7; y++) {
				this.plateau[x][y] = irtoutsk;
			}
		}
		// mongolie en deux partie
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
		// chine en trois partie
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

		////////////// OCEANIE /////////////
		// indonesie
		for (int x = 37; x < 41; x++) {
			for (int y = 18; y < 20; y++) {
				this.plateau[x][y] = indonesie;
			}
		}
		// nouvelle guinée
		for (int x = 42; x < 47; x++) {
			for (int y = 18; y < 20; y++) {
				this.plateau[x][y] = nouvelleGuinee;
			}
		}
		// autralie orientale
		for (int x = 42; x < 47; x++) {
			for (int y = 21; y < 26; y++) {
				this.plateau[x][y] = australieOrientale;
			}
		}
		// autralie occidentale
		for (int x = 37; x < 42; x++) {
			for (int y = 21; y < 26; y++) {
				this.plateau[x][y] = australieOccidentale;
			}
		}

		// les vois maritimes
		// groenland
		this.plateau[9][4] = new Territoire(" ", typeCase.FLECHE_HAUT);
		this.plateau[11][4] = new Territoire(" ", typeCase.FLECHE_HAUT);
		this.plateau[13][4] = new Territoire(" ", typeCase.FLECHE_HAUT);
		this.plateau[0][5] = new Territoire(" ", typeCase.FLECHE_DROITE);
		this.plateau[1][5] = new Territoire(" ", typeCase.FLECHE_DROITE);
		// oceanie
		this.plateau[41][18] = new Territoire(" ", typeCase.FLECHE_DROITE);
		this.plateau[44][20] = new Territoire(" ", typeCase.FLECHE_BAS);
		this.plateau[39][20] = new Territoire(" ", typeCase.FLECHE_BAS);
		this.plateau[39][16] = new Territoire(" ", typeCase.FLECHE_HAUT);
		this.plateau[39][17] = new Territoire(" ", typeCase.FLECHE_HAUT);
		// asie
		this.plateau[44][7].setTypeT(typeCase.FLECHE_DROITE);
		;
		this.plateau[44][9] = new Territoire(" ", typeCase.FLECHE_DROITE);
		for (int x = 47; x <= 49; x++) {
			this.plateau[x][3] = new Territoire(" ", typeCase.FLECHE_DROITE);
		}
		// afrique
		this.plateau[16][15] = new Territoire(" ", typeCase.FLECHE_DROITE);
		this.plateau[18][11] = new Territoire(" ", typeCase.FLECHE_HAUT);
		this.plateau[21][11] = new Territoire(" ", typeCase.FLECHE_HAUT);
		this.plateau[23][11] = new Territoire(" ", typeCase.FLECHE_HAUT);
		this.plateau[27][23] = new Territoire(" ", typeCase.FLECHE_DROITE);
		this.plateau[27][15] = new Territoire(" ", typeCase.FLECHE_HAUT);
		// europe

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
		
		// Tidiane Je crée la pile et j'ai changé certains noms ils n'étaient pas
					// patreil que dans les règles du jeu
					
						// EUROPE
						pile.add(new CarteRisk("Grande-Bretagne", TypeCarte.ARTILLERIE));
						pile.add(new CarteRisk("Islande", TypeCarte.INFANTERIE));
						pile.add(new CarteRisk("Europe du Nord", TypeCarte.ARTILLERIE));
						pile.add(new CarteRisk("Scandinavie", TypeCarte.CAVALERIE));
						pile.add(new CarteRisk("Europe du Sud", TypeCarte.ARTILLERIE));
						pile.add(new CarteRisk("RUSSIE", TypeCarte.CAVALERIE));
						pile.add(new CarteRisk("Europe de l'ouest", TypeCarte.ARTILLERIE));

						// ASIE
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

						// AMÉRIQUE DU SUD
						pile.add(new CarteRisk("Argentine", TypeCarte.INFANTERIE));
						pile.add(new CarteRisk("Brésil", TypeCarte.ARTILLERIE));
						pile.add(new CarteRisk("Pérou", TypeCarte.INFANTERIE));
						pile.add(new CarteRisk("Venezuela", TypeCarte.INFANTERIE));

						// AFRIQUE
						pile.add(new CarteRisk("AFRIQUE CENTRALE", TypeCarte.INFANTERIE));
						pile.add(new CarteRisk("Afrique orientale", TypeCarte.INFANTERIE));
						pile.add(new CarteRisk("Égypte", TypeCarte.INFANTERIE));
						pile.add(new CarteRisk("Madagascar", TypeCarte.CAVALERIE));
						pile.add(new CarteRisk("Afrique du Nord", TypeCarte.CAVALERIE));
						pile.add(new CarteRisk("Afrique du Sud", TypeCarte.ARTILLERIE));

						// AUSTRALIE
						pile.add(new CarteRisk("Australie Orientale", TypeCarte.ARTILLERIE));
						pile.add(new CarteRisk("Indonésie", TypeCarte.ARTILLERIE));
						pile.add(new CarteRisk("Nouvelle-Guinée", TypeCarte.INFANTERIE));
						pile.add(new CarteRisk("Australie Occidentale", TypeCarte.ARTILLERIE));

						// JOKER
						pile.add(new CarteRisk("JOKER", TypeCarte.JOKER));
						pile.add(new CarteRisk("JOKER", TypeCarte.JOKER));
						
						//TEST TIDIANE
						System.out.println("la carte est de nom "+ ajouterCartes().getNomCarte()+ "et de type " + ajouterCartes().getTypeCarte() );
						obtenirCarte();
						this.joueurActif.afficherCartes();
						this.joueurActif.echangerCartes();
						
  
		afrique.ajouterContinent(continents,afrique);
		europe.ajouterContinent(continents,europe);
		ameriqueNord.ajouterContinent(continents,ameriqueNord);
		ameriqueSud.ajouterContinent(continents,ameriqueSud);
		asie.ajouterContinent(continents,asie);
		australie.ajouterContinent(continents,australie);
		
		attribuerTerritoiresContinent();
		
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
	Territoire nouvelleGuinee = new Territoire("Nouvelle-Guinée", TypeContinent.AUSTRALIE);
	Territoire australieOccidentale = new Territoire("Australie Occidentale", TypeContinent.AUSTRALIE);
	Territoire australieOrientale = new Territoire("Australie Orientale", TypeContinent.AUSTRALIE);
	Territoire indonesie = new Territoire("Indonesie", TypeContinent.AUSTRALIE);
	

	  public ArrayList<Territoire> getTerritoireFromContinent(TypeContinent tc) {
			ArrayList<Territoire> territoiresContinent = new ArrayList<Territoire>();
	        for (int x = 0; x < plateau.length; x++) {
				for (int y = 0; y < plateau[x].length; y++) {
				   if(plateau[x][y].getContinent() == tc && !territoiresContinent.contains(plateau[x][y])) {
					 territoiresContinent.add(plateau[x][y]);
				}
			} 
		}
					return territoiresContinent;
	}
	    
	//FARKI Imane
	    public Joueur getJoueurActuel() {
	        return this.listeJoueurs.get(this.tour);
	    }
	  
	 // FARKI Imane : Creer la liste des territoires pour chaque centinent 
	public void attribuerTerritoiresContinent() {
		//territoiresAfrique = getTerritoireFromContinent(TypeContinent.AFRIQUE);
	
		territoiresAfrique.addAll(getTerritoireFromContinent(TypeContinent.AFRIQUE));
		territoiresAmeriqueNord.addAll(getTerritoireFromContinent(TypeContinent.AMERIQUEN));
		territoiresAmeriqueSud.addAll(getTerritoireFromContinent(TypeContinent.AMERIQUESUD));
		territoiresAsie.addAll(getTerritoireFromContinent(TypeContinent.ASIE));
		territoiresEurope.addAll(getTerritoireFromContinent(TypeContinent.EUROPE));
		territoiresOceanie.addAll(getTerritoireFromContinent(TypeContinent.AUSTRALIE));
		
	//Ajouter les listes dans la map
	continentTerritoires.put(afrique, territoiresAfrique);
	continentTerritoires.put(ameriqueNord, territoiresAmeriqueNord);
	continentTerritoires.put(ameriqueSud, territoiresAmeriqueSud);
	continentTerritoires.put(asie, territoiresAsie);
	continentTerritoires.put(europe, territoiresEurope);
	continentTerritoires.put(australie, territoiresOceanie);
	} 


	public ArrayList<Territoire> getTerritoiresAfrique() {
		return territoiresAfrique;
	}

	//FARKI Imane : avoir la liste des territoires pour un continent donné
	public ArrayList<Territoire> getListeTerritoire(Continent nomContinent) {
        //ArrayList<Territoire> territoiresContinent = new ArrayList<>();
        for(Map.Entry<Continent, ArrayList<Territoire>> continent : continentTerritoires.entrySet()) {
            if(continent.getKey().equals(nomContinent)) {
            	return continent.getValue();
            }
        }
        return null;
        }
        
        /*for (Territoire territoire : listTerritoires) {
            if (territoire.getContinent().equals(nomContinent)) {
                territoiresContinent.add(territoire);
            }
        }
        return territoiresContinent;
    }*/
	/*		
	private void creerJoueurs() {
		String[] couleurs = new String[] { "bleu", "jaune", "rouge", "vert", "noir" };
		for (String couleur : couleurs) {
			this.joueurs.add(new Joueur(this.idPlateau, couleur));
		}
	}*/
    //FARKI Imane
	public HashMap<Continent, ArrayList<Territoire>> getContinentTerritoires() {
		return continentTerritoires;
	}

		



//	private void creerJoueurs() {
//		String[] couleurs = new String[] { "bleu", "jaune", "rouge", "vert", "noir" };
//		for (String couleur : couleurs) {
//			this.joueurs.add(new Joueur(this.idPlateau, couleur));
//		}
//	}

	//FARKI Imane
	private void creerJoueurs(String couleur, int nbRegiment) {
		this.listeJoueurs.add(new Joueur(this.idPlateau, couleur, nbRegiment));
		/*String[] couleurs = new String[]{"bleu","jaune","rouge","vert","noir"};
		for (String couleur : couleurs) {
			this.joueurs.add(new Joueur(this.idPlateau,couleur));
		}*/
	}
	
	//FARKI Imane
    public void attribuerTerritoire(Territoire territoire, Joueur joueur) {
        territoiresControles.put(joueur, territoire);
    }

    //FARKI Imane
      /*public boolean territoireControle(Territoire territoire, Joueur joueur) {
		
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
    
	//FARKI Imane : retourner le nombre de territoires conquis par un joueur donné
    public int getNombreTerritoiresControles(Joueur joueur) {
       return  joueur.getListeTerritoire().size();
}
    
    //FARKI Imane : retourner le nombre de continents conquis par un joueur donné
  	public int getContinentJoueur(Joueur joueur) {
  		int nombre = 0;
  		for(Continent centinent : continents) {
  			if(joueur.conquerirContinent(centinent))
  				nombre+=1;
  		}
  		return nombre;
  	}
  		
  		/*int cpt = 0;
          ArrayList<Territoire> territoiresJoueur = joueur.getListeTerritoire();
  		for (Continent continent : continentTerritoires.keySet()) {
              ArrayList<Territoire> territoires = continent.getListTerritoire();
  			if (territoiresJoueur.containsAll(territoires))
  				cpt = cpt+1;
  		}
          return cpt;
          
        }*/

	//FARKI Imane
    public void calculerScore(Joueur joueur) {
		int score = 0;
		
    	//Connection connection;
		//connection = ConnexionBD.getConnexion();

    	int nombreContinent = getContinentJoueur(joueur);
		 
		if(nombreContinent >= 3)
			score = 10;
		else {
			Collections.sort(joueurs,(j1,j2) -> j1.getListeTerritoire().size() - j2.getListeTerritoire().size());
			for(int i=0; i<this.listeJoueurs.size(); i++) {
				if(joueurs.get(i).equals(joueur)) {
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
		            score = 3;
		            break;
       
				
			}      
		}
			}
    	
        String req = "INSERT INTO scorejoueur (scoreJoueur, joueur) VALUES (?, SELECT numInscription FROM joueur WHERE nomJoueur = ?))";
        //PreparedStatement statement = null;

		String url = "jdbc:mysql://localhost:3306/risk";
        String utilisateur = "root";
        String motDePasse = "";

            try {
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            PreparedStatement statement = connexion.prepareStatement(req);
        	        
            //statement = connexion.prepareStatement(req);
            statement.setInt(1, score);
            statement.setString(2, joueur.getNom());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    }
    
               
	  //FARKI Imane 
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
	    public void passerAuTourSuivant() {
	        this.tour += 1;
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
	/*public TypeTerritoire getTypeTerritoire() {
		return this.TypeCase;
	}*/

	private void creerJoueurs() {
		String[] couleurs = new String[] { "bleu", "jaune", "rouge", "vert", "noir" };
		for (String couleur : couleurs) {
			this.listeJoueurs.add(new Joueur(this.idPlateau, couleur,0));
		}

	}
	/*
	private void creerTerritoires() {

		String[] nomsTerEurope = new String[] { "Grande-Bretagne", "Islande", "Europe du Nord", "Scandinavie",
				"Europe du Sud", "RUSSIE", "Europe de l'ouest" };
		String[] nomsTerAsie = new String[] { "Afghanistan", "Chine", "Inde", "Asie du sud-est", "Japon", "Kamtchatka",
				"Moyen-Orient", "Mongolie", "IRKOUTSK", "Sibérie", "Oural", "Yakoutie" };
		String[] nomsTerAmeriqueN = new String[] { "Alaska", "Alberta", "Amérique centrale", "États de l'Est",
				"Groenland", "Territoires du Nord-Ouest", "Ontario", "CANADA DE L'EST", "États de l'Ouest" };
		String[] nomsTerAmeriqueS = new String[] { "Argentine", "Brésil", "Pérou", "Venezuela" };
		String[] nomsTerAfrique = new String[] { "AFRIQUE CENTRALE", "Afrique orientale", "Égypte", "Madagascar",
				"Afrique du Nord", "Afrique du Sud" };
		String[] nomsTerOceanie = new String[] { "Australie Orientale", "Indonésie", "Nouvelle-Guinée",
				"Australie Occidentale" };

	}

	}*/


	//NA
	public Territoire cliquerSurTerDEPART(int x, int y) {
		System.out.println("territoire départ choisi : " + this.plateau[x][y].getNomTer());
		this.territoireDept = this.plateau[x][y];
		return this.plateau[x][y];

	}
	
	//NA
	public Territoire cliquerSurTerVOISIN(int x, int y) {
		this.territoireVoisin = this.plateau[x][y];
		System.out.println("territoire voisin choisi : " + this.territoireVoisin.getNomTer());
		return this.territoireVoisin;
	}
	


	
	public int getPhase() {
		return this.phase;
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
	
	/*
	public static int getIdPlateau() {
		return idPlateau;
	}*/
	

	//FARKI Imane
	public int getIdPlateau() {
		return this.idPlateau;
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
	
	//NA
	public Territoire getTerritoireDept() {
		return this.territoireDept;
	}
	public void setTerritoireDept(Territoire territoireDept) {
		this.territoireDept = territoireDept;
	}


	@Override
	public Territoire getTerritoire(int x, int y) {
		// TODO Auto-generated method stub
		return plateau[x][y];
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
	

	// NA
	public void combattre() {
		
		//compteur point trophé "le belliqueux"
		joueurActif.setNbAttaque(joueurActif.getNbAttaque()+1);
		
		int nbAtt=0;
		int nbDef=0;
		
		
		//TODO Vérifier si nbAtt choisi laisse au moins 1 regiment au territoire départ
		//scanner demander nbAtt/nbRegiment/nbLance
		System.out.println("Taper le nombre de régiments à déplacer pour attaquer 1~3");
		nbAtt=scanner.nextInt(); 	
		
		Joueur defendant =  proprietaireDeTer(this.territoireVoisin);
		System.out.println("\ndéfendant is " + defendant.getCouleur() + ", territoire : " + this.territoireVoisin.getNomTer());
		
		//TODO Vérifier si nbDef choisi laisse au moins 1 regiment au territoire départ
		System.out.println("Taper le nombre de régiments pour défendre 1~2");
		nbDef=scanner.nextInt();
				
		
		//LancerDé
		this.joueurActif.lancerDe(nbAtt);
		defendant.lancerDe(nbDef);
		
		//résultat lancer de dés
		ArrayList<Integer> resAttaquant = this.joueurActif.getResultatDe();
		ArrayList<Integer> resDefendant = defendant.getResultatDe();
		Joueur vainqueur = null;
		
		//sysout test >>>>
		System.out.println("------------------------------------------\n");
		System.out.println("nbReg sur territoire défendant au début " + this.territoireVoisin.getNbRegTer());
		//<<<<<<<<
		
		for (int i = 0 ; i<Math.min(resAttaquant.size(), resDefendant.size()); i++) {
			
			System.out.println("-------------------------------\ncomparer dé index " + i);
			//comparer valeur 'i' avec la valeur au mm index que 'i' dans resDefendant
			//if vainqueur = defendant
			if (resAttaquant.get(i) <= resDefendant.get(i)) { 
				vainqueur = defendant;				
				System.out.println("vainqueur = " + vainqueur.getCouleur());
				
				//compteur point trophé "le bouclier"
				defendant.setNbDefenseReussi(defendant.getNbDefenseReussi()+1);
				
				//enlever regiment du territoire de l'attaquant
				this.territoireDept.setNbRegTer(this.territoireDept.getNbRegTer() - 1);
				//enlever regiment de l'attaquant
				this.joueurActif.setNbRegimentJoueur(this.joueurActif.getNbRegimentJoueur()-1);
				
				//définir le nombre restant d'attaquant 
				nbAtt -=1;
				
			//if vainqueur = attaquant
			} else {
				vainqueur = this.joueurActif;
				System.out.println("vainqueur = " + vainqueur.getCouleur());
				
				//si territoire conquis, ajouter dans territoire ds liste du gagnant
				if ((this.territoireVoisin.getNbRegTer() - 1) < 1 ) {
					//gérer listeTerritoire
					this.joueurActif.getListeTerritoire().add(this.territoireVoisin);
					defendant.getListeTerritoire().remove(this.territoireVoisin);
					
					//gérer nbRegiment nouveau sur territoire
					this.territoireVoisin.setNbRegTer(nbAtt);
					
					System.out.print("Vous avez acquis le territoire " + this.territoireVoisin.getNomTer());
					
				} else {
					//enlever regiment du territoire du defendant
					this.territoireVoisin.setNbRegTer(this.territoireVoisin.getNbRegTer()- 1);
					//enlever regiment du defendant 
					defendant.setNbRegimentJoueur(defendant.getNbRegimentJoueur()-1);
				}				
			}
		 }
		System.out.println("\nnbReg restant sur territoire defendant " + this.territoireVoisin.getNbRegTer());
		
		//Reset le territoireDept
		this.territoireDept = null;
	}
	//fin NA

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
		return etatPlateu;}


	//FARKI Imane
	public void setEtatPlateu(String etatPlateu) {
		this.etatPlateu = etatPlateu;
	}
	//FARKI Imane
	public ArrayList<Continent> getContinents() {
		return this.continents;
	}
	//FARKI Imane
	public void setContinents(ArrayList<Continent> continents) {
		this.continents = continents;
	}

	public ArrayList<Joueur> getListeJoueurs() {
		return this.listeJoueurs;
	}
	/*public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}*/

	public ArrayList<CarteRisk> getPile() {
		return pile;
	}

	public void setPile(ArrayList<CarteRisk> pile) {
		this.pile = pile;
	}
	


	public void setIdPlateau(int idPlateau) {
		this.idPlateau = idPlateau;
	}


	// Tidiane Ajouter carte permet de rajouter une carte de la pile au joueur je l'utilise dans la classe joueur
	public CarteRisk ajouterCartes() {
		
		Collections.shuffle(pile);// Mélanger la pile de cartes à chaque tour

		// un index aléatoire est généré dans la plage des index de la pile de cartes
		// mélangée.
		if (!pile.isEmpty()) {
		Random random = new Random();
		int index = random.nextInt(pile.size());

		return pile.remove(index); // supprimer la carte à l'index aléatoire de la pile, et cette carte est
		}							// retournée.
		else {
			return null;
		}
	}



	@Override
	public ArrayList<CarteRisk> echangerCarte() {
		// si 
		return joueurActif.echangerCartes();
	}


//Larissa


	@Override
	public String getNom(int x, int y) {
		// TODO Auto-generated method stub
		return plateau[x][y].getNomTerritoire();}

    public void placerRegiments(Territoire ter,int nbReg) {
    	this.joueurActif.ajouterRegiment(ter, nbReg);
    }
    
    public void deplacerRegiments(Territoire terDepart, Territoire terDesti, int nbReg) {
    	this.joueurActif.deplacerRegiments(terDepart, terDesti, nbReg);
    }
    
    public Joueur proprietaireDeTer(Territoire ter) { 
    	
		Joueur proprietaire = null;
		
		for (Joueur j : this.listeJoueurs) {
			
			if (j.getListeTerritoire().contains(ter)) {
				proprietaire = j;
			}
		}
		return proprietaire;
	} 
	
	private ArrayList<Territoire> tersVoisinsParJoueur(Territoire ter){
		ArrayList<Territoire> tersDeJoueur = this.proprietaireDeTer(ter).getTerritoires();
		ArrayList<Territoire> res = ter.getListeTerritoireVoisin();
		res.retainAll(tersDeJoueur);
		return res;
	}
	
	private ArrayList<Territoire> tersNoDup (ArrayList<Territoire> ters){
		Set<Territoire> set = new HashSet<Territoire>();
		ArrayList<Territoire> newTers = new ArrayList<Territoire>();
		set.addAll(ters);
		newTers.addAll(set);
		return newTers;
	}
	
	public ArrayList<Territoire> chercherTerritoiresLiesParJoueur(Territoire ter){
		ArrayList<Territoire> tersRes = this.tersVoisinsParJoueur(ter);
		ArrayList<Territoire> tersTemp=new ArrayList<Territoire>();
		while (tersRes.size()!=tersTemp.size()) {
			tersTemp=tersRes;
			for (Territoire t : tersRes) {
				tersRes.addAll(this.tersVoisinsParJoueur(t));
			}
			this.tersNoDup(tersRes);
		}
		return tersRes;
	}
	
	public void regimentParContinent() {
		int nbReg = 0;
		for (Continent c : this.continents) {
			if (this.joueurActif.getTerritoires().containsAll(c.getListTerritoire())) {
				nbReg+=c.getBareme();
			}
		}
		this.joueurActif.setNbRegimentJoueur(nbReg+this.joueurActif.getNbRegimentJoueur());
	}
	
	public void regimentParTerritoire() {
		if (this.joueurActif.getTerritoires().size()/3<3) {
			this.joueurActif.setNbRegimentJoueur(3+this.joueurActif.getNbRegimentJoueur());
		}else {
			this.joueurActif.setNbRegimentJoueur(3+this.joueurActif.getTerritoires().size()/3);
		}
		
	}


	public void afficherVoisin(Territoire ter) {
		for (Territoire t : ter.getListeTerritoireVoisin()) {
			System.out.println(t);
		}
	}
	
	//Widad / OBTENIR LISTE DES TERRITOIRES
	
	public ArrayList<Territoire>obtenirListeTerritoire(){
		ArrayList<Territoire>listeTerritoires=new ArrayList<>();
		for (int x=0;x<plateau.length;x++) {
			for (int y=0; y<plateau[x].length;x++) {
				listeTerritoires.add(plateau[x][y]);
			}
		}
		return listeTerritoires;
	}
	
	/**parcourir la grille de territoires et retourne 
	 * une liste avec tous les territoires. double boucle for pour 
	 * parcourir les lignes et les colonnes, puis ajoute
	 *  chaque territoire à la liste listeTerritoires.*/
	
	//OBTENIR NB TERRITOIRE
	
	public int obtenirNbTerritoire() {
		return obtenirListeTerritoire().size();
	}
	
	
	// AFFICHER LES TERRITOIRES DISPONIBLES DONC QUI N'ONT PAS DE PROPRIETAIRES
	
	public ArrayList<Territoire> getTerritoireDispo(Joueur joueur){
		ArrayList<Territoire>territoiresDisponibles=new ArrayList<>();
		for (Territoire territoire : obtenirListeTerritoire()) {
			if (proprietaireDeTer(territoire)==null) {//Si pas de proprietaire,territoire disponible
				territoiresDisponibles.add(territoire);
			}
		}
		return territoiresDisponibles;
	}

	//lE JOUEUR DOIT CHOISIR LES ACTIONS QU'IL VEUT FAIRE,
	public void getPhase (int phase) {
		Scanner scanner=new Scanner (System.in);
		if (phase==1) {    // le joueur reçoit des regiments enfonction du nombre de territoire qu'il possède 
			regimentParTerritoire();
		}
		else if (phase==2) { //le joueur peut choisir d'attaquer
			System.out.println("Voulez-vous attaquer ? (Oui/Non)");
			combattre();
			//String reponse=scanner.nextLine();
			//if (reponse.equalsIgnoreCase("Oui")) {
				//Territoire territoireAttaque= choisirTerritoire("Territoire d'attaque : ");
			//	Territoire territoireDefense = choisirTerritoire ("Territoire de défense :");
				//int NbRegTer = choisirNombreRegiments("Combien de regiments souhatez-vous envoyer?");
				//attaquer(territoireAttaque,territoireDefense,NbRegTer);
			}
		 else if (phase==3) { //le joueur peut choisir de déplacer ses regiments vers ses territoires voisins
		 System.out.println("Voulez-vous déplacer des régiments ? (Oui/Non)");
		 String reponse1 = scanner.nextLine();
		 if(reponse1.equalsIgnoreCase("Oui")) {
			 deplacerRegiments(chine, afghanistan, 8);
		}else {
			System.err.println("Erreur: Phase invalide " + phase);
		}
	}else {
		System.err.println("Erreur: Phase invalide " + phase);
	}
	
	//Widad
}


	// Tidiane : Obtenir carte est utiliser pour que le joueur puisse piocher la
		// carte.
		public void obtenirCarte() {
			//si la liste de territoire est +1 : 
			CarteRisk cartePiochee = ajouterCartes();
			this.joueurActif.getCarteRisk().add(cartePiochee);

		}
		
	
	//Trophé Conquérant
	public Joueur conquerant() {
		Joueur vainqueur = null;
		int max =0;
		for (Joueur j : this.listeJoueurs) {
			
			if (max <= j.getListeTerritoire().size()) {
				max = j.getListeTerritoire().size();
				vainqueur = j;
			}
		}
		return vainqueur;
	}
	
	
    //FARKI Imane : Demander au joueur s'il veut continuer à deplacer des régiments et on retourne sa réponse
    public boolean demanderContinuerDeplacementRegiments() {
        String reponse;
        do {
            System.out.print("Voulez-vous déplacer encore des régiments ? (oui/non) : ");
            reponse = scanner.nextLine().toLowerCase();
        } while (!reponse.equals("oui") && !reponse.equals("non"));

        return reponse.equals("oui");
    }
    
  //FARKI Imane : si la reponse du joueur = oui il continue à joueur sinon on passe au joueur suivant
    public void gererTour() {
    	System.out.println("tour " + this.tour);
        Joueur joueurActuel = getJoueurActuel();
		
		boolean reponse = demanderContinuerDeplacementRegiments();
		
		if (reponse) 
			System.out.println("C'est le tour de : "+joueurActuel.getNom());
        else {
        	passerAuTourSuivant();
		    Joueur joueurSuivant = getJoueurActuel();
		    System.out.println("C'est le tour de : "+joueurSuivant.getNom());
        }
    }
}

	
