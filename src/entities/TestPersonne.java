package entities;

import entities2.Personne;

public class TestPersonne {

	public static void main(String[] args) {
		AdressePostale adress1 = new AdressePostale();
		adress1.numeroRue = 2;
		adress1.libelleRue = "rue des chats";
		adress1.codePostal = 34000;
		adress1.ville = "Montpellier";
		
		AdressePostale adress2 = new AdressePostale();
		adress2.numeroRue = 15;
		adress2.libelleRue = "rue des oiseaux";
		adress2.codePostal = 75000;
		adress2.ville = "Paris";
		
		Personne pers1 = new Personne();
		pers1.nom = "Martin";
		pers1.prenom = "Martine";
		pers1.adresse = adress1;
		
		Personne pers2 = new Personne();
		pers2.nom = "Dupond";
		pers2.prenom = "Charles";
		pers2.adresse = adress2;

	}

}
