package tn.mbhc.tudev.cleancode.addition;

/**
 * Simple example for mathematic operation : Addition.
 */
public final class Addition {

	/**
	 * Add the given numbers.
	 * 
	 * @param firstOperand
	 * @param secondOperand
	 * @return
	 */
	public static int add(final int firstOperand, final int secondOperand) {
		return firstOperand + secondOperand;
	}

	private Addition() {
		// Utility class, no need to instanciate
	}
}
