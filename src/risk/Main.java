package risk;

import controler.Controler;
import vue.Vue;
import controler.AbstractControler;
import model.*;
import controler.*;


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
	}
} 

        	

