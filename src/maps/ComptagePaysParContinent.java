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
		
		// determination de la liste des continents
		ArrayList<String> listContinents = new ArrayList<>();
		int compteurContinents = 0;
		for(Pays pays : listPays) {
			if (compteurContinents == 0) {
				listContinents.add(pays.getContinent());
				compteurContinents++;
			}
			else {
				if(!listContinents.contains(pays.getContinent())) {
					listContinents.add(pays.getContinent());
					compteurContinents++;
				}
			}
		}
		
		System.out.println("\nContinents trouvés : \n");
		ArrayList<Integer>listNbPaysParContinent = new ArrayList<>();
		for(String continent : listContinents) {
			listNbPaysParContinent.add(0);
			System.out.println(continent.toString());
		}
		
		for (Pays pays : listPays) {
			for (int i=0; i<listContinents.size(); i++) {
				if(pays.getContinent().equals(listContinents.get(i))) {
					int cpt = listNbPaysParContinent.get(i) + 1;
					listNbPaysPa.set(i, cpt);
				}
			}
		}
		
		HashMap<String, Integer> mapContinents = new HashMap<>();
		for (int i=0; i<listContinents.size(); i++) {
			mapContinents.put(listContinents.get(i), listNbPaysParContinent.get(i));
		}
		/*
		System.out.println("\n\nMap des continents et nb pays :\n");
		Iterator<Entry<String, Integer>> iter = mapContinents.entrySet().iterator();
		while(iter.hasNext()) {
			String maString = (String) iter.next().toString();
			String[] tabString = maString.split("=");
			String nomContinent = tabString[0];
			int cpt = Integer.parseInt(tabString[1]);
			System.out.println("nom : " + nomContinent + " / nb pays : " + cpt);
		}*/
		
		System.out.println("\nMap des continents avec le nb de pays :\n");
		Iterator<String> iterKey = mapContinents.keySet().iterator();
		while(iterKey.hasNext()) {
			String key = iterKey.next();
			Integer value = mapContinents.get(key);
			System.out.println(key + " / " + value);
		}

	}

}
