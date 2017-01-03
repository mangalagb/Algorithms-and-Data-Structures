/*
 * How would you design a stack which, in addition to push
 *  and pop, also has a function min which returns 
 *  the minimum element? Push, pop and min should all operate in O(1) time.
 */
package chapter3;

import java.util.ArrayList;

public class Question2{
	int[] stack;
	ArrayList<Integer> minList;
	int top;
	int sizeOfStack;
	
	public Question2(int capacity) {
		stack = new int[capacity];
		minList = new ArrayList<Integer>();
		top = -1;
		sizeOfStack = capacity;
	}
	
	public void push(int data) {
		if(top < sizeOfStack) {
			stack[++top] = data;
			
			if(minList.isEmpty()) {
				minList.add(data);
			}else if(minList.get(0) > data) {
				minList.add(0, data);
			}else {
				minList.add(data);
			}
		}
	}
	
	public void pop() {
		if(top == -1) {
			System.out.print("Empty list");
			return;
		}
		
		int elementToBeDeleted = stack[top];
		stack[top] = 0;
		--top;
		
		//Delete the corresponding element in the minimum list
		int indexInMinList = minList.indexOf(elementToBeDeleted);
		minList.remove(indexInMinList);
	}
	
	public void display() {
		for(int i=sizeOfStack -1; i>=0; i--) {
			if(stack[i] != 0) {
				System.out.print(stack[i] + "\t");
			}
		}
		System.out.print("\nMinimum  =  " + minList.get(0));
		System.out.print("\n______________________________\n");
	}
	
	public static void main(String[] args) {
		Question2 stack = new Question2(4);
		stack.push(2);		
		stack.push(3);		
		stack.push(1);
		stack.display();
		
		stack.pop();
		stack.display();
	}
	
}