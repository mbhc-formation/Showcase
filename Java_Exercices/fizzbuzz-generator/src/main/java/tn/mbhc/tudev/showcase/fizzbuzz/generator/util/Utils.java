package tn.mbhc.tudev.showcase.fizzbuzz.generator.util;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utils {

	public static Stream<Integer> integerRangeStream(int min, int max) {
		return IntStream.range(min, max + 1).boxed();
	}

	public static boolean isDivisibleBy(Integer value, Integer divider) throws IllegalArgumentException {
		if(divider == 0) throw new IllegalArgumentException("Division by : " + divider);
		return value % divider == 0;
	}
}
