package maps;

public class Pays {
	private String nom;
	private int nombreHab;
	private String continent;
	
	public Pays(String nom, int nombreHab, String continent) {
		//super();
		this.nom = nom;
		this.nombreHab = nombreHab;
		this.continent = continent;
	}

	@Override
	public String toString() {
		return "nom : " + nom + ", nombreHab : " + nombreHab + ", continent : " + continent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombreHab() {
		return nombreHab;
	}

	public void setNombreHab(int nombreHab) {
		this.nombreHab = nombreHab;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
}
