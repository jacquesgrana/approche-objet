package maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FusionMap {

	public static void main(String[] args) {
		
		// Création map1
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(1, "Rouge");
		map1.put(2, "Vert");
		map1.put(3, "Orange");
		// Création map2
		HashMap<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(4, "Blanc");
		map2.put(5, "Bleu");
		map2.put(6, "Orange");
		
		
		HashMap<Integer, String> map3 = new HashMap<Integer, String>();
		
		Iterator<Entry<Integer, String>> iter1 = map1.entrySet().iterator();
		while(iter1.hasNext()) {
			String value = (String) iter1.next().toString();
			String[] extracted = value.split("=");
			//System.out.println("value : key : " + extracted[0] + " valeur : " + extracted[1]);
			
			map3.put(Integer.valueOf(extracted[0]), extracted[1]);
		}
		
		Iterator<Entry<Integer, String>> iter2 = map2.entrySet().iterator();
		while(iter2.hasNext()) {
			String value = (String) iter2.next().toString();
			String[] extracted = value.split("=");
			//System.out.println("value : key : " + extracted[0] + " valeur : " + extracted[1]);
			
			map3.put(Integer.valueOf(extracted[0]), extracted[1]);
		}
		
		System.out.println("\nListe :\n");
		Iterator<Entry<Integer, String>> iter3 = map3.entrySet().iterator();
		while(iter3.hasNext()) {
			String value = (String) iter3.next().toString();
			System.out.println(value);
		}
		
	}

}