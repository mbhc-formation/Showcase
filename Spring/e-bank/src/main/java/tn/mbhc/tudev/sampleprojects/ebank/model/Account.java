package tn.mbhc.tudev.sampleprojects.ebank.model;

import java.math.BigDecimal;
import java.util.UUID;

import tn.mbhc.tudev.sampleprojects.ebank.exceptions.AccountExceptions;
import tn.mbhc.tudev.sampleprojects.ebank.exceptions.AccountExceptions.InsufficientBalanceException;

public class Account {

	private UUID id;
	private User owner;
	private BigDecimal balance;

	public Account(final User owner) {
		this.owner = owner;
		this.balance = BigDecimal.ZERO;
		this.id = UUID.randomUUID();
	}

	/*
	 * 
	 */
	public void deposit(final BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}

	/*
	 * 
	 */
	public User owner() {
		return owner;
	}

	public BigDecimal balance() {
		return this.balance;
	}

	public UUID id() {
		return id;
	}

	public void close() throws AccountExceptions.CloseAccountWithNonZeroBalanceException {
		if (balanceIsNotZero()) {
			throw new AccountExceptions.CloseAccountWithNonZeroBalanceException();
		}
		this.owner = null;
		this.balance = BigDecimal.ZERO;
	}

	public void withDraw(BigDecimal amount) throws InsufficientBalanceException {
		throwExceptionIfWithdrawNotPossible(amount);
		this.balance = this.balance.subtract(amount);
	}

	private boolean balanceIsNotZero() {
		return !this.balance.equals(BigDecimal.ZERO);
	}

	private void throwExceptionIfWithdrawNotPossible(BigDecimal amount) throws InsufficientBalanceException {
		if (amount.compareTo(this.balance) > 0) {
			throw new AccountExceptions.InsufficientBalanceException();
		}
	}
}
