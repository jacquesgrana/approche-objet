package tri;

public class Ville implements Comparable<Ville>{
	private String nom;
	private long nombreHab;
	
	public Ville(String nom, long nombreHab) {
		//super();
		this.nom = nom;
		this.nombreHab = nombreHab;
	}
	
	public Ville clone() {
		return new Ville(this.nom, this.nombreHab);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getNombreHab() {
		return nombreHab;
	}

	public void setNombreHab(long nombreHab) {
		this.nombreHab = nombreHab;
	}

	@Override
	public int compareTo(Ville villeToCompare) {
		
		if (this.nombreHab > villeToCompare.getNombreHab()) {
			return 1;
		}
		else if(this.nombreHab < villeToCompare.getNombreHab()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	/*
	 @Override
	public int compareTo(Ville villeToCompare) {
		return this.nom.compareTo(villeToCompare.getNom());
	} 
	 
	 */

	@Override
	public String toString() {
		return "nom : " + this.nom + ", nombreHab : " + this.nombreHab;
	}

}
