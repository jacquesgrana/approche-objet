package fr.diginamic.recensement.model;

import java.util.Comparator;

/**
 * Comparator d'objets Departement selon la population en ordre décroissant. 
 * 
 * @see Departement
 * @author jacques granarolo
 */
public class ComparatorDptByPopDecr implements Comparator<Departement> {

	/**
	 * Override de la méthode compare, comparaison sur la population selon l'ordre décroissant. 
	 */
	@Override
	public int compare(Departement dept1, Departement dept2) {
		return (int) (dept2.getPopulTotale() - dept1.getPopulTotale());
	}

}
