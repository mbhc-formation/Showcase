package tn.mbhc.tudev.designpatterns.builder.main;

import java.time.LocalDate;

import tn.mbhc.tudev.designpatterns.builder.components.IApplicantModelBuilder;
import tn.mbhc.tudev.designpatterns.builder.components.IApplicationFileModelBuilder;
import tn.mbhc.tudev.designpatterns.builder.components.impl.ApplicantModelBuilderImpl;
import tn.mbhc.tudev.designpatterns.builder.components.impl.ApplicationFileModelBuilderImpl;
import tn.mbhc.tudev.designpatterns.builder.model.Applicant;
import tn.mbhc.tudev.designpatterns.builder.model.ApplicationFile;

public class BuilderPatternMain {

	private static IApplicantModelBuilder<Applicant> applicantModelBuilder = new ApplicantModelBuilderImpl();
	private static IApplicationFileModelBuilder<ApplicationFile> applicationFileModelBuilder = new ApplicationFileModelBuilderImpl();
	
	public static void main(String[] args) {
		Applicant applicant = applicantModelBuilder.build("Mohamed", "BH", LocalDate.of(1984, 1, 1));
		ApplicationFile applicationFile = applicationFileModelBuilder.build(applicant);
		System.out.println(String.format("Applicant : %s", applicant));
		System.out.println(String.format("Application File : %s", applicationFile));
	}

}
