package fr.diginamic.banque.entites;

public class CompteTaux extends Compte{

	private float tauxRemun;

	public CompteTaux(String numeroCompte, float soldeCompte, float tauxRemun) {
		super(numeroCompte, soldeCompte);
		this.tauxRemun = tauxRemun;
	}

	public float getTauxRemun() {
		return tauxRemun;
	}

	public void setTauxRemun(float tauxRemun) {
		this.tauxRemun = tauxRemun;
	}

	@Override
	public String toString() {
		return super.toString() + " / CompteTaux [tauxRemun=" + tauxRemun + "]";
	}
}
