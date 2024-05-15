package tn.mbhc.tudev.designpatterns.builder.components.impl;

import java.util.UUID;

import tn.mbhc.tudev.designpatterns.builder.components.IApplicationFileModelBuilder;
import tn.mbhc.tudev.designpatterns.builder.model.Applicant;
import tn.mbhc.tudev.designpatterns.builder.model.ApplicationFile;

/**
 * Builder for {@link ApplicationFile} 
 */
public class ApplicationFileModelBuilderImpl implements IApplicationFileModelBuilder<ApplicationFile> {

	@Override
	public ApplicationFile build(final Applicant candidat) {
		return build(candidat, UUID.randomUUID().toString());
	}

	@Override
	public ApplicationFile build(final Applicant candidat, final String reference) {
		return new ApplicationFile(candidat, reference);
	}
}
