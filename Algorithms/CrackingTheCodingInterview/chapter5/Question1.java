/*
 * You are given two 32-bit numbers, N and M, and two bit positions, 
 * i and j. Write a method to set all bits between i and j in N equal to
 *  M (e.g., M becomes a substring of N located at i and starting at j).
EXAMPLE:
Input: N = 10000000000, M = 10101, i = 2, j = 6
Output: N = 10001010100
 */
package chapter5;

class Question1
{	
	byte[] x;
	
	public Question1()
	{
		
	}
	public void newNumber()
	{
		
	}
	
	public static void main(String[] args)
	{
		Question1 q = new Question1();
		
		int i = Integer.parseInt("10", 2);
		String h = "10";
		
		byte[] b = h.getBytes();
		
		byte c = (byte) 10000000;
		
		
		for(int y=0;y<b.length;y++)
			System.out.print(b[y]);
	}
}