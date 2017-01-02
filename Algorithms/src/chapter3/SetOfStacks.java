package chapter3;

/*Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks push() and SetOfStacks pop() should behave identically to a single stack 
 * ie. that is, pop() should return the same values as it would if there were just a single stack. 
 * */

public class SetOfStacks{
	private int totalSizeOfSetOfStacks = 4;
	private int sizeOfIndividualStack = 2;	
	private int numberOfStacksNeeded = totalSizeOfSetOfStacks / sizeOfIndividualStack;
	private int pointerToCurrentStack = -1;
	
	Stack[] setOfStacks = new Stack[numberOfStacksNeeded];
	
	public void pushSetOfStacks(int data) {
		//Initialize first mini stack
		if(pointerToCurrentStack == -1) {
			setOfStacks[0] = new Stack();
			pointerToCurrentStack++;
			
			setOfStacks[0].push(data);
		}else {
			pushSetOfStacksHelper(pointerToCurrentStack, data);
		}
	}
	
	private void pushSetOfStacksHelper(int currentStackPointer, int data) {
		if(setOfStacks[currentStackPointer].isWithinCapacity()) {
			setOfStacks[currentStackPointer].push(data);
		}else {
			currentStackPointer++;
			pointerToCurrentStack++;
			if(pointerToCurrentStack < numberOfStacksNeeded) {
				setOfStacks[currentStackPointer] = new Stack();
				setOfStacks[currentStackPointer].push(data);
			}else {
				System.out.print("\nError. Maximum stack capacity exceeded.\n");
				return;
			}
		}
	}
	
	public void displaySetOfStacks() {
		if(pointerToCurrentStack == -1) {
			System.out.print("Empty set of stacks.\n");
			return;
		}
		
		for(int i=pointerToCurrentStack; i>=0; i--) {
			setOfStacks[i].display();
		}
		System.out.print("\n__________________________________________________________\n");
	}
	
	public void popElementFromSetOfStacks() {
		int result = setOfStacks[pointerToCurrentStack].pop();
		if(setOfStacks[pointerToCurrentStack].isEmpty()) {
			pointerToCurrentStack--;
		}
	}
	
	public class Stack{
		public class Node{
			Node next;
			int data;
			
			public Node(int i) {
				data = i;
				next = null;
			}
		}
		
		Node top;
		int capacity;
		public Stack() {
			top = null;
			capacity = 0;
		}
		
		public boolean isEmpty() {
			if(capacity == 0) {
				return true;
			}
			return false;
		}
		
		public boolean isWithinCapacity() {
			if(capacity < sizeOfIndividualStack) {
				return true;
			}
			return false;
		}
		
		public int push(int i) {
			if(isWithinCapacity()) {
				Node newNode = new Node(i);
				if(top == null) {
					top = newNode;
				}else {
					newNode.next = top;
					top = newNode;
				}
				capacity++;
				return 0;
			}
			return -1;
		}
		
		public int pop() {
			if(top == null) {
				return -1;	
			}			
			Node node = top;
			top = top.next;
			capacity--;
			return node.data;
		}
		
		public void display() {
			if(top == null) {
				System.out.print("Empty list.");
				return;
			}
			
			Node current = top;
			while(current != null) {
				System.out.print(current.data + "\t");
				current = current.next;
			}
		}
	}

	public static void main(String[] args) {
		SetOfStacks setofStacks = new SetOfStacks();
		setofStacks.pushSetOfStacks(1);
		setofStacks.pushSetOfStacks(2);		
		setofStacks.pushSetOfStacks(3);		
		setofStacks.displaySetOfStacks();
		
		setofStacks.popElementFromSetOfStacks();
		setofStacks.displaySetOfStacks();
		
		setofStacks.popElementFromSetOfStacks();
		setofStacks.displaySetOfStacks();
		
		setofStacks.popElementFromSetOfStacks();
		setofStacks.displaySetOfStacks();
				
	}
}
