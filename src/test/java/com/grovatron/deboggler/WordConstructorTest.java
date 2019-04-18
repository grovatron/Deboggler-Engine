package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordConstructorTest {

	/**
	 * Attempt to construct WordConstructorTest with null WordPointCalculator,
	 * should throw exception.
	 */
	@Test
	void testConstructor1() {
		assertThrows(IllegalArgumentException.class, () -> new WordConstructor(null),
				"WordConstructor does not take null WordPointCalculator, should throw"
				+ " IllegalArgumentException.");
	}

}
