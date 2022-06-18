package fr.diginamic.recensement.model;

public class Region {

	private String codeRegion;
	private String nomRegion;
	private Long populTotale;
	
	public Region(String codeRegion, String nomRegion, Long populTotale) {
		//super();
		this.codeRegion = codeRegion;
		this.nomRegion = nomRegion;
		this.populTotale = populTotale;
	}

	@Override
	public String toString() {
		return "codeRegion : " + this.codeRegion + " / nomRegion : " + this.nomRegion + " / populTotale : " + this.populTotale;
	}

	public String getCodeRegion() {
		return this.codeRegion;
	}

	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}

	public String getNomRegion() {
		return this.nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	public Long getPopulTotale() {
		return this.populTotale;
	}

	public void setPopulTotale(Long populTotale) {
		this.populTotale = populTotale;
	}
	
}
