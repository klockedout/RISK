package controler;

import model.AbstractModel;
import model.Plateau;
import model.TypeContinent;

public class Controler extends AbstractControler {

	public Controler(AbstractModel model) {
		super(model);
	}

	@Override
	public void cliqueSur(int x, int y) {
		System.out.println("Cliquer : " + x + " ; " + y);
		if (this.model instanceof Plateau) {
			Plateau plateau = (Plateau) model;

			System.out.println("Vous avez cliquer sur : " + plateau.getTerritoire(x, y));
			try{
				System.out.println("son propiétaire est : " + plateau.proprietaireDeTer(plateau.getTerritoire(x, y)));
				System.out.println("Il y a " + plateau.getTerritoire(x, y).getNbRegTer() + " regiments sur ce territoire. ");
			}catch(Exception e) {
				System.out.println("pas de propiétaire sur ce territoire");
			}

			System.out.println("----------les voisins sont : -----------------");
			plateau.afficherVoisin(plateau.getTerritoire(x, y));
		}
	}

	/*
	 * // test 1 Si fleche disponible, je fais ce qui suit : // test 2 Type case =
	 * mur in ou out je fais rien // test 3 si c'est chemin alors je met type haut
	 * // test 4 si c'est fleche haut alors je mets fleche droite // si c'est droit
	 * je met bas // si c'est gauche je met haut // test final si intFlecht = 0 je
	 * retire de la liste des cases flechées du labyrinthe je retire
	 * 
	 * if (labyrinthe.getNbFlecheMax() !=0) { if (typeCase == TypeCase.MUR ||
	 * typeCase == TypeCase.IN || typeCase == TypeCase.OUT) {
	 * 
	 * } else if (typeCase == TypeCase.CHEMIN) {
	 * labyrinthe.getEnvironnement()[x][y].setTypeCase(typeCase.FLECHE_HAUT);
	 * 
	 * } else if (typeCase == TypeCase.FLECHE_HAUT) {
	 * labyrinthe.getEnvironnement()[x][y].setTypeCase(typeCase.FLECHE_DROITE);
	 * 
	 * } else if (typeCase == TypeCase.FLECHE_DROITE) {
	 * labyrinthe.getEnvironnement()[x][y].setTypeCase(typeCase.FLECHE_BAS);
	 * 
	 * } else if (typeCase == TypeCase.FLECHE_BAS) {
	 * labyrinthe.getEnvironnement()[x][y].setTypeCase(typeCase.FLECHE_GAUCHE);
	 * 
	 * } else if (typeCase == TypeCase.FLECHE_GAUCHE) {
	 * labyrinthe.getEnvironnement()[x][y].setTypeCase(typeCase.FLECHE_HAUT);
	 * 
	 * } } }
	 * 
	 * }
	 */
	@Override
	public void calculerStepSuivant() {
		// model.faireSeDeplacerLesAnimaux();

		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		model.demandeMiseAjourVue();
	}

}
