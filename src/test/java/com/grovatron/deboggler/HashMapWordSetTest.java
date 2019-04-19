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

}
