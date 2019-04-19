package com.grovatron.deboggler.dictionary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TrieNodeTest {

	TrieNode node;
	
	@BeforeEach
	void setup() {
		node = new TrieNode();
	}
	
	/**
	 * Attempt to pass lower case char as argument, should throw exception.
	 */
	@ParameterizedTest
	@ValueSource(chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'})
	void testAddChild1(char letter) {
		assertThrows(IllegalArgumentException.class, () -> node.addChild(letter), 
				"addChild does not take lower case char, should throw IllegalArgumentException.");
	}

}
