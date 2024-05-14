package tn.mbhc.tudev.cleancode.birthdaycheck.component;

import java.time.LocalDate;
import java.util.Objects;

import tn.mbhc.tudev.cleancode.birthdaycheck.provider.DateProvider;

/**
 * Class that checks for birthday date.
 */
public final class BirthdayCheck {

	/*
	 * Date provider for comparison
	 */
	private final DateProvider dateProvider;

	/**
	 * Creates a new instance with a default date provider using system date
	 * {@link LocalDate#now()}.
	 */
	public BirthdayCheck() {
		this.dateProvider = LocalDate::now;
	}

	/**
	 * Creates a new instance with the given date provider.
	 * 
	 * @param dateProvider
	 */
	public BirthdayCheck(final DateProvider dateProvider) {
		this.dateProvider = dateProvider;
	}

	/**
	 * Checks if the given date is equal to the provider's generated date.
	 * 
	 * @param myBirthDate
	 * @return
	 * @throws if myBirthDate is null.
	 */
	public boolean isMyBirthday(final LocalDate myBirthDate) throws IllegalArgumentException {
		if (myBirthDate == null) {
			throw new IllegalArgumentException("Invalid date input");
		}
		return Objects.equals(this.dateProvider.getDate(), myBirthDate);
	}

}
