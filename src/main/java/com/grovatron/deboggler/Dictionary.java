package com.grovatron.deboggler;

/**
 * Responsible for validating prefixes and words found in the search process
 * of <code>Deboggler</code>'s <code>getWordList</code> method.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/15/2019
 *
 */

public interface Dictionary {

	/**
	 * Determines if a prefix is valid (e.g. is the beginning of a word that exists in the <code>Dictionary</code>)
	 * @param prefix The prefix to be validated.
	 * @return Boolean value representing whether the prefix is valid.
	 */
	boolean isValidPrefix(String prefix);
	
	/**
	 * Determines if a word is valid (e.g. exists in the <code>Dictionary</code>)
	 * @param word The word to be validated.
	 * @return Boolean value representing whether the word is valid.
	 */
	boolean isValidWord(String word);
}
