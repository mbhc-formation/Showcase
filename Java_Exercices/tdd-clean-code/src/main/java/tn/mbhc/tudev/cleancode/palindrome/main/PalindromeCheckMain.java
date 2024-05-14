package tn.mbhc.tudev.cleancode.palindrome.main;

import tn.mbhc.tudev.cleancode.palindrome.component.PalindromeCheck;

public class PalindromeCheckMain {

	private static PalindromeCheck palindromeCheck = new PalindromeCheck();
	private static String defaultOutputMessage = "Is '%s' a plaindrome : %s";
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("--------- Palindrome check examples -------------"); 

		System.out.println();
		System.out.println("-- 1 -- Using limit cases strings --");
		
		System.out.println(String.format("Is a null string a plaindrome : %s",
				translate(palindromeCheck.isPalindrome(null))));
		
		System.out.println(String.format("Is an empty string a plaindrome : %s",
				translate(palindromeCheck.isPalindrome(""))));
		
		System.out.println(String.format("Is a blank string a plaindrome : %s",
				translate(palindromeCheck.isPalindrome("		"))));
		
		System.out.println();
		System.out.println("-- 2 -- Using some random non plindrome words --");
		
		System.out.println(String.format(defaultOutputMessage,
				"banana",
				translate(palindromeCheck.isPalindrome("banana"))));
		System.out.println(String.format(defaultOutputMessage,
				"umbrella",
				translate(palindromeCheck.isPalindrome("umbrella"))));
		System.out.println(String.format(defaultOutputMessage,
				"airplane",
				translate(palindromeCheck.isPalindrome("airplane"))));
		System.out.println(String.format(defaultOutputMessage,
				"monitor",
				translate(palindromeCheck.isPalindrome("monitor"))));
		
		System.out.println();
		System.out.println("-- 3 -- Using some real plindrome words --");
		
		System.out.println(String.format(defaultOutputMessage,
				"level",
				translate(palindromeCheck.isPalindrome("level"))));
		System.out.println(String.format(defaultOutputMessage,
				"radar",
				translate(palindromeCheck.isPalindrome("radar"))));
		System.out.println(String.format(defaultOutputMessage,
				"racecar",
				translate(palindromeCheck.isPalindrome("racecar"))));
		System.out.println(String.format(defaultOutputMessage,
				"rotator",
				translate(palindromeCheck.isPalindrome("rotator"))));
		
		
		System.out.println();
		System.out.println("--------- End of conversion -------------"); 
	}

	/**
	 * Translates the given boolean to a yes/no value.
	 * @param result
	 * @return "yes" if result is true, "no" otherwise.
	 */
	private static String translate(final boolean result) {
		return (result) ? "yes" : "no";
	}
}
