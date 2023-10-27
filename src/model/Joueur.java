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
	private ArrayList <Territoire> territoires;
	//qu'est ce que c'est ? 
	Territoire territoire;
	Plateau plateau;
	Continent continent;
	

	//contructeur 
	
	public Joueur (int idPlateau, String couleur, int nbRegiment){
		//this.idPlateau=idPlateau;
		this.couleur=couleur;
		//this.nbRegimentJoueur = nbRegiment; 
		//liste de cartesRisk
		this.carteRisk=new ArrayList<CarteRisk>();
		//liste des territoires du joueur 
		this.territoires=new ArrayList<Territoire>();
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
		return this.territoires;
	}

	public void setTerritoire(ArrayList<Territoire> territoire) {
		this.territoires= territoire;
	}
	

	
	//Debut Larissa

	public boolean conquerirContinent(Continent continent) {
		for(Territoire t : plateau.getListeTerritoire(continent)) {
			if(!this.territoires.contains(t)) {
				return false;
			}
		}
		//on parcourt les ele
		return true; 
	}
//	//Fin Larissa

	public ArrayList<Territoire> getTerritoires() {
		return territoires;
	}


	public void setTerritoires(ArrayList<Territoire> territoires) {
		this.territoires = territoires;
	}


	public Territoire getTerritoire() {
		return territoire;
	}


	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}
	
	public void ajouterRegiment(Territoire ter,int nbReg) {
		if (this.territoires.contains(ter)&&this.nbRegimentJoueur>=nbReg) {
			ter.setNbRegTer(nbReg+ter.getNbRegTer());
			this.nbRegimentJoueur-=nbReg;
		} else {
			System.out.println("opération pas possible");
		}
	}
	
	public void deplacerRegiments(Territoire terDepart, Territoire terDesti, int nbReg) {
		if (this.territoires.contains(terDepart)&&this.territoires.contains(terDesti)&&terDepart.getNbRegTer()>nbReg) {
			terDepart.setNbRegTer(terDepart.getNbRegTer()-nbReg);
			terDesti.setNbRegTer(terDesti.getNbRegTer()+nbReg);;
		} else {
			System.out.println("opération pas possible");
		}
    }
	

	public int regimentParTerritoire() {
		if (this.territoires.size()/3<3) {
			return 3;
		}else {
			return this.territoires.size()/3;
		}		
	}
	
	

}
