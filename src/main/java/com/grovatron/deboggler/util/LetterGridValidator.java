package com.grovatron.deboggler.util;

import com.grovatron.deboggler.Letter;

/**
 * Responsible for validating the <code>Letter[][] letterGrid</code> argument in
 * <code>Deboggler</code>'s <code>getWordList</code> method.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/19/2019
 *
 */
public class LetterGridValidator {

	/**
	 * Validates <code>Letter[][] letterGrid</code> argument.
	 * @param letterGrid <code>Letter[][]</code> to be validated.
	 */
	public static void validateLetterGrid(Letter[][] letterGrid) {
		checkIfNull(letterGrid);
	}
	
	private static void checkIfNull(Letter[][] letterGrid) {
		if (letterGrid == null) {
			throw new IllegalArgumentException("getWordList does not take null Letter[][].");
		}
	}
}
