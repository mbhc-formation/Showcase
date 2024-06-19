package tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions;

public class NoReplacementForSequenceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5091587768445215312L;

	public NoReplacementForSequenceException() {
		super("No sequence values replacements are configured for FizzBuzz generator");
	}

}
