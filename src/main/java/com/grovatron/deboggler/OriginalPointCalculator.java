package com.grovatron.deboggler;

import java.util.List;

public class OriginalPointCalculator implements WordPointCalculator {

	@Override
	public int calculatePoints(List<Letter> letters) {
		if (letters == null || letters.isEmpty() || letters.contains(null)) {
			throw new IllegalArgumentException();
		}
		// TODO Auto-generated method stub
		int totalLetters = 0;
		for (Letter letter : letters) {
			totalLetters += letter.getLetter().length();
		}
		if (totalLetters <= 4) {
			return 1;
		} else if (totalLetters < 8) {
			return totalLetters - 3;
		} else {
			return 11;
		}
	}

}
