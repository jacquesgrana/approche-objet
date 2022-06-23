package fr.diginamic.testenumeration;

import java.util.ArrayList;
import java.util.List;



public class TestContinentAvecEnum {

	public static void main(String[] args) {
		
		List<Ville> listVilles = new ArrayList<>();
		listVilles.add(new Ville("New York", 4000000, Continent.AMERIQUE));
		listVilles.add(new Ville("Paris", 1200000, Continent.EUROPE));
		listVilles.add(new Ville("Pékin", 12000000, Continent.ASIE));
		listVilles.add(new Ville("Moscou", 2200000, Continent.EUROPE));
		listVilles.add(new Ville("Berlin", 1000000, Continent.EUROPE));
		listVilles.add(new Ville("Sydney", 1500000, Continent.OCEANIE));
		listVilles.add(new Ville("Sao Paulo", 4500000, Continent.AMERIQUE));
		listVilles.add(new Ville("Dakar", 3000000, Continent.AFRIQUE));

		System.out.println("Liste des villes : \n");
		for (Ville ville : listVilles) {
			System.out.println(ville.toString());
		}
	}

}
