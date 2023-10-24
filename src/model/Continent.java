package model;
import java.util.ArrayList;

public class Continent {
	private String nomCont;
	private ArrayList<Territoire> Territoires;
	
	Continent(String nomCont){
		this.nomCont=nomCont;
		this.Territoires=new ArrayList<Territoire>();
	}

	public String getNomCont() {
		return nomCont;
	}

	public void setNomCont(String nomCont) {
		this.nomCont = nomCont;
	}

	public ArrayList<Territoire> getTerritoires() {
		return Territoires;
	}

	public void setTerritoires(ArrayList<Territoire> territoires) {
		Territoires = territoires;
	}
	
	
}
