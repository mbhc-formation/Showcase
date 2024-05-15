package tn.mbhc.tudev.designpatterns.strategy.model;

import java.math.BigDecimal;

public class Product {

	public enum Category {
		DEFAULT, SERVICE, BASIC, NORMAL;
	}
	
	private Category category;
	private BigDecimal priceWithoutTax;

	public Product(final Category category, final BigDecimal priceWithoutTax) {
		this.category = category;
		this.priceWithoutTax = priceWithoutTax;
	}

	public Category getCategory() {
		return category;
	}
	public BigDecimal getPriceWithoutTax() {
		return priceWithoutTax;
	}
}
