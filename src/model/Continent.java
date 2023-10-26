package model;
import java.util.ArrayList;

public class Continent {
	private String nomCont;
	private ArrayList<Territoire> territoires;
	
	Continent(String nomCont){
		this.nomCont=nomCont;
		this.territoires=new ArrayList<Territoire>();
	}

	public String getNomCont() {
		return nomCont;
	}

	public void setNomCont(String nomCont) {
		this.nomCont = nomCont;
	}

	public ArrayList<Territoire> getTerritoires() {
		return territoires;
	}

	public void setTerritoires(ArrayList<Territoire> territoires) {
		this.territoires = territoires;
	}
	
	
}
