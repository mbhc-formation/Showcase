package tn.mbhc.tudev.cleancode.currency.main;

import java.math.BigDecimal;

import tn.mbhc.tudev.cleancode.currency.component.CurrencyConverter;
import tn.mbhc.tudev.cleancode.currency.data.Currency;
import tn.mbhc.tudev.cleancode.currency.data.CurrencyConversionRates;

public class CurrenCyconverterMain {

	/*
	 * Default scale for BigDecimal values
	 */
	private static final int DEF_SCALE = 1;
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("--------- Currency conversion examples -------------"); 

		System.out.println();
		System.out.println("-- 1 -- From EUR to USD --");
		
		Currency sourceCurrency = Currency.EUR;
		Currency targetCurrency = Currency.USD;
		BigDecimal valueToConvert = BigDecimal.valueOf(15.0);
		BigDecimal convertedValue = CurrencyConverter.convert(sourceCurrency, targetCurrency, valueToConvert, DEF_SCALE);
		
		System.out.println(String.format("Converting : %s %s ==> %s %s (with conversion rate %s and factor of %s)", 
				valueToConvert, sourceCurrency, 
				convertedValue, targetCurrency,
				CurrencyConversionRates.EURO_TO_USD,
				CurrencyConversionRates.EURO_TO_USD.getConversionRate()));
		
		System.out.println();
		System.out.println("-- 2 -- From USD to EUR --");
		
		sourceCurrency = Currency.USD;
		targetCurrency = Currency.EUR;
		valueToConvert = BigDecimal.valueOf(35.0);
		convertedValue = CurrencyConverter.convert(sourceCurrency, targetCurrency, valueToConvert, DEF_SCALE);
		
		System.out.println(String.format("Converting : %s %s ==> %s %s (with conversion rate %s and factor of %s)", 
				valueToConvert, sourceCurrency, 
				convertedValue, targetCurrency,
				CurrencyConversionRates.USD_TO_EUR,
				CurrencyConversionRates.USD_TO_EUR.getConversionRate()));
		
		System.out.println();
		System.out.println("--------- End of conversion -------------"); 
	}

}
