/*
 * Imagine a (literal) stack of plates. If the stack gets too high, 
 * it might topple. Therefore, in real life, we would likely start a 
 * new stack when the previous stack exceeds some threshold. Implement 
 * a data structure SetOfStacks that mimics this. SetOfStacks should be 
 * composed of several stacks, and should create a new stack once the
 *  previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() 
 *  should behave identically to a single stack (that is, pop() should 
 *  return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
package chapter3;

public class Question3{
	private int numberOfStacks = 3;
	private int sizeOfStack = 2;
	private int totalNumberOfElements = numberOfStacks * sizeOfStack;
	
	int[] stackArray = new int[totalNumberOfElements];
	
	//Stack1
	int top1 = -1;
	int top1End = top1 + sizeOfStack;
	int top1Start = top1 + 1;
	
	//Stack2
	int top2 = top1 + sizeOfStack;;
	int top2End = top2 + sizeOfStack; 
	int top2Start = top2 + 1;
	
	//Stack3
	int top3 = top2 + sizeOfStack;
	int top3End = top3 + sizeOfStack; 
	int top3Start = top3 + 1;
	
	public void push(int stackNumber, int data) {
		if(stackNumber == 1) {
			if(top1 < top1End) {
				stackArray[++top1] = data;
			}else {
				System.out.print("\nError. Stack 1 is full\n");
			}			
		}else if(stackNumber == 2) {
			if(top2 < top2End) {
				stackArray[++top2] = data;
			}else {
				System.out.print("\nError. Stack 2 is full\n");
			}
		}else if(stackNumber == 3) {
			if(top3 < top3End) {
				stackArray[++top3] = data;
			}else {
				System.out.print("\nError. Stack 3 is full\n");
			}
		}
		
	}
	
	/*
	 * This is the follow up POP
	 */
	public void pop(int stackNumber) {
		if(stackNumber == 1) {
			if(top1 >= top1Start) {
				stackArray[top1] = 0;
				--top1;
			}
		}else if(stackNumber == 2) {
			if(top2 >= top2Start) {
				stackArray[top2] = 0;
				--top2;
			}
		}else if(stackNumber == 3) {
			if(top3 >= top3Start) {
				stackArray[top3] = 0;
				--top3;
			}
		}
	}
	
	public void display() {
		for(int i=0; i< totalNumberOfElements; i++) {
			System.out.print(stackArray[i] + "\t");
		}
		System.out.print("\n__________________________________________________________\n");
	}
	
	public static void main(String[] args) {
		Question3 setOfStacks = new Question3();
		setOfStacks.push(1, 1);
		
		setOfStacks.push(2, 3);
		setOfStacks.push(2, 4);
		
		setOfStacks.push(3, 8);
		
		setOfStacks.display();
		
		setOfStacks.pop(1);
		setOfStacks.pop(2);
		setOfStacks.display();
	}
}