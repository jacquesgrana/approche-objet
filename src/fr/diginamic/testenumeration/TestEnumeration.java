package fr.diginamic.testenumeration;

public class TestEnumeration {

	public static void main(String[] args) {
		Saison[] tabSaison = Saison.values();
		
		System.out.println("Liste des saisons :\n");
		for (Saison saison : tabSaison) {
			System.out.println(saison.getNom() + " / " + saison.getNumero());
		}
		
		String nom = "ETE";
		Saison saison = Saison.valueOf(nom);
		System.out.println("\nString : " + nom + " / Saison :  " + saison.getNom() + " / " + saison.getNumero());
		
		String libelle = "Hiver";
		Saison saisonTrouvee = Saison.getSaisonByNom(libelle);
		System.out.println("\nLibellé : " + libelle + " / Saison :  " + saisonTrouvee.getNom() + " / " + saisonTrouvee.getNumero());
	}

}
