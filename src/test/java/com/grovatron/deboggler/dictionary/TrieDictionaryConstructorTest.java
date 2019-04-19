package com.grovatron.deboggler.dictionary;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrieDictionaryConstructorTest {
	
	DictionaryConstructor dictionaryConstructor;
	
	@BeforeEach
	void setup() {
		dictionaryConstructor = new TrieDictionaryConstructor();
	}

	/**
	 * Attempt to pass null InputStream to buildDictionary, should throw exception.
	 */
	@Test
	void testBuildDictionary1() {
		assertThrows(IllegalArgumentException.class, () -> dictionaryConstructor.buildDictionary(null),
				"buildDictionary does not take null InputStream, should throw IllegalArgumentException.");
	}
	
	/**
	 * Attempt to pass InputStream that contains no words to buildDictionary, should throw exception.
	 */
	@Test
	void testBuildDictionary2() {
		InputStream inputStream = this.getClass().getResourceAsStream("/empty-file.txt");
		assertThrows(IllegalArgumentException.class, () -> dictionaryConstructor.buildDictionary(inputStream),
				"InputStream must contain at least one word, should throw IllegalArgumentException");
	}

}
