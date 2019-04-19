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
	
	/**
	 * Attempt to pass digit char as argument, should throw exception.
	 */
	@ParameterizedTest
	@ValueSource(chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'})
	void testAddChild2(char digit) {
		assertThrows(IllegalArgumentException.class, () -> node.addChild(digit), 
				"addChild does not take digit char, should throw IllegalArgumentException.");
	}
	
	/**
	 * Attempt to pass symbol char as argument, should throw exception.
	 */
	@ParameterizedTest
	@ValueSource(chars = {'~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '*', '(', ')', '_',
			'-', '+', '=', '{', '}', '[', ']', '|', '\\', ':', ';', '"', '\'', '<', ',', '>', '.', '?', '/'})
	void testAddChild3(char symbol) {
		assertThrows(IllegalArgumentException.class, () -> node.addChild(symbol), 
				"addChild does not take digit char, should throw IllegalArgumentException.");
	}
	
	/**
	 * Attempt to pass whitespace char as argument, should throw exception.
	 */
	@ParameterizedTest
	@ValueSource(chars = {' ', '\t', '\n', '\r'})
	void testAddChild4(char whitespace) {
		assertThrows(IllegalArgumentException.class, () -> node.addChild(whitespace), 
				"addChild does not take whitespace char, should throw IllegalArgumentException.");
	}
	
	/**
	 * Pass one upper case char as argument, should return true;
	 */
	@ParameterizedTest
	@ValueSource(chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'})
	void testAddChild5(char letter) {
		boolean expected = true;
		boolean actual = node.addChild(letter);
		assertEquals(expected, actual);
	}
	
	/**
	 * Add two (identical) uppercase char, second addChild call should return false.
	 */
	@ParameterizedTest
	@ValueSource(chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'})
	void testAddChild6(char letter) {
		node.addChild(letter);
		boolean expected = false;
		boolean actual = node.addChild(letter);
		assertEquals(expected, actual);
	}
	
	/**
	 * Add every single upper case letter, should pass.
	 */
	@Test
	void testAddChild7() {
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		try {
			for (char letter : letters) {
				if (!node.addChild(letter)) {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			fail("Should return true");
		}
	}
	

}
