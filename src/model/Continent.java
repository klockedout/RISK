package model;
import java.sql.Connection;
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
	
	public String getNom() {
		return this.nomCont;
	}
	
	public TypeTerritoire getTypeCase() {
		return this.typeCase; 
	}
	
	public ArrayList<Territoire> getListTerritoire() {
			return this.listTerritoires; 
		}
	
	public ArrayList<Territoire> getListeTerritoire(Continent nomContinent) {
        ArrayList<Territoire> territoiresContinent = new ArrayList<>();

        for (Territoire territoire : listTerritoires) {
            if (territoire.getTypeTerritoire().equals(nomContinent.getTypeCase())) {
                territoiresContinent.add(territoire);
            }
        }
        return territoiresContinent;
    }
	
    public void attribuerTerritoire(Territoire territoire, Joueur joueur) {
        territoiresControles.put(territoire, joueur);
    }

    public boolean territoireControle(Territoire territoire, Joueur joueur) {
        return territoiresControles.get(territoire) == joueur;
    }

    public int getNombreTerritoiresControles(Joueur joueur) {
        int nombreTerritoires = 0;
        for (Territoire territoire : territoiresControles.keySet()) {
            if (territoireControle(territoire, joueur)) {
            	nombreTerritoires++;
            }
        }
        return nombreTerritoires;
    }
    
    public void calculerScore(Joueur joueur) {
		
    	Connection connection;
		connection = ConnexionBD.getConnexion();
    	
		// chaque territoire = 1 point
    	int score = getNombreTerritoiresControles(joueur);
    	
        String req = "INSERT INTO scorejoueur (scoreJoueur, joueur) VALUES (?, joueur = (SELECT numInscription FROM joueur WHERE nomJoueur = ?)))";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(req);
            statement.setDouble(1, score);
            statement.setString(2, joueur.getNom());
            statement.executeUpdate();	
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //fermer le PreparedStatement soit aprés le try ou aprés le catch
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

	}

