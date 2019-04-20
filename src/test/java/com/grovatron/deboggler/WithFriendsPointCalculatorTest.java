package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WithFriendsPointCalculatorTest {
	
	WordPointCalculator calculator;
	
	@BeforeEach
	void setup() {
		calculator = new WithFriendsPointCalculator();
	}

	/**
	 * Pass null List<Letter> to calculatePoints, should throw exception.
	 */
	@Test
	void testCalculatePoints1() {
		assertThrows(IllegalArgumentException.class, () -> calculator.calculatePoints(null),
				"calculatePoints does not take null List<Letter>, should throw IllegalArgumentException.");
	}

}
