package fr.diginamic.banque.entites;

public class TestBanque {

	public static void main(String[] args) {
		
		Compte monCompte = new Compte("15348677", 1200.65f);	
		System.out.println(monCompte.toString());
		System.out.println();
		
		Compte[] myTab = new Compte[2];
		CompteTaux monCompteTaux = new CompteTaux ("875633134", 8530.52f, 1.25f);
		
		myTab[0] = monCompte;
		myTab[1] = monCompteTaux;
		
		for (int i=0; i<myTab.length; i++) {
			System.out.println(i + " : " + myTab[i].toString());
		}
	}

}
