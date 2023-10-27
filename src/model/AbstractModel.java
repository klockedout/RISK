/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

import vue.observer.Observable;
import vue.observer.Observateur;

/**
 *
 * @author david
 */
public abstract class AbstractModel implements Observable {
    private ArrayList<Observateur> observateurs;

    public AbstractModel() {
        observateurs = new ArrayList<>();
    }
    
    /*
    public abstract void faireSeDeplacerLesAnimaux();
    
    public abstract TypeCase getTypeCase(int x, int y);
    public abstract void setTypeCase(int x, int y,TypeCase tc);  */
    
    public abstract void combattre();
    public abstract int getLargeur();
    public abstract int getHauteur();
    public abstract String getNom(int x, int y);
    public abstract TypeContinent getContinent(int x, int y);
    public abstract Territoire getTerritoire(int x, int y);
    public abstract ArrayList<Territoire> getVoisin(int x, int y);
    public abstract ArrayList<CarteRisk> echangerCarte(); 
    /*
    public abstract int getNbSourisIn();
    public abstract int getNbSourisOut();*/
    public abstract int getNbRegimentPlacés();
    public abstract int getNbRegiment();
    
    public abstract boolean partieTerminer();

    @Override
    public void demandeMiseAjourVue(){
        for(Observateur o : observateurs){
            o.update();
        }
    }

    @Override
    public void removeObservateur(Observateur o){
        observateurs.remove(o);
    }

    @Override
    public void addObservateur(Observateur o){
        observateurs.add(o);
    }
    
}
