package chapter1;
class Question8
{

	public boolean isSubstring(String str, String sub)
	{
		if(str.contains(sub))
			return true;
		
		return false;
	}
	
	public void rotate()
	{
		String s1 = "water"; 
		String s2 = "retaw";
		
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=s1.length()-1; i>=0; i--)
		{
			stringBuilder.append(s1.charAt(i));
		}
		
		
		System.out.println(isSubstring(s2, stringBuilder.toString()));
	}
	
	public void isRotation(String s1, String s2) {
		 int len = s1.length();
		 /* check that s1 and s2 are equal length and not empty */
		 if (len == s2.length() && len > 0) {
		 /* concatenate s1 and s1 within new buffer */
		 String s1s1 = s1 + s1;
		 
		 System.out.println(isSubstring(s1s1, s2));
		 }
		 else
		 System.out.println("false");
		 }
	
	public static void main(String[] args)
	{
		Question8 q = new Question8();
		q.rotate();
		//q.isRotation("abc", "cba");
	}
}