package com.grovatron.deboggler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.grovatron.deboggler.dictionary.Dictionary;
import com.grovatron.deboggler.util.DebogglerInputValidator;

/**
 * The <code>Deboggler</code> class comprises the heart of the Deboggler engine.
 * It has one method, getWordList, that returns a <code>Word</code> list of 
 * unique words that can be constructed from the <code>Letter</code> grid.
 * 
 * The components that make up the dependencies of the <code>Deboggler</code> are
 * customizable; they need only implement the <code>Dictionary</code>
 * and <code>WordSet</code> interfaces, respectively. <code>WordConstructor</code>
 * is created with a customizable <code>WordPointCalculator</code>.
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/15/2019
 *
 */
public class Deboggler {

	
	private final Dictionary dictionary;
	private final WordConstructor wordConstructor;
	private final WordSet wordSet;
	private final int minLength;
	
	/**
	 * Creates an instance of <code>Deboggler</code>.
	 * @param dictionary Object that implements the <code>Dictionary</code> interface.
	 * @param wordConstructor Object that constructs <code>Word</code> objects from 
	 * <code>Letter</code> objects in the 2d matrix.
	 * @param wordSet Object that implements the <code>WordSet</code> interface.
	 */
	public Deboggler(Dictionary dictionary, WordConstructor wordConstructor, WordSet wordSet, int minLength) {
		DebogglerInputValidator.validateConstructorArguments(dictionary, wordConstructor, wordSet, minLength);
		this.dictionary = dictionary;
		this.wordConstructor = wordConstructor;
		this.wordSet = wordSet;
		this.minLength = minLength;
	}
	
	/**
	 * Finds all the unique words that can be constructed from the <code>Letter</code> objects
	 * that make up the <code>letterGrid</code>.
	 * @param letterGrid A 2d array of <code>Letter</code> objects
	 * @return A list of <code>Word</code> objects that represent the set of unique words
	 * that can be constructed from the <code>letterGrid</code>
	 */
	public List<Word> getWordList(Letter[][] letterGrid) {
		DebogglerInputValidator.validateLetterGrid(letterGrid);
		List<Letter> letterList = new ArrayList<>();
		List<Integer> location = new ArrayList<>();
		for (int row = 0; row < letterGrid.length; row++) {
			for (int col = 0; col < letterGrid.length; col++) {
				depthFirstSearch(letterGrid, row, col, letterList, new HashSet<Letter>(), location);
			}
		}
		return wordSet.getWords();
	}
	
	private void depthFirstSearch(Letter[][] letterGrid, int row, int col, List<Letter> letterList, Set<Letter> visited, List<Integer> location) {
		Letter currentLetter = letterGrid[row][col];
		String prefix = letterList.stream().map(Letter::getLetter).collect(Collectors.joining()) + currentLetter.getLetter();
		if (!dictionary.isValidPrefix(prefix)) {
			return;
		}
		visited.add(currentLetter);
		location.add(getLocation(row, col, letterGrid.length));
		letterList.add(currentLetter);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int x = row + i;
				int y = col + j;
				if (isValidCoordinate(x, y, letterGrid.length) && !visited.contains(letterGrid[x][y])) {
					depthFirstSearch(letterGrid, x, y, letterList, new HashSet<Letter>(visited), location);
				}
			}
		}
		if (prefix.length() >= minLength && dictionary.isValidWord(prefix)) {
			Word word = wordConstructor.constructWord(new ArrayList<>(letterList), new ArrayList<>(location));
			wordSet.addWord(word);
		}
		letterList.remove(letterList.size() - 1);
		location.remove(location.size() - 1);
	}
	
	private int getLocation(int row, int col, int length) {
		return (row * length) + (col % length);
	}
	
	private boolean isValidCoordinate(int row, int col, int length) {
		return (row >= 0 && row < length && col >= 0 && col < length);
	}
}
