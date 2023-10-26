package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Joueur {

	// attribut
	private int idPlateau;
	private String couleur;
	private int nbAttaque;
	private int nbDefense;
	private int echanger = 0;
	private String phase;
	private int nbRegimentJoueur;
	private ArrayList<CarteRisk> carteRisk;
	private ArrayList<Territoire> Territoire;
	// qu'est ce que c'est ?
	Territoire territoire;
	
	// Tidiane j'ai rajouter la variable plateau pouvoir importer la methode ajouter
	// carte dans cette classe

	private Plateau plateau;

	// contructeur

	public Joueur(int idPlateau, String couleur, int nbRegiment) {
		// this.idPlateau=idPlateau;
		this.couleur = couleur;
		this.nbRegimentJoueur = nbRegiment;
		// liste de cartesRisk
		this.carteRisk = new ArrayList<CarteRisk>();
		// liste des territoires du joueur
		this.Territoire = new ArrayList<Territoire>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(couleur, idPlateau);
	}

//à commenter 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		return Objects.equals(couleur, other.couleur) && idPlateau == other.idPlateau;
	}

	public int getIdPlateau() {
		return idPlateau;
	}

	public void setIdPlateau(int idPlateau) {
		this.idPlateau = idPlateau;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getNbAttaque() {
		return nbAttaque;
	}

	public void setNbAttaque(int nbAttaque) {
		this.nbAttaque = nbAttaque;
	}

	public int getNbDefense() {
		return nbDefense;
	}

	public void setNbDefense(int nbDefense) {
		this.nbDefense = nbDefense;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public int getNbRegimentJoueur() {
		return nbRegimentJoueur;
	}

	public void setNbRegimentJoueur(int nbRegimentJoueur) {
		this.nbRegimentJoueur = nbRegimentJoueur;
	}

	public ArrayList<CarteRisk> getCarteRisk() {
		return carteRisk;
	}

	public void setCarteRisk(ArrayList<CarteRisk> carteRisk) {
		this.carteRisk = carteRisk;
	}

	public ArrayList<Territoire> getListeTerritoire() {
		return Territoire;
	}

	public void setTerritoire(ArrayList<Territoire> territoire) {
		Territoire = territoire;
	}

	public Territoire getTerritoire() {
		return territoire;
	}

	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}

	// Tidiane : Obtenir carte est utiliser pour que le joueur puisse piocher la
	// carte.
	public void obtenirCarte() {
		//si la liste de territoire est +1 : 
		CarteRisk cartePiochee = plateau.ajouterCartes();
		carteRisk.add(cartePiochee);

	}

	// Tidiane Pour afficher les cartes d'un joueur
	public void afficherCartes() {

		for (int i = 0; i < this.carteRisk.size(); i++) {

			System.out.println("Actuellement vous avez :" + "\nLa carte" + this.carteRisk.get(i).getNomCarte()
					+ "et elle est de type : " + this.carteRisk.get(i).getTypeCarte());
		}

	}

	// Tidiane Pour échanger les cartes
	public ArrayList<CarteRisk> echangerCartes() {

		// Creer une liste de cavlaerie ...
		ArrayList<CarteRisk> cavalerie = new ArrayList<>();
		ArrayList<CarteRisk> infanterie = new ArrayList<>();
		ArrayList<CarteRisk> artillerie = new ArrayList<>();
		ArrayList<CarteRisk> joker = new ArrayList<>();

		

		
		int compteurArtillerie = 0;
		int compteurInfanterie = 0;
		int compteurCavalerie = 0;
		int compteurJoker = 0;

		for (CarteRisk carte : carteRisk) {
			TypeCarte typeCarte = carte.getTypeCarte();

			if (typeCarte == TypeCarte.ARTILLERIE) {
				artillerie.add(carte);
				compteurArtillerie++;
			} else if (typeCarte == TypeCarte.INFANTERIE) {
				infanterie.add(carte);
				compteurInfanterie++;
			} else if (typeCarte == TypeCarte.CAVALERIE) {
				cavalerie.add(carte);
				compteurCavalerie++;
			}
			else if (typeCarte == TypeCarte.JOKER) {
				joker.add(carte);
				compteurJoker++;
			}
		}
		
		
		
		/*
		 * 1. 3 differents carterisk 
		 * 2. 3 mm carterisk
		 * 3. 2 carterisk (differents ou pareil) + joker
		 * 4. au moins 1 des 3 cartes échanger has your territoire = +2 regiments
		 */

		// Vérification des conditions d'échange
		if (compteurArtillerie >= 3 || compteurInfanterie >= 3 || compteurCavalerie >= 3
				|| (compteurArtillerie >= 1 && compteurInfanterie >= 1 && compteurCavalerie >= 1) 
				|| (compteurArtillerie >= 1 && compteurInfanterie >= 1 && compteurJoker >= 1)
				|| (compteurArtillerie >= 1 && compteurCavalerie >= 1 && compteurJoker >= 1)
				|| (compteurInfanterie >= 1 && compteurInfanterie >= 1 && compteurJoker >= 1)
				|| (compteurArtillerie >= 2 && compteurJoker >= 1)
				|| (compteurInfanterie >= 2 && compteurJoker >= 1)
				|| (compteurCavalerie >= 2 && compteurJoker >= 1)) 
		{
			this.echanger++;
		}

		// Ajouter des régiments en fonction du nombre d'échanges effectués
		if (this.echanger >= 1 && this.echanger <= 5) {
		     this.nbRegimentJoueur += 2 * this.echanger + 2;
		} else if (this.echanger >= 6) {
		    this.nbRegimentJoueur += 10 + 5 * (this.echanger - 5);
		}
		
		// Retirer les cartes échangées de la main du joueur
		
		carteRisk.removeAll(artillerie);
		carteRisk.removeAll(infanterie);
		carteRisk.removeAll(cavalerie);
		
		return carteRisk;

		return carteRisk; 
	}
	

}
