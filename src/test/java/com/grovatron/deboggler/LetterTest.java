package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	@ParameterizedTest
	@ValueSource(strings = {"\t", "\n", "\r", " "})
	void testConstructor3(String whitespace) {
		assertThrows(IllegalArgumentException.class, () -> new Letter(whitespace),
				"Letter does not take space character Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct letter with digits, should throw exception.
	 */
	@ParameterizedTest
	@ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
	void testConstructor4(String digit) {
		assertThrows(IllegalArgumentException.class, () -> new Letter(digit),
				"Letter does not take digit Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct letter with non-alphanumeric String, should throw exception.
	 */
	@ParameterizedTest
	@ValueSource(strings = {".", ",", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "{", "}", "[", "]", "-",
			"_", "=", "+", "|", "\\", ";", ":", "\"", "'", ">", "<", "?", "/"})
	void testConstructor5(String symbol) {
		assertThrows(IllegalArgumentException.class, () -> new Letter(symbol),
				"Letter does not take symbol Strings, should throw IllegalArgumentException");
	}

}
