package fr.diginamic.banque.entites;

public class Debit extends Operation {
	
	public Debit(String dateOper, float montantOper) {
		super(dateOper, montantOper);
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return "DEBIT";
	}

}
