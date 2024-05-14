package tn.mbhc.tudev.cleancode.currency.data;

/**
 * Conversion rates for currency.
 * <br>
 * <b>Simple example, not for real usage.</b>
 */
public enum CurrencyConversionRates {

	// @formatter:off
	
	EURO_TO_USD		(Currency.EUR, Currency.USD, 1.2), 
	EUR_TO_EUR		(Currency.USD, Currency.EUR, 1.0),

	USD_TO_EUR		(Currency.USD, Currency.EUR, 0.8), 
	USD_TO_USD		(Currency.USD, Currency.EUR, 1.0)
	;

	// @formatter:on

	private final double conversionRate;
	private final Currency source;
	private final Currency target;

	/**
	 * @param source
	 * @param target
	 * @param conversionRate
	 */
	private CurrencyConversionRates(final Currency source, final Currency target, final double conversionRate) {
		this.source = source;
		this.target = target;
		this.conversionRate = conversionRate;
	}

	/**
	 * Source currency for this rate rule.
	 * @return
	 */
	public Currency getSource() {
		return source;
	}
	
	/**
	 * Target currency for this rate rule.
	 * @return
	 */
	public Currency getTarget() {
		return target;
	}
	
	/**
	 * Returns the convertion rate value for the enum instance.
	 * 
	 * @return
	 */
	public double getConversionRate() {
		return conversionRate;
	}
	
}
