package chapter1;

class Question7
{
	public void initializeMatrix()
	{
		
		int[][] array = new int[][] {
				{1,1,1},
				{1,1,0}
				};
				
				
		
		printArray(array);
		setNumbers(array);
		
	}
	
	public void setNumbers(int[][] array)
	{
		
		int[][] positions = new int[array.length*array[0].length][2];
		
		for(int i=0; i<positions.length;i++)
		{
			for(int j=0;j<positions[0].length;j++)
			{
				positions[i][j] =-1;
			}
		}
		int z=0;
		
		for(int i=0; i<array.length;i++)
		{
			for(int j=0;j<array[0].length;j++)
			{
				if(array[i][j] ==0)
				{
					positions[z][0] =i;
					positions[z][1] =j;
					z=z+1;
				}
			}
		}
		
		for(int i=0; i<positions.length;i++)
		{
			for(int j=0;j<positions[0].length;j++)
			{
				if(positions[i][j] != -1)
				{
					if(j==0)
					{
						int row = positions[i][j];
						for(int w =0; w<array[0].length; w++)
						{
							array[row][w] =0;
						}
					}
					else
					{
						int col = positions[i][j];
						for(int w =0; w<array.length; w++)
						{
							array[w][col] =0;
						}
					}
				}
			}
		}
		
		printArray(array);
		
	}
	
	public void printArray(int[][] array)
	{
		
		for(int i=0; i<array.length;i++)
		{
			for(int j=0;j<array[0].length;j++)
			{
				System.out.print(array[i][j] +"\t");
			}
			System.out.println();
		}
		System.out.println("__________________________");
	}
	
	
	public static void main(String[] args)
	{
		Question7 q = new Question7();
		q.initializeMatrix();
	}
}