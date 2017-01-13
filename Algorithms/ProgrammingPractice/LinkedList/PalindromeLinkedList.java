package LinkedList;

//Check if a Singly Linked List is Palindrome in a single iteration.

//We first find the middle of the list in a single pass. O(n).
//Then, starting from the middle store the elements in a stack or Arraylist(insert at index 0. so you'll get a reverse list).
//Iterate through the Arraylist and check with current node.
//Break when current node equals middle.

import java.util.ArrayList;

public class PalindromeLinkedList {
	public class Node {
		Node next;
		int data;

		public Node(int i) {
			data = i;
			next = null;
		}
	}

	Node head = null;
	Node middle = null;

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	public Node getNode(int i) {
		if (head == null) {
			System.out.print("empty");
			return null;
		}
		int counter = 0;
		Node current = head;
		while (current != null) {
			if (counter == i) {
				break;
			} else {
				current = current.next;
				counter++;
			}
		}
		return current;
	}

	public void display() {
		if (head == null) {
			System.out.print("empty");
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.print(current.data + "\t");
			current = current.next;
		}
		System.out.print("\n");
	}

	public void findMiddleOfList() {
		int counter1 = 0;
		Node current = head;
		middle = head;
		while (current != null) {
			counter1++;
			current = current.next;
			if (counter1 % 2 == 0) {
				middle = middle.next;
			}
		}
	}

	public ArrayList<Integer> reverseListFromMiddle() {
		Node current = middle;
		ArrayList<Integer> halfList = new ArrayList<Integer>();
		
		while (current != null) {
			halfList.add(0,current.data);
			current = current.next;
		}
		return halfList;
	}

	public int compareList() {
		ArrayList<Integer> secondHalfOfList = reverseListFromMiddle();
		int counter = 0;
		
		Node current = head;
		while(current != null){
			if(current == middle){
				break;
			}
			
			if(!(secondHalfOfList.get(counter) == current.data)){
				return -1;
			}
			counter++;
			current = current.next;
		}
		return 0;
	}
	
	public int checkIfPalindrome() {
		findMiddleOfList();
		int result = compareList();
		return result;
	}
	
	public static void main(String[] args){
		PalindromeLinkedList list = new PalindromeLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(3);
		list.insertAtEnd(2);
		list.insertAtEnd(1);
		list.display();
		
		System.out.println(list.checkIfPalindrome());
	}

}
