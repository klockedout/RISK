/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JLabel;

import controler.AbstractControler;
import controler.Controler;

import model.AbstractModel;
import model.Plateau;
import model.Regiment;

import vue.PanelJeu;
import vue.observer.Observateur;


public class Vue extends javax.swing.JFrame implements Observateur{

    private AbstractModel model;
    private MouseListener mouseListener;
    private AbstractControler controler;
    private final JLabel barre_etat;
    /**
     * Creates new form 
     * @param model
     * @param controler
     */
    public Vue(AbstractModel model, AbstractControler controler) {
        this.model = model;
        this.controler = controler;
        initComponents();
        this.mouseListener = new MouseListener(controler);
        this.panelJeu.addMouseListener(this.mouseListener);
        this.barre_etat = new JLabel("Barre d'Etat");
    }
    
    public void dessinerJeu(){
       //labelNomTerritoire.setText("Le territoire : "+ model.getNom());
        /*labelNbSourisOut.setText("nombre souris sauvées : "+ model.getNbSourisOut());
        labelNbFleches.setText("Flèches : "+ model.getNbFlecheUtilisee()+"/"+model.getNbFlecheMax());
        */
        int h = this.panelJeu.getWidth();
        int l = this.panelJeu.getHeight();
        int x, y, cote;
        if(l/model.getLargeur() > h/model.getHauteur()){
            cote = h/model.getHauteur();
            y = (int) ((l-(cote*model.getLargeur()))/2.f);
            x = 0;
        } else {
            cote = l/model.getLargeur();
            x = (int) ((h-(cote*model.getHauteur()))/2.f);
            y = 0;
        }
        this.mouseListener.updateDimension(x, y, x+cote*model.getHauteur(), y+cote*model.getLargeur(), cote);
        for(int xP=0; xP<model.getHauteur();xP++){
            for(int yP=0; yP<model.getLargeur();yP++){
                switch(model.getContinent(xP, yP)){
                case OCEAN : 
                        panelJeu.drawOcean(x+xP*cote, y+yP*cote, cote);
                    break;
                case AFRIQUE : 
                        panelJeu.drawAfrique(x+xP*cote, y+yP*cote, cote);
                    break;
                case ASIE : 
                    panelJeu.drawAsie(x+xP*cote, y+yP*cote, cote);
                break;
                case AMERIQUEN : 
                    panelJeu.drawAmeriqueNord(x+xP*cote, y+yP*cote, cote);
                break;
                case AMERIQUESUD: 
                    panelJeu.drawAmeriqueSud(x+xP*cote, y+yP*cote, cote);
                break;
                case EUROPE : 
                    panelJeu.drawEurope(x+xP*cote, y+yP*cote, cote);
                break;
                case AUSTRALIE : 
                    panelJeu.drawOceanie(x+xP*cote, y+yP*cote, cote);
                break;
                case BORDURE : 
                    panelJeu.drawBordure(x+xP*cote, y+yP*cote, cote);
                break;
                case FLECHE_HAUT : 
                        panelJeu.drawCaseFlecheHaut(x+xP*cote, y+yP*cote, cote);
                    break;
                case FLECHE_DROITE : 
                        panelJeu.drawCaseFlecheDroite(x+xP*cote, y+yP*cote, cote);
                    break;
                case FLECHE_BAS : 
                        panelJeu.drawCaseFlecheBas(x+xP*cote, y+yP*cote, cote);
                    break;
                case FLECHE_GAUCHE : 
                        panelJeu.drawCaseFlecheGauche(x+xP*cote, y+yP*cote, cote);
                    break;
                }
                
                /*if(model.getAnimalPlusFort(xP, yP) instanceof Souris){
                    panelJeu.drawSouris(x+xP*cote, y+yP*cote, cote);
                } else if(model.getAnimalPlusFort(xP, yP) instanceof Chat){
                    panelJeu.drawChat(x+xP*cote, y+yP*cote, cote);
                }*/
            
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNbSourisIN = new javax.swing.JLabel();
        labelNbFleches = new javax.swing.JLabel();
        labelNbSourisOut = new javax.swing.JLabel();
        panelJeu = new vue.PanelJeu(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       labelNbSourisIN.setText("Nom Territoire");

        labelNbFleches.setText("NbRegiment");

       labelNbSourisOut.setText("Joueur");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelNbSourisIN, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNbSourisOut, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNbFleches, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            //taille de la largeur de la fenetre
            .addComponent(panelJeu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            		///taille de la longueur de la fenetre 
                .addComponent(panelJeu, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNbSourisIN)
                    .addComponent(labelNbFleches)
                    .addComponent(labelNbSourisOut)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelNbFleches;
    private javax.swing.JLabel labelNbSourisIN;
    private javax.swing.JLabel labelNbSourisOut;
    private vue.PanelJeu panelJeu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        repaint();
    }
}
