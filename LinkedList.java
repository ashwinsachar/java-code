public class LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void display() {
		Node n = head;
		while (n != null) {
			System.out.println("Data is " + n.data);
			n = n.next;
		}

	}

	public void pushBeforeHead(Node newNode) {
		newNode.next = head;
		head = newNode;
	}

	public void pushAfterLastNode(Node newNode) {
		// Check for empty List
		if (head == null) {
			head = newNode;
			return;
		}
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = newNode;
		return;
	}

	public void pushAfterAnyNode(Node givenNode, Node newNode) {
		// Check for empty List
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = givenNode.next;
		givenNode.next = newNode;
		return;
	}

	public void pushBeforeAnyNode(Node givenNode, Node newNode) {
		// Check for empty List
		if (head == null) {
			head = newNode;
			return;
		}
		Node n = head;
		if (givenNode == head) {
			pushBeforeHead(givenNode);
			return;
		}
		while (n.next != givenNode) {
			n = n.next;
		}
		pushAfterAnyNode(n, newNode);
		// newNode.next = givenNode;
		// n.next = newNode;
		return;
	}

	// Delete node given a key
	public void deleteNode(int key) {
		// Check if the head has the key to be deleted
		if (head.data == key) {
			head.next = head;
		}
		Node n = head;
		while (n.next != null && n.next.data != key) {
			n = n.next;
		}
		n.next = n.next.next;
	}

	// Delete a node given a position
	public void deleteNodeByPosition(int pos) {
		// Check if head is to be deleted, given by position = 0
		if (pos == 0 && head != null && head.next != null) {
			head = head.next;
			return;
		}
		Node n = head;
		for (int i = 1; i < pos; i++) {
			n = n.next;
		}
		n.next = n.next.next;
		return;
	}

	public void getListLengthIterative() {
		int count = 0;
		if (head == null)
			System.out.println("Length is 0");
		Node n = head;
		while (n != null) {
			n = n.next;
			count++;
		}
		System.out.println("Length is " + count);
	}

	public void getListLengthRecursive(Node n, int count) {
		if (head == null)
			System.out.println("Length is 0");
		if (n != null) {
			count++;
			getListLengthRecursive(n.next, count);
		}
		if (n == null) {
			System.out.println("Length is " + count);
		}
	}

	Node prev1, prev2 = null;

	// Swapping nodes without swapping keys
	public void swapNodesWithoutSwappingData(int x, int y) {

		if (x == y) {
			return;
		}

		Node n = head;
		while (n != null && n.data != x) {
			prev1 = n;
			n = n.next;
		}
		System.out.println("Refernce of node containing x before swap" + n.next);

		Node m = head;
		while (m != null && m.data != y) {
			prev2 = m;
			m = m.next;
		}
		System.out.println("Refernce of node containing y before swap" + m.next);

		if (prev1 != null) {
			prev1.next = m;
		} else
			head = m;

		if (prev2 != null) {
			prev2.next = n;
		} else
			head = n;

		Node temp = n.next;
		n.next = m.next;
		m.next = temp;

		System.out.println("Refernce of node containing x after swap" + n.next);
		System.out.println("Refernce of node containing y after swap" + m.next);
	}

	// Reverse a linked list
	public void llReverseIterative() {
		// First check if ll is empty
		// If not empty then make the head as the last and refer the last node
		// as head
		// If size of list = 2 nodes then stop
		// second node points to the new last node
		// Now third node points to second node and iterate till end of list

		if (head == null || head.next == null)
			return;

		Node next, current, prev;

		prev = null;
		current = head;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}
		head = prev;
	}

	public void llReverseRecursive(Node p) {
		if (p.next == null) {
			head = p;
			return;
		}
		llReverseRecursive(p.next);
		Node q = p.next;
		q.next = p;
		p.next = null;
	}

	public Node mergeList(Node l1, Node l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.data < l2.data) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		Node curr = head;
		while (l1 != null || l2 != null) {

			if (l1 == null) {
				curr.next = l2;
				return curr;
			}
			if (l2 == null) {
				curr.next = l1;
				return curr;
			}
			if (l1.data < l2.data) {
				curr.next = l1;
				curr = curr.next;
				l1 = l1.next;
			} else {
				curr.next = l2;
				curr = curr.next;
				l2 = l2.next;
			}
		}
		return curr;

	}

	public Node reverseListInGroup(Node head, int k) {
		Node prev = null;
		Node next = null;
		Node curr = head;
		int i = 0;
		while (i < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			i++;
		}
		if (next != null) {
			head.next = reverseListInGroup(next, k);
		}
		return prev;
	}

	public void detectAndRemoveLoopsIterative(Node head) {
		Node f = head;
		Node s = head;
		while ((s != null || f != null) && s.data != f.data) {
			s = s.next;
			f = f.next.next;
		}
		if (s.data == f.data) {
			s = head;
			while (s.data != f.data) {
				s = s.next;
				f = f.next;
			}
			while (f.next.data != s.data) {
				f = f.next;
			}
			f.next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		LinkedList l2 = new LinkedList();
		LinkedList l3 = new LinkedList();

		ll.head = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(4);
		Node n3 = new Node(8);
		Node n4 = new Node(9);
		Node n5 = new Node(10);

		l2.head = new Node(-1);
		Node l21 = new Node(2);
		Node l22 = new Node(3);
		Node l23 = new Node(5);
		Node l24 = new Node(6);
		Node l25 = new Node(7);

		ll.head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		l2.head.next = l21;
		l21.next = l22;
		l22.next = l23;
		l23.next = l24;
		l24.next = l25;

		// Node givenNode = n1;

		Node newNode = new Node(-1);
		l2.pushBeforeHead(newNode);
		// ll.pushAfterLastNode(newNode);
		// Node newNode1 = new Node(3);
		// ll.pushAfterAnyNode(givenNode, newNode1);
		// ll.pushBeforeAnyNode(givenNode, newNode1);
		// ll.deleteNode(1);
		// ll.deleteNodeByPosition(3);
		// System.out.println("Before reversal");
		// ll.display();
		// l2.display();
		// ll.llReverseRecursive(ll.head);
		// ll.llReverseIterative();
		// System.out.println("After reversal");
		// ll.display();
		// l3.mergeList(ll.head, l2.head);
		l2.display();
		// l3.reverseListInGroup(l3.head, 3);
		// l3.display();
		// ll.getListLengthIterative();
		// ll.getListLengthRecursive(ll.head, 0);
		// ll.swapNodesWithoutSwappingData(2, 4);

	}

}
