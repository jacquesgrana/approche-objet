package sets;

import java.util.HashSet;

public class TestPays {

	public static void main(String[] args) {

		HashSet<Pays> hashSetPays = new HashSet<>();
		hashSetPays.add(new Pays("USA", 331_002_651L, 59_495d));
		hashSetPays.add(new Pays("France", 65_273_511L, 43_551d));
		hashSetPays.add(new Pays("Allemagne", 83_783_942L, 50_206d));
		hashSetPays.add(new Pays("UK", 67_886_011L, 43_620d));
		hashSetPays.add(new Pays("Italie", 60_461_826L, 37_970d));
		hashSetPays.add(new Pays("Japon", 126_476_461L, 42_659d));
		hashSetPays.add(new Pays("Chine", 1_439_323_776L, 16_624d));
		hashSetPays.add(new Pays("Russie", 145_934_462L, 28_712d));
		hashSetPays.add(new Pays("Inde", 1_380_004_385L, 5_174d));

		System.out.println("\nSet initial : \n");
		for (Pays element : hashSetPays) {
			System.out.println(element.toString());
		}
		
		Double maxPibHab = Double.MIN_VALUE;
		Pays paysPibHabMax = null;
		
		for (Pays element : hashSetPays) {
			if (element.getPibParHab() > maxPibHab) {
				maxPibHab = element.getPibParHab();
				paysPibHabMax = element;
			}
			
		}
		System.out.println("\n\nPays dont le pib/hab est le plus grand : " + paysPibHabMax.toString());

		
		Double maxPib = Double.MIN_VALUE;
		Pays paysPibMax = null;
		
		for (Pays element : hashSetPays) {
			if (element.getPib() > maxPib) {
				maxPib = element.getPib();
				paysPibMax = element;
			}
		}
		System.out.println("\n\nPays dont le pib est le plus grand : " + paysPibMax.toString());
		
		
		Double minPib = Double.MAX_VALUE;
		Pays paysPibMin = null;
		
		for (Pays element : hashSetPays) {
			if (element.getPib() < minPib) {
				minPib = element.getPib();
				paysPibMin = element;
			}
		}
		
		
		hashSetPays.remove(paysPibMin);
		paysPibMin.setNom(paysPibMin.getNom().toUpperCase());
		hashSetPays.add(paysPibMin);
		
		System.out.println("\n\nSet après modification Majuscules : \n");
		for (Pays element : hashSetPays) {
			System.out.println(element.toString());
		}
		
		hashSetPays.remove(paysPibMin);
		
		System.out.println("\n\nSet après suppression : \n");
		for (Pays element : hashSetPays) {
			System.out.println("nom : " + element.getNom() + " pop : " + element.getNombreHab() + " pib : " + element.getPib());
		}
	}
}