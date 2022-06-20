package maps;

import java.util.HashMap;
import java.util.Iterator;

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
		
		HashMap<String, Ville> mapVilles = new HashMap<>();
		mapVilles.put("Nice", new Ville("Nice", 343000));
		mapVilles.put("Carcassonne", new Ville("Carcassonne", 47800));
		mapVilles.put("Narbonne", new Ville("Narbonne", 53400));
		mapVilles.put("Lyon", new Ville("Lyon", 484000));
		mapVilles.put("Foix", new Ville("Foix", 9700));
		mapVilles.put("Pau", new Ville("Pau", 77200));
		mapVilles.put("Marseille", new Ville("Marseille", 850700));
		mapVilles.put("Tarbes", new Ville("Tarbes", 40600));
		
		
		System.out.println("\n\nListe avant suppression :\n");
		Iterator<Ville> iter0 = mapVilles.values().iterator();
		while(iter0.hasNext()) {
			Ville ville = iter0.next();
			System.out.println(ville.toString());
		}
		//Iterator<Entry<String, Ville>> iter = mapVilles.entrySet().iterator();
		Ville villeMin = null;
		long min = Long.MAX_VALUE;
		Iterator<Ville> iter = mapVilles.values().iterator();
		while(iter.hasNext()) {
			Ville ville = iter.next();
			if(ville.getNombreHab() < min) {
				min = ville.getNombreHab();
				villeMin = ville;
			}
		}
		
		System.out.println("\n\nVille min : " + villeMin.toString());
		mapVilles.remove(villeMin.getNom());
		
		System.out.println("\n\nListe après suppression :\n");
		Iterator<Ville> iterVille = mapVilles.values().iterator();
		while(iterVille.hasNext()) {
			Ville ville = iterVille.next();
			System.out.println(ville.toString());
		}
	}

}
