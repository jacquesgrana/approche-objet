package fr.diginamic.recensement.model;

public class Departement {
	private String codeDept;
	private Long populTotale;
	
	public Departement(String codeDept, Long populTotale) {
		//super();
		this.codeDept = codeDept;
		this.populTotale = populTotale;
	}

	@Override
	public String toString() {
		return "codeDept : " + this.codeDept + " / populTotale : " + this.populTotale;
	}
	
	@Override
	public boolean equals(Object o){
		Departement dtpToTest = (Departement) o;
		boolean codeDeptEquals = dtpToTest.codeDept.equals(this.codeDept);
		//boolean popDptEquals = dtpToTest.getPopulTotale() == this.getPopulTotale();
		return (codeDeptEquals); // && popDptEquals
	}

	public String getCodeDept() {
		return this.codeDept;
	}

	public void setCodeDept(String codeDept) {
		this.codeDept = codeDept;
	}

	public Long getPopulTotale() {
		return this.populTotale;
	}

	public void setPopulTotale(Long populTotale) {
		this.populTotale = populTotale;
	}

}
