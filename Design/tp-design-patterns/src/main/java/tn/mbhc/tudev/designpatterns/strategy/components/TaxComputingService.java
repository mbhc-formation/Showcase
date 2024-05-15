package tn.mbhc.tudev.designpatterns.strategy.components;

import java.math.BigDecimal;

public interface TaxComputingService {

	/**
	 * Returns the price with included taxes according to the given taxe
	 * pourcentage.
	 * 
	 * @param priceWithoutTaxes
	 * @param taxePourcentage
	 * @return
	 */
	BigDecimal computeTaxedPrice(final BigDecimal priceWithoutTaxes, final double taxePourcentage);

}
