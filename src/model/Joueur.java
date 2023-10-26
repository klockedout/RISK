package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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


	public int getNbAttaque() {

		return this.nbAttaque;
	}


	public void setNbAttaque(int nbAttaque) {
		this.nbAttaque = nbAttaque;
	}


	public int getNbDefense() {
		return this.nbDefense;
	}

	public void setNbDefense(int nbDefense) {
		this.nbDefense = nbDefense;
	}

	public String getPhase() {
		return this.phase;
	}


	public int getNbRegimentJoueur() {
		return nbRegimentJoueur;
	}

	public void setNbRegimentJoueur(int nbRegimentJoueur) {
		this.nbRegimentJoueur = nbRegimentJoueur;
	}

	public ArrayList<CarteRisk> getCarteRisk() {
		return this.carteRisk;
	}


	public void setCarteRisk(ArrayList<CarteRisk> carteRisk) {
		this.carteRisk = carteRisk;
	}

	public ArrayList<Territoire> getListeTerritoire() {
		return this.Territoire;
	}

	public void setTerritoire(ArrayList<Territoire> territoire) {
		this.Territoire = territoire;
	}
	
	public Territoire getTerritoire() {
		return this.territoire;
	}

	
	//Debut Larissa

//	public boolean conquerirContinent(Continent continent) {
//		for(Territoire t : continent.getTerritoires()) {
//			if(!this.Territoire.contains(t)) {
//				return false;
//			}
//		}
//		//on parcourt les ele
//		return true; 
//	}
	//Fin Larissa
	

}
