package chapter3;

public class Queue{
	public class Node{
		Node next;
		int data;
		
		public Node(int i) {
			data = i;
			next = null;
		}
	}
	
	Node first;
	Node last;
	
	public Queue() {
		first = null;
		last = null;
	}
	
	public void enqueue(int i) {
		Node newNode = new Node(i);
		
		if(last == null) {
			first = newNode;
			last = newNode;
		}else {
			last.next = newNode;
			last = newNode;
		}
	}
	
	public Node dequeue() {
		Node node = first;		
		if(node == null) {
			System.out.print("Empty queue\n");
			return null;
		}else if(first == last) {
			first = null;
			last = null;
		}else {				
			first = first.next;
		}
		return node;
	}
	
	public void display() {
		if(first == null) {
			System.out.print("Empty stack\n");
			return;
		}
		Node current = first;
		while(current != null) {
			System.out.print(current.data + "\t");
			current = current.next;
		}
		System.out.print("\n_______________________\n");
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.display();
		
		queue.dequeue();
		queue.dequeue();
		queue.display();
	}
}