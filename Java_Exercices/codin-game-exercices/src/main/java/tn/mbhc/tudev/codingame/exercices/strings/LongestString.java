package tn.mbhc.tudev.codingame.exercices.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;

class LongestString {
	String longest(String value) {
		
		if(value == null || value.isBlank() || value.length() == 1) {
			return value;
		}
		
		if(value.length() == 2) {
			return (value.charAt(0) == value.charAt(1)) ? String.valueOf(value.charAt(0)) : value;
		}
		
		Map<Integer, String> longestStrings = new HashMap<>();
		
		Set<Character> seenChars = new HashSet<>();
		StringBuilder builder = new StringBuilder();
		
		for(int pos = 0; pos < value.length(); pos++) {
			
			if(seenChars.contains(value.charAt(pos))) {
				longestStrings.put(builder.toString().length(), builder.toString());
				builder = new StringBuilder();
				seenChars.clear();
				pos--;
			} else {
				builder.append(value.charAt(pos));
				seenChars.add(value.charAt(pos));
				if(pos == value.length() - 1) {
					longestStrings.put(builder.toString().length(), builder.toString());
				}
			}
		}
		
		OptionalInt max = longestStrings
				.keySet()
				.stream()
				.mapToInt(Integer::intValue)
				.sorted()
				.max();
		return max.isPresent() ? longestStrings.get(max.getAsInt()) : value;
	}
}