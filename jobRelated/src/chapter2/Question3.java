package chapter2;

public class Question3
{
	private Node head;
	private int listCount;
	
	public Question3()
	{
		head = new Node(null);
		listCount=0;
	}
	
	private class Node
	{
		Object data;
		Node next;
		
		public Node(Object o)
		{
			next = null;
			data = o;
		}
		
		public void setData(Object o)
		{
			data = o;
		}
		public Object getData()
		{
			return data;
		}
		public Node getNext()
		{
			return next;
		}
		public void setNext(Node n)
		{
			next = n;
		}
	}

	public void addToEnd(Object o)
	{
		Node temp = new Node(o);
		Node current = head;
		
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		
		current.setNext(temp);
		listCount++;
	}
	
	public void displayList()
	{
		Node current = head.getNext();
		
		while(current != null)
		{
			System.out.print(current.getData()+"\t");
			current = current.getNext();
		}
		System.out.println("\n_____________________________");
	}
	
	public int sizeOfList()
	{
		return listCount;
	}
	
	
	public Node getNodeInLinkedList(Node target)
	{
		Node current = head.getNext();
		
		while(current != null)
		{
			if(current.getData() == target.getData())
				return current;
			else
			current = current.getNext();
		}
		return null;
		
	}
	
	
	public void deleteNode(Object o)
	{	
		//No duplicates allowed
		Node target = new Node(o);
		Node current = head;
		//Node previous;
		
		while(current.getNext() != null)
		{
			if(current.getNext().getData() == target.getData())
			{
				//current is the previous node
				break;
			}
			current = current.getNext();
		}
		
		current.setNext(current.getNext().getNext());
		listCount--;
		
	}
	
	public boolean deleteAllNodes(Object o)
	{	
		// Repetition of elements is allowed. All instances of
		//the node will be removed
		Node current = head;
		
		while(current.getNext() != null)
		{
			
			if(current.getData() == o)
				deleteNode(o);
			
			current= current.getNext();
		}
		return true;
	}
	
	public void deleteParticularNode(Object o)
	{
		
	}
	
	public static void main(String[] args)
	{
		Question3 q = new Question3();
		
		q.addToEnd(1);
		q.addToEnd(2);
		q.addToEnd(3);
		q.addToEnd(4);
		q.addToEnd(5);
		
		q.displayList();
		
		
		//q.deleteNode(4);
		//q.deleteNode(1);
		
		q.deleteAllNodes(4);
		
		//q.run(4);
	
		q.displayList();
		
	}
	
}