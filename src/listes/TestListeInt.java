package listes;

import java.util.ArrayList;
import java.util.Iterator;

public class TestListeInt {

	public static void main(String[] args) {
		
		ArrayList<Integer> listInteger = new ArrayList<Integer>();
		
		listInteger.add(-1);
		listInteger.add(5);
		listInteger.add(7);
		listInteger.add(3);
		listInteger.add(-2);
		listInteger.add(4);
		listInteger.add(8);
		listInteger.add(5);
		
		System.out.println("Liste :");
		
		for (int element : listInteger) {
			System.out.println(element);
		}
		
		System.out.println("\nTaille de la liste : " + listInteger.size());

		int max = listInteger.get(0);
		for (int element : listInteger) {
			if (element > max) {
				max = element;
			}
		}
		
		System.out.println("\nMaximum de la liste : " + max);
		
		int min = listInteger.get(0);
		int indexMin = 0;
		for (int i=0; i<listInteger.size(); i++) {
			if (listInteger.get(i) < min) {
				min = listInteger.get(i);
				indexMin = i;
			}
		}
		
		listInteger.remove(indexMin);
		
		System.out.println("\nListe après suppression du minimum :");
		
		for (int element : listInteger) {
			System.out.println(element);
		}
		
		for (int i=0; i<listInteger.size(); i++) {
			if (listInteger.get(i) < 0) {
				listInteger.set(i, -1*listInteger.get(i));
			}	
		}
		
		System.out.println("\nListe après inversion des nombres négatifs :");
		
		for (int element : listInteger) {
			System.out.println(element);
		}
	}

}
