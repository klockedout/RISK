package model;

import java.util.ArrayList;

public class Continent {
	private String nomCont;
	private TypeTerritoire typeCase;
	private Territoire territoire;
	private ArrayList<Territoire> listTerritoires;
	//attribut
	public Continent(String nomCont, TypeTerritoire typeCase) {
		this.nomCont = nomCont;
		this.typeCase = typeCase;
		this.listTerritoires = new ArrayList<Territoire>();
	}

//	public String getNomCont() {
//		return nomCont;
//	}
//
//	public void setNomCont(String nomCont) {
//		this.nomCont = nomCont;
//	}
//
//	public ArrayList<Territoire> getTerritoires() {
//		return Territoires;
//	}
//
//	public void setTerritoires(ArrayList<Territoire> territoires) {
//		Territoires = territoires;
//	}
//	
//	
//}
//dernier version Larissa

	public String getNom() {
		return this.nomCont;
	}

	public TypeTerritoire getTypeTerritoire() {
		return this.typeCase;
	}

	public void setTypeT(TypeTerritoire typeT) {
		this.typeCase = typeT;
	}

	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}

	public ArrayList<Territoire> getListTerritoire() {
			return this.listTerritoires;
	}

}

>>>>>>>larissa
