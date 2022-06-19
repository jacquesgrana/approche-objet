package fr.diginamic.recensement.model;

import java.util.Comparator;

/**
 * Comparator de Region selon la population en ordre décroissant
 * 
 * @see Region
 * @author jacques granarolo
 */
public class ComparatorRegionByPopDecr implements Comparator<Region> {

	@Override
	public int compare(Region region1, Region region2) {
		return (int) (region2.getPopulTotale() - region1.getPopulTotale());
	}

}
