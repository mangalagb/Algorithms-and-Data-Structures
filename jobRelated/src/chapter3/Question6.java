package chapter3;

import java.util.ArrayList;
import java.util.Collections;

public class Question6 {
	Node top;

	class Node {
		Node next;
		int data;

		public Node(int o) {
			this.next = null;
			this.data = o;
		}
	}

	public void push(int o) {
		Node newNode = new Node(o);
		newNode.next = top;
		top = newNode;

	}

	public void storeReverse(Question6 stack1) {
		while (!isEmpty()) {
			pop();
		}

		for (Node x = stack1.top; x != null; x = x.next) {
			push(x.data);
		}
	}

	public int pop() {
		int item = top.data;
		top = top.next;
		return item;
	}

	public void POP() {
		// stack2.pop
	}

	public void PUSH() {
		// stack1.push
	}

	public int peek() {
		if (!isEmpty()) {
			int item = top.data;
			return item;
		}
		return -1;
	}

	public void displayStack() {

		String s = "";
		for (Node x = top; x != null; x = x.next)
			s += x.data + " ";

		System.out.println(s);
		System.out.println("______________________________________");

	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Question6 stack1 = new Question6();
		Question6 stack2 = new Question6();

		stack1.push(8);
		stack1.push(4);
		stack1.push(2);
		stack1.displayStack();

		stack2.storeReverse(stack1);
		// stack2.displayStack();

		stack2.pop();
		stack1.storeReverse(stack2);
		stack1.displayStack();

	}

}
