/*
 * Design an algorithm and write code to remove the duplicate 
 * characters in a string without using any additional buffer. 
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 */
package chapter1;

class Question3
{
	public void removeDup(String s)
	{	
		
		
		if(s==null || s.isEmpty())
		{
			System.out.println("Empty string. Error");
			System.exit(-1);
		}
		
		System.out.println("original : "+s);
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<s.length();j++)
			{	
				if(s.charAt(i) == s.charAt(j))
				{
					s = s.substring(0, j)+ s.substring(j+1);
				}
			}
		}
		
		System.out.println("non dup : "+s);
		
	}
	public static void main(String[] args)
	{
		Question3 q = new Question3();
		//q.removeDup("abasdgybgpl");
		q.removeDup("");
	}
}