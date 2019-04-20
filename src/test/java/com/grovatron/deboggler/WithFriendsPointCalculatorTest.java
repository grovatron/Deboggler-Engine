package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

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
	
	/**
	 * Pass empty List<Letter> to calculatePoints, should throw exception.
	 */
	@Test
	void testCalculatePoints2() {
		assertThrows(IllegalArgumentException.class, () -> calculator.calculatePoints(Arrays.asList()),
				"calculatePoints does not take empty List<Letter>, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass List<Letter> that contains null values to calculatePoints, should throw exception.
	 */
	@Test
	void testCalculatePoints3() {
		List<Letter> letters = Arrays.asList(new Letter("A"), null, new Letter("P"));
		assertThrows(IllegalArgumentException.class, () -> calculator.calculatePoints(letters),
				"calculatePoints does not take List<Letter> that contains null values, "
				+ "should throw IllegalArgumentException.");
	}

}
