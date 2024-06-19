package tn.mbhc.tudev.sampleprojects.ebank.usecases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import tn.mbhc.tudev.sampleprojects.ebank.exceptions.AccountExceptions.CloseAccountWithNonZeroBalanceException;
import tn.mbhc.tudev.sampleprojects.ebank.exceptions.AccountExceptions.InsufficientBalanceException;
import tn.mbhc.tudev.sampleprojects.ebank.model.Account;
import tn.mbhc.tudev.sampleprojects.ebank.model.User;

public class CreateUserAccountTest {

	private CreateAccountUseCase useCaseInstance = new CreateAccountUseCase();
	private User user = User.create("Wiss", "NJ", "Paris");

	@Test
	public void testCreateBankAccountForAUser() {
		/*
		 * UseCase 1 : create an account for a user
		 * 
		 * Input : - first name, last name, location - first deposit
		 * 
		 * Output : - Account object with account ID and balance with the money
		 * deposited and related to the user by user ID
		 */

		// Operation
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(1000));

		// Assertions
		assertNotNull(account.id());
		assertEquals(user, account.owner());
		assertEquals(BigDecimal.valueOf(1000), account.balance());
	}

	@Test
	public void testDepositAmountIntoBankAccount() {
		/*
		 * UseCase 2 : deposit amount into an account
		 * 
		 * Input : - account with initial amount 500 Operation : - deposit 700
		 * 
		 * Output : - account with 1200 as new balance
		 */
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(500));
		assertEquals(BigDecimal.valueOf(500), account.balance());

		// Operation
		account.deposit(BigDecimal.valueOf(700));
		// Assertions
		assertEquals(BigDecimal.valueOf(1200), account.balance());
	}

	@Test
	public void testWithdrawAmountFromBankAccount_SufficientBalance() throws InsufficientBalanceException {
		/*
		 * UseCase 3 : Withdraw amount from an account
		 * 
		 * Input : - account with initial amount 5000 Operation : - withdraw 3700
		 * 
		 * Output : - account with 1300 as new balance
		 */
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(5000));
		assertEquals(BigDecimal.valueOf(5000), account.balance());

		// Operation
		account.withDraw(BigDecimal.valueOf(3700));
		// Assertions
		assertEquals(BigDecimal.valueOf(1300), account.balance());
	}

	@Test
	public void testWithdrawAmountFromBankAccount_InsufficientBalance() {

		/*
		 * UseCase 4 : throw exception when withdraw and balance is insufficient
		 * 
		 * Input : - account with initial amount 5000 Operation : - withdraw 10000
		 * 
		 * Output : exception
		 */
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(5000));
		assertEquals(BigDecimal.valueOf(5000), account.balance());

		// Operation
		assertThrows(InsufficientBalanceException.class, () -> {
			account.withDraw(BigDecimal.valueOf(10000));
		});
	}

	@Test
	public void testCheckBalanceOfBankAccount() {
		/*
		 * UseCase 5 : return balance of a bank account
		 * 
		 * Input : - account with initial amount 5000
		 * 
		 * Operation : - check balance
		 * 
		 * Output : - balance is equal to initial deposit
		 */
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(5000));
		assertEquals(BigDecimal.valueOf(5000), account.balance());
	}

	@Test
	public void testCheckBalanceOfBankAccountAfterTwoDeposits() {
		/*
		 * UseCase 6 : return balance of a bank account with initial amount and two
		 * operations of deposit
		 * 
		 * Input : - account with initial amount 5000
		 * 
		 * Operations : - deposit 1000 - deposit 1500 - check balance
		 * 
		 * Output : - balance is equal to new value after the deposit operations
		 */
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(5000));

		// Operations
		account.deposit(BigDecimal.valueOf(1000));
		account.deposit(BigDecimal.valueOf(1500));

		// Assertions
		assertEquals(BigDecimal.valueOf(7500), account.balance());
	}

	@Test
	public void testCheckBalanceOfBankAccountAfterTwoWithdrawals() throws InsufficientBalanceException {
		/*
		 * UseCase 7 : return balance of a bank account with initial amount and two
		 * operations of withdrawal
		 * 
		 * Input : - account with initial amount 5000
		 * 
		 * Operations : - withdraw 1000 - withdraw 1500 - check balance
		 * 
		 * Output : - balance is equal to new value after the withdrawal operations
		 */
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(5000));

		// Operations
		account.withDraw(BigDecimal.valueOf(1000));
		account.withDraw(BigDecimal.valueOf(1500));

		// Assertions
		assertEquals(BigDecimal.valueOf(2500), account.balance());
	}

	@Test
	public void testCheckBalanceOfBankAccountAfterWithdrawalThenDeposit() throws InsufficientBalanceException {
		/*
		 * UseCase 8 : return balance of a bank account with initial amount and two
		 * operations of withdrawal then a deposit
		 * 
		 * Input : - account with initial amount 5000
		 * 
		 * Operations : - withdraw 1000 - deposit 1500 - check balance
		 * 
		 * Output : - balance is equal to new value after the operations
		 */
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(5000));

		// Operations
		account.withDraw(BigDecimal.valueOf(1000));
		account.deposit(BigDecimal.valueOf(1500));

		// Assertions
		assertEquals(BigDecimal.valueOf(5500), account.balance());
	}

	@Test
	public void testCheckBalanceOfBankAccountAfterDepositThenWithdrawal() throws InsufficientBalanceException {
		/*
		 * UseCase 8 : return balance of a bank account with initial amount and two
		 * operations of deposit then withdrawal
		 * 
		 * Input : - account with initial amount 5000
		 * 
		 * Operations : - deposit 1000 - withdrawal 6000 - check balance
		 * 
		 * Output : - balance is equal to new value after the operations
		 */
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(5000));

		// Operations
		account.deposit(BigDecimal.valueOf(1000));
		account.withDraw(BigDecimal.valueOf(6000));

		// Assertions
		assertEquals(BigDecimal.valueOf(0), account.balance());
	}

	@Test
	public void testCheckBalanceOfBankAccountAfterMultipleDepositsAndMultipleWithdrawals()
			throws InsufficientBalanceException {
		/*
		 * UseCase 8 : return balance of a bank account with initial amount and multiple
		 * operations of deposit and withdrawal
		 * 
		 * Input : - account with initial amount 5000
		 * 
		 * Operations : - deposit 1000 - withdrawal 500 - withdrawal 3600 - deposit
		 * 250.50 - check balance
		 * 
		 * Output : - balance is equal to new value after the operations
		 */
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(5000));

		// Operations
		account.deposit(BigDecimal.valueOf(1000));
		account.withDraw(BigDecimal.valueOf(500));
		account.withDraw(BigDecimal.valueOf(3600));
		account.deposit(BigDecimal.valueOf(250.50));

		// Assertions
		assertEquals(BigDecimal.valueOf(2150.50), account.balance());
	}

	@Test
	public void testCloseAccountForAUser() throws CloseAccountWithNonZeroBalanceException {
		/*
		 * UseCase 9 :fermeture de compte ayant un solde zero
		 * 
		 * Input : - account avec solde zero
		 * 
		 * 
		 * Output : - un objet account avec owner null , avec solde zero
		 * 
		 */

		// Operation
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(0));

		// Operations
		account.close();

		// Assertions
		assertNotNull(account.id());
		assertNull(account.owner());
		assertEquals(BigDecimal.valueOf(0), account.balance());
	}

	@Test
	public void testCloseAccountForAUser_AcccountWithPositiveBalance() {
		/*
		 * UseCase 10 :fermeture de compte ayant un solde non nul
		 * 
		 * Input : - account avec solde non nul
		 * 
		 * 
		 * Output : - un objet account avec owner null , avec solde zero
		 * 
		 */

		// Operation
		Account account = useCaseInstance.newAccount(user, BigDecimal.valueOf(10));
		// Operations
		assertThrows(CloseAccountWithNonZeroBalanceException.class, () -> {
			account.close();
		});
		
	}
}
