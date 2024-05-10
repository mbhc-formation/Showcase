package tn.mbhc.tudev.showcase.fizzbuzz.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tn.mbhc.tudev.showcase.fizzbuzz.generator.core.ReplacementImpl;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.InvalidSequenceIntervalException;

public class FizzBuzzGeneratorTest {

	private FizzBuzzGenerator generator;

	@BeforeEach
	public void beforeEach() {
		generator = buildGeneratorWithRules();
	}

	@Test
	void shoudGenerateFizzBuzzBasicSerieForOneElement() throws Exception {
		assertEquals("1", generator.generate(1, 1));
		assertEquals("2", generator.generate(2, 2));
		assertEquals("Fizz", generator.generate(3, 3));
		assertEquals("Buzz", generator.generate(5, 5));
		assertEquals("FizzBuzz", generator.generate(15, 15));
	}

	@Test
	void shoudGenerateFizzBuzzBasicSeriesForTwoElements() throws Exception {
		assertEquals("1 2", generator.generate(1, 2));
	}

	@Test
	void shoudGenerateFizzBuzzBasicSeriesForThreeElements() throws Exception {
		assertEquals("1 2 Fizz", generator.generate(1, 3));
	}

	@Test
	void shoudGenerateFizzBuzzBasicSeriesForMultipleElements() throws Exception {
		assertEquals("1 2 Fizz 4 Buzz", generator.generate(1, 5));
		assertEquals("Buzz 11 Fizz 13 14 FizzBuzz", generator.generate(10, 15));
		assertEquals("Buzz Fizz -8 -7 Fizz Buzz -4 Fizz -2 -1 FizzBuzz 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz", generator.generate(-10, 15));
	}

	@Test
	void shouldThrowInvalidSequenceIntervalForNonValidInterval() throws InvalidSequenceIntervalException {
		assertThrows(InvalidSequenceIntervalException.class, () -> generator.generate(0, -3));
		assertThrows(InvalidSequenceIntervalException.class, () -> generator.generate(5, 1));
		assertThrows(InvalidSequenceIntervalException.class, () -> generator.generate(10, 1));
	}

	private FizzBuzzGenerator buildGeneratorWithRules() {
		return new FizzBuzzGenerator()
				.withReplacement(new ReplacementImpl(3, "Fizz", 1))
				.withReplacement(new ReplacementImpl(5, "Buzz", 1))
				.withReplacement(new ReplacementImpl(15, "FizzBuzz", 0));
	}
}
