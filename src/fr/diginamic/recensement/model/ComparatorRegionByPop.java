package fr.diginamic.recensement.model;

import java.util.Comparator;

public class ComparatorRegionByPop implements Comparator<Region> {

	@Override
	public int compare(Region region1, Region region2) {
		return (int) (region2.getPopulTotale() - region1.getPopulTotale());
	}

}
