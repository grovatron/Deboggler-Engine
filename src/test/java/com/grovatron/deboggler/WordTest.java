package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class WordTest {

	/**
	 * Attempt to construct Word will null String, should throw exception.
	 */
	@Test
	void testConstructor1() {
		String word = null;
		int value = 0;
		List<Integer> location = List.of(1,2,3);
		List<ValueModifier> modifiers = List.of();
		assertThrows(IllegalArgumentException.class, () -> new Word(word, value, location, modifiers),
				"Word does not take null Strings, should throw IllegalArgumentException");
	}

}
