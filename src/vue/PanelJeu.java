/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author david
 */
public class PanelJeu extends javax.swing.JPanel {
    private Vue fenetre;
    private Graphics cg;
    
    public PanelJeu(Vue fenetre) {
        this.fenetre = fenetre;
    }
    
    public PanelJeu() {
    }
    
    
    
    public void paintComponent (Graphics g) {
        cg = g;
	super.paintComponent (cg) ;
        if(fenetre != null){
            fenetre.dessinerJeu();
        }
    }
    
    public void drawOcean(int x, int y,int cote){
        cg.drawImage(RessourcesImages.OCEAN, x , y , cote, cote ,this);
    }
    
    public void drawCaseChemin(int x, int y,int cote){
        cg.drawImage(RessourcesImages.CHEMIN, x , y , cote, cote ,this);
        
    }
    
    public void drawCaseFlecheHaut(int x, int y,int cote){
        Graphics2D g2d=(Graphics2D)cg;
        this.drawCaseChemin(x, y, cote);
        g2d.rotate(-Math.PI/2.d, x+cote/2, y+cote/2);
        cg.drawImage(RessourcesImages.FLECHE, x , y , cote, cote ,this);
        g2d.rotate(Math.PI/2.d, x+cote/2, y+cote/2);
        
    }


    public void drawCaseFlecheBas(int x, int y,int cote){
        Graphics2D g2d=(Graphics2D)cg;
        this.drawCaseChemin(x, y, cote);
        g2d.rotate(Math.PI/2.d, x+cote/2, y+cote/2);
        cg.drawImage(RessourcesImages.FLECHE, x , y , cote, cote ,this);
        g2d.rotate(-Math.PI/2.d, x+cote/2, y+cote/2);
    }
    
    public void drawCaseFlecheGauche(int x, int y,int cote){
        Graphics2D g2d=(Graphics2D)cg;
        this.drawCaseChemin(x, y, cote);
        g2d.rotate(Math.PI, x+cote/2, y+cote/2);
        cg.drawImage(RessourcesImages.FLECHE, x , y , cote, cote ,this);
        g2d.rotate(Math.PI, x+cote/2, y+cote/2);
    }
    
    public void drawCaseFlecheDroite(int x, int y,int cote){
        this.drawCaseChemin(x, y, cote);
        cg.drawImage(RessourcesImages.FLECHE, x , y , cote, cote ,this);
    }
}
