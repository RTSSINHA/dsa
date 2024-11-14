package linkedlist;
import java.util.*;

public class ReverseList {
	
	static Node head;
	static Node tail;
	
	class Node {
		int data;
		Node next;
		Node(int data, Node node) {
			this.data = data;
			this.next = node;
		}
		Node(int data) {
			this.data = data;
		}
	}
	
	void add(int num) {
		Node newNode = new Node(num);
		
		if(head == null) {
			head = tail = newNode;
			return;
		}
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
	
	void reverse() {
		
		Node curr = head;
		Node prev = null;
		Node nxt = null;
		
		while(curr != null) {
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		tail = head;
		head = prev;
				
	}
	
	public static void main(String args[]) {
		ReverseList list = new ReverseList();
		
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(5);
		list.print();
		list.reverse();
		list.print();
		list.add(0);
		list.add(-2);
		list.print();
		
	}
}
