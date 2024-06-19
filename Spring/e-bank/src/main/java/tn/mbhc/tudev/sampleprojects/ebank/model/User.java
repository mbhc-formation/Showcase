package tn.mbhc.tudev.sampleprojects.ebank.model;

import java.util.UUID;

public class User {

	private UUID userId;
	private String firstName;
	private String lastName;
	private String location;

	private User(final String firstName, final String lastName, final String location) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}

	public static User create(final String firstName, final String lastName, final String location) {
		User user = new User(firstName, lastName, location);
		user.userId = UUID.randomUUID();
		return user;
	}

	public UUID getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLocation() {
		return location;
	}
	
}
