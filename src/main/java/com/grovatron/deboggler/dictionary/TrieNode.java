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
}
