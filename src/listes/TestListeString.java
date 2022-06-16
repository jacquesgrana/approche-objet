package listes;

import java.util.ArrayList;
import java.util.Iterator;

public class TestListeString {

	public static void main(String[] args) {
		
		ArrayList<String> listString = new ArrayList<>();
		
		listString.add("Nice");
		listString.add("Carcassonne");
		listString.add("Narbonne");
		listString.add("Lyon");
		listString.add("Foix");
		listString.add("Pau");
		listString.add("Marseille");
		listString.add("Tarbes");
		
		System.out.println("Liste initiale : \n");
		for(String elem : listString) {
			System.out.println(elem);
		}
		
		int max = 0;
		String maxNameSize = "";
		for(String elem : listString) {
			if (elem.length() > max) {
				max = elem.length();
				maxNameSize = elem;
			}
		}
		
		System.out.println("\n\nVille dont le nom est le plus long : " + maxNameSize);
		
		
		for (int i=0; i<listString.size(); i++) {
			listString.set(i, listString.get(i).toUpperCase());
		}
		
		System.out.println("\n\nListe après passage en majuscules : \n");
		for(String elem : listString) {
			System.out.println(elem);
		}
		
		Iterator iter = listString.iterator();
		String value = "";
		while(iter.hasNext()) {
			value = (String) iter.next();
			if (value.charAt(0) == 'N') {
				iter.remove();
			}
		}
		
		System.out.println("\n\nListe après supression des villes commençant par 'N' : \n");
		for(String elem : listString) {
			System.out.println(elem);
		}

	}

}
