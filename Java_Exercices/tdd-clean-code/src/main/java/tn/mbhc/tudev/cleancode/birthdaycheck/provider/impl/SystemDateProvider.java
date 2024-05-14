package tn.mbhc.tudev.cleancode.birthdaycheck.provider.impl;

import java.time.LocalDate;

import tn.mbhc.tudev.cleancode.birthdaycheck.provider.DateProvider;

/**
 * System date provider using the {@link LocalDate#now()} to generate the date.
 */
public final class SystemDateProvider implements DateProvider {

	@Override
	public LocalDate getDate() {
		return LocalDate.now();
	}

}
