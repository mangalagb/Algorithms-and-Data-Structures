/*
 * Describe how you could use a single array to implement three stacks.
 */
package chapter3;

class Question1
{
	private Object stackArray[];
	private int top1,top2,top3;
	private int size1,size2,size3;
	private int maxCapacity;
	
	public Question1(int capacity, int s1, int s2, int s3)
	{
		maxCapacity = capacity;
		stackArray = new Object[maxCapacity];
		size1 = s1;
		size2 = s1+s2;
		size3 = s1+s2+s3;
		
		top1 = -1;
		top2 = 9;
		top3 = 19;
	}
	
	public void push(Object o, String stackName)
	{
		if(stackName == "stack1")
		{
			if(top1<size1-1)
			stackArray[++top1] = o;
		}
		else if(stackName == "stack2")
		{
			if(top2<size2-1)
			stackArray[++top2] = o;
		}
		else if(stackName == "stack3")
		{
			if(top3<size3-1)
			stackArray[++top3] = o;
		}
	}
	
	public Object pop(String stackName)
	{
		if(stackName == "stack1")
		{
			return stackArray[top1--];
		}
		else if(stackName == "stack2")
		{
			return stackArray[top2--];
		}
		else if(stackName == "stack3")
		{
			return stackArray[top3--];
		}
		else
			return null;
	}
	
	public static void main(String[] args)
	{
		Question1 q = new Question1(30,10,10,10);
		
		q.push(16, "stack3");
		
		System.out.println(q.pop("stack3"));
		
		q.push(1, "stack2");
		
		System.out.println(q.pop("stack2"));
	}
}