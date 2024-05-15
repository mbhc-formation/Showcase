package tn.mbhc.tudev.designpatterns.process.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingOrder {

	public enum Status {
		ACCEPTED, INITIALIZED, VALIDATED, IN_PREPARATION, FINISHED, SHIPPED, REJECTED
	}

	private Status status;
	private Customer customer;
	private List<ShoppingItem> items;

	public ShoppingOrder() {
		this.items = new ArrayList<ShoppingItem>();
		this.status = Status.INITIALIZED;
	}

	public void attachCustomer(final Customer customer) {
		this.customer = customer;
	}
	
	public boolean hasItems() {
		return !items.isEmpty();
	}

	public int itemsCount() {
		return items.size();
	}

	public void addItem(final ShoppingItem article) {
		if (!items.contains(article)) {
			article.increaseQuantity();
			this.items.add(article);
		}
	}

	public boolean itemsAreValid() {
		// All match permet de savoir si tous les articles ont une qté supérieure ou
		// égale à 1
		return items.stream().allMatch(article -> article.getQuantity() >= 1);
	}
	
	public boolean hasValidCustomer() {
		return customer != null && customer.hasValidDetails();
	}

	public List<ShoppingItem> getItems() {
		return Collections.unmodifiableList(items);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShoppingOrder [status=");
		builder.append(status);
		builder.append(", customer=");
		builder.append(customer);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

	public void updateStatus(final Status newStatus) {
		this.status = newStatus;
	}

	public Status getStatus() {
		return status;
	}

}
