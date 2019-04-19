package com.grovatron.deboggler.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		int count = 0;
		String line = null;
		while ((line = reader.readLine()) != null) {
			count++;
		}
		if (count == 0) {
			throw new IllegalArgumentException("InputStream must contain at least one word.");
		}
		
		return null;
	}

}
