package tn.mbhc.tudev.showcase.fizzbuzz.generator.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import tn.mbhc.tudev.showcase.fizzbuzz.generator.exceptions.NoReplacementForSequenceException;
import tn.mbhc.tudev.showcase.fizzbuzz.generator.util.Utils;

public class SequenceReplacementManager {

	private static final String EMPTY_STRING = "";
	private static final ReplacementPrecedenceComparator COMPARATOR = ReplacementPrecedenceComparator.newInstance();
	
	private Map<Integer, Replacement> replacements = new HashMap<>();

	/**
	 * Add the given replacement value to the sequence manager.
	 * 
	 * @param replacement
	 */
	public void addReplacement(final Replacement replacement) {
		this.replacements.put(replacement.getValue(), replacement);
	}

	/**
	 * Replace the given sequance integer by its corresponding replacement value.
	 * 
	 * @param value
	 * @return replacement value if present, empty string otherwise
	 */
	public String replace(final Integer value) {
		Optional<Replacement> replacement = getReplacement(value);
		if(replacement.isPresent()) {
			return replacement.get().getReplacement();
		}
		return EMPTY_STRING;
	}

	/**
	 * Indicates if the sequence manager is configured with replacement values.
	 * 
	 * @return
	 */
	public boolean hasReplacemnts() {
		return !this.replacements.isEmpty();
	}
	
	/**
	 * Indicates if the sequence manager is configured with replacement for the given sequence value.
	 * 
	 * @param value
	 * @return
	 * @throws NoReplacementForSequenceException
	 */
	public boolean hasReplacemnt(final Integer value) throws NoReplacementForSequenceException {
		return getReplacement(value).isPresent() 
				&& isReplaceable(value, getReplacement(value).orElseThrow(NoReplacementForSequenceException::new));
	}

	/*
	 * Private methods
	 */
	
	private Optional<Replacement> getReplacement(final Integer value) {
		return sortByReplacementPrecedence(mapToReplacement()).filter(entry -> isReplaceable(value, entry)).findAny();
	}

	private Stream<Replacement> mapToReplacement() {
		return entryStream().map(Entry::getValue);
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
