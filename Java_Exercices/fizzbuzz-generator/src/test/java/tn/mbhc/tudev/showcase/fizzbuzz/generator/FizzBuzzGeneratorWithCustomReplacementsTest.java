package tn.mbhc.tudev.showcase.fizzbuzz.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tn.mbhc.tudev.showcase.fizzbuzz.generator.core.ReplacementImpl;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.InvalidSequenceIntervalException;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.NoReplacementForSequenceException;

public class FizzBuzzGeneratorWithCustomReplacementsTest {

	private FizzBuzzGenerator generator;

	@BeforeEach
	public void beforeEach() {
		generator = buildGeneratorWithRules();
	}

	@Test
	void shoudGenerateFizzBuzzBasicSerieForOneElement() throws Exception {
		assertThat(generator.generate(1, 1)).isEqualTo("1");
		assertThat(generator.generate(2, 2)).isEqualTo("2");
		assertThat(generator.generate(3, 3)).isEqualTo("Three");
		assertThat(generator.generate(5, 5)).isEqualTo("Five");
		assertThat(generator.generate(15, 15)).isEqualTo("Fifteen");
	}

	@Test
	void shoudGenerateFizzBuzzBasicSeriesForTwoElements() throws Exception {
		assertThat(generator.generate(1, 2)).isEqualTo("1 2");
	}

	@Test
	void shoudGenerateFizzBuzzBasicSeriesForThreeElements() throws Exception {
		assertThat(generator.generate(1, 3)).isEqualTo("1 2 Three");
	}

	@Test
	void shoudGenerateFizzBuzzBasicSeriesForMultipleElements() throws Exception {
		assertThat(generator.generate(1, 5)).isEqualTo("1 2 Three 4 Five");
		assertThat(generator.generate(10, 15)).isEqualTo("Five 11 Three 13 14 Fifteen");
		assertThat(generator.generate(-10, 15)).isEqualTo("Five Three -8 -7 Three Five -4 Three -2 -1 Fifteen 1 2 Three 4 Five Three 7 8 Three Five 11 Three 13 14 Fifteen");
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
	
	private FizzBuzzGenerator buildGeneratorWithRules() {
		return new FizzBuzzGenerator()
				.withReplacement(new ReplacementImpl(3, "Three", 1))
				.withReplacement(new ReplacementImpl(5, "Five", 1))
				.withReplacement(new ReplacementImpl(15, "Fifteen", 0));
	}
}
