package tn.mbhc.tudev.showcase.fizzbuzz.generator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import tn.mbhc.tudev.showcase.fizzbuzz.generator.core.Replacement;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.core.SequenceReplacementManager;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.InvalidSequenceIntervalException;
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
	 */
	public String generate(int from, int to) throws InvalidSequenceIntervalException {
		if (from > to)
			throw new InvalidSequenceIntervalException(from, to);
		return replace(from, to);
	}

	private String replace(int from, int to) {
		Stream<Integer> integerRangeStream = Utils.integerRangeStream(from, to);
		List<String> elements = integerRangeStream.map(this::replaceOrDefault).collect(Collectors.toList());
		return String.join(SPACE, elements).stripTrailing();
	}

	private String replaceOrDefault(final Integer current) {
		return sequenceReplacementManager.hasReplacemnt(current)
				? sequenceReplacementManager.replace(current)
						: String.valueOf(current);
	}

	public FizzBuzzGenerator withReplacement(final Replacement replacement) {
		sequenceReplacementManager.addReplacement(replacement);
		return this;
	}

}
