package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grovatron.deboggler.dictionary.Dictionary;
import com.grovatron.deboggler.dictionary.TrieDictionaryConstructor;

class DebogglerTest {
	
	static String testFile = "star\narts\nrats\ntars\nart\ntar\nrat";

	Dictionary dictionary;
	WordConstructor wordConstructor;
	WordSet wordSet;
	int minLength;
	
	@BeforeEach
	void setup() throws IOException {
		InputStream inputStream = new ByteArrayInputStream(testFile.getBytes(Charset.forName("UTF-8")));
		dictionary = new TrieDictionaryConstructor().buildDictionary(inputStream);
		wordConstructor = new WordConstructor(new OriginalPointCalculator());
		wordSet = new HashMapWordSet();
		minLength = 3;
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

}
