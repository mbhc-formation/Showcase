package tn.mbhc.tudev.codingame.exercices.temperatures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TemperaturesTest {

	@ParameterizedTest
	@ValueSource(ints = { 1, -1 })
	void shouldReturnClosestTemperatureToZero_UsingSingleValueDataArray(int inputValue) {
		// Arrange
		int[] temperatures = { inputValue };
		int expectedClosestToZero = inputValue;

		// Act
		int actualClosestToZero = Temperatures.closestToZero(temperatures);

		// Assert
		assertThat(actualClosestToZero).isEqualTo(expectedClosestToZero);
	}

	@Test
	void shouldReturnClosestTemperatureToZero_UsingSimpleData() {
		// Arrange
		int[] temperatures = { 1, -2, -8, 4, 5 };
		int expectedClosestToZero = 1;

		// Act
		int actualClosestToZero = Temperatures.closestToZero(temperatures);

		// Assert
		assertThat(actualClosestToZero).isEqualTo(expectedClosestToZero);
	}

	@Test
	void shouldReturnClosestTemperatureToZero_UsingOnlyNegativeValues() {
		// Arrange
		int[] temperatures = { -12, -2, -8, -5, -137 };
		int expectedClosestToZero = -2;

		// Act
		int actualClosestToZero = Temperatures.closestToZero(temperatures);

		// Assert
		assertThat(actualClosestToZero).isEqualTo(expectedClosestToZero);
	}

	@Test
	void shouldReturnClosestTemperatureToZero_UsingSymetricNegativeAndPositiveValues() {
		// Arrange
		int[] temperatures = { 42, -5, 12, 21, 5, 24 };
		int expectedClosestToZero = 5;

		// Act
		int actualClosestToZero = Temperatures.closestToZero(temperatures);

		// Assert
		assertThat(actualClosestToZero).isEqualTo(expectedClosestToZero);
	}

	@Test
	void shouldReturnClosestTemperatureToZero_UsingComplexData() {
		// Arrange
		int[] temperatures = { -5, -4, -2, 12, -40, 4, 2, 18, 11, 5 };
		int expectedClosestToZero = 2;

		// Act
		int actualClosestToZero = Temperatures.closestToZero(temperatures);

		// Assert
		assertThat(actualClosestToZero).isEqualTo(expectedClosestToZero);
	}

	@Test
	void shouldReturnClosestTemperatureToZero_EmptyData() {
		// Arrange
		int[] temperatures = {};
		int expectedClosestToZero = 0;

		// Act
		int actualClosestToZero = Temperatures.closestToZero(temperatures);

		// Assert
		assertThat(actualClosestToZero).isEqualTo(expectedClosestToZero);
	}
}
