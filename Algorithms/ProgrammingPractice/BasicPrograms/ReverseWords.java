package BasicPrograms;
//Invert the words in a sentence without any built in method

public class ReverseWords{
	
	public void reverseWords(String sentence){
		String newSentence = "";
		String newWord = "";
		
		for(int i=sentence.length()-1; i>=0; i--){			
			char character = sentence.charAt(i);
			if(character == ' '){
				newSentence = newWord + " " + newSentence;
				newWord = "";
			}else if(i == 0){
				newWord = newWord + character;
				newSentence = newWord + " " + newSentence;
			}else{
				newWord = newWord + character;
			}
		}
		System.out.println(newSentence);
	}
	
	public static void main(String[] args){
		ReverseWords reverse = new ReverseWords();
		String sentence = "hello world";
		System.out.println(sentence);
		
		reverse.reverseWords(sentence);
	}
}