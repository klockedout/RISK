package model;

import java.util.ArrayList;

public class Territoire {
	String nomTer;
	int nbRegTer;
	ArrayList<Territoire>listeTerritoireVoisin; 
	
	Territoire(String nom){
		this.nbRegTer=0;
		this.nomTer=nom;
		}
	
	//methodes 
	

	
	public String getNomTerritoire() {
		return this.nomTer;
	}
	
	public int getNbRegTer() {
		return this.nbRegTer;
	}
	public Joueur getVainqueur() {
		return null; 
		
	}
	public ArrayList<Territoire> getListeTerritoireVoisin() {
			return this.listeTerritoireVoisin;
	}
	
	public void ajouterTerritoireVoisin(Territoire voisin) {
	    if (listeTerritoireVoisin == null) {
	        listeTerritoireVoisin = new ArrayList<>();
	    }
	    listeTerritoireVoisin.add(voisin);
	}

	//methode qui ajouter un regiment sur un territoire 

	//recuperer le joueur le plus fort dans un territoire
}