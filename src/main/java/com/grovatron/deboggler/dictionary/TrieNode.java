package com.grovatron.deboggler.dictionary;

/**
 * Represents a node in the trie of the <code>TrieDictionary</code> class.
 * Each TrieNode has an array of 26 <code>TrieNode</code> children
 * (one for each letter of the alphabet) and a boolean value that signifies
 * whether the letter it represents ends a word.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/19/2019
 *
 */
public class TrieNode {

	protected final TrieNode[] children;
	protected boolean endsWord;
	
	/**
	 * Constructs an instance of <code>TrieNode</code>.
	 */
	public TrieNode() {
		this.children = new TrieNode[26];
		this.endsWord = false;
	}
	
	/**
	 * Adds a <code>TrieNode</code> child in <code>children</code> at
	 * the index corresponding to <code>letter</code>
	 * @param letter <code>char</code> value that corresponds to an index
	 * in <code>children</code>
	 */
	public void addChild(char letter) {
		if (Character.isLowerCase(letter)) {
			throw new IllegalArgumentException(letter + " is invalid argument, addChild does not take lower case char argument.");
		}
		if (Character.isDigit(letter)) {
			throw new IllegalArgumentException(letter + " is invalid argument, addChild does not take digit char argument.");
		}
		if (!Character.isLetterOrDigit(letter)) {
			throw new IllegalArgumentException(letter + " is invalid argument, addChild does not take symbol or whitespace"
					+ " char argument.");
		}
		
	}
}
