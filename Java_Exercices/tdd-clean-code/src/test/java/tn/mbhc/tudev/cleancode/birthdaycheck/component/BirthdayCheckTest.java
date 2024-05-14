package tn.mbhc.tudev.cleancode.birthdaycheck.component;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import tn.mbhc.tudev.cleancode.birthdaycheck.provider.impl.InMemoryFixedDateProvider;
import tn.mbhc.tudev.cleancode.birthdaycheck.provider.impl.InitialInputDateProvider;
import tn.mbhc.tudev.cleancode.birthdaycheck.provider.impl.SystemDateProvider;

public class BirthdayCheckTest {

	@Nested
	class UsingInitialInputDateProvider {
		
		@Test
		public void shouldThrowAnExceptionForNullDateInput() {
			// Arrange
			LocalDate now = LocalDate.of(2021, 2, 2);
			BirthdayCheck birthdayCheck = new BirthdayCheck(new InitialInputDateProvider(now));
			
			// Act
			assertThrows(IllegalArgumentException.class, () -> 
				birthdayCheck.isMyBirthday(null)
			);
		}
		
		@Test
		public void shouldReturnTrueWhenInitialInputDateIsMyBirthDayGivenDate() {
			// Arrange
			LocalDate now = LocalDate.of(2021, 2, 2);
			LocalDate myBirthDate = LocalDate.of(2021, 2, 2);
			
			// Act
			BirthdayCheck birthdayCheck = new BirthdayCheck(new InitialInputDateProvider(now));
			boolean expected = birthdayCheck.isMyBirthday(myBirthDate);
			
			// Assert
			assertThat(expected).isTrue();
		}
		
		@Test
		public void shouldReturnFalseWhenInitialInputDateIsNotMyBirthDayGivenDate() {
			// Arrange
			LocalDate now = LocalDate.of(2021, 2, 2);
			LocalDate myBirthDate = LocalDate.of(2021, 2, 3);
			
			// Act
			BirthdayCheck birthdayCheck = new BirthdayCheck(new InitialInputDateProvider(now));
			boolean actual = birthdayCheck.isMyBirthday(myBirthDate);

			// Assert
			assertThat(actual).isFalse();
		}
		
	}
	
	@Nested
	class UsingInMemoryFixedDateProvider {
		
		@Test
		public void shouldThrowAnExceptionForNullDateInput() throws IllegalArgumentException {
			// Arrange
			InMemoryFixedDateProvider inMemoryFixedDateProvider = new InMemoryFixedDateProvider();
			BirthdayCheck birthdayCheck = new BirthdayCheck(inMemoryFixedDateProvider);
			
			// Act & assert
			assertThrows(IllegalArgumentException.class, () -> 
				birthdayCheck.isMyBirthday(null)
			);
		}
		
		@Test
		public void shouldReturnTrueWhenInMemoryFixedDateIsMyBirthDayGivenDate() {
			// Arrange
			LocalDate myBirthDate = LocalDate.of(2000, 1, 1);
			
			// Act
			BirthdayCheck birthdayCheck = new BirthdayCheck(new InMemoryFixedDateProvider());
			boolean actual = birthdayCheck.isMyBirthday(myBirthDate);
			
			// Assert
			assertThat(actual).isTrue();
		}
		
		@Test
		public void shouldReturnFalseWhenInMemoryFixedDateIsNotMyBirthDayGivenDate() {
			// Arrange
			LocalDate myBirthDate = LocalDate.of(2021, 2, 3);
			
			// Act
			BirthdayCheck birthdayCheck = new BirthdayCheck(new InMemoryFixedDateProvider());
			boolean actual = birthdayCheck.isMyBirthday(myBirthDate);

			// Assert
			assertThat(actual).isFalse();
		}
	}

	@Nested
	class UsingSystemDateProvider {
		
		@Test
		public void shouldThrowAnExceptionForNullDateInput() throws IllegalArgumentException {
			// Arrange
			SystemDateProvider systemDateProvider = new SystemDateProvider();
			BirthdayCheck birthdayCheck = new BirthdayCheck(systemDateProvider);
			
			// Act & assert
			assertThrows(IllegalArgumentException.class, () -> 
				birthdayCheck.isMyBirthday(null)
			);
		}
		
		@Test
		public void shouldReturnTrueWhenSystemDateIsMyBirthDayGivenDate() {
			// Arrange (system date)
			LocalDate myBirthDate = LocalDate.now();
			
			// Act
			SystemDateProvider systemDateProvider = new SystemDateProvider();
			BirthdayCheck birthdayCheck = new BirthdayCheck(systemDateProvider);
			boolean actual = birthdayCheck.isMyBirthday(myBirthDate);
			
			// Assert
			assertThat(actual).isTrue();
		}
		
		@Test
		public void shouldReturnFalseWhenSystemDateIsNotMyBirthDayGivenDate() {
			// Arrange
			LocalDate myBirthDate = LocalDate.of(2021, 2, 3);
			
			// Act
			SystemDateProvider systemDateProvider = new SystemDateProvider();
			BirthdayCheck birthdayCheck = new BirthdayCheck(systemDateProvider);
			boolean actual = birthdayCheck.isMyBirthday(myBirthDate);

			// Assert
			assertThat(actual).isFalse();
		}
	}
}
