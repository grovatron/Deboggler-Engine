package com.grovatron.deboggler.dictionary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrieDictionaryTest {

	/**
	 * Attempt to pass null TrieNode to constructor, should throw exception.
	 */
	@Test
	void testConstructor() {
		assertThrows(IllegalArgumentException.class, () -> new TrieDictionary(null),
				"Constructor does not take null TrieNode, should throw IllegalArgumentException.");
	}

}
