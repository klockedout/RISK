package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Continent {
	private TypeContinent tc;
	private Territoire territoire;
	private ArrayList<Territoire> listTerritoires;
	private HashMap<Territoire, Joueur> territoiresControles;

	private HashMap<Continent, Territoire[]> continentTerritoires;

	private int bareme; 
	
	public Continent(TypeContinent tc, int bareme){
		this.tc = tc;
		this.listTerritoires=new ArrayList<Territoire>();
		this.territoiresControles = new HashMap<Territoire, Joueur>();

		this.continentTerritoires= new HashMap<Continent, Territoire[]>();
 
		this.bareme = bareme; 
	}
	
	public void attribuerContinentTerritoires(Continent continent) {
		this.continentTerritoires.put(continent, null); 
	}

	public TypeContinent getNom() {
		return this.tc;
	}
	public String getTerritoire() {
		return this.territoire.getNomTerritoire();


	}


	//FARKI Imane
	public ArrayList<Territoire> getListTerritoire() {
			return this.listTerritoires; 
		}

	public int getBareme() {
		return this.bareme; 
	}

	
	public void ajouterContinent(ArrayList<Continent> liste, Continent continent) {
	      if (liste == null) {
	            liste = new ArrayList<>();
	        }
		    liste.add(continent);
	}

	public ArrayList<Territoire> construireListeTerritoires(){
		return this.listTerritoires;
	}
	
	//FARKI Imane : avoir la liste des territoires pour un continent donné
	
    /*    
	public ArrayList<Territoire> getListeTerritoire(Continent nomContinent) {
        ArrayList<Territoire> territoiresContinent = new ArrayList<>();
        for (Territoire territoire : listTerritoires) {
            if (territoire.getContinent().equals(nomContinent)) {
                territoiresContinent.add(territoire);
            }
        }
        return territoiresContinent;}
	*/
  //FARKI Imane
     //public void attribuerTerritoire(Territoire territoire, Joueur joueur) {
        //territoiresControles.put(territoire, joueur);
    //}

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
      



	public ArrayList<Territoire> getListTerritoires() {
		return this.listTerritoires;
	}


	public void setTerritoires(ArrayList<Territoire> territoires) {
		this.listTerritoires = territoires;
	}
	
	
}

	


