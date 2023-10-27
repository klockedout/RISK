package risk;

import controler.Controler;
import vue.Vue;
import model.*;


import java.util.ArrayList;




public class Main {

	public static void main(String[] args) {
		Plateau model = new Plateau();
        Controler controler = new Controler(model);
        Vue v = new Vue(model,controler);
        model.addObservateur(v);
        v.setVisible(true);
        while(!model.partieTerminer()){
            controler.calculerStepSuivant();
        }

	
	
	

    // Test de obtenirListeTerritoire
    ArrayList<Territoire> listeTerritoires = model.obtenirListeTerritoire();
    for (Territoire territoire2 : listeTerritoires) {
        System.out.println("Territoire : " + territoire2.getNomTer());
    }

    // Test de obtenirNbTerritoire
    int nbTerritoires = model.obtenirNbTerritoire();
    System.out.println("Nombre de territoires : " + nbTerritoires);

	// Test de getTerritoireDispo
	Joueur joueur = new Joueur(2, "bleu", 4); // Créez un joueur ou utilisez un joueur existant
	//ArrayList<Territoire> territoiresDisponibles = model.getTerritoireDispo(joueur);
	  //  System.out.println("Territoire disponible : " + territoire.getNomTer());
	

	// Test de getTerritoireDepart

	ArrayList<Territoire> territoiresDepart = model.getTerritoireDepart(joueur);
	for (Territoire territoire : territoiresDepart) {
	    System.out.println("Territoire de départ : " + territoire.getNomTer());
	}

	// Test de getPhase
	int phase = 1; // Remplacez par la phase que vous voulez tester (1, 2 ou 3)
	model.getPhase(phase);
	}
	
	
	
}
	
