package fr.diginamic.testenumeration;

public enum Saison {
	
	PRINTEMPS ("Printemps", 1),
	ETE ("Eté", 2),
	AUTOMNE ("Automne", 3),
	HIVER ("Hiver", 4);


	private String nom;
	private Integer numero;
	
	private Saison(String nom, int numero) {
		this.nom = nom;
		this.numero = numero;
	}
	
	public static Saison getSaisonByNom(String nom) {
		Saison[] tabSaison = Saison.values();
		for (Saison saison : tabSaison) {
			if (saison.getNom().equals(nom)) {
				return saison;
			}
		}
		return null;
	}

	public String getNom() {
		return nom;
	}

	public Integer getNumero() {
		return numero;
	}
	
}
