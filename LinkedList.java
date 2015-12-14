
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
	// Delete node given a key
	public void deleteNode(int key){
		//Check if the head has the key to be deleted
		if (head.data==key){
			head.next=head;
			}
		Node n = head;
		while (n.next != null && n.next.data !=key){
			n=n.next;
		}
		n.next=n.next.next;
	}
	
	// Delete a node given a position
	public void deleteNodeByPosition(int pos){
		// Check if head is to be deleted, given by position = 0
		if (pos == 0 && head != null && head.next != null){
			head = head.next;
			return;
		}
		Node n = head;
		for (int i = 1; i<pos; i++){
			n = n.next;
		}
		n.next = n.next.next;
		return;
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		ll.head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
//		Node givenNode = n1;
		
//		Node newNode = new Node(-1);
//		ll.pushBeforeHead(newNode);
//		ll.pushAfterLastNode(newNode);
//		Node newNode1 = new Node(3);
//		ll.pushAfterAnyNode(givenNode, newNode1);
//		ll.pushBeforeAnyNode(givenNode, newNode1);
//		ll.deleteNode(1);
		ll.deleteNodeByPosition(3);
		ll.display();
		

	}

}
