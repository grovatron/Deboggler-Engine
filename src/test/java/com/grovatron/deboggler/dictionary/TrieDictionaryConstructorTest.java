package com.grovatron.deboggler.dictionary;

import static org.junit.jupiter.api.Assertions.*;

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

}
