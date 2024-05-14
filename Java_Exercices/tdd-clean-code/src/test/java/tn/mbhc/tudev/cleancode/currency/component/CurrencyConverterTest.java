package tn.mbhc.tudev.cleancode.currency.component;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import tn.mbhc.tudev.cleancode.currency.data.Currency;

public class CurrencyConverterTest {

	private static final int DEF_SCALE = 1;

	@Test
	public void shouldThrowExceptionIfSourceCurrencyIsNull() {
		// Arrange 
		Currency sourceCurrency = null;
		Currency targetCurrency = Currency.USD;
		BigDecimal amount = BigDecimal.valueOf(1.0);
		
		// Act & Assert
		assertThrows(IllegalArgumentException.class, () -> CurrencyConverter.convert(sourceCurrency, targetCurrency, amount, DEF_SCALE));
	}

	@Test
	public void shouldThrowExceptionIfTargetCurrencyIsNull() {
		// Arrange 
		Currency sourceCurrency = Currency.EUR;
		Currency targetCurrency = null;
		BigDecimal amount = BigDecimal.valueOf(1.0);
		
		// Act & Assert
		assertThrows(IllegalArgumentException.class, () -> {
			CurrencyConverter.convert(sourceCurrency, targetCurrency, amount, DEF_SCALE);
		});
	}

	@Test
	public void shouldConvertEurosToDollars() {
		// Arrange 
		Currency sourceCurrency = Currency.EUR;
		Currency targetCurrency = Currency.USD;
		BigDecimal eurosToConvert = BigDecimal.valueOf(1.0);
		BigDecimal expectedDollars = BigDecimal.valueOf(1.2);
		
		// Act
		BigDecimal convertedValue = CurrencyConverter.convert(sourceCurrency, targetCurrency, eurosToConvert, DEF_SCALE);
		
		// Assert
		assertThat(convertedValue).isEqualTo(expectedDollars);
	}

	@Test
	public void shouldConvertDollarsToEuros() {
		// Arrange 
		Currency sourceCurrency = Currency.USD;
		Currency targetCurrency = Currency.EUR;
		BigDecimal dollarsToConvert = BigDecimal.valueOf(1.0);
		BigDecimal expectedEuros = BigDecimal.valueOf(0.8);
		
		// Act
		BigDecimal convertedValue = CurrencyConverter.convert(sourceCurrency, targetCurrency, dollarsToConvert, DEF_SCALE);
		
		// Assert
		assertThat(convertedValue).isEqualTo(expectedEuros);
	}

	@Test
	public void shouldReturnSameAmoutIfSourceCurrencyAndTargetCurrencyAreSameEuros() {
		// Arrange 
		Currency sourceCurrency = Currency.EUR;
		Currency targetCurrency = Currency.EUR;
		BigDecimal valueToConvert = BigDecimal.valueOf(1.0);
		BigDecimal expectedValue = BigDecimal.valueOf(1.0);
		
		// Act
		BigDecimal convertedValue = CurrencyConverter.convert(sourceCurrency, targetCurrency, valueToConvert, DEF_SCALE);
		
		// Assert
		assertThat(convertedValue).isEqualTo(expectedValue);
	}
	
	@Test
	public void shouldReturnSameAmoutIfSourceCurrencyAndTargetCurrencyAreSameDollars() {
		// Arrange 
		Currency sourceCurrency = Currency.USD;
		Currency targetCurrency = Currency.USD;
		BigDecimal valueToConvert = BigDecimal.valueOf(1.0);
		BigDecimal expectedValue = BigDecimal.valueOf(1.0);
		
		// Act
		BigDecimal convertedValue = CurrencyConverter.convert(sourceCurrency, targetCurrency, valueToConvert, DEF_SCALE);
		
		// Assert
		assertThat(convertedValue).isEqualTo(expectedValue);
	}

}
