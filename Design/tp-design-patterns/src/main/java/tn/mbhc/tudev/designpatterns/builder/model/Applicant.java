package tn.mbhc.tudev.designpatterns.builder.model;

import java.time.LocalDate;

/**
 * Class representing an application candidate.
 */
public class Applicant {

	private String lastName;
	private String firstName;
	private LocalDate birthDate;

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	/*
	 * Builder methods 
	 */
	public Applicant withFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public Applicant withLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public Applicant withBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Applicant [lastName=");
		builder.append(lastName);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append("]");
		return builder.toString();
	}

}
