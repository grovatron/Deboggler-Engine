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
	 */
	public static void validateWordStringInput(String input) {
		checkIfStringNull(input);
		checkIfStringBlank(input);
	}
	
	private static void checkIfStringNull(String input) {
		if (input == null) {
			throw new IllegalArgumentException("Word constructor does not take null String arguments");
		}
	}
	
	private static void checkIfStringBlank(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("Word constructor does not take blank String arguments");
		}
	}

	/**
	 * Validates the list of ints, <code>location</code> for the <code>Word</code> constructor.
	 * @param listInput the <code>location</code> list to be validated.
	 * @param stringInput the <code>word</code> argument for <code>Word</code>'s constructor.
	 */
	public static void validateLocationListInput(List<Integer> listInput, String stringInput) {
		checkIfLocationsNull(listInput);
		checkIfLocationsEmpty(listInput);
		checkIfValidLength(listInput, stringInput);
		checkIfContainsNull(listInput);
		checkIfContainsRepeats(listInput);
	}
	
	private static void checkIfLocationsNull(List<Integer> locations) {
		if (locations == null) {
			throw new IllegalArgumentException("Word constructor does not take null List<Integer> arguments");
		}
	}
	
	private static void checkIfLocationsEmpty(List<Integer> locations) {
		if (locations.isEmpty()) {
			throw new IllegalArgumentException("Word constructor does not take null List<Integer> arguments");
		}
	}
	
	private static void checkIfValidLength(List<Integer> locations, String word) {
		if (!validLength(locations, word)) {
			throw new IllegalArgumentException("Argument locations has invalid length.");
		}
	}
	
	private static void checkIfContainsRepeats(List<Integer> locations) {
		if (containsRepeats(locations)) {
			throw new IllegalArgumentException("Argument locations has non-unique values");
		}
	}
	
	private static void checkIfContainsNull(List<Integer> locations) {
		if (locations.contains(null)) {
			throw new IllegalArgumentException("Word constructor does not take List<Integer> argument that contains null values.");
		}
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
	
	private static boolean validLength(List<Integer> listInput, String stringInput) {
		int quCount = 0;
		int index = 0;
		while (stringInput.indexOf("QU", index) >= 0) {
			quCount++;
			index = stringInput.lastIndexOf(stringInput, index) + 1;
		}
		return listInput.size() == stringInput.length() - quCount;
	}

	/**
	 * Validates the list of <code>ValueModifier</code> objects, <code>modifiers</code> for the
	 * <code>Word</code> constructor.
	 * @param modifiers List of <code>ValueModifier</code> objects.
	 */
	public static void validateModifierListInput(List<ValueModifier> modifiers) {
		checkIfModifiersNull(modifiers);
		checkIfModifiersContainsNull(modifiers);
	}
	
	private static void checkIfModifiersNull(List<ValueModifier> modifiers) {
		if (modifiers == null) {
			throw new IllegalArgumentException("Word constructor does not take null List<ValueModifier> argument");
		}
	}
	
	private static void checkIfModifiersContainsNull(List<ValueModifier> modifiers) {
		if (modifiers.contains(null)) {
			throw new IllegalArgumentException("Word constructor does not take List<ValueModifier> argument that contains null values.");
		}
	}
}
