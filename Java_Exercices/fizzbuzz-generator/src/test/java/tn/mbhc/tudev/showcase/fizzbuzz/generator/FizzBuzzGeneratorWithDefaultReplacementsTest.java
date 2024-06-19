package tn.mbhc.tudev.showcase.fizzbuzz.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tn.mbhc.tudev.showcase.fizzbuzz.generator.core.ReplacementImpl;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.InvalidSequenceIntervalException;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.NoReplacementForSequenceException;

public class FizzBuzzGeneratorWithDefaultReplacementsTest {

	private FizzBuzzGenerator generator;

	@BeforeEach
	public void beforeEach() {
		generator = buildGeneratorWithRules();
	}

	@Test
	void shoudGenerateFizzBuzzBasicSerieForOneElement() throws Exception {
		assertThat(generator.generate(1, 1)).isEqualTo("1");
		assertThat(generator.generate(2, 2)).isEqualTo("2");
		assertThat(generator.generate(3, 3)).isEqualTo("Fizz");
		assertThat(generator.generate(5, 5)).isEqualTo("Buzz");
		assertThat(generator.generate(15, 15)).isEqualTo("FizzBuzz");
	}

	@Test
	void shoudGenerateFizzBuzzBasicSeriesForTwoElements() throws Exception {
		assertThat(generator.generate(1, 2)).isEqualTo("1 2");
	}

	@Test
	void shoudGenerateFizzBuzzBasicSeriesForThreeElements() throws Exception {
		assertThat(generator.generate(1, 3)).isEqualTo("1 2 Fizz");
	}

	@Test
	void shoudGenerateFizzBuzzBasicSeriesForMultipleElements() throws Exception {
		assertThat(generator.generate(1, 5)).isEqualTo("1 2 Fizz 4 Buzz");
		assertThat(generator.generate(10, 15)).isEqualTo("Buzz 11 Fizz 13 14 FizzBuzz");
		assertThat(generator.generate(-10, 15)).isEqualTo("Buzz Fizz -8 -7 Fizz Buzz -4 Fizz -2 -1 FizzBuzz 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz");
	}

	@Test
	void shouldThrowInvalidSequenceIntervalForNonValidInterval() throws InvalidSequenceIntervalException {
		assertThatExceptionOfType(InvalidSequenceIntervalException.class).isThrownBy(() -> generator.generate(0, -3));
		assertThatExceptionOfType(InvalidSequenceIntervalException.class).isThrownBy(() -> generator.generate(5, 1));
		assertThatExceptionOfType(InvalidSequenceIntervalException.class).isThrownBy(() -> generator.generate(10, 1));
	}
	
	@Test
	void shouldThrowNoReplacementForSequenceValueIfGeneratorReplacementsAreNotconfigured() throws NoReplacementForSequenceException {
		assertThatExceptionOfType(NoReplacementForSequenceException.class).isThrownBy(() -> new FizzBuzzGenerator().generate(1, 15));
	}
	
	@Test
	void shouldVerifyDefaultReplacementsOfGenerator() throws NoReplacementForSequenceException {
		
		FizzBuzzGenerator defaultGenerator = new FizzBuzzGenerator()
				.withDefaultReplacements();
		
		FizzBuzzGenerator manuallyConfiguredGenerator = new FizzBuzzGenerator()
				.withReplacement(new ReplacementImpl(3, "Fizz", 1))
				.withReplacement(new ReplacementImpl(5, "Buzz", 1))
				.withReplacement(new ReplacementImpl(15, "FizzBuzz", 0));
		
		assertThat(defaultGenerator)
			.usingRecursiveComparison()
			.isEqualTo(manuallyConfiguredGenerator);
	}

	private FizzBuzzGenerator buildGeneratorWithRules() {
		return new FizzBuzzGenerator().withDefaultReplacements();
	}
}
