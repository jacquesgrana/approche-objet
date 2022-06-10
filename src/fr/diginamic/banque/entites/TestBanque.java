package fr.diginamic.banque.entites;

public class TestBanque {

	public static void main(String[] args) {
		
		Compte monCompte = new Compte(15348677, 1200.65f);	
		System.out.println(monCompte.toString());
	}

}
