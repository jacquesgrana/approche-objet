package entities;

public class TestAdressePostale {

	public static void main(String[] args) {
		AdressePostale adress1 = new AdressePostale(2, "rue des chats", 34000, "Montpellier");
		AdressePostale adress2 = new AdressePostale(15, "rue des oiseaux", 75000, "Paris");
		System.out.println("Adresse : " + adress1.toString());
		System.out.println("Adresse : " + adress2.toString());
	}

}
