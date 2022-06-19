package fr.diginamic.recensement.model;

import java.util.Comparator;

/**
 * Comparator de Ville selon la population en ordre décroissant
 * 
 * @see Ville
 * @author jacques granarolo
 */
public class ComparatorVilleByPopDecr implements Comparator<Ville> {

	@Override
	public int compare(Ville ville1, Ville ville2) {
		return (int) (ville2.getPopulTotale() - ville1.getPopulTotale());
	}
}
