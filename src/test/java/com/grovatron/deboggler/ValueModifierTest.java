package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValueModifierTest {

	@Test
	void testConstructor1() {
		assertThrows(IllegalArgumentException.class, () -> new ValueModifier(null, 2), 
				"ValueModifier does not take null Modifier, should throw IllegalArgumentException.");
	}

}
