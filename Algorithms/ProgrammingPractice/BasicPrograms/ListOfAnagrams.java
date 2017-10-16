package BasicPrograms;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Find all anagrams form input from a file.
 */
public class ListOfAnagrams {
	
	List<String> words = new ArrayList<String>();
	Map<String, String> anagrams = new HashMap<String, String>();
		
	public void readFile() throws IOException {
		String word;
		FileReader fileReader = new FileReader("words.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		
		while((word = reader.readLine()) != null) {
			words.add(word);
		}
		
		fileReader.close();
		reader.close();
	}
	
	public void printAnagrams(){
		for(String entry : anagrams.values()) {
			System.out.print(entry + "\n");
		}
	}
	
	public void findAnagram(String word) {
		char[] charArrayOfWord = word.toCharArray();
		Arrays.sort(charArrayOfWord);
		String sortedWord = String.valueOf(charArrayOfWord);
		if(!anagrams.containsKey(sortedWord)) {
			anagrams.put(sortedWord, word);
		}else{
			String newValue = anagrams.get(sortedWord) + "," + word;
			anagrams.put(sortedWord, newValue);
		}
	}
	
	public void findAllAnagramsInList() {
		for(int i=0;i<words.size();i++) {
			findAnagram(words.get(i));
		}
	}
	
	public static void main(String[] args) throws IOException {
		ListOfAnagrams anagram = new ListOfAnagrams();
		anagram.readFile();		
		anagram.findAllAnagramsInList();
		anagram.printAnagrams();
	}
}
