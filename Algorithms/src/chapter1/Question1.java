/*
 * Implement an algorithm to determine if a string has all unique characters.
 *  What if you can not use additional data structures?
 * 
 */

package chapter1;

class Question1
{
	public boolean unique(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<s.length();j++)
			{	
				if(s.charAt(i) == s.charAt(j))
				{
					return false;
				}
			}
		}
		return true;
		
	}
	
	public void reverse(char[] string)
	{
		for(int i=0,j=string.length-1;i<string.length/2;i++,j--)
		{
			char current = string[i];
			string[i] = string[j];
			string[j] = current;
		}
		System.out.println(string + "\n");
	}
	
	public static void main(String[] args)
	{
		Question1 q = new Question1();
		if(q.unique("hello") ==true)
		System.out.println("It contains unique characters");
		
		else
			System.out.println("Not unique");
	}
	
}