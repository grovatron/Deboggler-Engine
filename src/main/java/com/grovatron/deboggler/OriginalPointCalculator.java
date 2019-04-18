package com.grovatron.deboggler;

import java.util.List;

public class OriginalPointCalculator implements WordPointCalculator {

	@Override
	public int calculatePoints(List<Letter> letters) {
		if (letters == null || letters.isEmpty() || letters.contains(null)) {
			throw new IllegalArgumentException();
		}
		// TODO Auto-generated method stub
		if (letters.size() <= 4) {
			return 1;
		} else if (letters.size() < 8) {
			return letters.size() - 3;
		} else {
			return 11;
		}
	}

}
