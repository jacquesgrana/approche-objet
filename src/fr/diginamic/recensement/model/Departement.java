package fr.diginamic.recensement.model;

/**
 * Classe des objets départements. 
 * 
 * codeDept : code du département de la ville, 
 * populTotale : population de la commune. 
 * 
 * @author jacques granarolo
 */
public class Departement {
	private String codeDept;
	private Long populTotale;
	
	/**
	 * Constructeur
	 * 
	 * @param codeDept
	 * @param populTotale
	 */
	public Departement(String codeDept, Long populTotale) {
		//super();
		this.codeDept = codeDept;
		this.populTotale = populTotale;
	}
	
	/**
	 * Méthode qui renvoie un clone de l'objet courant. 
	 */
	public Departement clone() {
		return new Departement(this.codeDept, this.populTotale);
	}

	@Override
	public String toString() {
		return "codeDept : " + this.codeDept + " / populTotale : " + this.populTotale;
	}
	
	/**
	 * Surcharge de la méthode équals() : définit les critères pour pouvoir utiliser contains() et equals()
	 */
	@Override
	public boolean equals(Object o){
		Departement dtpToTest = (Departement) o;
		boolean codeDeptEquals = dtpToTest.codeDept.equals(this.codeDept);
		return (codeDeptEquals);
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
