package model;
import java.util.ArrayList;

public class Continent {
	private String nomCont;
	private TypeTerritoire typeCase;
	private Territoire territoire;
	private ArrayList<Territoire> listTerritoires;
	
	public Continent(String nomCont, TypeTerritoire typeCase){
		this.nomCont=nomCont;
		this.typeCase = typeCase;
		this.listTerritoires=new ArrayList<Territoire>();
	}
	
	public String getNom() {
		return this.nomCont;
	}
	
	public  TypeTerritoire getTypeTerritoire() {
		return this.typeCase;
	}
	public void setTypeT(TypeTerritoire typeT) {
		this.typeCase = typeT;
	}
	public void setTerritoire( Territoire territoire) {
		this.territoire = territoire;
	}
	public String getTerritoire() {
		return this.territoire.getNomTerritoire();
	}
	public ArrayList<Territoire> getListTerritoire() {
			return this.listTerritoires; 
		}
	}

