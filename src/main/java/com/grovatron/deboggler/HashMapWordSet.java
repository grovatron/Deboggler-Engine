package com.grovatron.deboggler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Responsible for storing <code>Word</code> objects found while searching
 * <code>Letter</code> grid and returning <code>Word</code> list when search is
 * complete.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/18/2019
 *
 */
public class HashMapWordSet implements WordSet {
	
	private final Map<String, Word> wordMap;
	
	/**
	 * Creates an instance of HashMapWordSet.
	 */
	public HashMapWordSet() {
		wordMap = new HashMap<>();
	}

	/**
	 * Adds a <code>Word</code> to the <code>HashMapWordSet</code>.
	 * @param word <code>Word</code> to be added to the <code>HashMapWordSet</code>
	 * @return Boolean value representing whether the <code>Word</code> was
	 * successfully added.
	 */
	@Override
	public boolean addWord(Word word) {
		if (word == null) {
			throw new IllegalArgumentException("addWord does not take null Word argument.");
		}
		
		if (wordMap.containsKey(word.getWord()) &&
				word.getValue() <= wordMap.get(word.getWord()).getValue()) {
			return false;
		}
		wordMap.put(word.getWord(), word);
		return true;
	}

	/**
	 * Returns a list of all the <code>Word</code> objects in the
	 * <code>HashMapWordSet</code>
	 * @return List of <code>Word</code> objects.
	 */
	@Override
	public List<Word> getWords() {
		List<Word> words = new ArrayList<>();
		return words;
	}

}
