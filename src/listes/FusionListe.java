package listes;

import java.util.ArrayList;
import java.util.List;

public class FusionListe {

	public static void main(String[] args) {
		
		List<String> liste1 = new ArrayList<String>();
		liste1.add("Rouge");
		liste1.add("Vert");
		liste1.add("Orange");
		
		List<String> liste2 = new ArrayList<String>();
		liste2.add("Blanc");
		liste2.add("Bleu");
		liste2.add("Orange");
		
		List<String> liste3 = new ArrayList<String>();
		
		System.out.println("1e liste :");
		for(String element : liste1) {
			liste3.add(element);
			System.out.println(element);
		}
		
		System.out.println("\n2e liste :");
		for(String element : liste2) {
			liste3.add(element);
			System.out.println(element);
		}
		System.out.println("\n3e liste :");
		for(String element : liste3) {
			System.out.println(element);
		}

	}

}
