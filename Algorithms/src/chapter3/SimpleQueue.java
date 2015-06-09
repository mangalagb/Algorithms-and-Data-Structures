package chapter3;


class SimpleQueue
{
	class Node
	{
		Node next;
		int data;
		
		public Node(int o)
		{
			this.next = null;
			this.data = o;
		}
	}
	
	Node first;
	Node last;
	
	public SimpleQueue()
	{
		first = null;
		last = null;
	}
	
	public boolean isEmpty()
	{
		return (first == null);
	}
	
	public void enqueue(int i)
	{
		Node x = new Node(i);
		
		if(isEmpty())
		{
			first = x;
			last = x;
		}
		else
		{
			x.next = null;
			last.next = x;
			last = x;
		}
	}
	
	public Node dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Error. Empty Queue");
			return null;
		}
		else
		{
			Node n = first;
			first = first.next;
			return n;
		}
	}
	
	public void displayQueue()
	{
		String s = "";
		for (Node x = first; x != null; x = x.next)
			s += x.data + " ";
		
		System.out.println(s);
		System.out.println("______________________________________");

	}
	
	
	public static void main(String[] args)
	{
		SimpleQueue q = new SimpleQueue();
		q.enqueue(2);
		q.enqueue(5);
		q.enqueue(9);
		
		q.displayQueue();
		
		q.dequeue();
		q.displayQueue();
		
	}
}