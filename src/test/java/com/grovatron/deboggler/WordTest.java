package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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
	
	/**
	 * Attempt to construct Word with location list whose length does not match word length, should throw
	 * exception.
	 */
	@ParameterizedTest
	@MethodSource("intListProvider")
	void testConstructor6(List<Integer> locationList) {
		String word = "APE";
		int value = 0;
		List<Integer> location = locationList;
		List<ValueModifier> modifiers = List.of();
		assertThrows(IllegalArgumentException.class, () -> new Word(word, value, location, modifiers),
				"Word does not take location list whose length does not match word length, should throw IllegalArgumentException");
	}
	
	static Stream<List<Integer>> intListProvider() {
		return Stream.of(
				Arrays.asList(1,2),
				Arrays.asList(1, 2, 3, 6)
		);
	}
	
	/**
	 * Attempt to construct Word with location list that has repeat locations, should throw exception.
	 */
	@Test
	void testConstructor7() {
		String word = "APE";
		int value = 0;
		List<Integer> location = List.of(1, 1, 2);
		List<ValueModifier> modifiers = List.of();
		assertThrows(IllegalArgumentException.class, () -> new Word(word, value, location, modifiers),
				"Word does not take location list with repeat locations, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to construct Word with location list that contains null value, should throw exception.
	 */
	@Test
	void testConstructor8() {
		String word = "APE";
		int value = 0;
		List<Integer> location = List.of(1, 2, null);
		List<ValueModifier> modifiers = List.of();
		assertThrows(IllegalArgumentException.class, () -> new Word(word, value, location, modifiers),
				"Word does not take location list with repeat locations, should throw IllegalArgumentException");
	}

}
