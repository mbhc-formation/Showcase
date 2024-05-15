package tn.mbhc.tudev.designpatterns.process.model;

public class Customer {

	private String firstName;
	private String lastName;

	public void updateDetails(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean hasValidDetails() {
		return isNotNullOrEmpty(this.lastName) && isNotNullOrEmpty(this.firstName);
	}

	private boolean isNotNullOrEmpty(String value) {
		return value != null && !value.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}
}
