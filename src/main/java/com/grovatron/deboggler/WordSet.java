package com.grovatron.deboggler;

/**
 * Responsible for collecting <code>Word</code> objects found during the
 * search process of <code>Deboggler</code>'s <code>getWordList</code>
 * method, and returning a <code>List<Word></code> at the end of the method.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/19/2019
 *
 */
public interface WordSet {

	/**
	 * Add a <code>Word</code> to the set of unique, found words.
	 * @param word <code>Word</code> object to be added.
	 * @return Boolean value representing whether the <code>Word</code> was
	 * successfully added.
	 */
	boolean addWord(Word word);
}
