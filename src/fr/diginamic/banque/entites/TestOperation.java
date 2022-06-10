package fr.diginamic.banque.entites;

public class TestOperation {

	public static void main(String[] args) {
		Credit cred1 = new Credit("15/12/22", 1500.0f);
		Credit cred2 = new Credit("23/12/22", 250.0f);
		Debit deb1 = new Debit("24/12/22", 1300.0f);
		Debit deb2 = new Debit("25/12/22", 50.0f);
		
		Operation[] myTab = {cred1, cred2, deb1, deb2};
		
		float montant = 0.0f;
		
		for (int i=0; i<myTab.length; i++) {
			System.out.println(i + " Date : " + myTab[i].getDateOper() + " Montant : " + myTab[i].getMontantOper() + " Type : " + myTab[i].getType());
			
			if (myTab[i].getType() == "CREDIT") {
				montant += myTab[i].getMontantOper();
			}
			else if (myTab[i].getType() == "DEBIT") {
				montant -= myTab[i].getMontantOper();
			}
		}
		
		System.out.println();
		System.out.println("Montant opérations : " + montant);
	}

}
