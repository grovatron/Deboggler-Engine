package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WordTest {

	/**
	 * Attempt to construct Word with null String, should throw exception.
	 */
	@Test
	void testConstructor1() {
		String word = null;
		int value = 0;
		List<Integer> location = List.of(1,2,3);
		List<ValueModifier> modifiers = List.of();
		assertThrows(IllegalArgumentException.class, () -> new Word(word, value, location, modifiers),
				"Word does not take null Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct Word with empty String, should throw exception.
	 */
	@Test
	void testConstructor2() {
		String word = "";
		int value = 0;
		List<Integer> location = List.of(1,2,3);
		List<ValueModifier> modifiers = List.of();
		assertThrows(IllegalArgumentException.class, () -> new Word(word, value, location, modifiers),
				"Word does not take empty Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct Word with whitespace String, should throw exception.
	 */
	@ParameterizedTest
	@ValueSource(strings = {" ", "\t", "\n", "\r"})
	void testConstructor3(String whitespace) {
		String word = whitespace;
		int value = 0;
		List<Integer> location = List.of(1,2,3);
		List<ValueModifier> modifiers = List.of();
		assertThrows(IllegalArgumentException.class, () -> new Word(word, value, location, modifiers),
				"Word does not take whitespace Strings, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct Word with null List<Integer>, should throw exception.
	 */
	@Test
	void testConstructor4() {
		String word = "APE";
		int value = 0;
		List<Integer> location = null;
		List<ValueModifier> modifiers = List.of();
		assertThrows(IllegalArgumentException.class, () -> new Word(word, value, location, modifiers),
				"Word does not take null location list, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct Word with empty List<Integer>, should throw exception.
	 */
	@Test
	void testConstructor5() {
		String word = "APE";
		int value = 0;
		List<Integer> location = List.of();
		List<ValueModifier> modifiers = List.of();
		assertThrows(IllegalArgumentException.class, () -> new Word(word, value, location, modifiers),
				"Word does not take empty location list, should throw IllegalArgumentException");
	}

}
