package sets;

public class Pays {
	private String nom;
	private long nombreHab;
	private double pibParHab;
	
	public Pays(String nom, long nombreHab, double pibParHab) {
		//super();
		this.nom = nom;
		this.nombreHab = nombreHab;
		this.pibParHab = pibParHab;
	}
	
	
	
	public double getPib() {
		return this.pibParHab * this.nombreHab;
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

	public double getPibParHab() {
		return pibParHab;
	}

	public void setPibParHab(double pibParHab) {
		this.pibParHab = pibParHab;
	}

	@Override
	public String toString() {
		return "nom : " + this.nom + ", pop : " + this.nombreHab + ", pib/hab : " + this.pibParHab + ", pib : " + this.getPib();
	}
	
	
}
