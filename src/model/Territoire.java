package model;

public class Territoire {
	String nomTer;
	int nbRegTer;
	
	Territoire(String nom){
		this.nbRegTer=0;
		this.nomTer=nom;
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
	
	

}