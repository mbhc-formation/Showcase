package tn.mbhc.tudev.designpatterns.strategy.components.impl;

import java.math.BigDecimal;

import tn.mbhc.tudev.designpatterns.strategy.components.IProductTaxesIncludedPriceComputingStrategy;
import tn.mbhc.tudev.designpatterns.strategy.components.TaxComputingService;
import tn.mbhc.tudev.designpatterns.strategy.model.Product;

public final class DefaultProductCategoryTaxComputingImpl implements IProductTaxesIncludedPriceComputingStrategy {

	private static final String ERROR_MESSAGE = "Cannot use default tax pourcentage for a product which category is not DEFAULT";
	private static final Double taxPourcentage = 0.2;
	
	private final TaxComputingService computingService;

	public DefaultProductCategoryTaxComputingImpl() {
		this.computingService = new TaxesComputingServiceImpl();
	}

	@Override
	public BigDecimal computeTaxesIncludedPrice(final Product produit) {
		if (Product.Category.DEFAULT.equals(produit.getCategory())) {
			return computingService.computeTaxedPrice(produit.getPriceWithoutTax(), taxPourcentage);
		}
		throw new UnsupportedOperationException(ERROR_MESSAGE);
	}

}
