package com.grovatron.deboggler;

/**
 * Modifies the value of a <code>Letter</code> or <code>Word</code>'s point value.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com
 * @version 0.0.1 04/15/2019
 *
 */
public class ValueModifier {
	
	private final Modifier modifier;
	private final int multiplier;
	
	/**
	 * Creates a <code>ValueModifier</code> instance.
	 * @param modifier Enum that signals whether to modify <code>Letter</code>
	 * or <code>Word</code> value.
	 * @param mutliplier An integer amount to multiply the value by.
	 */
	public ValueModifier(Modifier modifier, int multiplier) {
		this.modifier = modifier;
		this.multiplier = multiplier;
	}

	/**
	 * Get the type of modifier.
	 * @return Modifier type.
	 */
	public Modifier getModifier() {
		return modifier;
	}

	/**
	 * Get the multiplier amount.
	 * @return Multiplier amount.
	 */
	public int getMultiplier() {
		return multiplier;
	}

}
