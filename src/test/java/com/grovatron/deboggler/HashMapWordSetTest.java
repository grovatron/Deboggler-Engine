package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashMapWordSetTest {

	WordSet wordSet;
	
	@BeforeEach
	void setup() {
		wordSet = new HashMapWordSet();
	}

}
