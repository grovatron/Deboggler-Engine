package com.grovatron.deboggler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	@Override
	public List<Word> getWords() {
		return wordMap.values().stream().collect(Collectors.toList());
	}

}
