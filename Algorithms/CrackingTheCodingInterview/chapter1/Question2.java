/*
 * Write code to reverse a C-Style String.
 *  (C-String means that “abcd” is represented as five characters, including the null character.)
 */
package chapter1;

class Question2
{
	public void reverse(String str)
	{
		
		StringBuilder reverseString = new StringBuilder();
		
		for(int j=str.length()-1; j>=0; j-- )
		{
			reverseString = reverseString.append(str.charAt(j));
		}
		
		System.out.println(reverseString);
		
	}
	
	public char[] reverseInPlace(String str) {
		char[] targetString = str.toCharArray();
		for(int i=0, j=targetString.length-1; i<targetString.length/2; i++, j--) {
			char temp = targetString[i];
			targetString[i] = targetString[j];
			targetString[j] = temp;
		}
		return targetString;
	}
	
	public void anotherReverse(String str)
	{
		System.out.println("Original : "+str);
		char[] strArray = str.toCharArray();
		
		for(int i=0, j=strArray.length-1; j>=i;j--,i++)
		{
			char temp;
			temp = strArray[i];
			
			
			strArray[i] = strArray[j];
			
			strArray[j] = temp;
			
		}
		System.out.print("Reverse : ");
		for(char c : strArray)
		{
			System.out.print(c);
		}
	}
	
	public static void main(String[] args)
	{
		Question2 q = new Question2();
		//q.reverse("hello");
		//q.anotherReverse("he\n");
		
		char[] result = q.reverseInPlace("hello");
		
		for(char c : result) {
			System.out.print(c + "\t");
		}
	}
}