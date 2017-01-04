package chapter3;

class Stack {
	Node top;

	public void push(Object o) {
		Node newNode = new Node(o);
		newNode.next = top;
		top = newNode;
	}

	public Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	public boolean isEmpty() {
		return (top == null);
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}

class Node {
	Node next;
	Object data;

	public Node(Object o) {
		this.next = null;
		this.data = o;
	}
}