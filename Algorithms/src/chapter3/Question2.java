/*
 * How would you design a stack which, in addition to push
 *  and pop, also has a function min which returns 
 *  the minimum element? Push, pop and min should all operate in O(1) time.
 */
package chapter3;

class Question2
{
	int top;
	int maxSize;
	int min;
	int[] stackArray;
	
	public Question2(int size)
	{
		top = -1;
		maxSize = size;
		stackArray = new int[maxSize];
	}
	
	public void push(int o)
	{
		if(top == -1)
		{
			min = o;
			stackArray[++top] = o;
		}
		else
		{
			if(o<min)
				min = o;
			stackArray[++top] = o;
		}
	}
	
	public int returnMin()
	{
		return min;
	}
	
	public static void main(String[] args)
	{
		Question2 q = new Question2(10);
		
		q.push(2);
		q.push(7);
		q.push(1);
		
		System.out.println(q.returnMin());
	}
	
}