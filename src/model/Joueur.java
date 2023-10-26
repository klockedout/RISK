package model;

import java.util.ArrayList;
import java.util.Objects;

public class Joueur {
	
	//attribut 
	private int idPlateau;
	private String couleur;
	private int nbAttaque;
	private int nbDefense;
	//a commenter 
	private String phase;
	private int nbRegimentJoueur;
	private ArrayList <CarteRisk> carteRisk;
	private ArrayList  <Territoire> Territoire;
	//qu'est ce que c'est ? 
	Territoire territoire;
	
	//contructeur 
	
	public Joueur (int idPlateau, String couleur, int nbRegiment){
		//this.idPlateau=idPlateau;
		this.couleur=couleur;
		//this.nbRegimentJoueur = nbRegiment; 
		//liste de cartesRisk
		this.carteRisk=new ArrayList<CarteRisk>();
		//liste des territoires du joueur 
		this.Territoire=new ArrayList<Territoire>();
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
		return Territoire;
	}


	public void setTerritoire(ArrayList<Territoire> territoire) {
		Territoire = territoire;
	}


	public Territoire getTerritoire() {
		return territoire;
	}


	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}
	
	
	

}
