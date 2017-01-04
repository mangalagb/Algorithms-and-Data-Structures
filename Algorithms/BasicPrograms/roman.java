

import java.util.Hashtable;

class roman
{
	Hashtable<Character,Integer> values = new Hashtable<Character,Integer>();
	public roman()
	{
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);
	}
	
	public void getDecimal(String romanValue)
	{
		int prev = 0;
		int decimal =0;
	
		for(int i=romanValue.length()-1; i>=0; i--)
		{
			int temp = values.get(romanValue.charAt(i));
			
			
			if(prev>temp)
			{
				decimal= decimal-temp;
			}
			else
			{
				decimal = decimal+temp;
			}
			prev = temp;
		}
		
		System.out.println(romanValue +" = "+decimal);
	}
	
	public static void main(String[] args)
	{
		roman r = new roman();
		
		r.getDecimal("IV");
		r.getDecimal("XCV");
		r.getDecimal("LXXXVIII");
		
		
	}
}