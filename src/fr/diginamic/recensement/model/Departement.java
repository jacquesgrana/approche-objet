package fr.diginamic.recensement.model;

/**
 * Classe des objets départements. 
 * 
 * codeDept : code du département de la ville, 
 * codeReg : code de la région du département, 
 * nomDept : nom du département, 
 * populTotale : population du département. 
 * 
 * @author jacques granarolo
 */
// TODO ajouter attributs : codeReg et nomDept
public class Departement {
	private String codeDept;
	private String codeReg;
	private String nomDept;
	private Long populTotale;
	
	/**
	 * Constructeur : 
	 * 
	 * @param codeDept : code du département, 
	 * @param codeReg : code de la région du département, 
	 * @param nomDept : nom du département, 
	 * @param populTotale : population du département. 
	 */
	public Departement(String codeDept, String codeReg, String nomDept, Long populTotale) {
		//super();
		this.codeDept = codeDept;
		this.codeReg = codeReg;
		this.nomDept = nomDept;
		this.populTotale = populTotale;
	}
	
	/**
	 * Méthode qui renvoie un clone de l'objet courant. 
	 */
	public Departement clone() {
		return new Departement(this.codeDept, this.codeReg, this.nomDept, this.populTotale);
	}

	@Override
	public String toString() {
		return "codeDept : " + this.codeDept + " / codeRegion : " + this.codeReg + " / nomDept : " + this.nomDept + " / populTotale : " + this.populTotale;
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

	public String getCodeReg() {
		return codeReg;
	}

	public void setCodeReg(String codeReg) {
		this.codeReg = codeReg;
	}

	public String getNomDept() {
		return nomDept;
	}

	public void setNomDept(String nomDept) {
		this.nomDept = nomDept;
	}

	public Long getPopulTotale() {
		return this.populTotale;
	}

	public void setPopulTotale(Long populTotale) {
		this.populTotale = populTotale;
	}

}
