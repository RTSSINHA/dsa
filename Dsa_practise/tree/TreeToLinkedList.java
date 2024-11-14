package tree;
import java.util.*;

class ConversionNode {
	int data;
	ConversionNode left, right;
	ConversionNode(int data) {
		this.data = data;
	}
}

class DLNode {
	int data;
	DLNode prev, next;
	DLNode(int data) {
		this.data = data;
	}
	
}

public class TreeToLinkedList {

	static ConversionNode root;
	static DLNode head, tail;
	
	void add(int num) {
			
		DLNode nNode = new DLNode(num);
		if(head == null) {
			head = tail = nNode;
			return;
		}
		tail.next = nNode;
		nNode.prev = tail;
		tail = nNode;
	}
	
	void print() {
		
		DLNode curr = head;
		while(curr != null) {
			System.out.print(curr.data+" ");
			 curr = curr.next;
		}
	}
	
	
	void inorder(ConversionNode n) {
		if(n == null) return;
		inorder(n.left);
		add(n.data);
		inorder(n.right);
	}
	
	public static void main(String args[]) {
		TreeToLinkedList tree = new TreeToLinkedList();
		root = new ConversionNode(10);
		root.left = new ConversionNode(12);
		root.left.left = new ConversionNode(25);
		root.left.right = new ConversionNode(30);
		root.right = new ConversionNode(15);
		root.right.left = new ConversionNode(36);
		System.out.println("Inorder: ");
		tree.inorder(root);
		System.out.println("\nPrinting DLL");
		tree.print();
		
		
	}

}
