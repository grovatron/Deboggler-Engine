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
		
		int letterScore = letters
				.stream()
				.map(letter -> {
					ValueModifier valueModifier;
					if ((valueModifier = letter.getModifier()) != null && valueModifier.getModifier().equals(Modifier.LETTER)) {
						return letter.getValue() * valueModifier.getMultiplier();
					} else {
						return letter.getValue();
					}
				})
				.reduce(0, (a, b) -> a + b);
		
		for (Letter letter : letters) {
			ValueModifier valueModifier;
			if ((valueModifier = letter.getModifier()) != null && valueModifier.getModifier().equals(Modifier.WORD)) {
				letterScore *= 2;
			}
		}
		
		String word = letters.stream().map(Letter::getLetter).collect(Collectors.joining());
		int lengthBonus;
		if (word.length() <= 4) {
			lengthBonus = 0;
		} else if (word.length() == 5) {
			lengthBonus = 3;
		} else if (word.length() == 6 ){
			lengthBonus = 6;
		} else if (word.length() == 7) {
			lengthBonus = 10;
		} else {
			lengthBonus = 15;
		}
		return letterScore + lengthBonus;
	}

}
