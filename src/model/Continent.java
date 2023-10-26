package model;
import java.util.ArrayList;

public class Continent {
	private String nomCont;
	private Territoire territoire;
	private ArrayList<Territoire> listTerritoires;
	
	public Continent(String nomCont){
		this.nomCont=nomCont;
		this.listTerritoires=new ArrayList<Territoire>();
	}
	
	public String getNom() {
		return this.nomCont;
	}
	public String getTerritoire() {
		return this.territoire.getNomTerritoire();
	}
	public ArrayList<Territoire> getListTerritoire() {
			return this.listTerritoires; 
		}
	public ArrayList<Territoire> construireListeTerritoires(){
		
		return this.listTerritoires;
	}
//	   public  ArrayList<Territoire obtenirTerritoiresParContinent(TypeContinent typeContinent) {
//	        ArrayList<Territoire> territoiresParContinent = new ArrayList<>();
//	        for (Territoire territoire : Territoire) {
//	            if (territoire.typeC.equals(typeContinent)) {
//	                territoiresParContinent.add(territoire);
//	            }
//	        }
//	        return territoiresParContinent;
//	    }
	}

