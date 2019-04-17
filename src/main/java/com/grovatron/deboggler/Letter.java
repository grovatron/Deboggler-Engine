package com.grovatron.deboggler;

import com.grovatron.deboggler.util.LetterValidator;

/**
 * Represents a letter in a Boggle-style grid of letters.
 * <code>Letter</code> objects may optionally have a point value and <code>Modifier</code>.
 * 
 * @author Grover Sundstrom	(grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/15/2019
 *
 */
public class Letter {

	private final String letter;
	private final int value;
	private final ValueModifier modifier;
	
	/**
	 * Creates an instance of <code>Letter</code> with the letter, value,
	 * and <code>ValueModifier</code> supplied by the client.
	 * @param letter
	 * @param value
	 * @param modifier
	 */
	public Letter(String letter, int value, ValueModifier modifier) {
		if (!LetterValidator.validateInput(letter)) {
			throw new IllegalArgumentException();
		}
		this.letter = letter;
		this.value = value;
		this.modifier = modifier;
	}
	
	/**
	 * Creates an instance of <code>Letter</code> with the letter and
	 * value supplied by the client.
	 * @param letter
	 * @param value
	 */
	public Letter(String letter, int value) {
		this(letter, value, null);
	}
	
	/**
	 * Creates an instance of <code>Letter</code> with only the letter
	 * supplied by the client.
	 * @param letter
	 */
	public Letter(String letter) {
		this(letter, 0, null);
	}

	/**
	 * Returns <code>Letter</code>'s letter value.
	 * @return letter
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * Returns <code>Letter</code>'s point value.
	 * @return point value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns <code>Letter</code>'s <code>Modifier</code>.
	 * @return point modifier.
	 */
	public ValueModifier getModifier() {
		return modifier;
	}
}
