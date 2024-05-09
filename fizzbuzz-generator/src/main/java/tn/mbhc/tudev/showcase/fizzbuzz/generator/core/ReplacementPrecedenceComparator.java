package tn.mbhc.tudev.showcase.fizzbuzz.generator.core;

import java.util.Comparator;

class ReplacementPrecedenceComparator implements Comparator<Replacement> {

	public static ReplacementPrecedenceComparator newInstance() {
		return new ReplacementPrecedenceComparator();
	}

	@Override
	public int compare(Replacement o1, Replacement o2) {
		return o1.getPrecedence().compareTo(o2.getPrecedence());
	}

	private ReplacementPrecedenceComparator() {
		// Use instance factory method
	}
}
