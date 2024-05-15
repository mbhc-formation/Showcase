package tn.mbhc.tudev.designpatterns.strategy.components.impl;

import java.math.BigDecimal;

import tn.mbhc.tudev.designpatterns.strategy.components.IProductTaxesIncludedPriceComputingStrategy;
import tn.mbhc.tudev.designpatterns.strategy.components.TaxComputingService;
import tn.mbhc.tudev.designpatterns.strategy.model.Product;

public final class NormalProductCategoryTaxComputingImpl implements IProductTaxesIncludedPriceComputingStrategy {

	private static final String ERROR_MESSAGE = "Cannot use notmal tax pourcentage for a product which category is not NORMAL";
	private static final Double taxPourcentage = 0.19;
	private final TaxComputingService computingService;

	public NormalProductCategoryTaxComputingImpl() {
		this.computingService = new TaxesComputingServiceImpl();
	}
	
	@Override
	public BigDecimal computeTaxesIncludedPrice(Product produit) {
		if (Product.Category.NORMAL.equals(produit.getCategory())) {
			return computingService.computeTaxedPrice(produit.getPriceWithoutTax(), taxPourcentage);
		}
		throw new UnsupportedOperationException(ERROR_MESSAGE);
	}

}
