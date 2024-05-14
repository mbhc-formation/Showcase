package tn.mbhc.tudev.cleancode.birthdaycheck.provider.impl;

import java.time.LocalDate;

import tn.mbhc.tudev.cleancode.birthdaycheck.provider.DateProvider;

/**
 * Initial input date provider using an initial value of {@link LocalDate}.
 */
public final class InitialInputDateProvider implements DateProvider {

	/*
	 * Initial input date
	 */
	private LocalDate testDate;

	/**
	 * Provides a {@link LocalDate} for testing.
	 * 
	 * @param testDate the initial input date that will be returned for testing
	 */
	public InitialInputDateProvider(final LocalDate testDate) {
		this.testDate = testDate;
	}

	@Override
	public LocalDate getDate() {
		return testDate;
	}

}
