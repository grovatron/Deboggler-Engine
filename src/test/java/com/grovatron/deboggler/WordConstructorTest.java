package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
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
	 * Attempt to call constructWord with null List<Letter>, should throw exception.
	 */
	@Test
	void testConstructWord1() {
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		assertThrows(IllegalArgumentException.class, () -> wordConstructor.constructWord(null, List.of(1,2,3)),
				"constructWord does not take null List<Letter>, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to call constructWord with empty List<Letter>, should throw exception.
	 */
	@Test
	void testConstructWord2() {
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		assertThrows(IllegalArgumentException.class, () -> wordConstructor.constructWord(List.of(), List.of(1,2,3)),
				"constructWord does not take empty List<Letter>, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to call constructWord with a List<Letter> that contains null values,
	 * should throw exception.
	 */
	@Test
	void testConstructWord3() {
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		List<Letter> letters = Arrays.asList(new Letter("A"), new Letter("P"), null);
		assertThrows(IllegalArgumentException.class, () -> wordConstructor.constructWord(letters, List.of(1,2,3)),
				"constructWord does not take List<Letter> that contains null values,"
				+ " should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to call constructWord with null List<Integer>, should throw exception.
	 */
	@Test
	void testConstructWord4() {
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		List<Letter> letters = Arrays.asList(new Letter("A"), new Letter("P"), new Letter("E"));
		assertThrows(IllegalArgumentException.class, () -> wordConstructor.constructWord(letters, null),
				"constructWord does not take null List<Integer>, should throw IllegalArgumentException.");
	}
	
	/**
	 * Attempt to call constructWord with empty List<Integer>, should throw exception.
	 */
	@Test
	void testConstructWord5() {
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		List<Letter> letters = Arrays.asList(new Letter("A"), new Letter("P"), new Letter("E"));
		assertThrows(IllegalArgumentException.class, () -> wordConstructor.constructWord(letters, List.of()),
				"constructWord does not take empty List<Integer>, should throw IllegalArgumentException.");
	}
	
	/**
	 * Attempt to call constructWord with List<Integer> that contains null value, should throw exception.
	 */
	@Test
	void testConstructWord6() {
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		List<Letter> letters = Arrays.asList(new Letter("A"), new Letter("P"), new Letter("E"));
		List<Integer> location = Arrays.asList(1, 2, null);
		assertThrows(IllegalArgumentException.class, () -> wordConstructor.constructWord(letters, location),
				"constructWord does not take List<Integer> that contains null values, "
				+ "should throw IllegalArgumentException.");
	}
	
	/**
	 * Attempt to call constructWord with List<Letter> that is shorter than List<Integer>,
	 * should throw exception.
	 */
	@Test
	void testConstructWord7() {
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		List<Letter> letters = Arrays.asList(new Letter("A"), new Letter("P"), new Letter("E"));
		List<Integer> location = Arrays.asList(1, 2, 3, 6);
		assertThrows(IllegalArgumentException.class, () -> wordConstructor.constructWord(letters, location),
				"constructWord does not take List<Letter> that is shorter than List<Integer>, "
				+ "should throw IllegalArgumentException.");
	}

}
