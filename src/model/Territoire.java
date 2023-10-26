package model;

import java.util.ArrayList;
import java.util.Objects;

public class Territoire {
	String nomTer;
	int nbRegTer;
	private TypeTerritoire typeTer; 
	
	Territoire(String nom, TypeTerritoire typeTer){
		this.nbRegTer=0;
		this.nomTer=nom;
		this.typeTer = typeTer; 
	}
	//methodes 
	
	public  TypeTerritoire getTypeTerritoire() {
		return this.typeTer;
	}
	
	public String getNomTerritoire() {
		return this.nomTer;
	}

	public String getNomTer() {
		return nomTer;
	}

	public void setNomTer(String nomTer) {
		this.nomTer = nomTer;
	}

	public int getNbRegTer() {
		return nbRegTer;
	}

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

	//recuperer le joueur le plus fort dans un territoire
}