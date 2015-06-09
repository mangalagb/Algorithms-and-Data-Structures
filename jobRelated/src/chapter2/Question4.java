package chapter2;

public class Question4
{	
	private int listCount;
	private Node head;
	
	public Question4()
	{
		head = new Node(null);
		listCount =0;
	}
	
	private class Node
	{
		Object data;
		Node next;
		
		public Node(Object o)
		{
			data = o;
			next = null;
		}
		
		public Node getNext()
		{
			return next;
		}
		public void setNext(Node n)
		{
			next = n;
		}
		public Object getData()
		{
			return data;
		}
		public void setData(Object i)
		{
			data = i;
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
		System.out.println("\n------------------------------------");
	}
	
	public void add(int num1, int num2)
	{
		int y = num1+num2;
		
		String stringResult = Integer.toString(y);
		
		Node current = head;
		
		for(int i=stringResult.length()-1; i>=0; i--)
		{
			Object o = stringResult.charAt(i);
			Node temp = new Node(o);
			current.setNext(temp);
			listCount ++;
			current = current.getNext();
		}
		
		
	}
	
	public int getNumber()
	{
		Node current = head.getNext();
		String temp = "";
		
		while(current != null)
		{
			temp = temp.concat(current.getData().toString());
			current = current.getNext();
		}
		
		int number = Integer.parseInt(temp);
		int reverse=0;
		
		
		while(number !=0)
		{
			int lastDigit = number %10;
			reverse = reverse*10 + lastDigit;
			number = number/10;
			
		}
		
		return reverse;
	}
	
	public static void main(String[] args)
	{
		Question4 num1 = new Question4();
		num1.addToEnd(3);
		num1.addToEnd(1);
		num1.addToEnd(5);
		num1.displayList();
		
		Question4 num2 = new Question4();
		num2.addToEnd(3);
		num2.addToEnd(9);
		num2.addToEnd(2);
		num2.displayList();
		
		
		
		Question4 result = new Question4();
		result.add(num1.getNumber(), num2.getNumber());
		result.displayList();
		
	}
}