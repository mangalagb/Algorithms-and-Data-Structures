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
	
	public static void main(String[] args)
	{
		Question1 q = new Question1();
		if(q.unique("abc") ==true)
		System.out.println("It contains unique characters");
		
		else
			System.out.println("Not unique");
	}
	
}