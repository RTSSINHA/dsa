package stack;

public class LinkedListImplementation {
	
	Node head;
	Node tail;
	int size = 0;
	int capacity;
	
	class Node {
		int data;
		Node next;
		Node prev;
		Node(int data) {
			this.data = data;
		}
		Node () {}
	}
	
	void push(int num) {
		
		Node newNode = new Node(num);
		size++;
		
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}
	
	int peek() {
		
		if(size == 0) {
			System.out.println("No element in the stack");
			return -1;
		}
		return tail.data;
	}
	
	int pop() {
		
		if(size == 0) {
			System.out.println("No element in the stack");
			return -1;
		}
		
		int top_element = tail.data;
		size--;
		tail = tail.prev;
		tail.next = null;
		return top_element;
	}
	
	void print() {
		
		Node curr = tail;
		while(curr != null) {
			System.out.print(curr.data+" ");
			System.out.println();
			curr = curr.prev;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		LinkedListImplementation stk = new LinkedListImplementation();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.print();
		System.out.println("Pop: "+stk.pop());
		System.out.println("Peek: "+stk.peek());
		System.out.println("Pop: "+stk.pop());
		stk.push(6);
		stk.push(7);
		stk.print();
	}
}

