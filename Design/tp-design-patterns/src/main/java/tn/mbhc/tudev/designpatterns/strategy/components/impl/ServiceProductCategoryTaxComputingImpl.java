package tn.mbhc.tudev.designpatterns.strategy.components.impl;

import java.math.BigDecimal;

import tn.mbhc.tudev.designpatterns.strategy.components.IProductTaxesIncludedPriceComputingStrategy;
import tn.mbhc.tudev.designpatterns.strategy.components.TaxComputingService;
import tn.mbhc.tudev.designpatterns.strategy.model.Product;

public final class ServiceProductCategoryTaxComputingImpl implements IProductTaxesIncludedPriceComputingStrategy {

	private static final String ERROR_MESSAGE = "Cannot use service tax pourcentage for a product which category is not SERVICE";
	private static final Double taxPourcentage = 0.1;
	private final TaxComputingService computingService;

	public ServiceProductCategoryTaxComputingImpl() {
		this.computingService = new TaxesComputingServiceImpl();
	}
	
	@Override
	public BigDecimal computeTaxesIncludedPrice(Product produit) {
		if (Product.Category.SERVICE.equals(produit.getCategory())) {
			return computingService.computeTaxedPrice(produit.getPriceWithoutTax(), taxPourcentage);
		}
		throw new UnsupportedOperationException(ERROR_MESSAGE);
	}

}
