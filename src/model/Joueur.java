package model;

import java.util.ArrayList;
import java.util.Objects;

public class Joueur {
	
	//attribut 
	private String nom;
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
		this.nbRegimentJoueur = nbRegiment; 
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

	//FARKI Imane
	public int getIdPlateau() {
		return this.idPlateau;
	}

	//FARKI Imane
	public void setIdPlateau(int idPlateau) {
		this.idPlateau = idPlateau;
	}

	//FARKI Imane
	public String getCouleur() {
		return this.couleur;
	}
	//FARKI Imane
	public String getNom() {
		return this.nom;
	}
	//FARKI Imane
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	//FARKI Imane
	public int getNbAttaque() {
		return this.nbAttaque;
	}

	//FARKI Imane
	public void setNbAttaque(int nbAttaque) {
		this.nbAttaque = nbAttaque;
	}

	//FARKI Imane
	public int getNbDefense() {
		return this.nbDefense;
	}

	//FARKI Imane
	public void setNbDefense(int nbDefense) {
		this.nbDefense = nbDefense;
	}

	//FARKI Imane
	public String getPhase() {
		return this.phase;
	}

	//FARKI Imane
	public void setPhase(String phase) {
		this.phase = phase;
	}

	//FARKI Imane
	public int getNbRegimentJoueur() {
		return this.nbRegimentJoueur;
	}

	//FARKI Imane
	public void setNbRegimentJoueur(int nbRegimentJoueur) {
		this.nbRegimentJoueur = nbRegimentJoueur;
	}

	//FARKI Imane
	public ArrayList<CarteRisk> getCarteRisk() {
		return this.carteRisk;
	}

	//FARKI Imane
	public void setCarteRisk(ArrayList<CarteRisk> carteRisk) {
		this.carteRisk = carteRisk;
	}

	//FARKI Imane
	public ArrayList<Territoire> getListeTerritoire() {
		return this.Territoire;
	}

	//FARKI Imane
	public void setTerritoire(ArrayList<Territoire> territoire) {
		this.Territoire = territoire;
	}

	//FARKI Imane
	public Territoire getTerritoire() {
		return this.territoire;
	}

	//FARKI Imane
	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}
	
	

}
