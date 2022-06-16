package sets;

import java.util.HashSet;

public class TestSetDouble {

	public static void main(String[] args) {
	
		HashSet<Double> setDouble = new HashSet<>();
		setDouble.add(1.5d);
		setDouble.add(8.25d);
		setDouble.add(-7.32d);
		setDouble.add(13.3d);
		setDouble.add(-12.45d);
		setDouble.add(48.5d);
		setDouble.add(0.01d);
		
		System.out.println("Set initial :\n");
		for (Double element : setDouble) {
			System.out.println(element);
		}
		
		Double max = Double.MIN_VALUE;
		for (Double element : setDouble) {
			if(element > max) {
				max = element;
			}
		}
		
		System.out.println("\n\nValeur max : " + max);
		
		Double min = Double.MAX_VALUE;
		for (Double element : setDouble) {
			if(element < min) {
				min = element;
			}
		}
		setDouble.remove(min);
		
		System.out.println("\n\nSet après suppression du min :\n");
		for (Double element : setDouble) {
			System.out.println(element);
		}
	}

}
