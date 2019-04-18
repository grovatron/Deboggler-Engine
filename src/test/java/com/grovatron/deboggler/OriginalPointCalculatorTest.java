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
	
	/**
	 * Pass five letter word to calculatePoints, should return 2.
	 */
	@Test
	void testCalculatePoints5() {
		List<Letter> letters = Arrays.asList(new Letter("H"), new Letter("A"), new Letter("N"), new Letter("D"),
				new Letter("S"));
		int expected = 2;
		int actual = wordPointCalculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 2");
	}
	
	/**
	 * Pass six letter word to calculatePoints, should return 3.
	 */
	@Test
	void testCalculatePoints6() {
		List<Letter> letters = Arrays.asList(new Letter("H"), new Letter("A"), new Letter("N"), new Letter("D"),
				new Letter("S"), new Letter("Y"));
		int expected = 3;
		int actual = wordPointCalculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 3");
	}
	
	/**
	 * Pass seven letter word to calculatePoints, should return 4.
	 */
	@Test
	void testCalculatePoints7() {
		List<Letter> letters = Arrays.asList(new Letter("S"), new Letter("W"), new Letter("A"), new Letter("L"),
				new Letter("L"), new Letter("O"), new Letter("W"));
		int expected = 4;
		int actual = wordPointCalculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 4");
	}
	
	/**
	 * Pass eight letter word to calculatePoints, should return 11.
	 */
	@Test
	void testCalculatePoints8() {
		List<Letter> letters = Arrays.asList(new Letter("S"), new Letter("W"), new Letter("A"), new Letter("L"),
				new Letter("L"), new Letter("O"), new Letter("W"), new Letter("S"));
		int expected = 11;
		int actual = wordPointCalculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 11");
	}
	
	/**
	 * Pass five letter word, including "QU", to calculatePoints, should return 2.
	 */
	@Test
	void testCalculatePoints9() {
		List<Letter> letters = Arrays.asList(new Letter("QU"), new Letter("E"), new Letter("S"), new Letter("T"));
		int expected = 2;
		int actual = wordPointCalculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 2");
	}
	
	/**
	 * Pass eight letter word, including "QU" to calculatePoints, should return 11.
	 */
	@Test
	void testCalculatePoints10() {
		List<Letter> letters = Arrays.asList(new Letter("QU"), new Letter("E"), new Letter("S"), new Letter("T"),
				new Letter("I"), new Letter("N"), new Letter("G"));
		int expected = 11;
		int actual = wordPointCalculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 11");
	}

}
