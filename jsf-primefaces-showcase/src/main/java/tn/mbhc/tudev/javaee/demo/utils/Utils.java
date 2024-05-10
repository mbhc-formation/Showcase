package tn.mbhc.tudev.javaee.demo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Utils {

	/**
	 * Returns today's date as a string timestamp with
	 * <b>ddMMyyyyHHmmss</b> pattern.
	 * 
	 * @return
	 */
	public static final String generateTodaysTimestamp() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
	}

	private Utils() {
		// Utility class, no need to instanciate
	}
}