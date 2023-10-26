package model;

import java.util.ArrayList;

public class Territoire {
	
	// attribut 
	String nomTer;
	TypeContinent typeC; 
	int nbRegTer;
	ArrayList<Territoire>listeTerritoireVoisin; 
	
	//constructeur 
	Territoire(String nom, TypeContinent typeC){
		this.nomTer=nom;
		this.nbRegTer=0;
		this.typeC = typeC; 
		this.listeTerritoireVoisin = new ArrayList<>();
		
		}
	
	//methodes 
	
	public String getNomTerritoire() {
		return this.nomTer;
	}
	
	public int getNbRegTer() {
		return this.nbRegTer;
	}

	public TypeContinent getContinent() {
		return this.typeC; 
	}
	
	public void setTypeT(TypeContinent typeC) {
		this.typeC = typeC;
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

	
	//recuperer le joueur le plus fort dans un territoire
	public Joueur getVainqueur() {
		return null; 
		
	}

	//methode qui ajouter un regiment sur un territoire 
	
}