package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Continent {
	private String nomCont;
	private Territoire territoire;
	private ArrayList<Territoire> listTerritoires;
	private HashMap<Territoire, Joueur> territoiresControles;
	
	public Continent(String nomCont){
		this.nomCont=nomCont;
		this.listTerritoires=new ArrayList<Territoire>();
		this.territoiresControles = new HashMap<Territoire, Joueur>();
	}


	public String getNom() {
		return this.nomCont;
	}
	public String getTerritoire() {
		return this.territoire.getNomTerritoire();

	//FARKI Imane
	/*public TypeTerritoire getTypeCase() {
		return this.typeCase; }*/

	}
	//FARKI Imane
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


/*Teritoire
	//FARKI Imane : avoir la liste des territoires pour un continent donné
	public ArrayList<Territoire> getListeTerritoire(Continent nomContinent) {
        ArrayList<Territoire> territoiresContinent = new ArrayList<>();
        //nomContinent.getTypeCase() : retourne TypeTerritoire pour un continent
        for (Territoire territoire : listTerritoires) {
            if (territoire.getTypeTerritoire().equals(nomContinent.getTypeCase())) {
                territoiresContinent.add(territoire);
            }
        }
        return territoiresContinent;
    }
	//FARKI Imane
    public void attribuerTerritoire(Territoire territoire, Joueur joueur) {
        territoiresControles.put(territoire, joueur);
    }
  //FARKI Imane
    public boolean territoireControle(Territoire territoire, Joueur joueur) {
        return territoiresControles.get(territoire) == joueur;
    }
  //FARKI Imane : retourne le nombre des territoires conquis par un joueur donné
    public int getNombreTerritoiresControles(Joueur joueur) {
        int nombreTerritoires = 0;
        for (Territoire territoire : territoiresControles.keySet()) {
            if (territoireControle(territoire, joueur)) {
            	nombreTerritoires++;
            }
        }
        return nombreTerritoires;
    }
      
}

	

*/
