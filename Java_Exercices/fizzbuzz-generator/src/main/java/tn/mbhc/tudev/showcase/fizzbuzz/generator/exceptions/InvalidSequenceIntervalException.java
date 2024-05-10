package tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions;

public class InvalidSequenceIntervalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5091587768445215312L;

	public InvalidSequenceIntervalException(int from, int to) {
		super(String.format("Invalid interval [%d, %d] for FizzBuzz generator", from, to));

	}

}
