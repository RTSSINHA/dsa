package queue;

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

public class LinkedListImpl {
	
	Node head;
	Node tail;
	int size = 0;
	int capacity;
	
	LinkedListImpl(int num) {
		this.capacity = num;
	}
	
	void enqueue(int num) {
		
		Node newNode = new Node(num);
		if(size == capacity-1) {
			System.out.println("Queue overflow");
			return;
		}
		if(head == null) {
			head = tail = newNode;
			return;
		}
		size++;
		tail.next = newNode;
		tail = tail.next;
		
	}
	
	int dequeue() {
		
		if(size == 0) {
			System.out.println("Queue underflow");
			return Integer.MIN_VALUE;
		}
		int num = head.data;
//		head = null;
		head = head.next;
		size--;
		return num;
	}
	
	void print() {
		
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		
		LinkedListImpl list = new LinkedListImpl(5);
		list.enqueue(1);
		list.enqueue(2);
		list.enqueue(3);
		list.enqueue(4);
		list.enqueue(5);
		list.enqueue(6);
		list.print();
		System.out.println(list.dequeue());
		list.dequeue();
		list.print();
		list.enqueue(7);
		list.enqueue(8);
		list.print();
	}
}
