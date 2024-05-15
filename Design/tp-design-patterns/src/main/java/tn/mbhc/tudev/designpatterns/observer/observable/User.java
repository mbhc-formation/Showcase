package tn.mbhc.tudev.designpatterns.observer.observable;

import java.util.Observable;

public class User extends Observable {

	public enum Type {
		ADMIN, USER
	}

	private static final String MESSAGE = "[User type update from '%s' to '%s']";
	
	private String userName;
	private Type userType;

	public User(final String userName, final Type userType) {
		this.userName = userName;
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public Type getUserType() {
		return userType;
	}

	/**
	 * Changes the user type to the given type.
	 * 
	 * @param newUserType
	 */
	public void changeType(final Type newUserType) {
		String.format(MESSAGE, this.userType, newUserType);

		this.userType = newUserType;

		// Set that the object has changed
		setChanged();

		// Notify the current user observers
		notifyObservers();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userName=");
		builder.append(userName);
		builder.append(", userType=");
		builder.append(userType);
		builder.append("]");
		return builder.toString();
	}

}
