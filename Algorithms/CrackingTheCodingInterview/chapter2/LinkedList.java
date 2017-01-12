package chapter2;

public class LinkedList {
	private Node head;
	private int listCount;
	
	public LinkedList() {
		head = new Node(null);
		listCount = 0;
	}
	
	private class Node {
		Node next;
		Object data;

		public Node(Object i) {
			next = null;
			data = i;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object i) {
			data = i;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node n) {
			next = n;
		}

	}

	public int getListCount() {
		return listCount;
	}

	public void addToEnd(Object data)
	{
		Node temp = new Node(data);
		Node current = head;
		
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		
		current.setNext(temp);
		listCount++;
	}
	
	public void displayLinkedList() {
		Node current = head.getNext();
		
		while(current != null)
		{
			System.out.print(current.getData()+"\t");
			current = current.getNext();
		}
		System.out.println("\n____________________________");
	}

	public void addToIndex(Object data, int index)
	{
		Node temp = new Node(data);
		Node current = head;
		
		for(int i=0; i<index && current.getNext() != null; i++)
		{
			current = current.getNext();
		}
		
		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}
	
	public Object getDataAtIndex(int index)
	{
		Node current = head.getNext();
		
		if(index < 0)
			return null;
		
		for(int i=0;i<index;i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		
		return(current.getData());
	}
	
	public boolean removeNodeAtIndex(int index)
	{
		Node current = head;
		
		for(int i =0; i<index; i++)
		{
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		
		current.setNext(current.getNext().getNext());
		listCount--;
		return true;
	}
	public static void main(String[] args) {
		LinkedList l = new LinkedList();

		l.addToEnd(9);
		l.addToEnd(5);
		l.addToEnd(2);
		l.displayLinkedList();
		
//		l.addToIndex(11, 1);
//		l.displayLinkedList();
//		
//		l.removeNodeAtIndex(3);
//		l.displayLinkedList();
//
//		System.out.println(l.getDataAtIndex(0));
//		
//		System.out.println("\n\nSize = " + l.getListCount());
		
		
	}
}