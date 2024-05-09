package tn.mbhc.tudev.telldontaskkata.domain;

import java.math.BigDecimal;

public final class Category {
	public final String name;
	public final BigDecimal taxPercentage;

	public Category(String name, BigDecimal taxPercentage) {
		this.name = name;
		this.taxPercentage = taxPercentage;
	}

}
