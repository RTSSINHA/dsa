package linkedlist;

public class LinkedListTraversal {
	static Node head;
	static Node tail;
	class Node {
		int data;
		Node next;
		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		Node(int data) {
			this.data = data;
		}
	}
	
	void add(int data) {
		
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = head;
			return;
		} 
		tail.next = newNode;
		tail = newNode;
	}
	
	void insertAtStart(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	void insertAtEnd(int data) {
		Node newNode = new Node(data);
		tail.next = newNode;
		tail = newNode;
	}
	
	void print() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	void insertAt(int pos, int val) {
		
		if(pos == 1) {
			insertAtStart(val);
			return;
		}
		Node newNode = new Node(val);
		Node curr = head;
		while(pos - 1> 1) {
			pos--;
			curr = curr.next;
			if(curr == null) {
				System.out.println("Outside the range");
				return;
			}
		}
		Node nxt = curr.next;
		curr.next = newNode;
		newNode.next = nxt;
	}
	
	void traverse(Node curr) {
		
		if(curr == null) return;
		System.out.print(curr.data+" ");
		traverse(curr.next);
	}
	
	void deleteLastNode() {
		Node curr = head;
		if(head== null) return;
		if(head.next == null) {
			head = null;
			return;
		}
		Node last = head;
		while(curr.next != null) {
			last = curr;
			curr = curr.next;
		}
		last.next = null;
	}
	
	boolean search(int val) {
		
		Node curr = head;
		while(curr != null) {
			if(curr.data == val) return true;
			curr = curr.next;
		}
		return false;
	}
	
	int getMid() {
		
		Node fast = head;
		Node slow = head;
		while(fast!=null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}
	
	public static void main(String args[]) {
		
		LinkedListTraversal list = new LinkedListTraversal();
		list.add(1);
		list.add(2);
		list.add(3);
//		list.print();
		list.add(4);
		list.add(5);
//		list.print();
		list.insertAtStart(0);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
//		list.print();
		list.insertAt(8, 10);
		list.print();
		list.traverse(head);
		System.out.println();
		list.deleteLastNode();
		list.print();
//		System.out.println("Element present: "+list.search(4));
		System.out.println("Get middle element: "+list.getMid());
	}
}
