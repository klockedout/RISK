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


	public int getNbRegTer() {
		return nbRegTer;
	}


	public void setNbRegTer(int nbRegTer) {
		this.nbRegTer = nbRegTer;
	}


	public Territoire getTerDepart() {
		return terDepart;
	}


	public void setTerDepart(Territoire terDepart) {
		this.terDepart = terDepart;
	}


	public Territoire getTerDes() {
		return terDes;
	}


	public void setTerDes(Territoire terDes) {
		this.terDes = terDes;
	}
	
	

}
