package tn.mbhc.tudev.designpatterns.strategy.main;

import static tn.mbhc.tudev.designpatterns.strategy.components.TaxComputingStrategyFactory.initStrategies;

import java.math.BigDecimal;
import java.util.Optional;

import tn.mbhc.tudev.designpatterns.strategy.components.IProductTaxesIncludedPriceComputingStrategy;
import tn.mbhc.tudev.designpatterns.strategy.model.Product;

public class MainUsageStrategires {

	public static void main(String[] args) {
		
		Product product = new Product(Product.Category.BASIC, new BigDecimal(100));
		
		Optional<IProductTaxesIncludedPriceComputingStrategy> strategy = initStrategies(product.getCategory());
		if (strategy.isPresent()) {
			BigDecimal taxedPrice = strategy.get().computeTaxesIncludedPrice(product);
			printMessage(product, taxedPrice);
		}
	}

	private static void printMessage(final Product product, final BigDecimal taxedPrice) {
		StringBuilder builder = new StringBuilder();
		builder.append("Taxed price for a product category : ");
		builder.append(product.getCategory());
		builder.append(" is equal to ");
		builder.append(taxedPrice);
		builder.append(" € (price without taxes was ");
		builder.append(product.getPriceWithoutTax());
		builder.append(" €)");
		System.out.println(builder.toString());
	}

}
