package com.grovatron.deboggler;

import java.util.List;

/**
 * Represents a word contstructed from the <code>Letter</code> objects of 2d matrix of <code>Letter</code>s.
 * Each <code>Word</code> has a String value, point value, location in the 2d matrix of <code>Letter</code>
 * objects, and a list of <code>ValueModifer</code> objects that were applied when calculating the point value.
 * 
 * @author Grover Sundstrom	(grover.a.sundstrom@gmail.com)
 * @version 0.0.1 (04/18/2019)
 *
 */
public class Word {

	private final String word;
	private final int value;
	private final List<Integer> location;
	private final List<ValueModifier> modifiers;
	
	/**
	 * Constructs a <code>Word</code> object.
	 * @param word String value representing the <code>Word</code>.
	 * @param value int value representing the point value of the <code>Word</code>.
	 * @param location Integer list representing the location of each <code>Letter</code> that makes up the
	 * <code>Word</code> (in order).
	 * @param modifiers <code>ValueModifier</code> list of all the modifiers that were applied while
	 * calculating the point value.
	 */
	public Word(String word, int value, List<Integer> location, List<ValueModifier> modifiers) {
		if (word == null || word.isBlank()) {
			throw new IllegalArgumentException();
		}
		this.word = word;
		this.value = value;
		this.location = location;
		this.modifiers = modifiers;
	}

	/**
	 * Returns the String value that represents the <code>Word</code> object.
	 * @return String value.
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Returns the point value of the <code>Word</code>
	 * @return Point value.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns a list of integers representing the location of the <code>Letter</code> objects
	 * in the 2d matrix of <code>Letter</code>s that were used to construct the <code>Word</code>
	 * @return Location list.
	 */
	public List<Integer> getLocation() {
		return location;
	}

	/**
	 * Returns a list of <code>ValueModifier</code> objects that were applied when calculating
	 * the point value of the <code>Word</code>.
	 * @return <code>ValueModifier</code> list.
	 */
	public List<ValueModifier> getModifiers() {
		return modifiers;
	}
	
}
