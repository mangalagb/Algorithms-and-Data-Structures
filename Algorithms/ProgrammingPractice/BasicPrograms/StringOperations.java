package BasicPrograms;
import java.util.Arrays;
import java.util.HashMap;

public class StringOperations {

	public String reverseUsingLoop(String word){
		char[] charArray = word.toCharArray();
		for(int i=0, j=charArray.length-1; i<charArray.length/2; i++, j--){
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;			
		}		
		return Arrays.toString(charArray);		
	}
	
	public void reverseUsingRecursion(String originalString, String newString){
		if(originalString.length() != 0){
			newString = newString.concat(String.valueOf(originalString.charAt(originalString.length()-1)));
			String newOriginal = originalString.substring(0, originalString.length()-1);
			reverseUsingRecursion(newOriginal, newString);
		}else{
			System.out.println(newString);
		}
	}
	
	public void isAnagram(String first, String second){
		HashMap<String, Integer> firstLetters = new HashMap<>();
		HashMap<String, Integer> secondLetters = new HashMap<>();
		
		for(int i=0; i<first.length(); i++){
			String character = Character.toString(first.charAt(i));
			if(!firstLetters.containsKey(character)){
				firstLetters.put(character, 1);
			}else{
				Integer oldValue = firstLetters.get(character);
				firstLetters.put(character, ++oldValue);
			}
		}
		
		for(int i=0; i<second.length(); i++){
			String character = Character.toString(second.charAt(i));
			if(!secondLetters.containsKey(character)){
				secondLetters.put(character, 1);
			}else{
				Integer oldValue = secondLetters.get(character);
				secondLetters.put(character, ++oldValue);
			}
		}
		
		if(firstLetters.equals(secondLetters)){
			System.out.println("Anagram");
		}else{
			System.out.println("Not Anagram");
		}
	}
	
	public void findPatterns(String target){
		char[] charString = target.toCharArray();
		if(target.equals("") || target == null){
			System.out.println("Error. Empty");
		}else{
			findPatternsHelper(target);
		}
	}
	
	private void findPatternsHelper(String target){
		for(int i=0; i< target.length(); i++){
			String fixed = Character.toString(target.charAt(i));
			String newTarget = target.replaceAll(fixed, "");
			findPatternsHelper2(fixed, newTarget);
		}
	}
	
	private void findPatternsHelper2(String fixedChar, String target){
		System.out.print(fixedChar);
	}
	
	
	public static void main(String[] args){
		StringOperations stringoperation = new StringOperations();
		//System.out.println(stringoperation.reverseUsingLoop("hello"));
		//stringoperation.reverseUsingRecursion("hello", "");
		
		stringoperation.isAnagram("top", "pot");
	}
}
