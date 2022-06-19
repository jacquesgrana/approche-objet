package fr.diginamic.recensement.model;

/**
 * Classes des objets régions. 
 * 
 * codeRegion : code de la région, 
 * nomRegion : nom de la région, 
 * populTotale : population de la région. 
 * 
 * @author jacques granarolo
 */
public class Region {

	private String codeRegion;
	private String nomRegion;
	private Long populTotale;
	
	/**
	 * Constructeur
	 * 
	 * @param codeRegion
	 * @param nomRegion
	 * @param populTotale
	 */
	public Region(String codeRegion, String nomRegion, Long populTotale) {
		this.codeRegion = codeRegion;
		this.nomRegion = nomRegion;
		this.populTotale = populTotale;
	}

	@Override
	public String toString() {
		return "codeRegion : " + this.codeRegion + " / nomRegion : " + this.nomRegion + " / populTotale : " + this.populTotale;
	}
	
	/**
	 * Surcharge de la méthode équals() : définit les critères pour pouvoir utiliser contains() et equals()
	 */
	@Override
	public boolean equals(Object o){
		Region regionToTest = (Region) o;
		boolean codeRegionEquals = regionToTest.getCodeRegion().equals(this.getCodeRegion());
		boolean nomRegionEquals = regionToTest.getNomRegion().equals(this.getNomRegion());
		return (codeRegionEquals && nomRegionEquals);
	}
	
	public Region clone() {
		return new Region(this.codeRegion, this.nomRegion, this.populTotale);
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
