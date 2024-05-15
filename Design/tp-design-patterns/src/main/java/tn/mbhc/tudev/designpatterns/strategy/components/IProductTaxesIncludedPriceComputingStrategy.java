package tn.mbhc.tudev.designpatterns.strategy.components;

import java.math.BigDecimal;

import tn.mbhc.tudev.designpatterns.strategy.model.Product;

public interface IProductTaxesIncludedPriceComputingStrategy {

	/**
	 * Returns the price of the given product with included taxes.
	 * 
	 * @param produit
	 * @return
	 */
	BigDecimal computeTaxesIncludedPrice(final Product produit);

}
