package tn.mbhc.tudev.codingame.exercices.strings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LongestStringTest {

	private LongestString longestString;

	@BeforeEach
	public void setUp() {
		longestString = new LongestString();
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "a", "aa" })
	public void shouldReturnSameCharacterIfStringContainsOneCharacterOrSameCharacterRepeated(final String input) {
		// Arrange
		String expected = "a";

		// Act
		String actual = longestString.longest(input);

		// Assert
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = { "ab", "aba" })
	public void shouldReturnSameStringIfContainsTwoUniqueCharacters(final String input) {
		// Arrange
		String expected = "ab";

		// Act
		String actual = longestString.longest(input);

		// Assert
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void shouldReturnTheLongestWhenStringContainsTwoLongStrings() {
		// Arrange
		String chaine = "abcdefghabcdefghijk";
		String expected = "abcdefghijk";

		// Act
		String actual = longestString.longest(chaine);

		// Assert
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void shouldReturnTheLongestWhenStringContainsMultipleLongStrings() {
		// Arrange
		String chaine = "abcdefghabcdefghijkkabcdefghijklmnopqrstuvwxyz";
		String expected = "klmnopqrstuvwxyz";

		// Act
		String actual = longestString.longest(chaine);

		// Assert
		assertThat(actual).isEqualTo(expected);
	}
}
