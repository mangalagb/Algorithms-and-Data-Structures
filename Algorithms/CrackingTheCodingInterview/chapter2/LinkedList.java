package chapter2;

class LinkedList{
	public class Node{
		Node next;
		int data;
		
		public Node(int i){
			data = i;
			next = null;
		}
	}
	
	Node head;
	int count;
	
	public LinkedList(){
		head = null;
		count = 0;
	}
	
	public void insert(int data){
		if(head == null){
			head = new Node(data);
		}else{
			Node current = head;
			Node newNode = new Node(data);
			while(current.next != null){
				current = current.next;
			}
			current.next = newNode;
		}
		count++;
	}
	
	/*
	 * Reverse a linked list
	 */
	public void reverseIterative(){
		Node previous = null;
		Node next = null;
		Node current = head;
		
		while(current != null){
			next = current.next;
			current.next = previous;
			
			previous = current;
			current = next;
		}
		head = previous;
	}
	
	public void insertFirst(int data){
		if(head == null){
			head = new Node(data);
		}else{
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
		count++;
	}
	
	public int insertAtIndex(int index, int data){
		Node newNode = new Node(data);
		if(index == 0){
			if(head == null){
				head = newNode;
			}else{
				newNode.next = head;
				head = newNode;
			}
			count++;
			return 0;
		}else if(index > count){
			System.out.println("No such index");
			return -1;
		}else{
			Node current = head;
			for(int i=0;i<index-1;i++){
				if(current == null){
					System.out.println("No such index");
					return -1;
				}
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			count++;
			return 0;
		}
	}
	
	public int getDataAtIndex(int index){
		if(head == null){
			System.out.println("Empty list");
			return -1;
		}else if(index >= count ){
			System.out.println("No such index");
			return -1;
		}else{
			Node current = head;
			for(int i=0; i<index;i++){
				if(current == null){
					System.out.println("No such index");
					return -1;
				}
				current = current.next;
			}
			return current.data;
		}
	}

	public Node removeNodeAtIndex(int index){
		if(head == null){
			System.out.println("Empty list");
			return null;
		}else if(index >= count ){
			System.out.println("No such index");
			return null;
		}else if(index == 0 && (head.next == null || count==1)){
			Node nodeToBeReturned = head;
			head = null;
			return nodeToBeReturned;
		}else{
			Node current = head;
			for(int i=0; i<index-1;i++){
				if(current == null){
					System.out.println("No such index");
					return null;
				}
				current = current.next;
			}
			Node nodeToBeReturned = current.next;
			current.next = current.next.next;
			return nodeToBeReturned;
		}
	}
		
	public void display(){
		if(head == null){
			System.out.println("Empty list");
		}else{
			Node current = head;
			System.out.print(current.data + "\t");
			while(current.next != null){
				current = current.next;
				System.out.print(current.data + "\t");
			}
			System.out.println("\n________________________________________\n");
		}
	}
	
	public int getListCount() {
		return count;
	}
	
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insertFirst(19);
		list.insertAtIndex(0, 23);
		list.display();
		
		System.out.println(list.getDataAtIndex(2));
		
		Node deletedNode = list.removeNodeAtIndex(3);
		if(deletedNode != null){
			System.out.println(deletedNode.data);
		}
		
		list.display();
	}
}