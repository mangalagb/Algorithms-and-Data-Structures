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