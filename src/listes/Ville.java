package listes;

public class Ville {
	private String nom;
	private long nombreHab;
	
	public Ville(String nom, long nombreHab) {
		super();
		this.nom = nom;
		this.nombreHab = nombreHab;
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

}
