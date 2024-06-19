package tn.mbhc.tudev.sampleprojects.ebank.exceptions;

import tn.mbhc.tudev.sampleprojects.ebank.model.Account;

/**
 * Utility class for grouping {@link Account} operations exceptions and errors.
 * This class provides nested static classes for specific types of exceptions that may occur
 * during account operations, such as closing an account with a non-zero balance or insufficient balance
 * for a withdrawal.
 */
public class AccountExceptions {

    /**
     * Exception thrown when attempting to close an account with a non-zero balance.
     */
    public static class CloseAccountWithNonZeroBalanceException extends Exception {
        private static final long serialVersionUID = -8918563767100717902L;

        /**
         * Constructs a new CloseAccountWithNonZeroBalanceException with null as its detail message.
         */
        public CloseAccountWithNonZeroBalanceException() {
            super();
        }

        /**
         * Constructs a new CloseAccountWithNonZeroBalanceException with the specified detail message.
         * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
         */
        public CloseAccountWithNonZeroBalanceException(String message) {
            super(message);
        }

        /**
         * Constructs a new CloseAccountWithNonZeroBalanceException with the specified detail message and cause.
         * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
         * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method)
         */
        public CloseAccountWithNonZeroBalanceException(String message, Throwable cause) {
            super(message, cause);
        }

        /**
         * Constructs a new CloseAccountWithNonZeroBalanceException with the specified cause and a detail message
         * that includes the cause's string representation.
         * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method)
         */
        public CloseAccountWithNonZeroBalanceException(Throwable cause) {
            super(cause);
        }
    }

    /**
     * Exception thrown when an account has insufficient balance for a requested operation.
     */
    public static class InsufficientBalanceException extends Exception {
        private static final long serialVersionUID = -2189771895115443534L;

        /**
         * Constructs a new InsufficientBalanceException with null as its detail message.
         */
        public InsufficientBalanceException() {
            super();
        }

        /**
         * Constructs a new InsufficientBalanceException with the specified detail message.
         * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
         */
        public InsufficientBalanceException(String message) {
            super(message);
        }

        /**
         * Constructs a new InsufficientBalanceException with the specified detail message and cause.
         * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
         * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method)
         */
        public InsufficientBalanceException(String message, Throwable cause) {
            super(message, cause);
        }

        /**
         * Constructs a new InsufficientBalanceException with the specified cause and a detail message
         * that includes the cause's string representation.
         * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method)
         */
        public InsufficientBalanceException(Throwable cause) {
            super(cause);
        }
    }

    /**
     * Private constructor to prevent instantiation of this utility class.
     * The nested exception classes {@link CloseAccountWithNonZeroBalanceException} and {@link InsufficientBalanceException}
     * should be used directly in account operation methods for throwing appropriate exceptions.
     */
    private AccountExceptions() {
        // Utility class: no instances should be created
    }
}
