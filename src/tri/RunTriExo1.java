package tri;

import java.util.ArrayList;
import java.util.Collections;

public class RunTriExo1 {

	public static void main(String[] args) {
		
		ArrayList<Ville> listVille = new ArrayList<>();	
		listVille.add(new Ville("Nice", 343000));
		listVille.add(new Ville("Carcassonne", 47800));
		listVille.add(new Ville("Narbonne", 53400));
		listVille.add(new Ville("Lyon", 484000));
		listVille.add(new Ville("Foix", 9700));
		listVille.add(new Ville("Pau", 77200));
		listVille.add(new Ville("Marseille", 850700));
		listVille.add(new Ville("Tarbes", 40600));
		
		System.out.println("\nListe initiale :\n");
		for (Ville element : listVille) {
			System.out.println(element.toString());
		}
		
		Collections.sort(listVille);
		System.out.println("\n\nAprès tri avec 'Comparable' :\n");
		for (Ville element : listVille) {
			System.out.println(element.toString());
		}
		
		Collections.sort(listVille, new ComparatorNom());
		System.out.println("\n\nAprès tri avec 'Comparator' sur les noms :\n");
		for (Ville element : listVille) {
			System.out.println(element.toString());
		}
		
		Collections.sort(listVille, new ComparatorHabitant());
		System.out.println("\n\nAprès tri avec 'Comparator' sur les nombres d'habitants :\n");
		for (Ville element : listVille) {
			System.out.println(element.toString());
		}
	}

}
