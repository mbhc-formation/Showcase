package tn.mbhc.tudev.cleancode.palindrome.component;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link PalindromeCheck}
 */
public class PalindromeCheckTest {

	/*
	 * Tested instance
	 */
	private PalindromeCheck palindromeCheckUnderTest;
	
	@BeforeEach
	public void before() {
		palindromeCheckUnderTest = new PalindromeCheck();
	}
	
	@Test
	public void shouldTellANullStringIsNotPalindrome() {
		// Arrange 
		String testedValue = null;
		
		// Act
		boolean isPalindrome = palindromeCheckUnderTest.isPalindrome(testedValue);
		
		// Assert
		assertThat(isPalindrome).isFalse();
	}
	
	@Test
	public void shouldTellAnEmptyStringIsPalindrome() {
		// Arrange 
		String testedValue = "";
		
		// Act
		boolean isPalindrome = palindromeCheckUnderTest.isPalindrome(testedValue);
		
		// Assert
		assertThat(isPalindrome).isTrue();
	}
	
	@Test
	public void shouldTellABlankStringIsPalindrome() {
		// Arrange 
		String testedValue = "			";
		
		// Act
		boolean isPalindrome = palindromeCheckUnderTest.isPalindrome(testedValue);
		
		// Assert
		assertThat(isPalindrome).isTrue();
	}
	
	@Test
	public void shouldTellKayakWordIsPalindrome() {
		// Arrange 
		String testedValue = "kayak";
		
		// Act
		boolean isPalindrome = palindromeCheckUnderTest.isPalindrome(testedValue);
		
		// Assert
		assertThat(isPalindrome).isTrue();
		
	}
	
	@Test
	public void shouldTellRandomStringValueIsNotPalindrome() {
		// Arrange 
		String testedValue = "abc";
		
		// Act
		boolean isPalindrome = palindromeCheckUnderTest.isPalindrome(testedValue);
		
		// Assert
		assertThat(isPalindrome).isFalse();
	}
}
