package model;
import java.util.ArrayList;

public class Continent {
	private String nomCont;
	private Territoire territoire;
	private int bareme; 
	private ArrayList<Territoire> listTerritoires; 
	
	public Continent(String nomCont, int bareme){
		this.nomCont=nomCont;
		this.listTerritoires=new ArrayList<Territoire>();
		this.bareme = bareme; 
	}

	public String getNom() {
		return this.nomCont;
	}
	public String getTerritoire() {
		return this.territoire.getNomTerritoire();
	}
	public int getBareme() {
		return this.bareme; 
	}
	public ArrayList<Territoire> getListTerritoire() {
			return this.listTerritoires; 
		}
	
	public void ajouterContinent(ArrayList<Continent> liste, Continent continent) {
		if(liste == null) {
			liste = new ArrayList<Continent>();
		}
		    liste.add(continent);
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
	


	public ArrayList<Territoire> getListTerritoires() {
		return this.listTerritoires;
	}

	public void setTerritoires(ArrayList<Territoire> territoires) {
		this.listTerritoires = territoires;
	}
	
	
}
