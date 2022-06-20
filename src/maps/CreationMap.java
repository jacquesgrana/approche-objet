package maps;

import java.util.HashMap;

public class CreationMap {

	public static void main(String[] args) {
		
		HashMap<String, Double> mapSalaires = new HashMap<>();
		
		mapSalaires.put("Paul", 1750d);
		mapSalaires.put("Hicham", 1825d);
		mapSalaires.put("Yu", 2250d);
		mapSalaires.put("Ingrid", 2015d);
		mapSalaires.put("Chantal", 2418d);
		
		System.out.println("Taille de la map : " + mapSalaires.size());
		/*
		System.out.println("\nListe initiale :\n");
		Iterator<Double> iter = mapSalaires.values().iterator();
		while (iter.hasNext()) {
			Double value = iter.next();
			//String name = iter.toString();
			System.out.println(value);
		}
		
		for (Double valDouble : mapSalaires.values()) {
			
		}
		
		for (String valString : mapSalaires.keySet()) {
			
		}*/
	}

}
