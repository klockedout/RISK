	
	package model;

	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class ConnexionBD {
		
	    private static String URL = "jdbc:mysql://localhost:3306/risk";
	    private static String UTILISATEUR = "root";
	    private static String MOT_DE_PASSE = "";

	    private static Connection connexion;

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
	    
	   public static Connection getConnexion() {
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
			
			String url = "jdbc:mysql://localhost:3306/risk";
	        String utilisateur = "root";
	        String motDePasse = "";

	            try {
	            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

	            Statement statement = connexion.createStatement();

	            int score = 13;
		    	
		        String req = "INSERT INTO scorejoueur (scoreJoueur, joueur) VALUES (?, joueur = (SELECT numInscription FROM joueur WHERE nomJoueur = ?)))";
		        PreparedStatement statement1 = null;
		        String nom = "FARKI";

		        try {
		            statement1 = connexion.prepareStatement(req);
		            statement1.setDouble(1, score);
		            statement1.setString(2, nom);
		            statement1.executeUpdate();	
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	    
		}
	}
	    	
			/*try {
		           
	            Class.forName("com.mysql.jdbc.Driver");
	        	connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
	            System.out.println("Connexion à la base de données réussie.");
	        } catch (ClassNotFoundException e) {
	            System.err.println("Erreur de chargement du pilote JDBC : " + e.getMessage());
	        } catch (SQLException e) {
	            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
	        }
			// chaque territoire = 1 point
	    	int score = 13;
	    	
	        String req = "INSERT INTO scorejoueur (scoreJoueur, joueur) VALUES (?, joueur = (SELECT numInscription FROM joueur WHERE nomJoueur = ?)))";
	        PreparedStatement statement = null;
	        String nom = "FARKI";

	        try {
	            statement = connexion.prepareStatement(req);
	            statement.setDouble(1, score);
	            statement.setString(2, nom);
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
	            }*/
	

