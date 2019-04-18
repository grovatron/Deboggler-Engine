package com.grovatron.deboggler.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Responsible for validating constructor arguments for the <code>Word</code> class.
 * 
 * @author Grover Sundstrom
 * @version 0.0.1 04/18/2019
 *
 */
public class WordValidator {

	/**
	 * Validates the String <code>word</code> argument for the <code>Word</code> constructor.
	 * @param input the <code>word</code> to be validated.
	 * @return Boolean value representing whether the input was valid.
	 */
	public static boolean validateWordStringInput(String input) {
		return input != null && !input.isBlank();
	}

	public static boolean validateLocationListInput(List<Integer> listInput, String stringInput) {
		return listInput != null &&
				!listInput.isEmpty() &&
				listInput.size() == stringInput.length() &&
				!containsRepeats(listInput);
	}
	
	private static boolean containsRepeats(List<Integer> listInput) {
		Set<Integer> intSet = new HashSet<>();
		for (int number : listInput) {
			if (!intSet.add(number)) {
				return true;
			}
		}
		return false;
	}
}
