import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedList {
	Node head;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int d) {
			data = d;
			next = null;
			prev = null;
		}
	}

	public void display() {
		Node n = head;
		while (n != null) {
			System.out.println("Data at the current node is " + n.data);
			n = n.next;
		}
	}

	public void insertBeforeHead(Node newnode) {
		head.prev = newnode;
		newnode.next = head;
		head = newnode;
		newnode.prev = null;
	}

	public void insertAfterAnyNode(Node newnode, Node givennode) {
		if (head == null) {
			head = newnode;
			return;
		}
	}

	public void deleteNode(Node givennode) {
		if (head == null) {
			return;
		}
		if (head == givennode) {
			head.next.prev = null;
			head.next = head;
		}
		Node curr = head;
		while (curr != givennode && curr != null) {
			curr = curr.next;
		}
		if (curr.next != null) {
			curr.next.prev = curr.prev;
		}
		curr.prev.next = curr.next;
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList d1 = new DoublyLinkedList();
		d1.head = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);

		d1.head.next = n2;
		// d1.head.prev = n6;
		d1.head.prev = null;

		n2.next = n3;
		n2.prev = d1.head;

		n3.next = n4;
		n3.prev = n2;

		n4.next = n5;
		n4.prev = n3;

		n5.next = n6;
		n5.prev = n4;

		n6.next = null;
		// n6.next = head;
		n6.prev = n5;

		Node newNode = new Node(70);
		int k = 50;

		// System.out.println("\nBefore Deletion\n");
		// d1.display();
		// d1.deleteNode(n3);
		// System.out.println("\nAfter Deletion\n");
		// d1.display();

		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();

		doTimings("ArrayList", arrayList);
		doTimings("LinkedList", linkedList);

	}

	public static void doTimings(String type, List<Integer> list) {

		for (int i = 0; i <= 1E5; i++) {
			list.add(i);
		}

		long start = System.currentTimeMillis();

		// Remove items from the list
		// list.remove(1E5);

		// Add items at the end of list
		/*
		 * for (int i = 0; i <= 1E5; i++) { list.add(i); }
		 */

		// Add items to the beginning of the list
		/*
		 * for (int i = 0; i <= 1E5; i++) { list.add(0, i); }
		 */

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start) + "ms by " + type);
	}

}
