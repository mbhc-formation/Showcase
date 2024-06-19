package tn.mbhc.tudev.showcase.fizzbuzz.generator;

import java.util.List;
import java.util.stream.Stream;

import tn.mbhc.tudev.showcase.fizzbuzz.generator.core.Replacement;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.core.ReplacementImpl;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.core.SequenceReplacementManager;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.InvalidSequenceIntervalException;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.NoReplacementForSequenceException;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.util.Utils;

public class FizzBuzzGenerator {

	private static final String SPACE = " ";
	private SequenceReplacementManager sequenceReplacementManager = new SequenceReplacementManager();

	/**
	 * Generates a sequence of integer values : from ... to and replace its value
	 * with given replacement rules.
	 * 
	 * @param from sequence starting value
	 * @param to   sequence ending value
	 * @return
	 * @throws InvalidSequenceIntervalException If [from, to] is an invalid sequence
	 *                                          interval.
	 * @throws NoReplacementForSequenceException If no replacement for sequence values are configured. See {@link #withReplacement(Replacement)}.
	 */
	public String generate(int from, int to) throws InvalidSequenceIntervalException, NoReplacementForSequenceException {
		if (from > to)
			throw new InvalidSequenceIntervalException(from, to);
		
		if(!sequenceReplacementManager.hasReplacemnts())
			throw new NoReplacementForSequenceException();
		
		return replace(from, to);
	}
	
	/**
	 * Returns an instance of the generator with default FizzBuzz replacements values : 
	 * <br>
	 * <ul>
	 * 	<li>"Fizz" for multiples of 3</li>
	 * 	<li>"Buzz" for multiples of 5</li>
	 * 	<li>"FizzBuzz" for multiples of 15</li>
	 * </ul>
	 * @return
	 */
	public FizzBuzzGenerator withDefaultReplacements() {
		sequenceReplacementManager.addReplacement(new ReplacementImpl(3, "Fizz", 1));
		sequenceReplacementManager.addReplacement(new ReplacementImpl(5, "Buzz", 1));
		sequenceReplacementManager.addReplacement(new ReplacementImpl(15, "FizzBuzz", 0));
		return this;
	}
	
	/**
	 * Configure the current generator with the given replacement value.
	 * 
	 * @param replacement
	 * @return
	 */
	public FizzBuzzGenerator withReplacement(final Replacement replacement) {
		sequenceReplacementManager.addReplacement(replacement);
		return this;
	}
	
	/*
	 * Private methods
	 */
	
	private String replace(int from, int to) {
		Stream<Integer> integerRangeStream = Utils.integerRangeStream(from, to);
		List<String> elements = integerRangeStream.map(this::replaceOrDefault).toList();
		return String.join(SPACE, elements).stripTrailing();
	}

	private String replaceOrDefault(final Integer current) {
		return sequenceReplacementManager.hasReplacemnt(current)
				? sequenceReplacementManager.replace(current)
						: String.valueOf(current);
	}

}
