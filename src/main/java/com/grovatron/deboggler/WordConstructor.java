package com.grovatron.deboggler;

import java.util.List;
import java.util.stream.Collectors;

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
		if (letters == null || letters.isEmpty() || letters.contains(null) ||
				location == null || location.isEmpty() || location.contains(null) ||
				letters.size() != location.size()) {
			throw new IllegalArgumentException();
		}
		String word = letters.stream().map(Letter::getLetter).collect(Collectors.joining());
		int value = wordPointCalculator.calculatePoints(letters);
		List<ValueModifier> modifiers = letters.stream()
											.map(Letter::getModifier)
											.filter(modifier -> modifier != null)
											.collect(Collectors.toList());
		return new Word(word, value, location, modifiers);
	}
}
