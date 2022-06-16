package sets;

import java.util.HashSet;

public class TestSetString {

	public static void main(String[] args) {
		
		HashSet<String> setString = new HashSet<>();
		
		setString.add("USA");
		setString.add("France");
		setString.add("Allemagne");
		setString.add("UK");
		setString.add("Italie");
		setString.add("Japon");
		setString.add("Chine");
		setString.add("Russie");
		setString.add("Inde");
		
		System.out.println("\n\nSet initial :\n");
		for (String element : setString) {
			System.out.println(element);
		}
		
		String greaterName = "";
		int maxLength = 0;
		for (String element : setString) {
			if(element.length() > maxLength) {
				maxLength = element.length();
				greaterName = element;
			}
		}
		
		System.out.println("\n\nPays dont le nom est le plus long : " + greaterName);
		setString.remove(greaterName);
		
		System.out.println("\n\nSet après suppression :\n");
		for (String element : setString) {
			System.out.println(element);
		}
		
	}

}
