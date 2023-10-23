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

}
