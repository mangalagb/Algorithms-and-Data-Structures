/*
 *Write a method to decide if two strings are anagrams or not. 
 */
package chapter1;

class Question4 {

	public void isAnagramEfficient(String original, String modified) {
		String newOriginal = original;
		String newModified = modified;
		int size =  modified.length() - 1;
		
		while(size >=0){
			if (original.contains(String.valueOf(modified.charAt(size)))) {
				original = original.replace(String.valueOf(modified.charAt(size)), "");
				modified = modified.replace(String.valueOf(modified.charAt(size)), "");
			}
			size--;
		}

		if (original.isEmpty() && modified.isEmpty()) {
			System.out.print("Anangram");
		} else {
			System.out.print("Not Anangram");
		}
	}

	public void isAnagram(String orig, String modified) {
		int[] letters = new int[orig.length()];

		for (int i = 0; i < orig.length(); i++) {
			letters[i] = -1;
		}

		for (int j = 0; j < modified.length(); j++) {
			int position = orig.indexOf(modified.charAt(j));

			if (position != -1)

			{
				letters[position] = 1;
			}

		}

		for (int i = 0; i < letters.length; i++) {
			if (letters[i] != 1) {
				System.out.println("It is not an anagram");
				System.exit(0);
			}

			else
				continue;
		}

		System.out.println("It is an anagram");
	}

	public static void main(String[] args) {
		Question4 q = new Question4();
		String s1 = "awret";
		String s2 = "water";
		//q.isAnagram(s1, s2);
		q.isAnagramEfficient(s1, s2);
	}
}