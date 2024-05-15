package tn.mbhc.tudev.designpatterns.builder.components.impl;

import java.time.LocalDate;

import tn.mbhc.tudev.designpatterns.builder.components.IApplicantModelBuilder;
import tn.mbhc.tudev.designpatterns.builder.model.Applicant;

/**
 * Model builder for objects of {@link Applicant} instance.
 */
public class ApplicantModelBuilderImpl implements IApplicantModelBuilder<Applicant> {

	@Override
	public Applicant build(final String firstName, final String lastName) {
		return new Applicant()
				.withFirstName(firstName)
				.withLastName(lastName);
	}

	@Override
	public Applicant build(final String firstName, final String lastName, final LocalDate birthDate) {
		return build(firstName, lastName)
				.withBirthDate(birthDate);
	}

}
