package examples;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grovatron.deboggler.Deboggler;
import com.grovatron.deboggler.HashMapWordSet;
import com.grovatron.deboggler.Letter;
import com.grovatron.deboggler.Modifier;
import com.grovatron.deboggler.ValueModifier;
import com.grovatron.deboggler.WithFriendsPointCalculator;
import com.grovatron.deboggler.Word;
import com.grovatron.deboggler.WordConstructor;
import com.grovatron.deboggler.WordSet;
import com.grovatron.deboggler.dictionary.Dictionary;
import com.grovatron.deboggler.dictionary.DictionaryConstructor;
import com.grovatron.deboggler.dictionary.TrieDictionaryConstructor;

public class WithFriendsDebogglerExample {

	private static final int WORDS_AT_A_TIME = 5;

	public static void main(String[] args) throws IOException {
		
		/**
		 * Build a TrieDictionary that contains all the words in SOWPODS dictionary.
		 * For more information on SOWPODS:
		 * https://en.wikipedia.org/wiki/Collins_Scrabble_Words
		 */
		DictionaryConstructor dictionaryConstructor = new TrieDictionaryConstructor();
		InputStream inputStream = WithFriendsDebogglerExample.class.getResourceAsStream("/sowpods.txt");
		Dictionary dictionary = dictionaryConstructor.buildDictionary(inputStream);
		
		/**
		 * Build a WordConstructor that uses the WithFriendsPointCalculator.
		 * The WithFriendsPointCalculator uses the scoring system from the mobile
		 * game Boggle With Friends to generate point values for words.
		 */
		WordConstructor wordConstructor = new WordConstructor(new WithFriendsPointCalculator());
		
		/**
		 * Build a HashMapWordSet to store the words found in the Boggle grid.
		 */
		WordSet wordSet = new HashMapWordSet();
		
		/**
		 * Set the minimum length.
		 * The minimum length for a word in Boggle With Friends is 2.
		 */
		int minLength = 2;
		
		/**
		 * Build a Deboggler using the components built above.
		 */
		Deboggler deboggler = new Deboggler(dictionary, wordConstructor, wordSet, minLength);
		
		/**
		 * Build a Letter[][] grid from user input.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Letter[][] letterGrid = getLetterGrid(reader);
		
		/**
		 * Get the list of Words found in the Letter[][] grid.
		 */
		List<Word> wordList = deboggler.getWordList(letterGrid);
		
		/**
		 * Display the list of words and their locations within the Letter[][] grid.
		 */
		displayWords(wordList, letterGrid, reader);
		
		reader.close();
	}
	
	private static void displayWords(List<Word> wordList, Letter[][] letterGrid, BufferedReader reader) throws IOException {
		Collections.sort(wordList, new Comparator<Word>() {
			public int compare(Word w1, Word w2) {
				int result = Integer.compare(w2.getValue(), w1.getValue());
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

	private static void displayWord(Word word, Letter[][] letterGrid) {
		String[][] output = buildOutputGrid(letterGrid);
		for (int location : word.getLocation()) {
			int row = location / letterGrid.length;
			int col = location % letterGrid.length;
			output[row][col] = output[row][col].toUpperCase();
		}
		
		System.out.println(String.format("\n\n%s", word.getWord()));
		System.out.println(String.format("Points: %d", word.getValue()));
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
		System.out.println("If a letter has a modifier (for instance, triple letter) enter it like so: 'n,tl'");
		for (int i = 0; i < size; i++) {
			System.out.printf("Row %d: ", (i + 1));
			String[] row = reader.readLine().toLowerCase().split(" ");
			for (int j = 0; j < size; j++) {
				String[] tokens = row[j].split(",");
				Letter letter;
				if (tokens.length == 1) {
					letter = new Letter(tokens[0].toUpperCase(), letterValues.get(tokens[0]));
				} else {
					letter = new Letter(tokens[0].toUpperCase(), letterValues.get(tokens[0]), modifiers.get(tokens[1]));
				}
				letterGrid[i][j] = letter;
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
	
	static Map<String, Integer> letterValues;
	static Map<String, ValueModifier> modifiers;
	
	static {
		letterValues = new HashMap<String, Integer>();
		modifiers = new HashMap<String, ValueModifier>();
		
		letterValues.put("e", 1);
		letterValues.put("s", 1);
		letterValues.put("t", 1);
		letterValues.put("r", 1);
		letterValues.put("a", 1);
		letterValues.put("i", 1);
		letterValues.put("o", 1);
		letterValues.put("l", 2);
		letterValues.put("d", 2);
		letterValues.put("n", 2);
		letterValues.put("u", 2);
		letterValues.put("g", 3);
		letterValues.put("y", 3);
		letterValues.put("h", 3);
		letterValues.put("p", 4);
		letterValues.put("m", 4);
		letterValues.put("c", 4);
		letterValues.put("b", 4);
		letterValues.put("f", 4);
		letterValues.put("w", 4);
		letterValues.put("k", 5);
		letterValues.put("v", 5);
		letterValues.put("x", 8);
		letterValues.put("j", 10);
		letterValues.put("qu", 10);
		letterValues.put("z", 10);
		
		modifiers.put("dw", new ValueModifier(Modifier.WORD, 2));
		modifiers.put("tw", new ValueModifier(Modifier.WORD, 3));
		modifiers.put("dl", new ValueModifier(Modifier.LETTER, 2));
		modifiers.put("tl", new ValueModifier(Modifier.LETTER, 3));
	}
}
