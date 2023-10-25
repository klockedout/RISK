package model;

import java.util.ArrayList;

public class Territoire {
	String nomTer;
	int nbRegTer;
	Continent continent; 
	
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

	//methode qui ajouter un regiment sur un territoire 

	//recuperer le joueur le plus fort dans un territoire
}