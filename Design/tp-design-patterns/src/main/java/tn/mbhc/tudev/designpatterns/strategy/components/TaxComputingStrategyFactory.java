package tn.mbhc.tudev.designpatterns.strategy.components;

import java.util.Optional;

import tn.mbhc.tudev.designpatterns.strategy.components.impl.BasicProductCategoryTaxComputingImpl;
import tn.mbhc.tudev.designpatterns.strategy.components.impl.DefaultProductCategoryTaxComputingImpl;
import tn.mbhc.tudev.designpatterns.strategy.components.impl.ServiceProductCategoryTaxComputingImpl;
import tn.mbhc.tudev.designpatterns.strategy.model.Product;

public final class TaxComputingStrategyFactory {

	/**
	 * Creates the strategy implementation instance dependeing on the given product.
	 * 
	 * @param product
	 * @return
	 */
	public static Optional<IProductTaxesIncludedPriceComputingStrategy> initStrategies(final Product.Category productCategory) {

		Optional<IProductTaxesIncludedPriceComputingStrategy> strategy = Optional.empty();
		switch (productCategory) {
		case BASIC:
			strategy = Optional.of(new BasicProductCategoryTaxComputingImpl());
			break;
		case DEFAULT:
			strategy = Optional.of(new DefaultProductCategoryTaxComputingImpl());
			break;
		case SERVICE:
			strategy = Optional.of(new ServiceProductCategoryTaxComputingImpl());
			break;
		default:
			System.out.println(String.format("No computing strategy defined for product category : %s", productCategory));
			break;
		}
		return strategy;
	}

}
