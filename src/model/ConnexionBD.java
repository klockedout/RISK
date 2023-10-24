	
	package model;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class ConnexionBD {
		
	    private String URL = "jdbc:mysql://localhost:3306/risk";
	    private String UTILISATEUR = "root";
	    private String MOT_DE_PASSE = "";

	    private Connection connexion;

	    public ConnexionBD() {
	        try {
	           
	            Class.forName("com.mysql.jdbc.Driver");
	        	connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
	            System.out.println("Connexion à la base de données réussie.");
	        } catch (ClassNotFoundException e) {
	            System.err.println("Erreur de chargement du pilote JDBC : " + e.getMessage());
	        } catch (SQLException e) {
	            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
	        }
	    }
	    
	   public Connection getConnexion() {
	        return connexion;
	    }

	    public void fermerConnexion() {
	        if (connexion != null) {
	            try {
	                connexion.close();
	                System.out.println("Connexion à la base de données fermée.");
	            } catch (SQLException e) {
	                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
	            }
	        }
	    }

		public static void main(String[] args) {
			/*
		    String URL = "jdbc:mysql://localhost:3306/risk";
		    String UTILISATEUR = "root";
		    String MOT_DE_PASSE = "";
			
			try {
	            
	            Connection connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
	            Statement statement = connexion.createStatement();
	            
	            String requeteSQL = "SELECT * FROM joueur";

	            ResultSet resultat = statement.executeQuery(requeteSQL);

	            while (resultat.next()) {
	                int id = resultat.getInt("numInscription");
	                String nom = resultat.getString("nomJoueur");
	                String prenom = resultat.getString("prenomJoueur");

	                System.out.println("ID : " + id + ", Nom : " + nom + ", Prenom : " + prenom);
	            }

	            resultat.close();
	            statement.close();
	            connexion.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }*/

		}

	}

