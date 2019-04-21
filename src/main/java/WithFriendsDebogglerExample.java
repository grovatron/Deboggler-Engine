import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.grovatron.deboggler.Deboggler;
import com.grovatron.deboggler.HashMapWordSet;
import com.grovatron.deboggler.Letter;
import com.grovatron.deboggler.WithFriendsPointCalculator;
import com.grovatron.deboggler.Word;
import com.grovatron.deboggler.WordConstructor;
import com.grovatron.deboggler.WordSet;
import com.grovatron.deboggler.dictionary.Dictionary;
import com.grovatron.deboggler.dictionary.DictionaryConstructor;
import com.grovatron.deboggler.dictionary.TrieDictionaryConstructor;

public class WithFriendsDebogglerExample {

	public static void main(String[] args) throws IOException {
		
		DictionaryConstructor dictionaryConstructor = new TrieDictionaryConstructor();
		InputStream inputStream = WithFriendsDebogglerExample.class.getResourceAsStream("/sowpods.txt");
		Dictionary dictionary = dictionaryConstructor.buildDictionary(inputStream);
		
		WordConstructor wordConstructor = new WordConstructor(new WithFriendsPointCalculator());
		
		WordSet wordSet = new HashMapWordSet();
		
		int minLength = 2;
		
		Deboggler deboggler = new Deboggler(dictionary, wordConstructor, wordSet, minLength);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Letter[][] letterGrid = getLetterGrid(reader);
		
		List<Word> wordList = deboggler.getWordList(letterGrid);
		
		displayWords(wordList);
		
		reader.close();
	}
}
