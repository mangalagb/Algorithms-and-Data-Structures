/*
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to 
an earlier node, so as to make a loop in the linked list.
EXAMPLE
input: A -> B -> C -> D -> E -> C [the same C as earlier]
output: C
 */
package chapter2;

public class Question5 {

	Item head;
	// Item tail;
	int listCount;

	public Question5() {
		head = null;
		// tail = null;
		listCount = 0;
	}

	
	public void newList() {
		Item x = new Item("A");
		Item y = new Item("B");
		Item z = new Item("C");
		Item m = new Item("D");
		Item n = new Item("E");

		head = x;
		// tail = ;

		x.next = y;
		y.next = z;
		z.next = m;
		m.next = n;
		n.next = z;

		listCount = 5;
	}

	public void determineLoop() {
		Item loop = head;
		Item counter = head.next;

		for (int i = 0; i < listCount; i++, loop = loop.next) {
			for (int y = 0; y < listCount; y++, counter = counter.next) {

				if (loop == counter) {
					System.out.println("Loop is : " + loop.data);
					return;
				}
			}

		}
		// System.out.println("Loop is : "+loop.data);
	}

	public void displayList() {
		Item current = head;

		if (head == null) {
			System.out.println("Empty list");
			return;
		} else if (head.next == head) {
			System.out.print(head.data + "->" + current.data + "\n");
			return;
		}

		else {
			System.out.print(head.data + " -> ");
			// current = head.next;

			while (current.next != head) {
				current = current.next;
				System.out.print(current.data + " -> ");

			}
			System.out.print(head.data);

		}
		System.out.println("\n____________________________\n");
	}

	public static void main(String[] args) {
		Question5 c = new Question5();

		c.newList();
		c.determineLoop();
	}
}

class Item {
	Object data;
	Item next;

	public Item(Object o) {
		data = o;
		// next = null;
	}

	public Item(Object o, Item n) {
		data = o;
		next = n;
	}

	public void displayItem() {
		System.out.print(data + "  -> ");
	}
}