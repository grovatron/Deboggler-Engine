package com.grovatron.deboggler.dictionary;

import java.io.InputStream;

/**
 * Responsible for reading in words from an <code>InputStream</code> and
 * constructing an object that implements the <code>Dictionary</code>
 * interface.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/19/2019
 *
 */
public interface DictionaryConstructor {

	/**
	 * Builds an object that implements the <code>Dictionary</code>
	 * interface.
	 * @param inputStream Stream of words (one per line)
	 * @return A fully constructed object that implements the <code>Dictionary</code> interface.
	 */
	Dictionary buildDictionary(InputStream inputStream);
}
