
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
	
	public void getListLengthIterative(){
		int count = 0;
		if (head == null)
			System.out.println("Length is 0");
		Node n = head;
		while (n != null){
			n=n.next;
			count++;
		}
		System.out.println("Length is "+ count);
	}
	
	public void getListLengthRecursive(Node n, int count){
		if (head == null)
			System.out.println("Length is 0");
		if (n != null){
			count++;
			getListLengthRecursive(n.next,count);
		}
	if (n==null){
		System.out.println("Length is "+count);
		}
	}
	Node prev1,prev2 = null;
	//Swapping nodes without swapping keys
	public void swapNodesWithoutSwappingData(int x, int y){
		
		if(x == y){
			return;
		}
		
		Node n = head;
		while (n != null && n.data != x){
			prev1 = n;
			n = n.next;
		}
		System.out.println("Refernce of node containing x before swap"+n.next);
		
		Node m = head;
		while (m != null && m.data != y){
			prev2 = m;
			m = m.next;
		}
		System.out.println("Refernce of node containing y before swap"+m.next);
		
		if(prev1 != null){
			prev1.next = m;
		}
		else
			head = m;
		
		if(prev2 != null){
			prev2.next = n;
		}
		else
			head = n;
		
		Node temp = n.next;
		n.next = m.next;
		m.next = temp;
		
		System.out.println("Refernce of node containing x after swap"+n.next);
		System.out.println("Refernce of node containing y after swap"+m.next);
	}
	

	// Reverse a linked list
	public void llReverseIterative(){
		//First check if ll is empty
		//If not empty then make the head as the last and refer the last node as head
		//If size of list = 2 nodes then stop
		//second node points to the new last node
		//Now third node points to second node and iterate till end of list
		
		if (head == null || head.next == null) return;
		
		Node next, current, prev;

		prev =null;
		current = head;
		
		while (current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			
		}
		head = prev;
	}
	
	public void llReverseRecursive(Node p){
		if (p.next == null){
			head = p;
			return;
		}
		llReverseRecursive(p.next);
		Node q = p.next;
		q.next = p;
		p.next = null;
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
//		ll.deleteNodeByPosition(3);
		System.out.println("Before reversal");
		ll.display();
		ll.llReverseRecursive(ll.head);
//		ll.llReverseIterative();
		System.out.println("After reversal");
		ll.display();
//		ll.getListLengthIterative();
//		ll.getListLengthRecursive(ll.head, 0);
//		ll.swapNodesWithoutSwappingData(2, 4);
		

	}

}
