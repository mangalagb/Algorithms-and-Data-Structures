package chapter2;

public class DoubleLinkedList{
	public class Node{
		int data;
		Node previous;
		Node next;
		
		public Node(int i) {
			data = i;
			previous = null;
			next = null;
		}
		
		public void displayNode() {
			System.out.print(data + "\t");
		}
	}
	
	Node first;
	Node last;
	int count;
	
	public DoubleLinkedList() {
		first = null;
		last = null;
		count = 0;
	}
	
	public void insertFirst(int i) {
		Node newNode = new Node(i);
		Node current = first;
		
		if(current == null) {
			first = newNode;
			last = newNode;
			count++;
		}else {
			newNode.next = current;
			current.previous = newNode;
			first = newNode;
			++count;
		}
	}
	
	public void insertLast(int i) {
		Node newNode = new Node(i);
		Node current = last;
		
		if(current == null) {
			first = newNode;
			last = newNode;
			++count;
		}else {
			newNode.previous = last;
			last.next = newNode;
			last = newNode;
			count++;
		}
	}
	
	public int insertAtIndex(int index, int data) {
		Node newNode = new Node(data);
		Node current = first;
		
		if(index > count) {
			System.out.print("Error. No such index\n");
			return -1;
		}
		
		//Insert first
		if(index == 0) {
			if(first != null) {
				first.previous = newNode;
				newNode.next = first;
				first= newNode;
			}else {
				first = newNode;
				last =  newNode;
			}
			++count;
			return 0;
		}
		
		for(int i=0; i<index; i++) {
			if(current.next != null) {
				current = current.next;
			}else {
				System.out.print("Error. No such index\n");
				return -1;
			}
		}
		
		if(current == last) {
			newNode.previous = last;
			last.next = newNode;
			last = newNode;
			count++;
		}else {
			Node previous = current.previous;
			previous.next = newNode;
			newNode.previous = previous;
			newNode.next = current;
			current.previous = newNode;
			++count;
		}
		return 0;
	}
	
	public void display() {
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.print("\n____________________________________\n");
	}
	
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.insertFirst(3);
		list.insertFirst(2);
		list.insertFirst(1);
		//list.display();
		
		list.insertLast(8);
		//list.insertLast(7);
		//list.insertLast(6);
		list.display();
		
		list.insertAtIndex(1, 9);
		list.display();
	}
}