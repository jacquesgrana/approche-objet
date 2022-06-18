package fr.diginamic.recensement.model;

import java.util.Comparator;

public class ComparatorDptByPopDecr implements Comparator<Departement> {

	@Override
	public int compare(Departement dept1, Departement dept2) {
		return (int) (dept2.getPopulTotale() - dept1.getPopulTotale());
	}

}
