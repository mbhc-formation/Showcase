package tn.mbhc.tudev.designpatterns.process.model;

import java.util.UUID;

public class ShoppingItem {

	private final String reference;
	private int quantity = 0;

	public ShoppingItem() {
		this.reference = UUID.randomUUID().toString();
	}
	
	public String getReference() {
		return reference;
	}

	public int getQuantity() {
		return quantity;
	}

	public void increaseQuantity() {
		this.quantity += 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantity;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingItem other = (ShoppingItem) obj;
		if (quantity != other.quantity)
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShoppingItem [reference=");
		builder.append(reference);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
}
