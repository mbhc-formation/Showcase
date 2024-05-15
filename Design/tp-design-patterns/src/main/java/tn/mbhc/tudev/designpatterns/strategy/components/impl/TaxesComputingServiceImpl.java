package tn.mbhc.tudev.designpatterns.strategy.components.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import tn.mbhc.tudev.designpatterns.strategy.components.TaxComputingService;

/**
 * Business service for computing taxed prices.
 */
final class TaxesComputingServiceImpl implements TaxComputingService {

	private final int scale;
	private final RoundingMode roundingMode;

	/**
	 * Creates a new instance of the computing service with a default scale value
	 * <b>2</b> and a default rounding mode <b>RoundingMode.HALF_EVEN</b>
	 */
	TaxesComputingServiceImpl() {
		this.scale = 2;
		this.roundingMode = RoundingMode.HALF_EVEN;
	}

	/**
	 * Creates a new instance of the computing service with the given scale value
	 * and rounding mode.
	 * 
	 * @param scale
	 * @param roundingMode
	 */
	TaxesComputingServiceImpl(final int scale, final RoundingMode roundingMode) {
		this.scale = scale;
		this.roundingMode = roundingMode;
	}

	/**
	 * Returns the price with included taxes according to the given taxe
	 * pourcentage.
	 * 
	 * @param priceWithoutTaxes
	 * @param taxePourcentage
	 * @return
	 */
	@Override
	public final BigDecimal computeTaxedPrice(final BigDecimal priceWithoutTaxes, final double taxePourcentage) {
		BigDecimal taxeValue = priceWithoutTaxes.multiply(new BigDecimal(taxePourcentage));
		BigDecimal taxedPrice = priceWithoutTaxes.add(taxeValue);
		return taxedPrice.setScale(scale, roundingMode);
	}

}
