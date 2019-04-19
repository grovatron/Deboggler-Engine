package com.grovatron.deboggler.dictionary;

import java.io.IOException;
import java.io.InputStream;

/**
 * Responsible for constructing a <code>TrieDictionary</code> from an
 * <code>InputStream</code> of words.
 * 
 * @author Grover Sundstrom
 * @version 0.0.1 04/19/2019
 *
 */
public class TrieDictionaryConstructor implements DictionaryConstructor {

	@Override
	public Dictionary buildDictionary(InputStream inputStream) throws IOException {
		if (inputStream == null) {
			throw new IllegalArgumentException("buildDictionary does not take null InputStream.");
		}
		// TODO Auto-generated method stub
		return null;
	}

}
