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
	private TypeTerritoire typeCase;
	private ArrayList<Territoire> listTerritoires;
	private HashMap<Territoire, Joueur> territoiresControles;
	
	public Continent(String nomCont, TypeTerritoire typeCase){
		this.nomCont=nomCont;
		this.typeCase = typeCase;
		this.listTerritoires=new ArrayList<Territoire>();
		this.territoiresControles = new HashMap<Territoire, Joueur>();
	}
	//FARKI Imane
	public String getNom() {
		return this.nomCont;
	}
	//FARKI Imane
	public TypeTerritoire getTypeCase() {
		return this.typeCase; 
	}
	//FARKI Imane
	public ArrayList<Territoire> getListTerritoire() {
			return this.listTerritoires; 
		}
	//FARKI Imane
	public ArrayList<Territoire> getListeTerritoire(Continent nomContinent) {
        ArrayList<Territoire> territoiresContinent = new ArrayList<>();

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
  //FARKI Imane
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

	

