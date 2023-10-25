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
	// a commenter
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
	public void echangerCartes() {
		
		for (int i = 0; i < this.carteRisk.size(); i++) {
		
		
		
		
//	// Création du compteur de cartes
//	HashMap<TypeCarte, Integer> compteurCartes = new HashMap<>();
//
//	// Parcours de la liste des cartes du joueur et ajout au compteur
//	for (CarteRisk carte : carteRisk) {
//	    TypeCarte typeCarte = carte.getTypeCarte();
//	    
//	    if (compteurCartes.containsKey(typeCarte)) {
//	        int nombreCartes = compteurCartes.get(typeCarte);
//	        //compteur nous permet de stocker le nombre actuel de cartes dans la liste du joueur. 
//	        compteurCartes.put(typeCarte, nombreCartes + 1);
//	    } else {
//	        compteurCartes.put(typeCarte, 1);
//	    }
//
//    int nombreEchanges = 0;
//
//    // Calculer le nombre d'échange à faire 
//    for (TypeCarte type : compteurCartes.keySet()) {
//        int nombreCartes = compteurCartes.get(type);
//        if (nombreCartes >= 3) {  // Échange pour trois cartes de même type
//            // Effectuer l'échange
//            nombreEchanges++;
//        }
//    }
//
//    // Ajouter des renforts en fonction du nombre d'échanges effectués
//    
//    
//    
//    // Retirer les cartes échangées de la main du joueur
//    // ...
//
//    return ;
//}

}

}
