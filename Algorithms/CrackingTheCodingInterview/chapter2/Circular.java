package chapter2;

public class Circular{
	public class Node{
		Node next;
		int data;
		boolean isPrinted;
		
		public Node(int i){
			data = i;
			next = null;
			isPrinted = false;
		}
	}
	
	Node head;
	public Circular(){
		head = null;
	}
	
	public void initializeList(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		
		//Loop
		node8.next = node3;
	}
	
	public void display(){
		Node current = head;
		while(current != null && current.isPrinted == false){
			System.out.print(current.data + "\t");
			current.isPrinted = true;
			current = current.next;
		}
		System.out.print("\n_______________________________________________________________\n");
	}
	
	public Node detectLoop(){
		Node slow = head;
		Node fast = head;
		
		while(slow != null && fast!= null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				return slow;
			}
		}
		return null;
	}
	
	public Node determineStartingPointOfLoop(Node loopMeetingPoint){
		Node current = head;
		while(true){
			if(current == loopMeetingPoint){
				return loopMeetingPoint;
			}
			loopMeetingPoint = loopMeetingPoint.next;
			current = current.next;
		}
	}
	
	public static void main(String[] args){
		Circular circular = new Circular();
		circular.initializeList();
		circular.display();
		
		Node loopMeetingPoint = circular.detectLoop();
		if(loopMeetingPoint != null){
			System.out.println("Contains loop");
		}else{
			System.out.println("No loop");
		}
		
		if(loopMeetingPoint != null){
			Node loopStart = circular.determineStartingPointOfLoop(loopMeetingPoint);
			System.out.println("\nLoop start : "+ loopStart.data);
		}
	}
}