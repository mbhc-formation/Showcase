package tn.mbhc.tudev.codingame.exercices.temperatures;

import java.util.Arrays;

final class Temperatures {
	
	private static final int DEFAULT_ZERO_TEMPERATURE = 0;

	private Temperatures() {
		// Utility class : no need to instanciate
	}
	
	/**
	 * Returns the closest temperatur to Zero in the given array of integers.
	 * <br>
	 * Using rules :
	 * <br>
	 * Si deux nombres sont aussi proches de zéro, alors <b>l'entier positif</b>
	 * <br>
	 * sera considéré comme étant <b>le plus proche de zéro.</b>
	 * <br>
	 * Par exemple, si les températures sont -5 et 5, alors renvoyer 5
	 * 
	 * @param temperatures
	 * @return
	 */
	private static int closestTemp = Integer.MAX_VALUE;
	
	static int closestToZero(int[] temperatures) {
		
		closestTemp = Integer.MAX_VALUE;
		
		// Empty array
		if(temperatures == null || temperatures.length == 0) {
			return DEFAULT_ZERO_TEMPERATURE;
		}
		
		// Single value, no need to further operations like comparing or abs
		if(temperatures.length == 1) {
			return temperatures[0];
		}
		
		// Array with at least a value
		Arrays
			.stream(temperatures)
			.forEach(t -> {
				if(Math.abs(t) < Math.abs(closestTemp) 
						|| (Math.abs(t) == Math.abs(closestTemp) && t > closestTemp)) {
					closestTemp = t;
				}
			});
		return closestTemp;
	}

}