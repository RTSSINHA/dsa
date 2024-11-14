package circularLinkedList;

public class Creation {
	
	static Node last;
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
	
	void add(int num) {
		
		Node newNode = new Node(num);
		if(last == null) {
			last = newNode;
			last.next = last;
			return;
		}
		Node head = last.next;
		last.next = newNode;
		last = newNode;
		last.next = head;
	}
	
	void print() {
		
		if(last == null) return;
		Node curr = last.next;
		do {
			System.out.print(curr.data+" ");
			curr = curr.next;
		} while(curr != last.next);
		System.out.println();
	}
	
	public static void main(String args[]) {
		Creation list = new Creation();
		list.print();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.print();
		list.add(5);
		list.add(6);
		list.print();
		
	}
}
