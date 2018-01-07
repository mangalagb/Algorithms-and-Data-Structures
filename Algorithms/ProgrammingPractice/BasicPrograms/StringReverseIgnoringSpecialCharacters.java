package BasicPrograms;
/*
 * Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’),
 * reverse the string in a way that special characters are not affected.
 * 
 *  Input:   str = "a,b$c"
	Output:  str = "c,b$a"
	Note that $ and , are not moved anywhere.  
	Only subsequence "abc" is reversed

	Input:   str = "Ab,c,de!$"
	Output:  str = "ed,c,bA!$"
 */

public class StringReverseIgnoringSpecialCharacters {
	
	private boolean isCharacter(Character charToBeTested) {
		if((charToBeTested >= 'a' && charToBeTested <= 'z') || (charToBeTested >= 'A' && charToBeTested <= 'Z') ) {
			return true;
		}
		return false;
	}
	
	public String reverseString(String word1) {
		if(word1 == null || word1.isEmpty()) {
			return null;
		}
		
		char[] characterArray = word1.toCharArray();
		
		for(int i=0,j=word1.length()-1;i<characterArray.length/2;i++,j--) {
			while(!isCharacter(characterArray[i])) {
				i++;
			}
			
			while(!isCharacter(characterArray[j])) {
				j--;
			}
			
			if(j<i) {
				break;
			}
			
			char temp = characterArray[i];
			characterArray[i] = characterArray[j];
			characterArray[j] = temp;
		}
		
		return String.valueOf(characterArray);
	}
	
	public static void main(String[] args) {
		StringReverseIgnoringSpecialCharacters reverse = new StringReverseIgnoringSpecialCharacters();
		//String input = "a,b$c";
		//String input = "Ab,c,de!$"; 
		//String input = "a!!!b.c.d,e'f,ghi";
		String input = "hello$$$$$$$$$world";
		System.out.print(reverse.reverseString(input));
	}

}
