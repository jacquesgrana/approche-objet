package maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import tri.Ville;

public class MapVilles {

	public static void main(String[] args) {
		
/*
		ArrayList<Ville> listVille = new ArrayList<>();	
		listVille.add(new Ville("Nice", 343000));
		listVille.add(new Ville("Carcassonne", 47800));
		listVille.add(new Ville("Narbonne", 53400));
		listVille.add(new Ville("Lyon", 484000));
		listVille.add(new Ville("Foix", 9700));
		listVille.add(new Ville("Pau", 77200));
		listVille.add(new Ville("Marseille", 850700));
		listVille.add(new Ville("Tarbes", 40600));
		*/
		
		Map<String, Ville> mapVilles = new HashMap<>();
		mapVilles.put("Nice", new Ville("Nice", 343000));
		mapVilles.put("Carcassonne", new Ville("Carcassonne", 47800));
		mapVilles.put("Narbonne", new Ville("Narbonne", 53400));
		mapVilles.put("Lyon", new Ville("Lyon", 484000));
		mapVilles.put("Foix", new Ville("Foix", 9700));
		mapVilles.put("Pau", new Ville("Pau", 77200));
		mapVilles.put("Marseille", new Ville("Marseille", 850700));
		mapVilles.put("Tarbes", new Ville("Tarbes", 40600));
		
		
		System.out.println("\n\nListe avant suppression :\n");
		Iterator<String> iterKey = mapVilles.keySet().iterator();
		while(iterKey.hasNext()) {
			String key = iterKey.next();
			Ville ville = mapVilles.get(key);
			System.out.println("key : " + key + " / ville : " + ville.toString());
		}
		
		Ville villeMin = null;
		long min = Long.MAX_VALUE;
		
		for (String nomVille : mapVilles.keySet()) {
			Ville ville = mapVilles.get(nomVille);
			if (ville.getNombreHab() < min) {
				min = ville.getNombreHab();
				villeMin = ville;
			}
		}
		
		System.out.println("\n\nVille min : " + villeMin.toString());
		mapVilles.remove(villeMin.getNom());
		
		System.out.println("\n\nListe après suppression :\n");
		Iterator<String> iterKey2 = mapVilles.keySet().iterator();
		while(iterKey2.hasNext()) {
			String key = iterKey2.next();
			Ville ville = mapVilles.get(key);
			System.out.println("key : " + key + " / ville : " + ville.toString());
		}
	}

}
