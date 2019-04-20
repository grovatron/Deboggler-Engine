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
	 */
	public static void validateStringInput(String input) {
		checkIfNull(input);
		checkIfBlank(input);
		checkIfContainsNonAlphabeticChar(input);
		checkIfLengthIllegal(input);
		checkIfNotUpperCase(input);
	}
	
	private static void checkIfNull(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Letter does not take null String argument.");
		}
	}
	
	private static void checkIfBlank(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("Letter does not take blank String arugment.");
		}
	}
	
	private static void checkIfContainsNonAlphabeticChar(String input) {
		if (containsNonAlphabeticChar(input)) {
			throw new IllegalArgumentException("Letter does not take String that contains non-alphabetic chararcters");
		}
	}
	
	private static void checkIfLengthIllegal(String input) {
		if (input.length() > 1 && !input.equals("QU")) {
			throw new IllegalArgumentException("Letter does not take Strings with lengths longer than one (except for \"QU\"");
		}
	}
	
	private static void checkIfNotUpperCase(String input) {
		if (input.equals(input.toLowerCase())) {
			throw new IllegalArgumentException("Letter does not take lower case Strings.");
		}
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
