package tn.mbhc.tudev.sampleprojects.ebank.exceptions;

import tn.mbhc.tudev.sampleprojects.ebank.model.Account;

/**
 * Grouping class for {@link Account} operations exceptions and errors.
 */
public class AccountExceptions {

	/**
	 * Close account operations errors and exceptions
	 */
	public static class CloseAccountWithNonZeroBalanceException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8918563767100717902L;
	}

	public static class InsufficientBalanceException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2189771895115443534L;

	}

	private AccountExceptions() {
		// Utility grouping class : no need to instanciate
	}
}
