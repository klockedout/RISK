/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.MouseEvent;

import model.AbstractModel;


/**
 *
 * @author david
 */
public abstract class AbstractControler {
    protected AbstractModel model;
    
    public AbstractControler(AbstractModel model){
        this.model = model;
    }
    
    public abstract void cliqueSur(int x, int y);
    public abstract void calculerStepSuivant();

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
