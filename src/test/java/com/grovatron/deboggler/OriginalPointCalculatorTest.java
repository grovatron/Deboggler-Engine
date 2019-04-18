package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
	
	/**
	 * Attempt to pass empty List<Letter> to calculatePoints method, should
	 * throw exception.
	 */
	@Test
	void testCalculatePoints2() {
		assertThrows(IllegalArgumentException.class, () -> wordPointCalculator.calculatePoints(List.of()),
				"calculatePoints does not take empty List<Letter>, should throw IllegalArgumentException.");
	}
	
	/**
	 * Attempt to pass List<Letter> that contains null value to calculatePoints method,
	 * should throw exception.
	 */
	@Test
	void testCalculatePoints3() {
		List<Letter> letters = new ArrayList<Letter>();
		letters.add(new Letter("A"));
		letters.add(new Letter("P"));
		letters.add(null);
		assertThrows(IllegalArgumentException.class, () -> wordPointCalculator.calculatePoints(letters),
				"calculatePoints does not List<Letter> that contains null value, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass three and four letter word to calculatePoints, should return 1.
	 * @param letterList
	 */
	@ParameterizedTest
	@MethodSource("fourOrLess")
	void testCalculatePoints4(List<Letter> letterList) {
		int expected = 1;
		int actual = wordPointCalculator.calculatePoints(letterList);
		assertEquals(expected, actual, "Should return 1");
	}
	
	static Stream<List<Letter>> fourOrLess() {
		return Stream.of(
				Arrays.asList(new Letter("S"), new Letter("T"), new Letter("A"), new Letter("R")),
				Arrays.asList(new Letter("R"), new Letter("A"), new Letter("T")));
	}
	
	

}
