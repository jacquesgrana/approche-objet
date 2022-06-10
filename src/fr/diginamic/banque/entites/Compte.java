package fr.diginamic.banque.entites;

public class Compte {
	private String numeroCompte;
	private float soldeCompte;
	
	public Compte(String numeroCompte, float soldeCompte) {
		this.numeroCompte = numeroCompte;
		this.soldeCompte = soldeCompte;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public float getSoldeCompte() {
		return soldeCompte;
	}

	public void setSoldeCompte(float soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", soldeCompte=" + soldeCompte + "]";
	}
	
	
}
