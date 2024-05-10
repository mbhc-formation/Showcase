package tn.mbhc.tudev.telldontaskkata.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

public class Order {

	private Long id;
	private OrderDetails details;
	private List<OrderItem> items;

	private Order() {
	}

	private Order(Long id, BigDecimal total, String currency, BigDecimal tax, OrderStatus status,
			List<OrderItem> items) {
		this.id = id;
		this.items = items;
		this.details = new OrderDetails(total, currency, tax, status);
	}

	public void addItem(OrderItem orderItem) {
		this.items.add(orderItem);
		details.updateTotalAndApplyTax(orderItem.taxedAmount(), orderItem.tax());
	}

	public Long itemsCount() {
		return (long) items.size();
	}

	public boolean isOrderIdEqualtTo(Long orderId) {
		return id.equals(orderId);
	}

	public void ship() {
		details.updatetStatus(OrderStatus.SHIPPED);
	}

	public boolean isApproved() {
		return details.isApproved();
	}

	public boolean isRejected() {
		return details.isRejected();
	}

	public boolean isShipped() {
		return details.isShipped();
	}

	public boolean isCreated() {
		return details.isCreated();
	}

	public Collection<OrderItem> items() {
		return Collections.unmodifiableCollection(items);
	}

	public OrderStatus status() {
		return details.status;
	}

	public BigDecimal total() {
		return details.total;
	}

	public BigDecimal tax() {
		return details.tax;
	}

	public String currency() {
		return details.currency;
	}

	class OrderDetails {

		private String currency;
		private BigDecimal total;
		private BigDecimal tax;
		private OrderStatus status;

		public OrderDetails(BigDecimal total, String currency, BigDecimal tax, OrderStatus status) {
			super();
			this.total = total;
			this.currency = currency;
			this.tax = tax;
			this.status = status;
		}

		boolean isApproved() {
			return status.equals(OrderStatus.APPROVED);
		}

		boolean isRejected() {
			return status.equals(OrderStatus.REJECTED);
		}

		boolean isShipped() {
			return status.equals(OrderStatus.SHIPPED);
		}

		boolean isCreated() {
			return status.equals(OrderStatus.CREATED);
		}

		void updatetStatus(OrderStatus newStatus) {
			status = newStatus;
		}

		void updateTotalAndApplyTax(BigDecimal taxedAmount, BigDecimal taxAmount) {
			updateTotal(taxedAmount);
			updateTax(taxAmount);
		}

		private void updateTotal(BigDecimal taxedAmount) {
			this.total = total.add(taxedAmount);
		}

		private void updateTax(BigDecimal taxAmount) {
			this.tax = tax.add(taxAmount);
		}
	}

	public static class OrderBilder {

		private Long id;
		private BigDecimal total;
		private String currency;
		private BigDecimal tax;
		private OrderStatus status;
		private List<OrderItem> items;

		/**
		 * Default order id is set to 1 and status to created.
		 * @return
		 */
		public OrderBilder withDefaultIdAndStatus() {
			return new OrderBilder().withId(Long.valueOf(1)).withStatus(OrderStatus.CREATED);
		}

		public OrderBilder withId(Long id) {
			this.id = id;
			return this;
		}

		public OrderBilder withStatus(OrderStatus status) {
			this.status = status;
			return this;
		}

		public OrderBilder withTotal(BigDecimal total) {
			this.total = total;
			return this;
		}

		public OrderBilder withTax(BigDecimal tax) {
			this.tax = tax;
			return this;
		}

		public OrderBilder withCurrency(String currency) {
			this.currency = currency;
			return this;
		}

		public OrderBilder withItems(List<OrderItem> items) {
			this.items = items;
			return this;
		}

		public OrderBilder createdWithNoId(Currency curency) {
			this.withStatus(OrderStatus.CREATED);
			this.withTotal(new BigDecimal("0.00"));
			this.withTax(new BigDecimal("0.00"));
			this.withItems(new ArrayList<>());
			this.withCurrency(curency.getCurrencyCode());
			return this;
		}

		public Order build() {
			return new Order(id, total, currency, tax, status, items);
		}

	}

	public void approve() {
		details.status = OrderStatus.APPROVED;
	}

	public void reject() {
		details.status = OrderStatus.REJECTED;
	}

}
