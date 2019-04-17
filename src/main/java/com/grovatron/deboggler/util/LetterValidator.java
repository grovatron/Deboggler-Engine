package com.grovatron.deboggler.util;

public class LetterValidator {

	public static boolean validateInput(String input) {
		return input != null &&
				!input.isEmpty() &&
				!input.isBlank() &&
				!containsDigits(input);
	}
	
	private static boolean containsDigits(String input) {
		if (input == null) {
			return false;
		}
		char[] characters = input.toCharArray();
		for (char character : characters) {
			if (Character.isDigit(character)) {
				return true;
			}
		}
		return false;
	}
}
