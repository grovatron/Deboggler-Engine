package examples;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
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
	
	static final int WORDS_AT_A_TIME = 5;

	public static void main(String[] args) throws IOException {

		DictionaryConstructor dictionaryConstructor = new TrieDictionaryConstructor();
		InputStream inputStream = OriginalDebogglerExample.class.getResourceAsStream("/sowpods.txt");
		Dictionary dictionary = dictionaryConstructor.buildDictionary(inputStream);
		
		WordConstructor wordConstructor = new WordConstructor(new OriginalPointCalculator());
		
		WordSet wordSet = new HashMapWordSet();
		
		int minLength = 3;
		
		Deboggler deboggler = new Deboggler(dictionary, wordConstructor, wordSet, minLength);
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Letter[][] letterGrid = getLetterGrid(reader);
		
		List<Word> wordList = deboggler.getWordList(letterGrid);
		
		displayWords(wordList, letterGrid, reader);
		reader.close();
	}
	
	private static void displayWords(List<Word> wordList, Letter[][] letterGrid, BufferedReader reader) throws IOException {
		Collections.sort(wordList, new Comparator<Word>() {
			public int compare(Word w1, Word w2) {
				int result = Integer.compare(w1.getWord().length(), w2.getWord().length());
				if (result == 0) {
					result = w1.getWord().compareTo(w2.getWord());
				}
				return result;
			}
		});
		
		System.out.printf("\nFound %d words\n", wordList.size());
		System.out.println("Press enter to start displaying words...");
		reader.readLine();
		
		int count = 0;
		for (Word word : wordList) {
			if (count == WORDS_AT_A_TIME) {
				System.out.println(String.format("Press enter to display the next %d words...", WORDS_AT_A_TIME));
				reader.readLine();
				count = 0;
			}
			displayWord(word, letterGrid);
			count++;
		}
		
	}
	
	public static void displayWord(Word word, Letter[][] grid) {
		String[][] output = buildOutputGrid(grid);
		for (int location : word.getLocation()) {
			int row = location / grid.length;
			int col = location % grid.length;
			output[row][col] = output[row][col].toUpperCase();
		}
		System.out.println(String.format("\n\n%s", word.getWord()));
		for (String[] row : output) {
			System.out.println(String.join("|", row));
		}
	}
	
	public static String[][] buildOutputGrid(Letter[][] grid) {
		String[][] outputGrid = new String[grid.length][grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				outputGrid[i][j] = grid[i][j].getLetter().toLowerCase();
			}
		}
		return outputGrid;
	}

	public static Letter[][] getLetterGrid(BufferedReader reader) throws IOException {
		int size = getSize(reader);
		Letter[][] letterGrid = new Letter[size][size];
		
		System.out.println("Enter one row at a time with a space between each letter.");
		for (int i = 0; i < size; i++) {
			System.out.printf("Row %d: ", (i + 1));
			String[] row = reader.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				letterGrid[i][j] = new Letter(row[j].toUpperCase());
			}
		}
		
		return letterGrid;
	}
	
	public static int getSize(BufferedReader reader) throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean gotSize = false;
		int size = 0;
		while (!gotSize) {
			try {
				System.out.print("Grid Size: ");
				size = Integer.parseInt(reader.readLine().trim());
				if (size < 2) {
					throw new Exception();
				}
				gotSize = true;
			} catch (Exception ex) {
				System.out.println("Please enter an integer greater than or equal to 2\n");
			}
		}
		return size;
	}

}
