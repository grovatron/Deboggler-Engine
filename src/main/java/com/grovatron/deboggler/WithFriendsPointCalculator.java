package com.grovatron.deboggler;

import java.util.List;

public class WithFriendsPointCalculator implements WordPointCalculator {

	@Override
	public int calculatePoints(List<Letter> letters) {
		if (letters == null) {
			throw new IllegalArgumentException("calculatePoints does not take null List<Letter> argument.");
		}
		if (letters.isEmpty()) {
			throw new IllegalArgumentException("calculatePoints does not take empty List<Letter> argument.");
		}
		if (letters.contains(null)) {
			throw new IllegalArgumentException("calculatePoints does not take List<Letter> that contains null elements.");
		}
		// TODO Auto-generated method stub
		return letters.stream().map(Letter::getValue).reduce(0, (a, b) -> a + b);
	}

}
