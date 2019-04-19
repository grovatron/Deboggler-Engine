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
	 * Attempt to pass InputStream that contains lines with more than one word per line,
	 * should throw exception.
	 */
	@Test
	void testBuildDictionary3() {
		String testFile = "One\nTwo\nThree Four\nFive\nSix";
		InputStream inputStream = new ByteArrayInputStream(testFile.getBytes(Charset.forName("UTF-8")));
		assertThrows(IllegalArgumentException.class, () -> dictionaryConstructor.buildDictionary(inputStream),
				"InputStream must have only one word per line, should throw IllegalArgumentException");
	}
	
	/**
	 * Attempt to pass InputStream that contains only blank lines, should throw exception.
	 */
	@Test
	void testBuildDictionary4() {
		String testFile = "\n\n\n\n\n";
		InputStream inputStream = new ByteArrayInputStream(testFile.getBytes(Charset.forName("UTF-8")));
		assertThrows(IllegalArgumentException.class, () -> dictionaryConstructor.buildDictionary(inputStream),
				"InputStream must have only one word per line, should throw IllegalArgumentException");
	}
	
	/**
	 * Pass InputStream that contains one word on each line, should return TrieDictionary.
	 */
	@Test
	void testBuildDictionary5() {
		String testFile = "apple\ncat\nexplosive\ntrendy\nlively";
		InputStream inputStream = new ByteArrayInputStream(testFile.getBytes(Charset.forName("UTF-8")));
		try {
			Dictionary dictionary = dictionaryConstructor.buildDictionary(inputStream);
			assertNotEquals(null, dictionary, "Should return a TrieDictionary");
		} catch (Exception ex) {
			fail();
		}
	}
	
	/**
	 * Pass InputStream that contains some blank lines, should return TrieDictionary.
	 */
	@Test
	void testBuildDictionary6() {
		String testFile = "apple\n\ncat\nexplosive\n\ntrendy\nlively";
		InputStream inputStream = new ByteArrayInputStream(testFile.getBytes(Charset.forName("UTF-8")));
		try {
			Dictionary dictionary = dictionaryConstructor.buildDictionary(inputStream);
			assertNotEquals(null, dictionary, "Should return a TrieDictionary");
		} catch (Exception ex) {
			fail();
		}
	}

}
