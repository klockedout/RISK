package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Manche {
    private ArrayList<Joueur> joueurs;
    private int tourActuel;

    public Manche(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
        this.tourActuel = 0; // Démarrez le tour au premier joueur
    }

    public Joueur getJoueurActuel() {
        return joueurs.get(tourActuel);
    }

    public void passerAuTourSuivant() {
        tourActuel += 1;
    }

    public static boolean demanderContinuerDeplacementRegiments() {
        Scanner scanner = new Scanner(System.in);
        String reponse;
        do {
            System.out.print("Voulez-vous déplacer encore des régiments ? (oui/non) : ");
            reponse = scanner.nextLine().toLowerCase();
        } while (!reponse.equals("oui") && !reponse.equals("non"));

        scanner.close();

        return reponse.equals("oui");
    }
    public void gererTour() {
        Joueur joueurActuel = getJoueurActuel();
		
		boolean reponse = demanderContinuerDeplacementRegiments();
		
		if (reponse) 
			System.out.println("C'est le tour de : "+joueurActuel.getNom());
        // la logique métier spécifique à la gestion du tour (une fois le joueur a fini de deplacer les régiments)
        // Exécutez ici les actions du joueur actuel
        else {
        	passerAuTourSuivant();
		    Joueur joueurSuivant = getJoueurActuel();
		    System.out.println("C'est le tour de : "+joueurSuivant.getNom());
        }
    }
}