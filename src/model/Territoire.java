package model;

import java.util.ArrayList;

public class Territoire {
	String nomTer;
	int nbRegTer;
	private TypeTerritoire typeTer; 
	//FARKI Imane	
	Territoire(String nom){
		this.nbRegTer=0;
		this.nomTer=nom;
	}
	 
	//FARKI Imane
	public  TypeTerritoire getTypeTerritoire() {
		return this.typeTer;
	}
	//FARKI Imane
	public String getNomTerritoire() {
		return this.nomTer;
	}
	//FARKI Imane
	public String getNomTer() {
		return nomTer;
	}
	
	public Joueur getVainqueur() {
		return null; 
		
	}
	//FARKI Imane
	public void setNomTer(String nomTer) {
		this.nomTer = nomTer;
	}
	//FARKI Imane
	public int getNbRegTer() {
		return nbRegTer;
	}
	//FARKI Imane
	public void setNbRegTer(int nbRegTer) {
		this.nbRegTer = nbRegTer;
	}
	
	

	//methode qui ajouter un regiment sur un territoire 

	//recuperer le joueur le plus fort dans un territoire
}