package fr.diginamic.chaines;

public class TestStringBuilder {

	public static void main(String[] args) {
		long debut = System.currentTimeMillis();
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=1; i<= 100000; i++) {
			stringBuilder.append(i);
		}
		long fin = System.currentTimeMillis();
		
		System.out.println("Temps avec stringBuilder : " + (fin - debut));
		
		String string = "";
		long debut1 = System.currentTimeMillis();
		for (int i=1; i<= 100000; i++) {
			string += i;
		}
		long fin1 = System.currentTimeMillis();
		
		System.out.println("\nTemps avec '+' : " + (fin1 - debut1));

	}

}
