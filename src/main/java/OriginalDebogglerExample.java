import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.grovatron.deboggler.Deboggler;
import com.grovatron.deboggler.HashMapWordSet;
import com.grovatron.deboggler.Letter;
import com.grovatron.deboggler.OriginalPointCalculator;
import com.grovatron.deboggler.Word;
import com.grovatron.deboggler.WordConstructor;
import com.grovatron.deboggler.WordSet;
import com.grovatron.deboggler.dictionary.Dictionary;
import com.grovatron.deboggler.dictionary.DictionaryConstructor;
import com.grovatron.deboggler.dictionary.TrieDictionaryConstructor;

public class OriginalDebogglerExample {

	public static void main(String[] args) throws IOException {

		DictionaryConstructor dictionaryConstructor = new TrieDictionaryConstructor();
		InputStream inputStream = OriginalDebogglerExample.class.getResourceAsStream("/sowpods.txt");
		Dictionary dictionary = dictionaryConstructor.buildDictionary(inputStream);
		
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		
		WordSet wordSet = new HashMapWordSet();
		
		int minLength = 3;
		
		Deboggler deboggler = new Deboggler(dictionary, wordConstructor, wordSet, minLength);
		
		Letter[][] letterGrid = getLetterGrid();
		
		List<Word> wordList = deboggler.getWordList(letterGrid);
		
		displayWords(wordList);
	}

}
