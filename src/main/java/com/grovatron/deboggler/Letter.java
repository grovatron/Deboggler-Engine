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
	 * @param letter A String representation of the <code>Letter</code>
	 * @param value  An int value representing the point value of the <code>Letter</code>
	 * @param modifier A <code>Modifier</code> object associated with the <code>Letter</code>
	 */
	public Letter(String letter, int value, ValueModifier modifier) {
		if (!LetterValidator.validateStringInput(letter)) {
			throw new IllegalArgumentException();
		}
		this.letter = letter;
		this.value = value;
		this.modifier = modifier;
	}
	
	/**
	 * Creates an instance of <code>Letter</code> with the letter and
	 * value supplied by the client.
	 * @param letter A String representation of the <code>Letter</code>
	 * @param value  An int value representing the point value of the <code>Letter</code>
	 */
	public Letter(String letter, int value) {
		this(letter, value, null);
	}
	
	/**
	 * Creates an instance of <code>Letter</code> with only the letter
	 * supplied by the client.
	 * @param letter A String representation of the <code>Letter</code>
	 */
	public Letter(String letter) {
		this(letter, 0, null);
	}

	/**
	 * Returns <code>Letter</code>'s letter value.
	 * @return letter A String representation of the <code>Letter</code>
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * Returns <code>Letter</code>'s point value.
	 * @return value The point value of the <code>Letter</code>
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns <code>Letter</code>'s <code>Modifier</code>.
	 * @return modifier The <code>Modifier</code> object associated with the <code>Letter</code> object
	 */
	public ValueModifier getModifier() {
		return modifier;
	}
}
