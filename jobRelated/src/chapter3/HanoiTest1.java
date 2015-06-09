package chapter3;

public class HanoiTest1
{
	static int N;
	static int[] fromStack;
	static int[] toStack;
	static int[] helperStack;
	static int top1,top2,top3;
	
	public HanoiTest1(int numberOfElements)
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

	public void hanoi(int numberOfElements, int fromPeg, int toPeg )
	{
		String sol1,myStep,sol2,finalSol;
		int helperPeg = 6-fromPeg-toPeg;
		
		if(numberOfElements ==1)
		{
			shift(fromPeg,toPeg);
		}
		else
		{
			hanoi(numberOfElements-1, fromPeg, helperPeg);
			shift(fromPeg,toPeg);
			hanoi(numberOfElements-1, helperPeg, toPeg);
		}
		
		
	}
	
	public void shift(int onePeg, int anotherPeg)
	{
		if(onePeg == 1  && anotherPeg == 2)
		{
			// shift from fromStack to helperStack
				int number = fromStack[top1];
				top1 = top1-1;
				helperStack[++top2] = number;
				System.out.println("1 -> 2");
		}
		if(onePeg==1 && anotherPeg ==3)
		{
			// shift from fromStack to toStack
			int number = fromStack[top1];
			top1 = top1-1;
			toStack[++top3] = number;
			System.out.println("1 -> 3");
		}
		if(onePeg==2 && anotherPeg ==1)
		{
			// shift from helperStack to fromStack
			int number = helperStack[top2];
			top2 = top2-1;
			fromStack[++top1] = number;
			
			System.out.println("2 -> 1");
		}
		if(onePeg == 2  && anotherPeg == 3)
		{
				// shift from helperStack to toStack
				int number = helperStack[top2];
				top2 = top2-1;
				toStack[++top3] = number;
				System.out.println("2 -> 3");
		}
		if(onePeg==3 && anotherPeg ==1)
		{
			// shift from toStack to fromStack
			int number = toStack[top3];
			top3 = top3-1;
			fromStack[++top1] = number;
			System.out.println("3 -> 1");
		}
		if(onePeg==3 && anotherPeg ==2)
		{
			// shift from toStack to fromStack
			int number = toStack[top3];
			top3 = top3-1;
			toStack[++top2] = number;
			System.out.println("3 -> 2");
		}
	}
	
	
	public static void main(String[] args)
	{
		HanoiTest1 q = new HanoiTest1(4);
		q.printStacks();
		
		q.hanoi(4, 1, 3);
		q.printStacks();
	
	}
}