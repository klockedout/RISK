package model;
import java.sql.*;

import model.TypeCarte;

public class CarteRisk {
	private String nomCarte;
	TypeCarte typeCarte;
	
	CarteRisk(String nom, TypeCarte typeCarte) {
		this.nomCarte=nom;
		this.typeCarte=typeCarte;
	}

	public String getNomCarte() {
		return nomCarte;
	}

	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}

	public TypeCarte getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(TypeCarte typeCarte) {
		this.typeCarte = typeCarte;
	}
	
	

}
