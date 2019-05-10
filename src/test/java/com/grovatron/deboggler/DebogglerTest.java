package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grovatron.deboggler.dictionary.Dictionary;
import com.grovatron.deboggler.dictionary.TrieDictionaryConstructor;

class DebogglerTest {
	
	static String testFile = "star\narts\nrats\ntars\nart\ntar\nrat\nquit\nquits\nquote\ntoque";

	Dictionary dictionary;
	WordConstructor wordConstructor;
	WordSet wordSet;
	int minLength;
	Deboggler deboggler;
	
	@BeforeEach
	void setup() throws IOException {
		InputStream inputStream = new ByteArrayInputStream(testFile.getBytes(Charset.forName("UTF-8")));
		dictionary = new TrieDictionaryConstructor().buildDictionary(inputStream);
		wordConstructor = new WordConstructor(new OriginalPointCalculator());
		wordSet = new HashMapWordSet();
		minLength = 3;
		deboggler = new Deboggler(dictionary, wordConstructor, wordSet, minLength);
	}
	
	/**
	 * Pass null Dictionary to constructor, should throw exception.
	 */
	@Test
	void testConstructor1() {
		assertThrows(IllegalArgumentException.class, () -> new Deboggler(null, wordConstructor, wordSet, minLength),
				"Constructor does not take null Dictionary, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass null WordConstructor to constructor, should throw exception.
	 */
	@Test
	void testConstructor2() {
		assertThrows(IllegalArgumentException.class, () -> new Deboggler(dictionary, null, wordSet, minLength),
				"Constructor does not take null WordConstructor, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass null WordSet to constructor, should throw exception.
	 */
	@Test
	void testConstructor3() {
		assertThrows(IllegalArgumentException.class, () -> new Deboggler(dictionary, wordConstructor, null, minLength),
				"Constructor does not take null WordSet, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass minLength less than 1 to constructor, should throw exception.
	 */
	@Test
	void testConstructor4() {
		assertThrows(IllegalArgumentException.class, () -> new Deboggler(dictionary, wordConstructor, wordSet, 0),
				"Constructor does not take minLength < 1, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass null Letter[][] to getWordList, should throw exception.
	 */
	@Test
	void testGetWordList1() {
		assertThrows(IllegalArgumentException.class, () -> deboggler.getWordList(null),
				"getWordList does not take null Letter[][], should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass empty Letter[][] to getWordList, should throw exception.
	 */
	@Test 
	void testGetWordList2() {
		assertThrows(IllegalArgumentException.class, () -> deboggler.getWordList(new Letter[2][2]),
				"getWordList does not take empty Letter[][], should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass jagged Letter[][] to getWordList, should throw exception.
	 */
	@Test
	void testGetWordList3() {
		Letter[][] letterGrid = {new Letter[] {new Letter("S"), new Letter("T")}, new Letter[] {new Letter("A")}};
		assertThrows(IllegalArgumentException.class, () -> deboggler.getWordList(letterGrid),
				"getWordList does not take jagged Letter[][], should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass Letter[][] with less than 2 rows and columns to getWordList, should throw exception.
	 */
	@Test
	void testGetWordList4() {
		Letter[][] letterGrid = {new Letter[] {new Letter("S")}};
		assertThrows(IllegalArgumentException.class, () -> deboggler.getWordList(letterGrid),
				"getWordList does not take Letter[][] with less than 2 rows and columns, "
				+ "should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass valid Letter[][], should return list of all possible words
	 */
	@Test
	void testGetWordList5() {
		Letter[][] letterGrid = {new Letter[] {new Letter("S"), new Letter("T")}, new Letter[] {new Letter("A"), new Letter("R")}};
		Word word1 = new Word("STAR", 1, Arrays.asList(0,1,2,3), Arrays.asList());
		Word word2 = new Word("ARTS", 1, Arrays.asList(2,3,1,0), Arrays.asList());
		Word word3 = new Word("TARS", 1, Arrays.asList(1,2,3,0), Arrays.asList());
		Word word4 = new Word("RATS", 1, Arrays.asList(3,2,1,0), Arrays.asList());
		Word word5 = new Word("ART", 1, Arrays.asList(2,3,1), Arrays.asList());
		Word word6 = new Word("TAR", 1, Arrays.asList(1,2,3), Arrays.asList());
		Word word7 = new Word("RAT", 1, Arrays.asList(3,2,1), Arrays.asList());
		List<Word> wordList = deboggler.getWordList(letterGrid);
		boolean expected = true;
		boolean actual = wordList.contains(word1) && wordList.contains(word2) && wordList.contains(word3) && wordList.contains(word4)
				&& wordList.contains(word5) && wordList.contains(word6) && wordList.contains(word7);
		assertEquals(expected, actual, "List should contain all seven words");
	}
	
	/**
	 * Pass valid Letter[][], should return empty list.
	 */
	@Test
	void testGetWordList6() {
		Letter[][] letterGrid = {new Letter[] {new Letter("F"), new Letter("O")}, new Letter[] {new Letter("X"), new Letter("V")}};
		List<Word> expected = Arrays.asList();
		List<Word> actual = deboggler.getWordList(letterGrid);
		assertEquals(expected, actual, "List should be empty");
	}
	
	/**
	 * Pass the letters "Qu", "I", "T", "S", should return word list that contains "QUIT"
	 */
	@Test
	void testGetWordList7() {
		Letter[][] letterGrid = {new Letter[] {new Letter("QU"), new Letter("I")}, new Letter[] {new Letter("T"), new Letter("S")}};
		List<Word> wordList = deboggler.getWordList(letterGrid);
		boolean expected = true;
		boolean actual = false;
		for (Word word : wordList) {
			if (word.getWord().equals("QUIT")) {
				actual = true;
			}
		}
		assertEquals(expected, actual);
	}
	
	/**
	 * Pass the letters "QU", "O", "T", "E", should return word list that contains "QUOTE"
	 */
	@Test
	void testGetWordList8() {
		Letter[][] letterGrid = {new Letter[] {new Letter("QU"), new Letter("O")}, new Letter[] {new Letter("T"), new Letter("E")}};
		List<Word> wordList = deboggler.getWordList(letterGrid);
		boolean expected = true;
		boolean actual = false;
		for (Word word : wordList) {
			if (word.getWord().equals("QUOTE")) {
				actual = true;
			}
		}
		assertEquals(expected, actual);
	}
	
	/**
	 * Pass the letters "QU", "O", "T", "E", should return word list that contains "TOQUE"
	 */
	@Test
	void testGetWordList9() {
		Letter[][] letterGrid = {new Letter[] {new Letter("QU"), new Letter("O")}, new Letter[] {new Letter("T"), new Letter("E")}};
		List<Word> wordList = deboggler.getWordList(letterGrid);
		boolean expected = true;
		boolean actual = false;
		for (Word word : wordList) {
			if (word.getWord().equals("TOQUE")) {
				actual = true;
			}
		}
		assertEquals(expected, actual);
	}

}
