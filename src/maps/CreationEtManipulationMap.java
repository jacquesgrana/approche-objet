package maps;

import java.util.HashMap;

public class CreationEtManipulationMap {

	public static void main(String[] args) {
		
		HashMap<Integer, String> mapVilles = new HashMap<>();
		mapVilles.put(13, "Marseille");
		mapVilles.put(34, "Montpellier");
		mapVilles.put(44, "Nantes");
		mapVilles.put(75, "Paris");
		mapVilles.put(31, "Toulouse");
		
		mapVilles.put(59, "Lille");
		mapVilles.put(69, "Lyon");
		mapVilles.put(33, "Bordeaux");
		
		
		System.out.println("\nListe des clés :\n");
		for (Integer valInteger : mapVilles.keySet()) {
			System.out.println(valInteger);
		}
		
		System.out.println("\n\nListe des noms :\n");
		for (String valString : mapVilles.values()) {
			System.out.println(valString);
		}

		System.out.println("\n\nTaille de la map : " + mapVilles.size());
	}

}
