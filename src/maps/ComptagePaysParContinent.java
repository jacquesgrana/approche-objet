package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ComptagePaysParContinent {

	public static void main(String[] args) {
		
		ArrayList<Pays> listPays = new ArrayList<>();
		
		
		listPays.add(new Pays("France", 65, "Europe"));
		listPays.add(new Pays("Allemagne", 80, "Europe"));
		listPays.add(new Pays("Belgique", 10, "Europe"));
		listPays.add(new Pays("Russie", 150, "Asie"));
		listPays.add(new Pays("Chine", 1400, "Asie"));
		listPays.add(new Pays("Indonésie", 220, "Océanie"));
		listPays.add(new Pays("Australie", 20, "Océanie"));
		
		System.out.println("\nListe initiale :\n");
		for(Pays pays : listPays) {
			System.out.println(pays.toString());
		}
		
		HashMap<String, Integer> mapContinents = new HashMap<>();
		
		for (Pays pays : listPays) {
			if(mapContinents.containsKey(pays.getContinent())) {
				mapContinents.put(pays.getContinent(), mapContinents.get(pays.getContinent()) + 1);
			}
			else {
				mapContinents.put(pays.getContinent(), 1);
			}
		}
		
		System.out.println("\nMap des continents avec le nb de pays :\n");
		Iterator<String> iterKey = mapContinents.keySet().iterator();
		while(iterKey.hasNext()) {
			String key = iterKey.next();
			Integer value = mapContinents.get(key);
			System.out.println(key + " / " + value);
		}

	}

}
