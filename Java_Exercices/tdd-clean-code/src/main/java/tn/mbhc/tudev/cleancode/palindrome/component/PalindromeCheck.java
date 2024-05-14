package tn.mbhc.tudev.cleancode.palindrome.component;

/**
 * Class used to check if a given string is a "palindrome". <br>
 * Palindrome string is a string that can be read from left to right as same as
 * from right to left. <br>
 */
public final class PalindromeCheck {

	/**
	 * Checks if the given string is a "Palindrom".
	 * 
	 * @param valueToCheck
	 * @return
	 */
	public boolean isPalindrome(final String valueToCheck) {
		return valueToCheck != null 
				&& valueToCheck.equals(reverse(valueToCheck));
	}

	/**
	 * Reverse the given string using a {@link StringBuilder}
	 * @param value
	 * @return
	 */
	private String reverse(final String value) {
		return new StringBuilder(value)
				.reverse()
				.toString();
	}

}
