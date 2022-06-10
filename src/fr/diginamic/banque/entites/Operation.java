package fr.diginamic.banque.entites;

public abstract class Operation {
	
	private String dateOper;
	private float montantOper;
	
	
	public Operation(String dateOper, float montantOper) {
		this.dateOper = dateOper;
		this.montantOper = montantOper;
	}
	
	public abstract String getType();

	public String getDateOper() {
		return dateOper;
	}

	public void setDateOper(String dateOper) {
		this.dateOper = dateOper;
	}

	public float getMontantOper() {
		return montantOper;
	}

	public void setMontantOper(float montantOper) {
		this.montantOper = montantOper;
	}
	
	
}
