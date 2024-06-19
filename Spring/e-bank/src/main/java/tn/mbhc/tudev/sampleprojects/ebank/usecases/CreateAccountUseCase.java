package tn.mbhc.tudev.sampleprojects.ebank.usecases;

import java.math.BigDecimal;

import tn.mbhc.tudev.sampleprojects.ebank.model.Account;
import tn.mbhc.tudev.sampleprojects.ebank.model.User;

public class CreateAccountUseCase {

	public Account newAccount(User user, BigDecimal amount) {
		Account account = new Account(user);
		account.deposit(amount);
		return account;
	}

}
