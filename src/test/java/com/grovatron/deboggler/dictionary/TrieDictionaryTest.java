package com.grovatron.deboggler.dictionary;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TrieDictionaryTest {
	
	static String testFile = "apple\nbanana\ncactus\ndaffodil";
	Dictionary dictionary;
	
	@BeforeEach
	void setup() throws IOException {
		DictionaryConstructor dictionaryConstructor = new TrieDictionaryConstructor();
		InputStream inputStream = new ByteArrayInputStream(testFile.getBytes(Charset.forName("UTF-8")));
		dictionary = dictionaryConstructor.buildDictionary(inputStream);		
	}

	/**
	 * Attempt to pass null TrieNode to constructor, should throw exception.
	 */
	@Test
	void testConstructor() {
		assertThrows(IllegalArgumentException.class, () -> new TrieDictionary(null),
				"Constructor does not take null TrieNode, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass valid prefix, should return true
	 */
	@ParameterizedTest
	@MethodSource("getPrefixes")
	void testIsValidPrefix1(String validPrefix) {
		boolean expected = true;
		boolean actual = dictionary.isValidPrefix(validPrefix);
		assertEquals(expected, actual, "Should return true");
	}
	
	static Stream<String> getPrefixes() {
		String[] words = testFile.split("\n");
		List<String> prefixes = new ArrayList<>();
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				prefixes.add(word.substring(0, i + 1).toUpperCase());
			}
		}
		return prefixes.stream();
	}
	
	/**
	 * Pass invalid prefix, should return false.
	 */
	@Test
	void testIsValidPrefix2() {
		boolean expected = false;
		boolean actual = dictionary.isValidPrefix("SANDWICH");
		assertEquals(expected, actual, "Should return false");
	}
	
	/**
	 * Pass null String to isValidPrefix, should throw exception
	 */
	@Test
	void testIsValidPrefix3() {
		assertThrows(IllegalArgumentException.class, () -> dictionary.isValidPrefix(null),
				"isValidPrefix does not take null String, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass empty String to isValidPrefix, should throw exception
	 */
	@Test
	void testIsValidPrefix4() {
		assertThrows(IllegalArgumentException.class, () -> dictionary.isValidPrefix(""),
				"isValidPrefix does not take empty String, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass String that contains lower case characters to isValidPrefix, should throw exception
	 */
	@Test
	void testIsValidPrefix5() {
		assertThrows(IllegalArgumentException.class, () -> dictionary.isValidPrefix("Apple"),
				"isValidPrefix does not take String that contains lower case characters, "
				+ "should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass valid word, should return true
	 */
	@ParameterizedTest
	@MethodSource("getWords")
	void testIsValidWord1(String validWord) {
		boolean expected = true;
		boolean actual = dictionary.isValidWord(validWord);
		assertEquals(expected, actual, "Should return true");
	}
	
	static Stream<String> getWords() {
		List<String> wordList = new ArrayList<>();
		for (String word : testFile.split("\n")) {
			wordList.add(word.toUpperCase());
		}
		return wordList.stream();
	}
	
	/**
	 * Pass invalid word, should return false.
	 */
	@ParameterizedTest
	@MethodSource("getInvalidWords")
	void testIsValidWord2(String invalidWord) {
		boolean expected = false;
		boolean actual = dictionary.isValidWord(invalidWord);
		assertEquals(expected, actual, "Should return false.");
	}
	
	static Stream<String> getInvalidWords() {
		String[] words = testFile.split("\n");
		List<String> prefixes = new ArrayList<>();
		for (String word : words) {
			for (int i = 0; i < word.length() - 1; i++) {
				prefixes.add(word.substring(0, i + 1).toUpperCase());
			}
		}
		return prefixes.stream();
	}


}
