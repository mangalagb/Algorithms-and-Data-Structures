package chapter2;

public class Circular{
	public class Node{
		Node next;
		int data;
		boolean isPrinted;
		
		public Node(int data){
			this.data = data;
			next = null;
			isPrinted = false;
		}
	}
	
	Node head = null;
	
	public void createNodes(){
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
		
		//loop
		node8.next = node1;
	}
	
	public void display(){
		Node current = head;
		if(current == null){
			System.out.println("Empty");
			return;
		}
		
		while(current != null && !current.isPrinted == true){
			System.out.print(current.data + "\t");
			current.isPrinted = true;
			current = current.next;			
		}
		
		//clear the visited for next time
		current = head;
		while(current != null && current.isPrinted == true){
			current.isPrinted = false;
			current = current.next;
		}
		System.out.println("\n_______________________________________________________________\n");
	}
	
	public Node detectLoop(){
		Node fast = head;
		Node slow = head;
		
		while(slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				return slow;
			}
		}
		return null;
	}
	
	public void findLoopStart(Node loopBegin){
		Node current  = head;
		while(true){
			if(current == loopBegin){
				System.out.println("Loop begins at " + current.data);
				return;
			}
			current = current.next;
			loopBegin =loopBegin.next;
		}
	}
	
	public Node delete(int nodeToDeleteData){
		if(head == null){
			System.out.println("Empty");
			return null;
		}
		
		//Assume that you give valid values only
		Node cur = head;
		Node prev = null;
		Node deletedNode = null;
		
		while(true){
			if(cur.data == nodeToDeleteData){
				break;
			}
			prev = cur;
			cur = cur.next;
		}
		
		deletedNode = cur;
		if(cur == head){
			//Check if it is the only node in the list
			if(cur.next == null){				
				head = null;
			}else{
				//move prev until it reaches the last node.
				prev = cur;
				while(prev.next != cur){
					prev = prev.next;
				}
				head = head.next;
				prev.next = head;
			}	
		}else if(cur.next == head){
			//If current is last node
			prev.next = head;
		}else{
			//Delete middle node
			Node next = cur.next;
			prev.next = next;			
		}
		deletedNode.next = null;
		return deletedNode;
	}
	
	public static void main(String[] args){
		Circular circular = new Circular();
		circular.createNodes();
		circular.display();
//		
//		Node result = circular.detectLoop();
//		if(result != null){
//			System.out.println("Loop detected");
//			circular.findLoopStart(result);
//		}else{
//			System.out.println("No Loop");
//		}
		
		circular.delete(8);
		circular.display();		
	}
}