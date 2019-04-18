package com.grovatron.deboggler.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.grovatron.deboggler.ValueModifier;

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

	/**
	 * Validates the list of ints, <code>location</code> for the <code>Word</code> constructor.
	 * @param listInput the <code>location</code> list to be validated.
	 * @param stringInput the <code>word</code> argument for <code>Word</code>'s constructor.
	 * @return Boolean value representing whether the input was vaild.
	 */
	public static boolean validateLocationListInput(List<Integer> listInput, String stringInput) {
		return listInput != null &&
				!listInput.isEmpty() &&
				listInput.size() == stringInput.length() &&
				!containsNull(listInput) &&
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
	
	private static boolean containsNull(List<Integer> listInput) {
		for (Integer number : listInput) {
			if (number == null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Validates the list of <code>ValueModifier</code> objects, <code>modifiers</code> for the
	 * <code>Word</code> constructor.
	 * @param modifiers List of <code>ValueModifier</code> objects.
	 * @return Boolean value representing whether the input is valid.
	 */
	public static boolean validateModifierListInput(List<ValueModifier> modifiers) {
		return modifiers != null &&
				!modifiers.contains(null);
	}
}
