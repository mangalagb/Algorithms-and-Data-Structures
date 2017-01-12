package chapter3;

public class hanoitest
{
	static int N;
	static int[] fromStack;
	static int[] toStack;
	static int[] helperStack;
	static int top1,top2,top3;
	
	public hanoitest(int numberOfElements)
	{
		N = numberOfElements;
		fromStack = new int[N];
		toStack = new int[N];
		helperStack = new int[N];
		top1=-1;
		top2=-1;
		top3=-1;
		
		for(int i=N;i>=1;i--)
		{
			fromStack[++top1] = i;
		}
		
	}
	
	public void printStacks()
	{
		System.out.println("\n\nFinal position of the stacks\n");
		System.out.println("Stack1");
		
		if(top1 == -1)
			System.out.println("Empty stack");
		else
		{
			for(int i=top1;i>-1;i--)
			{
				System.out.println(fromStack[i]);
			}
		}
			
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Stack2");
		
		if(top2 == -1)
			System.out.println("Empty stack");
		else
		{
			for(int i=top2;i>-1;i--)
			{
				System.out.println(helperStack[i]);
			}
		}
			
		
		System.out.println("---------------------------------------------------------");
		
		System.out.println("Stack3");
		
		if(top3 == -1)
			System.out.println("Empty stack");
		else
		{
			for(int i=top3;i>-1;i--)
			{
				System.out.println(toStack[i]);
			}
		}
	}

	public void hanoi(int numberOfElements )
	{
		String sol1,myStep,sol2,finalSol;
		
		if(numberOfElements ==1)
		{
			shift(1,1,3);
		}
		else
		{
			shift(numberOfElements-1, 1,2);
			shift(1,1,3);
			shift(numberOfElements-1, 2,3);
		}
		
	}
		
	public void shift(int n, int fromPeg, int toPeg)
	{
		if(fromPeg == 1  && toPeg == 3)
		{
			for(int i=1;i<=n;i++)
			{
				// shift from fromStack to toStack
				int number = fromStack[top1];
				top1 = top1-1;
				toStack[++top3] = number;
			}
		}
		if(fromPeg == 1  && toPeg == 2)
		{
			for(int i=1;i<=n;i++)
			{
				// shift from fromStack to helperStack
				int number = fromStack[top1];
				top1 = top1-1;
				helperStack[++top2] = number;
			}
		}
		if(fromPeg == 2  && toPeg == 3)
		{
			for(int i=1;i<=n;i++)
			{
				// shift from helperStack to toStack
				int number = helperStack[top2];
				top2 = top2-1;
				toStack[++top3] = number;
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		hanoitest q = new hanoitest(3);
		q.hanoi(3);
		q.printStacks();
		
	}
}