/*
 * 
URLify: Write a method to replace all spaces in a string with '%20: 
You may assume that the string has sufficient space at the end to hold 
the additional characters, and that you are given the "true" length of 
the string. (Note: If implementing in Java, please use a character array 
so that you can perform this operation in place.)
EXAMPLE
Input:  "Mr John Smith     ",  13 
Output: "Mr%20John%20Smith"
 */
package chapter1;

public class URLify {
	
	public void createURL(char[] stringToChange, int trueLength) {
		for(int index=0;index<trueLength;index++) {
			if(stringToChange[index] == ' ') {
				stringToChange = shiftBy3(stringToChange, index);
				trueLength += 2;
			}
		}
		System.out.print(String.valueOf(stringToChange));
	}
	
	public char[] shiftBy3(char[] stringToChange, int counter) {
		for(int i=stringToChange.length-1; i>counter; i--) {
			stringToChange[i] = stringToChange[i-2];
		}
		stringToChange[counter] = '%';
		stringToChange[counter+1] = '2';
		stringToChange[counter+2] = '0';
		return stringToChange;
	}
	
	
	public static void main(String[] args) {
		URLify url = new URLify();
		String value = "Mr John Smith     ";
		char[] charValue = value.toCharArray();
		url.createURL(charValue, 13);
	}
}
