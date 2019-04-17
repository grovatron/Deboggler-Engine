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
	
	/**
	 * Attempt to construct Letter with empty String, should throw exception.
	 */
	@Test
	void testConstructor2() {
		assertThrows(IllegalArgumentException.class, () -> new Letter(""),
				"Letter does not take empty Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct letter with space character String, should throw exception.
	 */
	@Test
	void testConstructor3() {
		assertThrows(IllegalArgumentException.class, () -> new Letter(" "),
				"Letter does not take space character Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct letter with tab character String, should throw exception.
	 */
	@Test
	void testConstructor4() {
		assertThrows(IllegalArgumentException.class, () -> new Letter("\t"),
				"Letter does not take tab character Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct letter with new-line character String, should throw exception.
	 */
	@Test
	void testConstructor5() {
		assertThrows(IllegalArgumentException.class, () -> new Letter("\n"),
				"Letter does not take new-line character Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct letter with carriage return character String, should throw exception.
	 */
	@Test
	void testConstructor6() {
		assertThrows(IllegalArgumentException.class, () -> new Letter("\r"),
				"Letter does not take carriage return character Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct letter with digits, should throw exception.
	 */
	@Test
	void testConstructor7() {
		assertThrows(IllegalArgumentException.class, () -> new Letter("8"),
				"Letter does not take digit Strings, should throw IllegalArgumentException");
	}

}
