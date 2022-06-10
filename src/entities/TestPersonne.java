package entities;

import entities2.Personne;

public class TestPersonne {

	public static void main(String[] args) {
		AdressePostale adress1 = new AdressePostale(2, "rue des chats", 34000, "Montpellier");
		AdressePostale adress2 = new AdressePostale(15, "rue des oiseaux", 75000, "Paris");
		
		Personne pers1 = new Personne("Martin", "Martine");
		//pers1.adresse = adress1;
		pers1.setAdresse(adress1);
		pers1.afficheNomPrenom();
		System.out.println();
		
		Personne pers2 = new Personne("Dupond", "Charles", adress2);
		pers2.afficheNomPrenom();
	}

}
