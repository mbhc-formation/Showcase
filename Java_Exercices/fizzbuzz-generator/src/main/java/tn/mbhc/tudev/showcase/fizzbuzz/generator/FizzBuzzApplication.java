package tn.mbhc.tudev.showcase.fizzbuzz.generator;

import java.util.logging.Level;
import java.util.logging.Logger;

import tn.mbhc.tudev.showcase.fizzbuzz.generator.core.ReplacementImpl;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.InvalidSequenceIntervalException;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.NoReplacementForSequenceException;

public class FizzBuzzApplication {

	private static final Logger LOGGER = Logger.getAnonymousLogger();
	
	public static void main(String[] args) throws InvalidSequenceIntervalException, NoReplacementForSequenceException {
		
		LOGGER.info("Using FizzBuzzGenerator with default sequence replacement configuration");
		
		FizzBuzzGenerator defaultConfiguredGenerator = new FizzBuzzGenerator()
				.withDefaultReplacements();
		
		LOGGER.log(Level.INFO, "Generated sequence : {0}", defaultConfiguredGenerator.generate(1, 15));
		
		LOGGER.info("Using FizzBuzzGenerator with default sequence replacement configuration");
		
		FizzBuzzGenerator manuallyConfiguredGenerator = new FizzBuzzGenerator()
				.withReplacement(new ReplacementImpl(3, "Three", 1))
				.withReplacement(new ReplacementImpl(5, "Five", 1))
				.withReplacement(new ReplacementImpl(15, "Fifteen", 0));
		
		LOGGER.log(Level.INFO, "Generated sequence : {0}", manuallyConfiguredGenerator.generate(1, 15));
	}

}
