package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OriginalPointCalculatorTest {
	
	WordPointCalculator wordPointCalculator;
	
	@BeforeEach
	void setup() {
		wordPointCalculator = new OriginalPointCalculator();
	}

	/**
	 * Attempt to pass null List<Letter> to calculatePoints method, should
	 * throw exception.
	 */
	@Test
	void testCalculatePoints1() {
		assertThrows(IllegalArgumentException.class, () -> wordPointCalculator.calculatePoints(null),
				"calculatePoints does not take null List<Letter>, should throw IllegalArgumentException.");
	}

}
