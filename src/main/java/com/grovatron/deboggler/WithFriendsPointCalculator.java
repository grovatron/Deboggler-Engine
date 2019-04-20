package com.grovatron.deboggler;

import java.util.List;

public class WithFriendsPointCalculator implements WordPointCalculator {

	@Override
	public int calculatePoints(List<Letter> letters) {
		if (letters == null) {
			throw new IllegalArgumentException("calculatePoints does not take null List<Letter> argument.");
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
