package tn.mbhc.tudev.showcase.fizzbuzz.generator.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import tn.mbhc.tudev.showcase.fizzbuzz.generator.util.Utils;

public class SequenceReplacementManager {

	private static final ReplacementPrecedenceComparator COMPARATOR = ReplacementPrecedenceComparator.newInstance();
	private Map<Integer, Replacement> replacements = new HashMap<>();

	public void addReplacement(final Replacement replacement) {
		this.replacements.put(replacement.getValue(), replacement);
	}

	public String replace(final Integer value) {
		return getReplacement(value).get().getReplacement();
	}

	public boolean hasReplacemnt(final Integer value) {
		return getReplacement(value).isPresent() && isReplaceable(value, getReplacement(value).get());
	}

	private Optional<Replacement> getReplacement(final Integer value) {
		return sortByReplacementPrecedence(mapToReplacement()).filter(entry -> isReplaceable(value, entry)).findAny();
	}

	private Stream<Replacement> mapToReplacement() {
		return entryStream().map(entry -> entry.getValue());
	}

	private Stream<Entry<Integer, Replacement>> entryStream() {
		return replacements.entrySet().stream();
	}

	private Stream<Replacement> sortByReplacementPrecedence(Stream<Replacement> values) {
		return values.sorted(COMPARATOR);
	}

	private boolean isReplaceable(Integer value, Replacement replacement) {
		return Utils.isDivisibleBy(value, replacement.getValue());
	}

}
