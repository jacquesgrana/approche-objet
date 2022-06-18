package fr.diginamic.recensement.model;

public class Ville {

	private String codeRegion;
	private String nomRegion;
	private String codeDept;
	private String codeCom;
	private String nomCom;
	private Long populTotale;
	
	
	public Ville(String codeRegion, String nomRegion, String codeDept, String codeCom, String nomCom, Long populTotale) {
		//super();
		this.codeRegion = codeRegion;
		this.nomRegion = nomRegion;
		this.codeDept = codeDept;
		this.codeCom = codeCom;
		this.nomCom = nomCom;
		this.populTotale = populTotale;
	}


	@Override
	public String toString() {
		return "codeRegion : " + this.codeRegion + " / nomRegion : " + this.nomRegion + " / codeDept : " + this.codeDept + " / codeCom : "
				+ this.codeCom + " / nomCom : " + this.nomCom + " / populTotale : " + this.populTotale;
	}


	public String getCodeRegion() {
		return codeRegion;
	}


	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}


	public String getNomRegion() {
		return nomRegion;
	}


	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}


	public String getCodeDept() {
		return codeDept;
	}


	public void setCodeDept(String codeDept) {
		this.codeDept = codeDept;
	}


	public String getCodeCom() {
		return codeCom;
	}


	public void setCodeCom(String codeCom) {
		this.codeCom = codeCom;
	}


	public String getNomCom() {
		return nomCom;
	}


	public void setNomCom(String nomCom) {
		this.nomCom = nomCom;
	}


	public Long getPopulTotale() {
		return populTotale;
	}


	public void setPopulTotale(Long populTotale) {
		this.populTotale = populTotale;
	}
	
}
