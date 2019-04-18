package com.grovatron.deboggler;

import java.util.List;

/**
 * Responsible for constructing words found on the 2d <code>Letter</code> matrix.
 * 
 * @author Grover Sundstrom
 * @version 0.0.1 (04/18/2019)
 *
 */
public class WordConstructor {

	private final WordPointCalculator wordPointCalculator;

	/**
	 * Creates an instance of the <code>WordConstructor</code>
	 * @param wordPointCalculator An object that implements the <code>WordPointCalculator</code>
	 * interface.
	 */
	public WordConstructor(WordPointCalculator wordPointCalculator) {
		if (wordPointCalculator == null) {
			throw new IllegalArgumentException();
		}
		this.wordPointCalculator = wordPointCalculator;
	}
	
	public Word constructWord(List<Letter> letters, List<Integer> location) {
		if (letters == null || letters.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return null;
	}
}
