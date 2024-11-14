package linkedlist;
import java.util.*;

public class NthFromLast {
	
	static Node head;
	static Node tail;
	class Node {
		int data;
		Node next;
		Node(int data, Node nxt) {
			this.data = data;
			this.next = nxt;
		}
		Node(int data) {
			this.data = data;
		}
	}
	
	void add(int val) {
		
		Node newNode = new Node(val);
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
	
//	Wrong
//	void NumberFromLast(int pos, Node n) {
//		
//		int i = 0;
//		if(n == null) return;
//		NumberFromLast(pos, n.next);
//		
//		if(++i == pos) {
//			System.out.println("Number in last "+pos+" index: "+n.data);
//		}
//		System.out.println(i);
//	}
//	
//	Wrong
//	static void printNthFromLast(Node head, int n)
//	{
//	    int i = 0;
//
//	    if (head == null)
//	        return;
//	    printNthFromLast(head.next, n);
//
//	    if (++i == n)
//	        System.out.print(head.data);
//	}

//	Works
	void printFromLast(int pos) {
		
		Node first = head;
		Node sec = head;
		int initialPos = pos;
		
		while(first != null && pos > 1) {
			first = first.next;
			pos--;
		}
		if(first == null) {
			System.out.println("Length of linkedlist is less than "+initialPos);
			return;
		}
		while(first.next!=null) {
			sec = sec.next;
			first = first.next;
		}
		System.out.println("Number from last "+initialPos+" is: "+sec.data);
	}

	
	public static void main(String args[]) {
		
		NthFromLast list = new NthFromLast();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.print();
		list.printFromLast(11);
//		list.printNthFromLast(head, 3);
//		list.NumberFromLast(3, head);
	}
}
