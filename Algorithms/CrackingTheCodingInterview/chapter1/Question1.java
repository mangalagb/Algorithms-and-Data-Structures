/*
 * Implement an algorithm to determine if a string has all unique characters.
 *  What if you can not use additional data structures?
 * 
 */

package chapter1;

import java.util.HashSet;

class Question1
{
	public boolean isUnique(String stringToTest){
		HashSet<Character> unique = new HashSet<Character>();
		for(int i=0;i<stringToTest.length();i++){
			Character character = stringToTest.charAt(i);
			if(unique.contains(character)){
				return false;
			}
			unique.add(character);
		}
		if(unique.size() == stringToTest.length()){
			return true;
		}
		return false;
	}
	
	public void reverse(char[] string)
	{
		for(int i=0,j=string.length-1;i<string.length/2;i++,j--)
		{
			char current = string[i];
			string[i] = string[j];
			string[j] = current;
		}
		System.out.println(string.toString() + "\n");
	}
	
	public static void main(String[] args)
	{
		Question1 q = new Question1();
		if(q.isUnique("hello") ==true)
		System.out.println("It contains unique characters");
		
		else
			System.out.println("Not unique");
	}
	
}