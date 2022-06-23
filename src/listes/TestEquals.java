package listes;

public class TestEquals {

	public static void main(String[] args) {
		Ville ville1 = new Ville("Nice", 343000);
		Ville ville2 = new Ville("Carcassonne", 47800);
		Ville ville3 = new Ville("Nice", 343000);

		System.out.println("Test equals1 : " + ville1.equals(ville3) + "\n");
		System.out.println("Test equals2 : " + ville1.equals(ville2) + "\n");
		
		System.out.println("Test == 1 : " + (ville1 == ville2) + "\n");
		System.out.println("Test == 2 : " + (ville1 == ville3) + "\n");
		
		Ville ville4 = ville1;
		System.out.println("Test == 3 : " + (ville1 == ville4) + "\n");
	}

}
