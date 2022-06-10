package entities;

public class TestAdressePostale {

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

	}

}
