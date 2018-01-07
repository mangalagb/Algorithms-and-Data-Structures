package BasicPrograms;

public class PalindromeChecker {
	
	public boolean checkIfPalindromeIterative(char[] characters) {
		for(int i=0, j=characters.length-1; i<characters.length/2; i++,j--) {
			if(characters[i] != characters[j]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkIfPalindromeRecursive(char[] characters, int low, int high) {
		if(low >= high) {
			return true;
		}else if(characters[low] != characters[high]) {
			return false;
		}
		return checkIfPalindromeRecursive(characters, low+1, high-1);
	}
	
	public static void main(String[] args) {
		PalindromeChecker palindromeChecker = new PalindromeChecker();
		String word1 = "madam";
		System.out.println(palindromeChecker.checkIfPalindromeIterative(word1.toCharArray()));
		
		System.out.println(palindromeChecker.checkIfPalindromeRecursive(word1.toCharArray(), 0, word1.length()-1));
		
	}
}
