package tn.mbhc.tudev.telldontaskkata.util;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;

public final class PricingUtils {

	public static BigDecimal scaleTwoHalfUp(BigDecimal value) {
		return value.setScale(2, HALF_UP);
	}

	public static BigDecimal unitaryTaxValue(final BigDecimal price, final BigDecimal taxPourcentage) {
		return price
				.divide(valueOf(100))
				.multiply(taxPourcentage);
	}

	public static BigDecimal sum(final BigDecimal first, final BigDecimal second) {
		return first.add(second);
	}

	public static BigDecimal total(final BigDecimal unitaryPrice, final int quantity) {
		return unitaryPrice.multiply(BigDecimal.valueOf(quantity));
	}

	private PricingUtils() {
	}

}
