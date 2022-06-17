package fichier;

public class Ville {
	private String Nom;
	private String CodeDep;
	private String nomRegion;
    private long popTotale;
    
	public Ville(String nom, String codeDep, String nomRegion, long popTotale) {
		super();
		this.Nom = nom;
		this.CodeDep = codeDep;
		this.nomRegion = nomRegion;
		this.popTotale = popTotale;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public String getCodeDep() {
		return CodeDep;
	}

	public void setCodeDep(String codeDep) {
		this.CodeDep = codeDep;
	}

	public String getNomRegion() {
		return nomRegion;
	}

	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	public long getPopTotale() {
		return popTotale;
	}

	public void setPopTotale(long popTotale) {
		this.popTotale = popTotale;
	}

	@Override
	public String toString() {
		return "Nom : " + this.Nom + ", CodeDep : " + this.CodeDep + ", nomRegion : " + this.nomRegion + ", popTotale : " + this.popTotale;
	}
    
    
}
