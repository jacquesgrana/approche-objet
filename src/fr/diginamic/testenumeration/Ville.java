package fr.diginamic.testenumeration;

public class Ville {
	private String nom;
	private long nombreHab;
	private Continent continent;
	
	public Ville(String nom, long nombreHab, Continent continent) {
		//super();
		this.nom = nom;
		this.nombreHab = nombreHab;
		this.continent = continent;
	}
	
	public Ville clone() {
		return new Ville(this.nom, this.nombreHab, this.continent);
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

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}
/*
	@Override
	public String toString() {
		return "nom : " + this.nom + " / nombreHab : " + this.nombreHab + " / continent : " + this.continent.toString();
	}*/

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("nom : ");
		builder.append(nom);
		builder.append(" / nombreHab : ");
		builder.append(nombreHab);
		builder.append(" / continent : ");
		builder.append(continent);
		return builder.toString();
	}
	
	
	
	

}
