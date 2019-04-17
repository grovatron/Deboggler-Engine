package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LetterTest {

	/**
	 * Attempt to construct Letter with null String, should throw exception.
	 */
	@Test
	void testConstructor1() {
		assertThrows(IllegalArgumentException.class, () -> new Letter(null),
				"Letter does not take null Strings, should throw IllegalArgumentException.");
	}

}
