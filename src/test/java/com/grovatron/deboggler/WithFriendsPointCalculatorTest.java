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
	
	/**
	 * Pass "APE" with no modifiers to calculatePoints, should return 6.
	 */
	@Test
	void testCalculatePoints4() {
		List<Letter> letters = Arrays.asList(new Letter("A", 1), new Letter("P", 4), new Letter("E", 1));
		int expected = 6;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 6");
	}
	
	/**
	 * Pass "TAR" with no modifiers to calculatePoints, should return 3.
	 */
	@Test
	void testCalculatePoints5() {
		List<Letter> letters = Arrays.asList(new Letter("T", 1), new Letter("A", 1), new Letter("R", 1));
		int expected = 3;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 3");
	}
	
	/**
	 * Pass "VOLE" with no modifiers to calculatePoints, should return 9
	 */
	@Test
	void testCalculatePoints6() {
		List<Letter> letters = Arrays.asList(new Letter("V", 5), new Letter("O", 1), new Letter("L", 2), new Letter("E", 1));
		int expected = 9;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 9");
	}
	
	/**
	 * Pass "SMOTE" with no modifiers to calculatePoints, should return 8 + 3 (length bonus) = 11
	 */
	@Test
	void testCalculatePoints7() {
		List<Letter> letters = Arrays.asList(new Letter("S", 1), new Letter("M", 4), new Letter("O", 1),
				new Letter("T", 1), new Letter("E", 1));
		int expected = 11;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 11 (8 Letter points plus 3 for length of 5");
	}
	
	/**
	 * Pass "PASTAS" with no modifiers to calculatePoints, should return 9 + 6 (length bonus) = 15
	 */
	@Test
	void testCalculatePoints8() {
		List<Letter> letters = Arrays.asList(new Letter("P", 4), new Letter("A", 1), new Letter("S", 1),
				new Letter("T", 1), new Letter("A", 1), new Letter("S", 1));
		int expected = 15;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 15 (9 Letter points plus 6 for length of 6");
	}
	
	/**
	 * Pass "WINTERS" with no modifiers to calculatePoints, should return 11 + 10 (length bonus) = 21
	 */
	@Test
	void testCalculatePoints9() {
		List<Letter> letters = Arrays.asList(new Letter("W", 4), new Letter("I", 1), new Letter("N", 2),
				new Letter("T", 1), new Letter("E", 1), new Letter("R", 1), new Letter("S", 1));
		int expected = 21;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 21 (11 Letter points plus 10 for length of 7");
	}
	
	/**
	 * Pass "MINDLESS" with no modifiers to calculatePoints, should return 14 + 15 (length bonus) = 29.
	 */
	@Test
	void testCalculatePoints10() {
		List<Letter> letters = Arrays.asList(new Letter("M", 4), new Letter("I", 1), new Letter("N", 2),
				new Letter("D", 2), new Letter("L", 2), new Letter("E", 1), new Letter("S", 1), new Letter("S", 1));
		int expected = 29;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 29 (14 Letter points plus 15 for length of 8");
	}
	
	/**
	 * Pass "APE" with 2x letter modifier on "P" to calculatePoints, should return 10.
	 */
	@Test
	void testCalculatePoints11() {
		List<Letter> letters = Arrays.asList(new Letter("A", 1), new Letter("P", 4, new ValueModifier(Modifier.LETTER, 2)),
				new Letter("E", 1));
		int expected = 10;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 10, (2x letter score for \"P\")");
	}
	
	/**
	 * Pass "APE" with 3x letter modifier on all letters to calculatePoints, should return 18.
	 */
	@Test
	void testCalculatePoints12() {
		List<Letter> letters = Arrays.asList(
				new Letter("A", 1, new ValueModifier(Modifier.LETTER, 3)),
				new Letter("P", 4, new ValueModifier(Modifier.LETTER, 3)),
				new Letter("E", 1, new ValueModifier(Modifier.LETTER, 3)));
		int expected = 18;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 18, (3x letter score on all letters");
	}
	
	/**
	 * Pass "APE" with 2x word modifier on "P" to calculatePoints, should return 12.
	 */
	@Test
	void testCalculatePoints13() {
		List<Letter> letters = Arrays.asList(
				new Letter("A", 1),
				new Letter("P", 4, new ValueModifier(Modifier.WORD, 2)),
				new Letter("E", 1));
		int expected = 12;
		int actual = calculator.calculatePoints(letters);
		assertEquals(expected, actual, "Should return 12, (2x word modifier on \"P\"");
	}

}
