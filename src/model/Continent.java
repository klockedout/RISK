package model;
import java.util.ArrayList;

public class Continent {
	private String nomCont;
	private TypeTerritoire typeCase;
	private ArrayList<Territoire> listTerritoires;
	
	public Continent(String nomCont, TypeTerritoire typeCase){
		this.nomCont=nomCont;
		this.typeCase = typeCase;
		this.listTerritoires=new ArrayList<Territoire>();
	}
	
	public String getNom() {
		return this.nomCont;
	}
	
	public TypeTerritoire getTypeCase() {
		return this.typeCase; 
	}
	public ArrayList<Territoire> getListTerritoire() {
			return this.listTerritoires; 
		}
	}

