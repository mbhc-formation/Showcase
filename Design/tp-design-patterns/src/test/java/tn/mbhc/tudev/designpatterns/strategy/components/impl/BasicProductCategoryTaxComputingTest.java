package tn.mbhc.tudev.designpatterns.strategy.components.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import tn.mbhc.tudev.designpatterns.strategy.components.IProductTaxesIncludedPriceComputingStrategy;
import tn.mbhc.tudev.designpatterns.strategy.model.Product;

@RunWith(BlockJUnit4ClassRunner.class)
public class BasicProductCategoryTaxComputingTest {

	private IProductTaxesIncludedPriceComputingStrategy strategy;
	
	@Before
	public void before() {
		strategy = new BasicProductCategoryTaxComputingImpl();
	}
	
	@Test
	public void shouldComputeTaxedPriceForBasicProductCategory() {

		// Arrange
		Product product = new Product(Product.Category.BASIC, new BigDecimal(10));
		BigDecimal expectedTaxedPrice = new BigDecimal(10.55).setScale(2, RoundingMode.HALF_EVEN);

		// Act 
		BigDecimal taxesIncludedPrice = strategy.computeTaxesIncludedPrice(product);

		// Assert
		assertEquals(expectedTaxedPrice, taxesIncludedPrice);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void shouldThrowExceptionForNonBasicProductCategory() {
		// Arrange
		Product basicProduct = new Product(Product.Category.NORMAL, new BigDecimal(10));

		// Act 
		strategy.computeTaxesIncludedPrice(basicProduct);
	}

}
