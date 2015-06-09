package chapter3;

public class Question5 {
	Node top;
	
	class Node
	{
		Node next;
		int data;
		
		public Node(int o)
		{
			this.next = null;
			this.data = o;
		}
	}

	public void push(int o) {
		Node newNode = new Node(o);
		newNode.next = top;
		top = newNode;
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

	public int pop() {
		int item = top.data;
		top = top.next;
		return item;
	}

	public static void main(String[] args) {
		Question5 q = new Question5();
		q.push(7);
		q.push(4);
		q.push(9);
		q.push(10);
		q.displayStack();

	
	}
}