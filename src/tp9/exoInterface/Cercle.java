package tp9.exoInterface;

public class Cercle implements ObjetGeometrique {

	private double rayon;
	
	public Cercle(double rayon) {
		super();
		this.rayon = rayon;
	}

	@Override
	public double perimetre() {
		return 2*Math.PI*this.rayon;
	}

	@Override
	public double surface() {
		return Math.PI*this.rayon*this.rayon;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	@Override
	public String toString() {
		return "Cercle [rayon=" + rayon + "]";
	}

}
