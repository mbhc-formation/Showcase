package tn.mbhc.tudev.showcase.fizzbuzz.generator.core;

public class ReplacementImpl implements Replacement {

	private Integer value;
	private String replacement;
	private Integer precedence;

	public ReplacementImpl(Integer value, String replacement, Integer precedence) {
		this.value = value;
		this.replacement = replacement;
		this.precedence = precedence;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public String getReplacement() {
		return replacement;
	}

	@Override
	public Integer getPrecedence() {
		return precedence;
	}

}
