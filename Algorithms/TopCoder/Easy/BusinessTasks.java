/*
Points : 500
A businessman has a number of equally important tasks which he must accomplish. 
To decide which of the tasks to perform first, he performs the following operation.

He writes down all his tasks in the form of a circular list, so the first task is adjacent to the last task. 
He then thinks of a positive number. This number is the random seed, which he calls n. 
Starting with the first task, he moves clockwise (from element 1 in the list to element 2 in the list and so on), 
counting from 1 to n. When his count reaches n, he removes that task from the list and starts counting 
from the next available task. He repeats this procedure until one task remains. It is this last task that he chooses to execute.

Given a list representing the tasks and an n, return the task which the businessman chooses to execute.

Examples
0) {"a","b","c","d"}
2
Returns: "a"
We start counting from a. So a is 1, b is 2. We remove b, so list is now {a,c,d}. We continue from c. So c is 1, d is 2.
We remove d, so list is now {a,c}. We continue from a. So a is 1, c is 2. We remove c, and now we are left with the last task a.
 
 
1) {"a","b","c","d","e"}
3
Returns: "d"
We start counting from a. So a is 1, b is 2, c is 3. We remove c, now list = {a,b,d,e}. We continue from d. 
So d is 1, e is 2, a is 3. We remove a, now list = {b,d,e}. We continue from b. So b is 1, d is 2, e is 3.
We remove e, now list = {b,d}. We continue from b. So b is 1, d is 2 and finally b is 3. We remove b, and 
now we are left with just one task d.


2) {"alpha","beta","gamma","delta","epsilon"}
1
Returns: "epsilon"


3) {"a","b"}
1000
Returns: "a"


4) {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t", "u","v","w","x","y","z"}
17
Returns: "n"


5) {"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp", "olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu", "qgcxjbfx","my","mlhy","bt","bo","q"}
9000000
Returns: "fxjqzznvg"
 */

package Easy;

import java.util.ArrayList;

public class BusinessTasks{
	class CircularList{
		class Node{
			String data;
			Node next;
			
			public Node(String data){
				this.data = data;
				next = null;
			}
		}
		
		Node head;
		int count;
		
		public CircularList(){
			head = null;
			count = 0;
		}
		
		private void insert(String data){
			if(head == null){
				head = new Node(data);
				head.next = head;
				count++;
			}else{
				Node newNode = new Node(data);
				Node current = head;
				
				while(current.next != head){
					current = current.next;
				}
				
				current.next = newNode;
				newNode.next = head;
				count++;
			}
		}
		
		private void display(){
			if(head == null){
				System.out.println("Empty list");
				return;
			}
			
			Node current = head;
			while(true){
				System.out.print(current.data + "\t");
				
				if(current.next == head){
					break;
				}else{
					current = current.next;
				}
			}			
			System.out.println("\n___________________________\n");
		}
		
		private String getElementAtIndex(int index){
			Node current = head;
			int counter = 1;
			while(true){
				if(counter == index){
					break;
				}else{
					current = current.next;
				}
				counter++;
			}
			return current.data;
		}
		
		private String remove(String data){
			if(head == null){
				System.out.println("Empty list");
				return "";
			}
			
			Node nodeToBeRemoved = null;
			
			//Remove head
			if(head.data == data){
				nodeToBeRemoved = head;
				if(head.next == head){
					head.next = null;
					head = null;
				}else{
					Node newHead = head.next;
					if(newHead.next == head){
						newHead.next = newHead;
						head = newHead;
					}else{
						Node current = newHead;
						while(true){
							if(current.next == head){
								break;
							}else{
								current = current.next;
							}
						}
						current.next = newHead;						
						head = newHead;
					}
				}
			}else{
				
				//Remove middle
				Node current = head;
				while(true){
					if(current.next.data == data){
						nodeToBeRemoved = current.next;
						break;
					}else{
						current = current.next;
					}
				}
				Node next = current.next;
				current.next = next.next;
				head = next.next;
				//System.out.println("done");
			}
			count--;
			return nodeToBeRemoved.data;
		}
	}
	
	private CircularList createCircularList(ArrayList<String> values){
		CircularList list = new CircularList();		
		for(String value : values){
			list.insert(value);
		}
		return list;
	}

	
	public String getTask(String[] list, int n){
		ArrayList<String> valuesInList= new ArrayList<String>();		
		for(String value : list){
			valuesInList.add(value);
		}
		
		//Create list
		CircularList circularList = createCircularList(valuesInList);
		
		while(circularList.count > 1){
			String elementToRemove = circularList.getElementAtIndex(n);
			circularList.remove(elementToRemove);
		}
		String result = circularList.getElementAtIndex(1);
		return result;
	}
	
	public static void main(String[] args){
		BusinessTasks businessTask = new BusinessTasks();		
		String[] values = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t", "u","v","w","x","y","z"};
		int n = 17;
		System.out.println(businessTask.getTask(values , n));
	}
}