package chapter2;

public class DoubleLinkedList
{
	private Node first;
	private Node last;
	private int listCount;
	
	public DoubleLinkedList()
	{
		first = null;
		last = null;
		listCount = 0;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public void insertFirst(Object o)
	{
		Node newNode = new Node(o);
		
		if(isEmpty())
			last = newNode;
		else
			{	first.previous = newNode;
				newNode.next = first;		}
		
		first = newNode;
		listCount++;
	}
	
	public void insertLast(Object i)
	{
		Node newNode = new Node(i);
		
		if(isEmpty())
			first = newNode;
		else
		{
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
		listCount++;
	}
	
	public boolean insertAfter(Object key, Object i)
	{
		Node newNode = new Node(i);
		
		Node current = first;
		
		while(current.data != key)
		{
			current = current.next;
			if(current == null)
			{
				return false;
			}
		}
		
		if(current == last)
		{
			newNode.next = null;
			last = newNode;
		}
		else
		{
			newNode.next = current.next;
			current.next.previous = newNode;
		}
		
		newNode.previous = current;
		current.next = newNode;
		listCount++;
		return true;
	}
	
	public Node deleteFirst()
	{
		Node temp = first;
		
		if(first.next == null)
			last = null;
		else
			first.next.previous = null;
		
		first = first.next;
		listCount--;
		return temp;
	}
	
	public Node deleteLast()
	{
		Node temp = last;
		
		if(last.previous == null)
			first = null;
		else
			last.previous.next = null;
		
		last = last.previous;
		listCount--;
		return temp;
	}
	
	public Node deleteKey(Object key)
	{
		Node current = first;
		
		while(current.data != key)
		{
			current = current.next;
			if(current == null)
				return null;
		}
		
		if(current == first)
			first = current.next;
		else
			current.previous.next = current.next;
		
		if(current == last)
			last = current.previous;
		else
			current.next.previous = current.previous;
		
		listCount--;
		return current;
	}
	
	public void displayList()
	{
		Node current = first;
		
		while(current != null)
		{
			current.displayNode();
			current = current.next;
		}
		System.out.println("\n-------------------------------------\n");
	}
	
	public static void main(String[] args)
	{
		DoubleLinkedList dl = new DoubleLinkedList();
		dl.insertFirst(5);
		dl.insertFirst(3);
		dl.insertFirst(2);
		dl.displayList();
		
		dl.insertLast(4);
		dl.insertLast(12);
		dl.displayList();
		
		dl.deleteFirst();
		dl.displayList();
		
		dl.deleteLast();
		dl.displayList();
		
		dl.insertAfter(5, 10);
		dl.displayList();
		
		dl.insertAfter(4, 6);
		dl.displayList();
		
		dl.deleteKey(10);
		dl.displayList();
		
	}
}

class Node
{
	Node previous;
	Node next;
	Object data;
	
	public Node(Object o)
	{
		data = o;
	}
	
	public void displayNode()
	{
		System.out.print(data+"\t");
	}
}