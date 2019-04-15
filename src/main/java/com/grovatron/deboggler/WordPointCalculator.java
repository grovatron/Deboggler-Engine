package com.grovatron.deboggler;

import java.util.List;

/**
 * Determines the point value of <code>Word</code> objects found in the
 * <code>Letter</code> grid. Different implementations of the interface
 * allow for different scoring styles (i.e. value determined solely by
 * word length, adding individual <code>Letter</code> values, etc.).
 * 
 * @author Grover Sundstrom (grover.a.sundstrom@gmail.com)
 * @version 0.0.1 04/15/2019
 *
 */
public interface WordPointCalculator {

	/**
	 * 
	 * @param letters A <code>List</code> of <code>Letter</code> objects comprising a
	 * word found on the grid.
	 * @return A point value, determined by the implementation of the interface.
	 */
	int calculatePoints(List<Letter> letters);
}
