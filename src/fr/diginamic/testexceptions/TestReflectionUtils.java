package fr.diginamic.testexceptions;

public class TestReflectionUtils {

	public static void main(String[] args) {

		Ville ville1 = new Ville("Montpellier", 360000L);

		try {
			ReflectionUtils.afficherAttributs(ville1);
		} catch (IllegalArgumentException e) {
			System.out.println("Erreur d'argument.");
			// e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("Erreur d'accès.");
			// e.printStackTrace();
		} catch (ReflectionException e) {
			System.out.println("Erreur d'objet");
			// e.printStackTrace();
		}

		System.out.println();

		try {
			ReflectionUtils.afficherAttributs(null);
		} catch (IllegalArgumentException e) {
			System.out.println("Erreur d'argument.");
			// e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("Erreur d'accès.");
			// e.printStackTrace();
		} catch (ReflectionException e) {
			System.out.println("Erreur d'objet");
			// e.printStackTrace();
		}

	}

}
