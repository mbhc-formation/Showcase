package tn.mbhc.tudev.telldontaskkata.domain;

import static tn.mbhc.tudev.telldontaskkata.util.PricingUtils.scaleTwoHalfUp;
import static tn.mbhc.tudev.telldontaskkata.util.PricingUtils.sum;
import static tn.mbhc.tudev.telldontaskkata.util.PricingUtils.total;
import static tn.mbhc.tudev.telldontaskkata.util.PricingUtils.unitaryTaxValue;

import java.math.BigDecimal;

public class OrderItem {

	private final int quantity;
	private final Product product;
	private BigDecimal taxedAmount;
	private BigDecimal tax;

	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		computeTaxAndTotal();
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal tax() {
		return tax;
	}

	public BigDecimal taxedAmount() {
		return taxedAmount;
	}

	private void computeTaxAndTotal() {

		//		BigDecimal unitaryTax =  scaleTwoHalfUp(unitaryTaxValue(product.getPrice(), product.taxPercentage()));
		//		tax = total(unitaryTax, quantity);
		//
		//		BigDecimal unitaryTaxedAmount = sum(product.getPrice(), unitaryTax);
		//		taxedAmount = scaleTwoHalfUp(total(unitaryTaxedAmount, quantity));

		BigDecimal unitaryTax =  scaleTwoHalfUp(unitaryTaxValue(product.getPrice(), product.taxPercentage()));
		tax = total(unitaryTax, quantity);
		BigDecimal sum = sum(product.getPrice(), unitaryTax);
		taxedAmount = scaleTwoHalfUp(total(sum, quantity));
	}

}
