
public class LinkedList {

	Node head;
	static class Node{
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public void display(){
		Node n = head;
		while(n != null){
			System.out.println("Data is "+n.data);
			n = n.next;
		}
		
	}
	
	public void pushBeforeHead(Node newNode){
		newNode.next = head;
		head = newNode;
	}
	
	public void pushAfterLastNode(Node newNode){
		//Check for empty List
		if (head == null){
			head = newNode;
			return;
		}
		Node n = head;
		while (n.next != null){
			n = n.next;
		}
		n.next = newNode;
		return;
	}
	
	public void pushAfterAnyNode(Node givenNode, Node newNode){
		// Check for empty List
		if (head == null){
			head = newNode;
			return;
		}
		newNode.next = givenNode.next;
		givenNode.next = newNode;
		return;
	}
	
	public void pushBeforeAnyNode(Node givenNode, Node newNode){
		// Check for empty List
		if (head == null){
			head = newNode;
			return;
		}
		Node n = head;
		if (givenNode == head){
			pushBeforeHead(givenNode);
			return;
		}
		while (n.next != givenNode){
			n = n.next;
		}
		pushAfterAnyNode(n, newNode);
//		newNode.next = givenNode;
//		n.next = newNode; 
		return;
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		
		ll.head.next = n1;
		n1.next = n2;
		
		Node givenNode = n1;
		
//		Node newNode = new Node(-1);
//		ll.pushBeforeHead(newNode);
//		ll.pushAfterLastNode(newNode);
		Node newNode1 = new Node(3);
//		ll.pushAfterAnyNode(givenNode, newNode1);
		ll.pushBeforeAnyNode(givenNode, newNode1);
		
		ll.display();
		

	}

}
