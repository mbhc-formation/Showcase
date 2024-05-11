package tn.mbhc.tudev.spring.rest.utils;

import java.util.stream.IntStream;

public final class LocalStringUtils {

	/**
	 * Generates a string containing "n" times the given value.
	 * 
	 * @param value : value to repeat
	 * @param n : repeat times (included)
	 * @return
	 */
	public static String repeat(String value, int n) {
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, n + 1).forEach(nbr -> sb.append(value));
		return sb.toString();
	}

	private LocalStringUtils() {
		// Utility class
	}
}
