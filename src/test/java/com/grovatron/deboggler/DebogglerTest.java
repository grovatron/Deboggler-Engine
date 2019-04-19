package com.grovatron.deboggler;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grovatron.deboggler.dictionary.Dictionary;
import com.grovatron.deboggler.dictionary.TrieDictionaryConstructor;

class DebogglerTest {
	
	static String testFile = "star\narts\nrats\ntars\nart\ntar\nrat";

	Dictionary dictionary;
	WordConstructor wordConstructor;
	WordSet wordSet;
	int minLength;
	
	@BeforeEach
	void setup() throws IOException {
		InputStream inputStream = new ByteArrayInputStream(testFile.getBytes(Charset.forName("UTF-8")));
		dictionary = new TrieDictionaryConstructor().buildDictionary(inputStream);
		wordConstructor = new WordConstructor(new OriginalPointCalculator());
		wordSet = new HashMapWordSet();
		minLength = 3;
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
