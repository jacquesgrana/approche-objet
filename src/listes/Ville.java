package listes;

import java.util.Objects;

public class Ville {
	private String nom;
	private long nombreHab;
	
	public Ville(String nom, long nombreHab) {
		//super();
		this.nom = nom;
		this.nombreHab = nombreHab;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ville)) {
			return false;
		}
		Ville other = (Ville) obj;
		return Objects.equals(nom, other.nom) && nombreHab == other.nombreHab;
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

}
