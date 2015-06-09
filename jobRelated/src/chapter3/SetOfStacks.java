package chapter3;

import java.util.ArrayList;

public class SetOfStacks
{
	ArrayList<Stack> StackSet = new ArrayList<Stack>();
	int threshold;
	
	public SetOfStacks(int i)
	{
		threshold = i;
	}
	
	public void Push(int i)
	{
		if(StackSet.isEmpty())
		{
			Stack first = new Stack(threshold);
			first.push(i);
			StackSet.add(first);
		}
		else
		{
			int size = StackSet.size() - 1;
			Stack last = StackSet.get(size);
			
			if(! last.isFull())
			{
				last.push(i);
			}
			else
			{
				Stack another = new Stack(threshold);
				another.push(i);
				StackSet.add(another);
			}
		}
	}
	
	public int pop()
	{
		if(StackSet.isEmpty())
			return -1;
		
		else
		{
			int size = StackSet.size() - 1;
			Stack last = StackSet.get(size);
			
			
			
			int i = last.pop();
			
			if(last.isEmpty())
			{
				StackSet.remove(size);
			}
			else
			{
			StackSet.set(size, last);
			}
			return i;
		}
		
	}
	
	public void popAt(int index)
	{
		int stackNumber = index / threshold;
		System.out.println(stackNumber);
	}
	
	public void displaySetOfStacks()
	{
		for(int i = StackSet.size()-1; i!=-1; i--)
		{
			Stack s = StackSet.get(i);
			s.display();
		}
		System.out.print("\n-------------------------------\n");
	}
	
	public static void main(String[] args)
	{
		SetOfStacks s = new SetOfStacks(2);
		s.Push(2);
		s.Push(5);
		s.Push(3);
		s.Push(7);
		s.Push(1);
		s.displaySetOfStacks();
		
		s.pop();
		s.displaySetOfStacks();
		s.pop();
		s.displaySetOfStacks();
		
		s.popAt(2);
	}
}

class Stack
{
	int maxSize;
	int top;
	int[] stackArray;
	
	public Stack(int i)
	{
		maxSize = 2;
		top = -1;
		stackArray = new int[maxSize];
	}
	
	public boolean isEmpty()
	{
		return (top == -1); 
	}
	
	public boolean isFull()
	{
		if(top == maxSize -1)
			return true;
		else
			return false;
	}
	
	public void display()
	{	
		for(int i=top; i!=-1; i--)
		{
			System.out.print(stackArray[i] + "\t");
		}
		
	}
	
	public void push(int i)
	{
		if(isFull() == false)
			stackArray[++top] = i;
		else
			System.err.println("Error in push");
	}
	
	public int pop()
	{
		int i = -1;
		if(top != -1)
		{
			i = stackArray[top];
			--top;
		}
		else
			System.err.println("Error in pop");
		
		return i;
	}
}