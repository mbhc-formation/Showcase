package tn.mbhc.tudev.cleancode.currency.component;

import java.math.BigDecimal;

import tn.mbhc.tudev.cleancode.currency.data.Currency;
import tn.mbhc.tudev.cleancode.currency.data.CurrencyConversionRates;

/**
 * Currency converter.
 */
public final class CurrencyConverter {

	/**
	 * Converts the given amount from the source currency to the target currency.
	 * <br>
	 * The conversion uses a scale of 1 for the {@link BigDecimal}.
	 * 
	 * @param sourceCurrency
	 * @param targetCurrency
	 * @param amoutToConvert
	 * @param scale
	 * @return
	 * @throws IllegalArgumentException if source or target are null values.
	 */
	public static BigDecimal convert(final Currency sourceCurrency, final Currency targetCurrency,
			final BigDecimal amoutToConvert, int scale) throws IllegalArgumentException {

		// In a normal case, the given source and target should not be null
		// In a reuse approach, it means that we can integrate the control into the processing
		if (sourceCurrency == null || targetCurrency == null)
			throw new IllegalArgumentException();
		
		// No need to conversion if source and target currency are same
		if (sourceCurrency.equals(targetCurrency))
			return amoutToConvert;

		BigDecimal converted = null;
		switch (sourceCurrency) {
		case EUR:
			converted = fromEuroToDollars(amoutToConvert);
			break;
		case USD:
			converted = fromDollarsToEuros(amoutToConvert);
			break;
		default:
			throw new UnsupportedOperationException(String.format("Unrecognized source currency (%s)", sourceCurrency));
		}
		
		return converted.setScale(1);
	}
	
	/**
	 * Utility class, no need to instanciate
	 */
	private CurrencyConverter() {
		// Utility class, no need to instanciate 
	}
	
	/*
	 * Private utility methods (convenience methods used for simpicity)
	 */
	private static BigDecimal fromEuroToDollars(final BigDecimal amount) {
		
		if (amount == null)
			throw new IllegalArgumentException("Amount to convert must not be null");
		
		return amount
				.multiply(getConversionRate(CurrencyConversionRates.EURO_TO_USD));
				//.setScale(1);
	}
	private static BigDecimal fromDollarsToEuros(final BigDecimal amount) {
		if (amount == null)
			throw new IllegalArgumentException("Amount to convert must not be null");
		
		return amount
				.multiply(getConversionRate(CurrencyConversionRates.USD_TO_EUR));
				//.setScale(1);
	}
	private static BigDecimal getConversionRate(CurrencyConversionRates rates) {
		return BigDecimal.valueOf(rates.getConversionRate());
	}
}
