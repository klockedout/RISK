package model;
import java.util.ArrayList;

public class Continent {
	private String nomCont;
	private ArrayList<Territoire> Territoires;
	
	Continent(String nomCont){
		this.nomCont=nomCont;
		this.Territoires=new ArrayList<Territoire>();
	}
}
