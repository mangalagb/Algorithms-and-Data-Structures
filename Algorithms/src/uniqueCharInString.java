import java.util.regex.Matcher;
import java.util.regex.Pattern;

class uniqueCharInString {
	static String str = "poop gowri poop";
	
	public void replace()
	{
		
		
		int[][] arr = {{4,3},
				{1,2}};
		
		for(int i=0 ; i<2; i++)
		{
			for(int j=0; j<2; j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println("\n");
		}
		
		//transpose
		
		int[][] newarr = new int[2][2];
		
		for(int i=0 ; i<2; i++)
		{
			for(int j=0; j<2; j++)
			{
				newarr[j][i] = arr[i][j];
			}
			
		}

		System.out.println("===========");
		for(int i=0 ; i<2; i++)
		{
			for(int j=0; j<2; j++)
			{
				System.out.print(newarr[i][j]+"\t");
			}
			System.out.println("\n");
		}
		
		int[][] newar = new int[2][2];
		int collen =1;
		
		for(int i=0 ; i<2; i++)
		{
			
			for(int j=0; j<2; j++)
			{
				
				newarr[i][j] = newarr[i][collen];
				--collen;
			}
			
		}
		System.out.println("===========");
		for(int i=0 ; i<2; i++)
		{
			for(int j=0; j<2; j++)
			{
				System.out.print(newar[i][j]+"\t");
			}
			System.out.println("\n");
		}
		
				
	}
	
	public static void main(String[] args) {
		
	
	uniqueCharInString u = new uniqueCharInString();
	u.replace();
}
}