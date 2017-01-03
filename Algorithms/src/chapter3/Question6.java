package chapter3;

import java.util.ArrayList;
/*
 *Write a program to sort a stack in ascending order. You should not 
 * make any assumptions about how the stack is implemented.
 * The following are the only functions that should be used 
 * to write this program: push | pop | peek | isEmpty.
 */

class Question6 {
	class Node {
		Node next;
		int data;

		public Node(int data) {
			this.next = null;
			this.data = data;
		}
	}
	
	Node top;
	
	public Question6() {
		top = null;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		if(top == null) {
			top = newNode;
			return;
		}
		
		newNode.next = top;
		top = newNode;
	}

	public int pop() {
		if (top != null) {
			int item = top.data;
			top = top.next;
			return item;
		}else {
			System.out.print("Empty list\n");
			return -1;
		}
	}

	public boolean isEmpty() {
		if(top == null) {
			return true;
		}
		return false;
	}
	
	public void display() {
		Node current = top;
		if(current == null) {
			System.out.print("Empty list\n");
			return;
		}
		
		while(current != null) {
			System.out.print(current.data + "\t");
			current = current.next;
		}
		System.out.print("\n_____________________________________________\n");
	}

	public int peek() {
		if(top == null) {
			System.out.print("Empty list");
			return -1;
		}	
		return top.data;
	}
	
	public Question6 sortStack() {
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		while(!isEmpty()) {
			int item = pop();
			if(sortedList.isEmpty()) {
				sortedList.add(item);
			}else if(sortedList.get(0) > item) {
				sortedList.add(0, item);
			}else {
				
				int index = -1;
				for(int i=0; i<sortedList.size(); i++) {
					if(item < sortedList.get(i)) {
						index = i;
						break;
					}
				}
				sortedList.add(index, item);
			}
		}
		
		Question6 sortedStack = new Question6();
		for(int i=sortedList.size()-1; i>=0; i--) {
			sortedStack.push(sortedList.get(i));
		}
		
		return sortedStack;
	}
	
	public static void main(String[] args) {
		Question6 stack = new Question6();
		stack.push(6);
		stack.push(3);
		stack.push(1);
		stack.push(2);
		stack.push(11);
		stack.display();
		
		Question6 sortedStack = stack.sortStack();
		sortedStack.display();
		
	}
}