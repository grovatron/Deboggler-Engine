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
	
	/**
	 * Call getWords on HashMapWordSet that has all unique words added to it, expect List<Word>
	 * contains all added words.
	 */
	@Test
	void testGetWords2() {
		String wordString1 = "APE";
		int value1 = 1;
		List<Integer> location1 = Arrays.asList(1, 2, 3);
		List<ValueModifier> modifiers1 = Arrays.asList();
		Word word1 = new Word(wordString1, value1, location1, modifiers1);
		
		String wordString2 = "TULIP";
		int value2 = 3;
		List<Integer> location2 = Arrays.asList(12, 13, 14, 15, 11);
		List<ValueModifier> modifiers2 = Arrays.asList();
		Word word2 = new Word(wordString2, value2, location2, modifiers2);
		
		String wordString3 = "QUESTION";
		int value3 = 11;
		List<Integer> location3 = Arrays.asList(0, 4, 5, 6, 3, 7, 9);
		List<ValueModifier> modifiers3 = Arrays.asList();
		Word word3 = new Word(wordString3, value3, location3, modifiers3);
		
		wordSet.addWord(word1);
		wordSet.addWord(word2);
		wordSet.addWord(word3);
		
		List<Word> wordList = wordSet.getWords();
		
		boolean containsWord1 = wordList.contains(word1);
		boolean containsWord2 = wordList.contains(word2);
		boolean containsWord3 = wordList.contains(word3);
		boolean isSize3 = wordList.size() == 3;
		
		assertTrue(containsWord1 && containsWord2 && containsWord3 && isSize3, "Should be true.");
	}
	
	/**
	 * Call getWords on HashMapWordSet that has non-unique words added to it, expect List<Word>
	 * contains only the words with higher values.
	 */
	@Test
	void testGetWords3() {
		String wordString1 = "APE";
		int value1 = 1;
		List<Integer> location1 = Arrays.asList(1, 2, 3);
		List<ValueModifier> modifiers1 = Arrays.asList();
		Word word1 = new Word(wordString1, value1, location1, modifiers1);
		
		String wordString2 = "APE";
		int value2 = 5;
		List<Integer> location2 = Arrays.asList(1, 2, 3);
		List<ValueModifier> modifiers2 = Arrays.asList();
		Word word2 = new Word(wordString2, value2, location2, modifiers2);
		
		String wordString3 = "TULIP";
		int value3 = 3;
		List<Integer> location3 = Arrays.asList(12, 13, 14, 15, 11);
		List<ValueModifier> modifiers3 = Arrays.asList();
		Word word3 = new Word(wordString3, value3, location3, modifiers3);
		
		String wordString4 = "TULIP";
		int value4 = 1;
		List<Integer> location4 = Arrays.asList(12, 13, 14, 15, 11);
		List<ValueModifier> modifiers4 = Arrays.asList();
		Word word4 = new Word(wordString4, value4, location4, modifiers4);
		
		String wordString5 = "QUESTION";
		int value5 = 11;
		List<Integer> location5 = Arrays.asList(0, 4, 5, 6, 3, 7, 9);
		List<ValueModifier> modifiers5 = Arrays.asList();
		Word word5 = new Word(wordString5, value5, location5, modifiers5);
		
		String wordString6 = "QUESTION";
		int value6 = 12;
		List<Integer> location6 = Arrays.asList(0, 4, 5, 6, 3, 7, 9);
		List<ValueModifier> modifiers6 = Arrays.asList();
		Word word6 = new Word(wordString6, value6, location6, modifiers6);
		
		wordSet.addWord(word1);
		wordSet.addWord(word2);
		wordSet.addWord(word3);
		wordSet.addWord(word4);
		wordSet.addWord(word5);
		wordSet.addWord(word6);
		
		List<Word> wordList = wordSet.getWords();
		
		boolean containsWord1 = wordList.contains(word2);
		boolean containsWord2 = wordList.contains(word3);
		boolean containsWord3 = wordList.contains(word6);
		boolean isSize3 = wordList.size() == 3;
		
		assertTrue(containsWord1 && containsWord2 && containsWord3 && isSize3, "Should be true.");
	}

}
