package model;

import java.util.ArrayList;
import java.util.Objects;

public class Joueur {
	
	private int idPlateau;
	private String couleur;
	private int nbAttaque;
	private int nbDefense;
	private String phase;
	private int nbRegimentJoueur;
	private ArrayList <CarteRisk> carteRisk;
	private ArrayList  <Territoire> Territoire;
	Territoire territoire;
	
	
	Joueur (int idPlateau, String couleur){
		this.idPlateau=idPlateau;
		this.couleur=couleur;
		this.carteRisk=new ArrayList<CarteRisk>();
		this.Territoire=new ArrayList<Territoire>();
	}


	@Override
	public int hashCode() {
		return Objects.hash(couleur, idPlateau);
	}


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
	
	

}
