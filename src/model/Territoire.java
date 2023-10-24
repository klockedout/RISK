package model;

import java.util.ArrayList;

public class Territoire {
	String nomTer;
	int nbRegTer;
	private TypeTerritoire typeTer; 
	
	Territoire(String nom){
		this.nbRegTer=0;
		this.nomTer=nom;
	}
	//methodes 
	
	public  TypeTerritoire getTypeTerritoire() {
		return this.typeTer;
	}
	
	public String getNomTerritoire() {
		return this.nomTer;
	}
	
	public int getNbRegTer() {
		return this.nbRegTer;
	}
	public Joueur getVainqueur() {
		return null; 
		
	}

	//methode qui ajouter un regiment sur un territoire 

	//recuperer le joueur le plus fort dans un territoire
}