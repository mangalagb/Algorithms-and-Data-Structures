package chapter2;

public class Question1
{
	private Node head;
	private int listCount;
	
	public Question1() {
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
	
	public Node getNodeAtIndex(int index)
	{
		Node current = head.getNext();
		
		for(int i=0; i<index;i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		
		return current;
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
	
	public boolean removeAtIndex(int index)
	{
		Node current = head;
		
		for(int i=0; i<index; i++)
		{
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		
		current.setNext(current.getNext().getNext());
		listCount--;
		return true;
	}
	
	public void removeDuplicate()
	{
			for(int i=0; i<getListCount();i++)
			{	
				Node current = getNodeAtIndex(i);
				
				for(int j=i+1; j<getListCount(); j++)
				{
					Node next = getNodeAtIndex(j);
					
					if(current.getData() == next.getData())
					{
						removeAtIndex(j);
						
					}
					
				}
			}
		
	}
	
	public static void main(String[] args) {
		
		Question1 q = new Question1();
		q.addToEnd(2);
		q.addToEnd(3);
		q.addToEnd(11);
		q.addToEnd(2);
		q.addToEnd(11);
		
		q.displayLinkedList();
		
		q.removeDuplicate();
		
		q.displayLinkedList();
		
	}

}