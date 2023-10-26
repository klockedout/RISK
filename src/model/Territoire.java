package model;

import java.util.ArrayList;
import java.util.Objects;

public class Territoire {
	
	// attribut 

	private String nomTer;
	private TypeContinent typeC; 
	private int nbRegTer;
	private ArrayList<Territoire>listeTerritoireVoisin; 

	
	//constructeur 
	Territoire(String nom, TypeContinent typeC){
		this.nomTer=nom;
		this.nbRegTer=0;
		this.typeC = typeC; 
		this.listeTerritoireVoisin = new ArrayList<>();
		
		}
	
	//methodes 
	
/*
	private TypeTerritoire typeTer; 
	//FARKI Imane	
	Territoire(String nom){
		this.nbRegTer=0;
		this.nomTer=nom;
	}
	 
	//FARKI Imane
	public  TypeTerritoire getTypeTerritoire() {
		return this.typeTer;
	}*/
	//FARKI Imane

	public String getNomTerritoire() {
		return this.nomTer;
	}
	//FARKI Imane
	public String getNomTer() {
		return nomTer;
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

	@Override
	public int hashCode() {
		return Objects.hash(nomTer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Territoire other = (Territoire) obj;
		return Objects.equals(nomTer, other.nomTer);
	}
	
	
	

	//methode qui ajouter un regiment sur un territoire 
//Debut Larissa
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
//Fin Larissa

	
	
	//recuperer le joueur le plus fort dans un territoire
	public Joueur getVainqueur() {
		return null; 
		
	}

	@Override
	public String toString() {
		return nomTer;
	}

	
	//methode qui ajouter un regiment sur un territoire 
	
}