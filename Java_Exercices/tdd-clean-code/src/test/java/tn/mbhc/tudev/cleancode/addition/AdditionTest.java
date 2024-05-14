package tn.mbhc.tudev.cleancode.addition;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Test class for {@link Addition}.
 */
public class AdditionTest {

	@Test
	public void shouldAddTwoNumbersAndReturnExpectedResult() {
		assertThat(Addition.add(1, 1)).isEqualTo(2);
	}

	@Test
	public void shouldAddTwoNumbersAndReturnDifferentResult() {
		assertThat(Addition.add(1, 2)).isNotEqualTo(2);
	}
}
