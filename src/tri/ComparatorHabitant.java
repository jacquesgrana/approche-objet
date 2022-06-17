package tri;

import java.util.Comparator;

public class ComparatorHabitant implements Comparator<Ville>{

	@Override
	public int compare(Ville ville1, Ville ville2) {
		if(ville1.getNombreHab() > ville2.getNombreHab()) {
			return 1;
		}
		else if(ville1.getNombreHab() < ville2.getNombreHab()) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
