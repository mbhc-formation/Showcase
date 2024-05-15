package tn.mbhc.tudev.designpatterns.builder.components;

import java.time.LocalDate;

import tn.mbhc.tudev.designpatterns.builder.model.Applicant;

/**
 * Marking interface for the {@link Applicant} model builder;
 * 
 * @author Mohamed
 *
 * @param <T> generic type to be built (must type of {@link Applicant} or
 *            a subclass of it)
 */
public interface IApplicantModelBuilder<T extends Applicant> {

	/**
	 * Builds a {@link Applicant} instance using the given inputs.
	 * @param firstName
	 * @param lastName
	 * 
	 * @return
	 */
	T build(final String firstName, final String lastName);

	/**
	 * Builds a {@link Applicant} instance using the given inputs.
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * 
	 * @return
	 */
	T build(final String firstName, final String lastName, final LocalDate birthDate);

}
