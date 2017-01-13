package BasicPrograms;


class ReverseStringInPlace
{
	public void reverse(char[] string)
	{
		for(int i=0,j=string.length-1;i<string.length/2;i++,j--)
		{
			char current = string[i];
			string[i] = string[j];
			string[j] = current;
		}
		System.out.println(string);
	}
	
	public static void main(String[] args)
	{
		ReverseStringInPlace r = new ReverseStringInPlace();
		String str = "hellotom";
		r.reverse(str.toCharArray());
		
	}
}