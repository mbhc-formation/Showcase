package tn.mbhc.tudev.designpatterns.builder.components;

import tn.mbhc.tudev.designpatterns.builder.model.Applicant;
import tn.mbhc.tudev.designpatterns.builder.model.ApplicationFile;

/**
 * Marking interface for the {@link ApplicationFile} model builder;
 * 
 * @author Mohamed
 *
 * @param <T> generic type to be built (must type of {@link ApplicationFile} or
 *            a subclass of it)
 */
public interface IApplicationFileModelBuilder<T extends ApplicationFile> {

	/**
	 * Builds a {@link ApplicationFile} instance using the given {@link Applicant}
	 * and then assign a default reference to it.
	 * 
	 * @param candidat
	 * @return
	 */
	T build(final Applicant candidat);

	/**
	 * Builds a {@link ApplicationFile} instance using the given {@link Applicant}
	 * and then given reference.
	 * 
	 * @param candidat
	 * @param reference
	 * @return
	 */
	T build(final Applicant candidat, final String reference);
}
