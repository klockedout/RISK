package model;

public class Place {
	private int nbRegTer;
	private Territoire terDepart;
	private Territoire terDes;
	
	
	Place (int nbRegTer,Territoire terDepart,Territoire terDes){
		this.nbRegTer=nbRegTer;
		this.terDepart=terDepart;
		this.terDes=terDes;
	


		/*public String modifierNbRegiments(Territoire terDepart, Territoire terDes) {
			
			
			return "Modif à été faite" ;
		
		}*/
	}

	//FARKI Imane
	public int getNbRegTer() {
		return nbRegTer;
	}

	//FARKI Imane
	public void setNbRegTer(int nbRegTer) {
		this.nbRegTer = nbRegTer;
	}

	//FARKI Imane
	public Territoire getTerDepart() {
		return terDepart;
	}

	//FARKI Imane
	public void setTerDepart(Territoire terDepart) {
		this.terDepart = terDepart;
	}

	//FARKI Imane
	public Territoire getTerDes() {
		return terDes;
	}

	//FARKI Imane
	public void setTerDes(Territoire terDes) {
		this.terDes = terDes;
	}
	
	

}
