package com.grovatron.deboggler.dictionary;

/**
 * Responsible for validating prefixes and words found in the search process
 * of <code>Deboggler</code>'s <code>getWordList</code> method.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/19/2019
 *
 */
public class TrieDictionary implements Dictionary {

	private final TrieNode root;
	
	/**
	 * Contstructs an instance of <code>TrieDictionary</code>.
	 * @param root Root <code>TrieNode</code> of the <code>TrieDictionary</code>.
	 */
	public TrieDictionary(TrieNode root) {
		if (root == null) {
			throw new IllegalArgumentException("Constructor does not take null TrieNode.");
		}
		this.root = root;
	}
	
	@Override
	public boolean isValidPrefix(String prefix) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean isValidWord(String word) {
		// TODO Auto-generated method stub
		return false;
	}

}
