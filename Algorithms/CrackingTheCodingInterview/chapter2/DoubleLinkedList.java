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
	
	public int insertAfter(int data, int value) {
		Node current = first;
		Node newNode = new Node(value);
		if(current == null) {
			System.out.print("Error. Empty list");
			return -1;
		}
		
		while(current.next != null) {
			if(current.data == data) {
				break;
			}else {
				current = current.next;
			}
		}
		
		if(current == first) {
			first.next = newNode;
			newNode.previous = first;
		}else if(current == last) {
			last.next = newNode;
			newNode.previous = last;
			last = newNode;
		}else {
			newNode.previous = current;
			newNode.next = current.next;
			current.next.previous = newNode;
			current.next = newNode;
		}
		
		count++;
		return 0;
	}
	
	public int insertAtIndex(int index, int data) {
		if(index > count){
			System.out.println("No such index");
			return -1;
		}
		
		Node newNode = new Node(data);
		
		if(index == 0){
			if(first == null){
				first = newNode;
				last = newNode;				
			}else{
				newNode.next = first;
				first.previous = newNode;
				first = newNode;				
			}
		}else{
			Node current = first;
			for(int i=0; i<index; i++){
				if(current.next == null){
					System.out.println("No such index");
					return -1;
				}
				current = current.next;
			}
		
			Node previous = current.previous;			
			previous.next = newNode;
			newNode.previous = previous;
			current.previous = newNode;
			newNode.next = current;			
		}		
		count+= 1;
		return 0;
	}
	
	public Node removeAtIndex(int index) {
		if(index > count || first == null || last == null) {
			System.out.print("No such index or empty list\n");
			return null;
		}
		
		Node current = first;
		for(int i=0; i<index;i++) {
			if(current.next == null) {
				return null;
			}
			current = current.next;	
		}
		
		Node nodeToBeDeleted = current;
		
		if(current == first) {
			if(first.next == null) {
				first = null;
				last = null;				
			}else {
				first.next.previous = null;
				first = first.next;
			}
		}else if (current == last) {
			last.previous.next = null;
			last = last.previous;
		}else {
			Node prev = current.previous;
			Node nex = current.next;
			prev.next = nex;
			nex.previous = prev;
		}	
		count--;
		return nodeToBeDeleted;
	}
	
	public void display() {
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.print("\n_____________________________________________\n");
	}
	
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);
		//list.display();
		
		list.insertLast(8);
		//list.insertLast(7);
		//list.insertLast(6);
		//list.display();
		
		list.insertAtIndex(1, 9);
		list.display();
		
		list.insertAfter(3, 7);
		list.display();
		
	}
}