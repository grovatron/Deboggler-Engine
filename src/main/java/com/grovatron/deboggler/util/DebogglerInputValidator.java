package com.grovatron.deboggler.util;

import com.grovatron.deboggler.Letter;
import com.grovatron.deboggler.WordConstructor;
import com.grovatron.deboggler.WordSet;
import com.grovatron.deboggler.dictionary.Dictionary;

/**
 * Responsible for validating all input for the <code>Deboggler</code> class.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/19/2019
 *
 */
public class DebogglerInputValidator {
	
	public static void validateConstructorArguments(Dictionary dictionary, WordConstructor wordConstructor,
			WordSet wordSet, int minLength) {
		checkIfDictonaryNull(dictionary);
		checkIfWordConstructorNull(wordConstructor);
		checkIfWordSetNull(wordSet);
		checkIfMinLengthGreaterThanOne(minLength);
	}
	
	private static void checkIfDictonaryNull(Dictionary dictionary) {
		if (dictionary == null) {
			throw new IllegalArgumentException("Constructor does not take null Dictionary value");
		}
	}
	
	private static void checkIfWordConstructorNull(WordConstructor wordConstructor) {
		if (wordConstructor == null) {
			throw new IllegalArgumentException("Constructor does not take null WordConstructor value");
		}
	}
	
	private static void checkIfWordSetNull(WordSet wordSet) {
		if (wordSet == null) {
			throw new IllegalArgumentException("Constructor does not take null WordSet value");
		}
	}
	
	private static void checkIfMinLengthGreaterThanOne(int minLength) {
		if (minLength < 1) {
			throw new IllegalArgumentException("Constructor does not take minLength < 1");
		}
	}

	/**
	 * Validates <code>Letter[][] letterGrid</code> argument.
	 * @param letterGrid <code>Letter[][]</code> to be validated.
	 */
	public static void validateLetterGrid(Letter[][] letterGrid) {
		checkIfNull(letterGrid);
		checkIfEmpty(letterGrid);
		checkIfJagged(letterGrid);
		checkIfMinimumLength(letterGrid);
	}
	
	private static void checkIfNull(Letter[][] letterGrid) {
		if (letterGrid == null) {
			throw new IllegalArgumentException("getWordList does not take null Letter[][].");
		}
	}
	
	private static void checkIfEmpty(Letter[][] letterGrid) {
		for (int i = 0; i < letterGrid.length; i++) {
			for (int j = 0; j < letterGrid[i].length; j++) {
				if (letterGrid[i][j] == null) {
					throw new IllegalArgumentException("getWordList does not take Letter[][] with null values");
				}
			}
		}
	}
	
	private static void checkIfJagged(Letter[][] letterGrid) {
		int rowLength = letterGrid.length;
		for (Letter[] column : letterGrid) {
			if (column.length != rowLength) {
				throw new IllegalArgumentException("getWordList does not take jagged Letter[][].");
			}
		}
	}
	
	private static void checkIfMinimumLength(Letter[][] letterGrid) {
		if (letterGrid.length < 2) {
			throw new IllegalArgumentException("getWordList does not take Letter[][] with less than two rows and columns");
		}
	}
}
