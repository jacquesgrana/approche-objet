package fr.diginamic.recensement.model;

import java.util.Comparator;

/**
 * Comparator d'objets Region selon la population en ordre décroissant. 
 * 
 * @see Region
 * @author jacques granarolo
 */
public class ComparatorRegionByPopDecr implements Comparator<Region> {
	
	/**
	 * Override de la méthode compare, comparaison sur la population selon l'ordre décroissant. 
	 */
	@Override
	public int compare(Region region1, Region region2) {
		return (int) (region2.getPopulTotale() - region1.getPopulTotale());
	}

}
