	
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
			
		}

	}

