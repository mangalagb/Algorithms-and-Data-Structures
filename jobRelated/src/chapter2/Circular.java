package chapter2;

public class Circular
{
	
	Link head;
	Link tail;
	int listCount;
	
	public Circular()
	{
		head = null;
		tail = null;
		listCount = 0;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public void insertFront(Object o)
	{
		Link newLink = new Link(o);
		newLink.next = head;
		
		if(isEmpty())
		{
			head = newLink;
			newLink.next = head;
			tail = newLink;
		}
		else
		{
			tail.next = newLink;
			head = newLink;
		}
		listCount++;	
	}
	
	public void displayList()
	{
		Link current = head;
		
		if(isEmpty())
		{
			System.out.println("Empty list");
			return;
		}
		else if(head.next == head)
		{
			System.out.print(head.data+ "->"+current.data+ "\n");
			return;
		}
		
		else
		{
			System.out.print(head.data+" -> ");
			//current = head.next;
			
			while(current.next != head)
			{
				current = current.next;
				System.out.print(current.data+" -> ");
				
			}
			System.out.print(head.data);
			 
		}
		System.out.println("\n____________________________\n");
	}
	
    public void display()
    {
        System.out.print("\nCircular Singly Linked List = ");
        Link ptr = head;
        if (listCount == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (head.next == head) 
        {
            System.out.print(head.data+ "->"+ptr.data+ "\n");
            return;
        }
        System.out.print(head.data+ "->");
        ptr = head.next;
        while (ptr.next != head) 
        {
            System.out.print(ptr.data+ "->");
            ptr = ptr.next;
        }
        System.out.print(ptr.data+ "->");
        ptr = ptr.next;
        System.out.print(ptr.data+ "\n");
    }

	
	public static void main(String[] args)
	{
		Circular c = new Circular();
		c.insertFront(4);
		c.insertFront(9);
		c.displayList();
		//c.display();
	}
}

class Link
{
	Object data;
	Link next;
	
	public Link(Object o)
	{
		data = o;
		//next = null;
	}
	
	public Link(Object o, Link n)
	{
		data = o;
		next = n;
	}
	
	public void displayLink()
	{
		System.out.print(data +"  -> ");
	}
}