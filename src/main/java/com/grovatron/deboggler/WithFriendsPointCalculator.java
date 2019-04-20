package com.grovatron.deboggler;

import java.util.List;
import java.util.stream.Collectors;

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
		String word = letters.stream().map(Letter::getLetter).collect(Collectors.joining());
		int lengthBonus;
		if (word.length() <= 4) {
			lengthBonus = 0;
		} else if (word.length() == 5) {
			lengthBonus = 3;
		} else if (word.length() == 6 ){
			lengthBonus = 6;
		} else {
			lengthBonus = 10;
		}
		return letters.stream().map(Letter::getValue).reduce(0, (a, b) -> a + b) + lengthBonus;
	}

}
