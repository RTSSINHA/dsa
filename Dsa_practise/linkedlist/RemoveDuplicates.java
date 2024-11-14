package linkedlist;
import java.util.*;

public class RemoveDuplicates {
	
	static Node head;
	static Node tail;
	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
		Node(int data, Node next) {
			this.data = data;
			this.next = next;
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
	void remDuplicates() {
		
		Node dummy = new Node(-1);
		Node dummyTail = dummy;
		
		Node curr = head;
		while(curr != null) {
			if(dummyTail.data != curr.data) {
				dummyTail.next = curr;
				dummyTail = curr;
			}
			curr = curr.next;
		}
		head = dummy.next;
	}
	
	public static void main(String args[]) {
		
		RemoveDuplicates list = new RemoveDuplicates();
		list.add(11);
		list.add(11);
		list.add(11);
		list.add(21);
		list.add(43);
		list.add(43);
		list.add(60);
		list.print();
		list.remDuplicates();
		list.print();
		
	}
}
