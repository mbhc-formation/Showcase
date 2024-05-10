package tn.mbhc.tudev.spring.rest.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Date time utility class.
 */
public final class DateTimeUtils {

	private static final DateTimeFormatter DEFAULT_DTF = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	/**
	 * Format the given date with the default <b>dd-MM-yyyy</b> pattern.
	 * 
	 * @param date
	 * @return
	 */
	public static final String format(final LocalDate date) {
		return DEFAULT_DTF.format(date);
	}

	/**
	 * Format the given date with the given pattern.
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String format(final LocalDate date, final String pattern) {
		return DateTimeFormatter.ofPattern(pattern).format(date);
	}

	private DateTimeUtils() {
		// Utility class, no need to instanciate it
	}

}
