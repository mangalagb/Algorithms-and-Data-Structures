package chapter3;

class Stack
{
	Node top;
	
	public void push(Object o)
	{
		Node newNode = new Node(o);
		newNode.next = top;
		top = newNode;
	}
	
	public Object pop()
	{
		if(top != null)
		{
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	public boolean isEmpty()
	{
		return (top == null);
	}
	
	public static void main(String[] args)
	{
		Stack sta = new Stack();
		sta.push(1);
		sta.push(2);
		
		while(!sta.isEmpty())
		{
			System.out.println(sta.pop());
		}
	}
}

class Node
{
	Node next;
	Object data;
	
	public Node(Object o)
	{
		this.next = null;
		this.data = o;
	}
}