package fr.diginamic.testexceptions;

public class TestReflectionUtils {

	public static void main(String[] args) throws ReflectionException {

		Ville ville1 = new Ville("Montpellier", 360000L);

		try {
			ReflectionUtils.afficherAttributs(ville1);
		} 
		catch (IllegalArgumentException e) {
			System.err.println("Erreur d'argument.");
			// e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			System.err.println("Erreur d'accès.");
			// e.printStackTrace();
		} 
		catch (ReflectionException e) {
			System.err.println("Erreur d'objet : " + e.getMessage());
			// e.printStackTrace();
		}
		catch (NullPointerException e) {
			System.err.println("Null pointer exception");
		}

		System.out.println();

		try {
			ReflectionUtils.afficherAttributs(null);
		} 
		catch (IllegalArgumentException e) {
			System.err.println("Erreur d'argument.");
			// e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			System.err.println("Erreur d'accès.");
			// e.printStackTrace();
		} 
		catch (ReflectionException e) {
			System.err.println("Erreur d'objet : " + e.getMessage());
			// e.printStackTrace();
		}
		catch (NullPointerException e) {
			System.err.println("Null pointer exception");
		}
		
		System.out.println();
		
		Ville ville2 = new Ville(null, 0L);
		
		try {
			ReflectionUtils.afficherAttributs(ville2);
		} 
		catch (IllegalArgumentException e) {
			System.err.println("Erreur d'argument.");
			// e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			System.err.println("Erreur d'accès.");
			// e.printStackTrace();
		} 
		catch (ReflectionException e) {
			System.err.println("Erreur d'objet : " + e.getMessage());
			// e.printStackTrace();
		}
		catch (NullPointerException e) {
			System.err.println("Null pointer exception");
		}

	}

}
