package com.grovatron.deboggler;

import java.util.List;

public class OriginalPointCalculator implements WordPointCalculator {

	@Override
	public int calculatePoints(List<Letter> letters) {
		if (letters == null || letters.isEmpty()) {
			throw new IllegalArgumentException();
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
