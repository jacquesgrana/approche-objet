package listes;

import java.util.ArrayList;

public class TestVille {

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
		
		System.out.println("Liste initiale :\n");
		for (Ville elem : listVille) {
			System.out.println(elem.getNom() + " / " + elem.getNombreHab());
		}
		
		long max = 0;
		Ville villeMax = null;
		for (Ville elem : listVille) {
			if (elem.getNombreHab() > max) {
				max = elem.getNombreHab();
				villeMax = elem; // cloner?
			}
		}
		
		System.out.println("\n\nVille la plus peuplée : " + villeMax.getNom() + " / " + villeMax.getNombreHab());

		long min = listVille.get(0).getNombreHab();
		Ville villeMin = null;
		for (Ville elem : listVille) {
			if (elem.getNombreHab() < min) {
				min = elem.getNombreHab();
				villeMin = elem; // cloner?
			}
		}
		listVille.remove(villeMin);
		
		System.out.println("\n\nListe après suppression de la ville la moins peuplée :\n");
		for (Ville elem : listVille) {
			System.out.println(elem.getNom() + " / " + elem.getNombreHab());
		}
		
		for (Ville elem : listVille) {
			if (elem.getNombreHab() > 100000) {
				elem.setNom(elem.getNom().toUpperCase());
			}
		}
		
		System.out.println("\n\nListe après passage en majuscule conditionnel :\n");
		for (Ville elem : listVille) {
			System.out.println(elem.getNom() + " / " + elem.getNombreHab());
		}
	}

}
