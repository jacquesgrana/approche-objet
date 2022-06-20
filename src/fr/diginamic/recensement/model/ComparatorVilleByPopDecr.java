package fr.diginamic.recensement.model;

import java.util.Comparator;

/**
 * Comparator d'objets Ville selon la population en ordre décroissant
 * 
 * @see Ville
 * @author jacques granarolo
 */
public class ComparatorVilleByPopDecr implements Comparator<Ville> {

	/**
	 * Override de la méthode compare, comparaison sur la population selon l'ordre décroissant. 
	 */
	@Override
	public int compare(Ville ville1, Ville ville2) {
		return (int) (ville2.getPopulTotale() - ville1.getPopulTotale());
	}
}
