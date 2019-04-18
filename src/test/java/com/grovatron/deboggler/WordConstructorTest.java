package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
	
	/**
	 * Attempt to call constructWord with null List<Integer>, should throw exception.
	 */
	@Test
	void testConstructWord1() {
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		assertThrows(IllegalArgumentException.class, () -> wordConstructor.constructWord(null, List.of(1,2,3)),
				"constructWord does not take null List<Integer>, should throw IllegalArgumentException");
	}

}
