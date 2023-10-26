package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Joueur {
	
	//attribut 
	private int idPlateau;
	private String couleur;
	private int nbRegimentJoueur;
	private int nbAttaque;
	private int nbDefense;
	//a commenter 
	private ArrayList<Integer> resultatDe; //NA
	private String phase;
	
	private ArrayList <CarteRisk> carteRisk;
	private ArrayList  <Territoire> listeTerritoire; //NA
	
	private Territoire territoire;
	
	//contructeur 
	public Joueur (int idPlateau, String couleur, int nbRegiment){
		//this.idPlateau=idPlateau;
		this.couleur=couleur;
		this.nbRegimentJoueur = nbRegiment;
		//this.nbRegimentJoueur = nbRegiment; 
		//liste de cartesRisk
		this.carteRisk=new ArrayList<CarteRisk>();
		//liste des territoires du joueur 
		this.listeTerritoire=new ArrayList<Territoire>();
		this.resultatDe = new ArrayList<Integer>();
	}


	@Override
	public int hashCode() {
		return Objects.hash(couleur, idPlateau);
	}

//à commenter 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		return Objects.equals(couleur, other.couleur) && idPlateau == other.idPlateau;
	}


	public int getIdPlateau() {
		return idPlateau;
	}


	public void setIdPlateau(int idPlateau) {
		this.idPlateau = idPlateau;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public int getNbAttaque() {
		return nbAttaque;
	}


	public void setNbAttaque(int nbAttaque) {
		this.nbAttaque = nbAttaque;
	}


	public int getNbDefense() {
		return nbDefense;
	}


	public void setNbDefense(int nbDefense) {
		this.nbDefense = nbDefense;
	}
	
	
	public ArrayList<Integer> getResultatDe(){
		return this.resultatDe;
	}


	public String getPhase() {
		return phase;
	}


	public void setPhase(String phase) {
		this.phase = phase;
	}


	public int getNbRegimentJoueur() {
		return nbRegimentJoueur;
	}


	public void setNbRegimentJoueur(int nbRegimentJoueur) {
		this.nbRegimentJoueur = nbRegimentJoueur;
	}


	public ArrayList<CarteRisk> getCarteRisk() {
		return carteRisk;
	}


	public void setCarteRisk(ArrayList<CarteRisk> carteRisk) {
		this.carteRisk = carteRisk;
	}


	public ArrayList<Territoire> getListeTerritoire() {
		return listeTerritoire;
	}


	public void setTerritoire(ArrayList<Territoire> territoire) {
		listeTerritoire = territoire;
	}


	public Territoire getTerritoire() {
		return territoire;
	}


	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}
	
	
	public ArrayList<Integer> lancerDe(int nbDe) { // code Nam An
		this.resultatDe.clear();
		
		while ( this.resultatDe.size() < nbDe ) {
			int random = (int) (Math.random() * 6) + 1;
        	this.resultatDe.add(random);
		}
		
		//Mettre en ordre décroissant
		Collections.sort(this.resultatDe, Collections.reverseOrder());
		
		System.out.println(this.resultatDe);
		return this.resultatDe;
	}
	
	
	
	public void defendre(int nbRegiment) {
		lancerDe(nbRegiment);
	}
}
