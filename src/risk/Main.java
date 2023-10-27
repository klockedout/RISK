package risk;

import controler.Controler;
import vue.Vue;
import controler.AbstractControler;
import model.*;
import model.Territoire;

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

		/*Controler controler = new Controler(model);
		Vue v = new Vue(model, controler);
		model.addObservateur(v);
		v.setVisible(true);
		while (!model.partieTerminer()) {
			controler.calculerStepSuivant();
		}*/



	    // Test obtenirListeTerritoire
	    ArrayList<Territoire> listeTerritoires = model.obtenirListeTerritoire();
	    for (Territoire territoire2 : listeTerritoires) {
	        System.out.println("Territoire : " + territoire2.getNomTer());
	    }
	   
	    // Test obtenirNbTerritoire
	    int nbTerritoires = model.obtenirNbTerritoire();
	    System.out.println("Nombre de territoires : " + nbTerritoires);
	
		// Test getTerritoireDispo
		Joueur joueur = new Joueur(2, "bleu", 4); 
		ArrayList<Territoire> territoiresDisponibles = model.getTerritoireDispo(joueur);
		for (Territoire territoire : territoiresDisponibles) {
			System.out.println("Territoire disponible : " + territoire.getNomTer());
		
		}
		// Test getTerritoireDepart
		ArrayList<Territoire> territoiresDepart = model.getTerritoireDepart(joueur);
		for (Territoire territoire : territoiresDepart) {
		    System.out.println("Territoire de départ : " + territoire.getNomTer());
		}
 
	
	}
}
	
