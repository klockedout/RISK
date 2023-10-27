package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Manche {
    private ArrayList<Joueur> joueurs;
    private int tourActuel;
    //FARKI Imane
    public Manche(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
        this.tourActuel = 0; // Démarrez le tour au premier joueur
    }
    //FARKI Imane
    public Joueur getJoueurActuel() {
        return joueurs.get(tourActuel);
    }
    //FARKI Imane 
    public void passerAuTourSuivant() {
        tourActuel += 1;
    }
    //FARKI Imane : Demander au joueur s'il veut continuer à deplacer des régiments et on retourne sa réponse
    public boolean demanderContinuerDeplacementRegiments() {
        Scanner scanner = new Scanner(System.in);
        String reponse;
        do {
            System.out.print("Voulez-vous déplacer encore des régiments ? (oui/non) : ");
            reponse = scanner.nextLine().toLowerCase();
        } while (!reponse.equals("oui") && !reponse.equals("non"));

        scanner.close();

        return reponse.equals("oui");
    }
    
  //FARKI Imane : si la reponse du joueur = oui il continue à joueur sinon on passe au joueur suivant
    public void gererTour() {
        Joueur joueurActuel = getJoueurActuel();
		
		boolean reponse = demanderContinuerDeplacementRegiments();
		
		if (reponse) 
			System.out.println("C'est le tour de : "+joueurActuel.getNom());
        else {
        	passerAuTourSuivant();
		    Joueur joueurSuivant = getJoueurActuel();
		    System.out.println("C'est le tour de : "+joueurSuivant.getNom());
        }
    }
}