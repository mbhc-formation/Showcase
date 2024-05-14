package tn.mbhc.tudev.cleancode.birthdaycheck.provider.impl;

import java.time.LocalDate;

import tn.mbhc.tudev.cleancode.birthdaycheck.provider.DateProvider;

/**
 * In-memory fixed date provider using {@link LocalDate} fixed value : 1st
 * January 2000.
 */
public class InMemoryFixedDateProvider implements DateProvider {

	@Override
	public LocalDate getDate() {
		return LocalDate.of(2000, 1, 1);
	}

}
