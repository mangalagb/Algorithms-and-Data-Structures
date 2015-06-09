package chapter2;


public class Question2
{
	private Node head;
	private int listCount;
	
	public Question2()
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
	
	public Node returnNodeAtIndex(int index)
	{
		Node current = head.getNext();
		
		for(int i=0; i<index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		
		return current;
		
		
	}
	
	public void nthToLast(int n)
	{
		//System.out.println(sizeOfList());
		int index = sizeOfList() - n ;
		
		Node node = returnNodeAtIndex(index);
		
		System.out.println("Node at index "+ n +"(from last) : "+node.getData() );
	}
	
	public static void main(String[] args)
	{
		Question2 q = new Question2();
		
		q.addToEnd(1);
		q.addToEnd(2);
		q.addToEnd(3);
		q.addToEnd(4);
		q.addToEnd(5);
		
		q.displayList();
		
		q.nthToLast(3);
		q.nthToLast(1);
	}
	
	
	
}