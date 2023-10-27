package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Objects;

public class Joueur {

	// attribut
	private int idPlateau;
	private String couleur;
	private int echanger = 0;
	private String phase;
	private int nbRegimentJoueur;
	private ArrayList<CarteRisk> carteRisk;
	private ArrayList<Territoire> territoires;
	// qu'est ce que c'est ?
	private Territoire territoire;
	
	// Tidiane j'ai rajouter la variable plateau pouvoir importer la methode ajouter
	private Plateau plateau;
	//NA
	private int nbAttaque;
	private int nbDefenseReussi;
	private int obtenu1;
	private ArrayList  <Territoire> listeTerritoire; 
	private ArrayList<Integer> resultatDe; 
	//fin NA
	
	//contructeur 
	public Joueur (int idPlateau, String couleur, int nbRegiment){
		//this.idPlateau=idPlateau;
		this.couleur=couleur;
		this.nbRegimentJoueur = nbRegiment;
		this.obtenu1 = 0;
		this.nbAttaque = 0;
		this.nbDefenseReussi = 0;
		this.resultatDe = new ArrayList<Integer>();
		//liste de cartesRisk
		this.carteRisk=new ArrayList<CarteRisk>();
		//liste des territoires du joueur 
		this.listeTerritoire=new ArrayList<Territoire>();
		this.territoires = new ArrayList<Territoire>();
		
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
		return this.idPlateau;
	}

	public void setIdPlateau(int idPlateau) {
		this.idPlateau = idPlateau;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getNbAttaque() {
		return this.nbAttaque;
	}

	public void setNbAttaque(int nbAttaque) {
		this.nbAttaque = nbAttaque;
	}


	public int getNbDefenseReussi() {
		return this.nbDefenseReussi;
	}


	public void setNbDefenseReussi(int nbDefenseReussi) {
		this.nbDefenseReussi = nbDefenseReussi;
	}
	
	
	public ArrayList<Integer> getResultatDe(){
		return this.resultatDe;
	}

	public String getPhase() {
		return this.phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public int getNbRegimentJoueur() {
		return this.nbRegimentJoueur;
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

	public ArrayList<Territoire> getTerritoires() {
		return territoires;
	}


	public void setTerritoires(ArrayList<Territoire> territoires) {
		this.territoires = territoires;
	}

	public ArrayList<Territoire> getListeTerritoire() {
		return this.listeTerritoire;
	}


	public void setTerritoire(ArrayList<Territoire> territoire) {
		this.listeTerritoire = territoire;
	}

	public Territoire getTerritoire() {
		return this.territoire;
	}

	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}

	

	// Tidiane Pour afficher les cartes d'un joueur
	public void afficherCartes() {

		for (int i = 0; i < this.carteRisk.size(); i++) {

			System.out.println("Actuellement vous avez :" + "\nLa carte" + this.carteRisk.get(i).getNomCarte()
					+ "et elle est de type : " + this.carteRisk.get(i).getTypeCarte());
		}

	}  

	// Tidiane Pour échanger les cartes
	public ArrayList<CarteRisk> echangerCartes() {

		// Creer une liste de cavlaerie ...
		ArrayList<CarteRisk> cavalerie = new ArrayList<>();
		ArrayList<CarteRisk> infanterie = new ArrayList<>();
		ArrayList<CarteRisk> artillerie = new ArrayList<>();
		ArrayList<CarteRisk> joker = new ArrayList<>();

		
		int compteurArtillerie = 0;
		int compteurInfanterie = 0;
		int compteurCavalerie = 0;
		int compteurJoker = 0;

		for (CarteRisk carte : carteRisk) {
			TypeCarte typeCarte = carte.getTypeCarte();

			if (typeCarte == TypeCarte.ARTILLERIE) {
				artillerie.add(carte);
				compteurArtillerie++;
			} else if (typeCarte == TypeCarte.INFANTERIE) {
				infanterie.add(carte);
				compteurInfanterie++;
			} else if (typeCarte == TypeCarte.CAVALERIE) {
				cavalerie.add(carte);
				compteurCavalerie++;
			}
			else if (typeCarte == TypeCarte.JOKER) {
				joker.add(carte);
				compteurJoker++;
			}
		}
		
		
		
		/*
		 * 1. 3 differents carterisk 
		 * 2. 3 mm carterisk
		 * 3. 2 carterisk (differents ou pareil) + joker
		 * 4. au moins 1 des 3 cartes échanger has your territoire = +2 regiments
		 */

		// Vérification des conditions d'échange
		if (compteurArtillerie >= 3 || compteurInfanterie >= 3 || compteurCavalerie >= 3
				|| (compteurArtillerie >= 1 && compteurInfanterie >= 1 && compteurCavalerie >= 1) 
				|| (compteurArtillerie >= 1 && compteurInfanterie >= 1 && compteurJoker >= 1)
				|| (compteurArtillerie >= 1 && compteurCavalerie >= 1 && compteurJoker >= 1)
				|| (compteurInfanterie >= 1 && compteurInfanterie >= 1 && compteurJoker >= 1)
				|| (compteurArtillerie >= 2 && compteurJoker >= 1)
				|| (compteurInfanterie >= 2 && compteurJoker >= 1)
				|| (compteurCavalerie >= 2 && compteurJoker >= 1)) 
		{
			this.echanger++;
		}

		// Ajouter des régiments en fonction du nombre d'échanges effectués
		if (this.echanger >= 1 && this.echanger <= 5) {
		     this.nbRegimentJoueur += 2 * this.echanger + 2;
		} else if (this.echanger >= 6) {
		    this.nbRegimentJoueur += 10 + 5 * (this.echanger - 5);
		}
		
		// Retirer les cartes échangées de la main du joueur
		
		carteRisk.removeAll(artillerie);
		carteRisk.removeAll(infanterie);
		carteRisk.removeAll(cavalerie);
		
		return carteRisk;

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


	@Override
	public String toString() {
		return "Joueur [idPlateau=" + idPlateau + ", couleur=" + couleur + "]";
	}
		
	//NA
	public ArrayList<Integer> lancerDe(int nbDe) { 
		this.resultatDe.clear();
		
		while ( this.resultatDe.size() < nbDe ) {
			int random = (int) (Math.random() * 6) + 1;
        	this.resultatDe.add(random);
		}
		
		//compteur point trophé "le malchanceux"
		for (int res : this.resultatDe) {
			
			if (res ==1 ) {
				this.obtenu1 +=1;
			}
		}
		
		//Mettre en ordre décroissant
		Collections.sort(this.resultatDe, Collections.reverseOrder());
		
		System.out.println(this.resultatDe);
		return this.resultatDe;
	}
	
}
