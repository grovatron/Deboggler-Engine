package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashMapWordSetTest {

	WordSet wordSet;
	
	@BeforeEach
	void setup() {
		wordSet = new HashMapWordSet();
	}
	
	/**
	 * Add word to HashMapWordSet, should return true.
	 */
	@Test
	void testAddWord1() {
		String wordString = "APE";
		int value = 1;
		List<Integer> location = Arrays.asList(1, 2, 3);
		List<ValueModifier> modifiers = Arrays.asList();
		Word word = new Word(wordString, value, location, modifiers);
		
		boolean expected = true;
		boolean actual = wordSet.addWord(word);
		assertEquals(expected, actual, "Should return true");
	}
	
	/**
	 * Add the same word (same String and int value) twice to HashMapWordSet, should return false.
	 */
	@Test
	void testAddWord2() {
		String wordString = "APE";
		int value = 1;
		List<Integer> location = Arrays.asList(1, 2, 3);
		List<ValueModifier> modifiers = Arrays.asList();
		Word word = new Word(wordString, value, location, modifiers);
		
		boolean expected = false;
		wordSet.addWord(word);
		boolean actual = wordSet.addWord(word);
		assertEquals(expected, actual, "Should return false");
	}
	
	/**
	 * Add two Word objects with same String value, but the second Word has a greater
	 * int value. Should return true.
	 */
	@Test
	void testAddWord3() {
		String wordString = "APE";
		int value1 = 1;
		int value2 = 2;
		List<Integer> location = Arrays.asList(1, 2, 3);
		List<ValueModifier> modifiers = Arrays.asList();
		Word word1 = new Word(wordString, value1, location, modifiers);
		Word word2 = new Word(wordString, value2, location, modifiers);
		
		boolean expected = true;
		wordSet.addWord(word1);
		boolean actual = wordSet.addWord(word2);
		assertEquals(expected, actual, "Should return true");
	}
	
	/**
	 * Add two Word objects with same String value, but the first Word has a greater
	 * int value. Should return false.
	 */
	@Test
	void testAddWord4() {
		String wordString = "APE";
		int value1 = 1;
		int value2 = 2;
		List<Integer> location = Arrays.asList(1, 2, 3);
		List<ValueModifier> modifiers = Arrays.asList();
		Word word1 = new Word(wordString, value1, location, modifiers);
		Word word2 = new Word(wordString, value2, location, modifiers);
		
		boolean expected = false;
		wordSet.addWord(word2);
		boolean actual = wordSet.addWord(word1);
		assertEquals(expected, actual, "Should return false");
	}
	
	/**
	 * Attempt to pass null Word to addWord method, should throw exception.
	 */
	@Test
	void testAddWord5() {
		assertThrows(IllegalArgumentException.class, () -> wordSet.addWord(null),
				"addWord does not take null Word argument, should throw IllegalArgumentException.");
	}
	
	/**
	 * Call getWords on an empty HashMapWordSet, should return an empty List<Word>.
	 */
	@Test
	void testGetWords1() {
		List<Word> expected = Arrays.asList();
		List<Word> actual = wordSet.getWords();
		assertEquals(expected, actual, "Should return an empty List<Word>");
	}

}
