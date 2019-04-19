package com.grovatron.deboggler.dictionary;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

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
		InputStream inputStream = new ByteArrayInputStream(new String("").getBytes(Charset.forName("UTF-8")));
		assertThrows(IllegalArgumentException.class, () -> dictionaryConstructor.buildDictionary(inputStream),
				"InputStream must contain at least one word, should throw IllegalArgumentException");
	}
	
	/**
	 * 
	 */

}
