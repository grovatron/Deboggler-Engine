package com.grovatron.deboggler.util;

/**
 * Responsible for validating constructor arguments for the Letter class.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 (04/17/2019)
 *
 */
public class LetterValidator {

	/**
	 * Validates Strings for <code>Letter</code>'s <code>letter</code> argument
	 * in the constructor
	 * @param input String to be validated
	 * @return Boolean value representing whether input was valid
	 */
	public static boolean validateStringInput(String input) {
		return input != null &&
				!input.isEmpty() &&
				!input.isBlank() &&
				!containsNonAlphabeticChar(input) &&
				(input.length() == 1 || input.equalsIgnoreCase("QU"));
	}
	
	private static boolean containsNonAlphabeticChar(String input) {
		if (input == null) return false;
		
		char[] characters = input.toCharArray();
		for (char character : characters) {
			if (!Character.isAlphabetic(character)) {
				return true;
			}
		}
		
		return false;
	}
}
