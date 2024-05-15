package tn.mbhc.tudev.designpatterns.builder.model;

import java.util.UUID;

/**
 * Application file object representation.
 */
public class ApplicationFile {

	private final Applicant applicant;
	private final String fileReference;

	/**
	 * Creates a new instance of {@link ApplicationFile} for the given
	 * {@link Applicant} and a default random reference.
	 * 
	 * @param applicant
	 */
	public ApplicationFile(final Applicant applicant) {
		this.applicant = applicant;
		this.fileReference = UUID.randomUUID().toString();
	}
	
	/**
	 * Creates a new instance of {@link ApplicationFile} for the given
	 * {@link Applicant} and a default random reference.
	 * 
	 * @param applicant
	 */
	public ApplicationFile(final Applicant applicant, final String reference) {
		this.applicant = applicant;
		this.fileReference = reference;
	}

	/**
	 * Returns the reference of this application file.
	 * @return
	 */
	public String getFileReference() {
		return fileReference;
	}

	/**
	 * Returns the {@link Applicant} owner of this application file.
	 * @return
	 */
	public Applicant getApplicant() {
		return applicant;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ApplicationFile [applicant=");
		builder.append(applicant);
		builder.append(", fileReference=");
		builder.append(fileReference);
		builder.append("]");
		return builder.toString();
	}
	

}
