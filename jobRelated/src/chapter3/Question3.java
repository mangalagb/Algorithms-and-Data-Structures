package chapter3;

class Question3
{
	int maxSize;
	int threshold;
	int[][] outer;
	String position = "";
	int noOfElements;
	int numberOfStacks;
	
	public Question3(int n, int thr)
	{
		threshold = thr;
		maxSize = n;
		noOfElements =0;
		
		float no = (float)n/threshold;
		 numberOfStacks = (int)Math.ceil(no);
		
		outer = new int[numberOfStacks][threshold];
		
		for(int i=0; i<outer.length;i++)
		{
			for(int j=0; j<outer[0].length; j++)
			{
				outer[i][j] = 0;
			}
		}
		
	}
	
	public boolean isEmpty()
	{
		boolean myNull=true;
		
		for(int i=0; i<outer.length;i++)
		{
			for(int j=0; j<outer[0].length; j++)
			{
				if(outer[i][j] != 0)
				{
					myNull = false;
					break;
				}
			}
		}
		if(myNull == true)
			return true;
		else
			return false;
	}
	
	public void push(int n)
	{
		
		if(isEmpty())
		{
			outer[0][0] = n;
			position = "00";
			
		}
		else
		{
			outerLoop:
			for(int i=0; i<outer.length;i++)
			{
				for(int j=0; j<outer[0].length; j++)
				{
					if(outer[i][j] !=0)
					{
						continue;
					}
					else
					{
						outer[i][j] = n;
						position = Integer.toString(i)+ Integer.toString(j);
						break outerLoop;
					}
				}
			}
			
			
		}
	}
	
	public void pop()
	{
		char c1= position.charAt(0);
		char c2= position.charAt(1);
		
		int i = Character.getNumericValue(c1);
		int j = Character.getNumericValue(c2);
		
		outer[i][j] = 0;
		
		if(j==0)
		{
			--i;
			j = outer[0].length-1;
		}
		else
		{
			--j;
		}
		position = Integer.toString(i)+ Integer.toString(j);
		
	}
	
	
	
	public void newPop(int index)
	{	
		int newIndex = (noOfElements -1) - (index);
		
		int stackNumber = (newIndex/threshold);		
		int tempIndex = newIndex -(stackNumber*threshold);
		
		System.out.println("Element popped : "+outer[stackNumber][tempIndex]);
		System.out.print("\n---------------------------\n");
		outer[stackNumber][tempIndex]= 0;
	}
	
	public void popAt(int index)
	{
		for(int i=0;i<outer.length;i++)
		{
			for(int j=0;j<outer[0].length;j++)
			{
				System.out.print(outer[i][j]+"\t");
			}
		}
		System.out.print("\n---------------------------\n");
		
		int newIndex = (noOfElements -1) - (index);
		
		int stackNumber = (newIndex/threshold);		
		int tempIndex = newIndex -(stackNumber*threshold);
		
		System.out.println("Element popped : "+outer[stackNumber][tempIndex]);
		System.out.print("\n---------------------------\n");
		outer[stackNumber][tempIndex]= 0;
		
		// 0 * 1
		for(int i=0;i<outer.length;i++)
		{
			for(int j=0;j<outer[0].length;j++)
			{
				System.out.print(outer[i][j]+"\t");
			}
		}
		System.out.print("\n---------------------------\n");
		
		for(int i=stackNumber;i<outer.length;i++)
		{
			for(int j=tempIndex;j<outer[0].length;j++)
			{
				System.out.print(outer[i][j]+"\t");
			}
		}
		System.out.print("\n---------------------------\n");


	}
	
	public void print()
	{
		for(int i=outer.length-1; i>=0;i--)
		{
			for(int j=outer[0].length-1; j>=0; j--)
			{
				if(outer[i][j] == 0)
					continue;
				else
				{
					System.out.print(outer[i][j]+"\t");
					++noOfElements;
				}
			}
			
		}
		
		
		System.out.print("\n---------------------------\n");
	}
	
	
	public static void main(String[] args)
	{
		Question3 q = new Question3(5,2);
		q.push(9);
		q.push(7);
		q.push(5);
		q.push(2);
		q.push(77);
		
		//q.pop();
		
		q.print();
		
//		q.newPop(3);
//		q.print();
//		
		q.popAt(3);
		
		
//		q.push(11);
//		q.print();
		//q.print();
	}
}