package tree;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
	}
}

public class LCA {
	
	static Node root;
	void inorder(Node n) {
		if(n == null) return;
		inorder(n.left);
		System.out.print(n.data+" ");
		inorder(n.right);
	}
	
	Node findLCA(int a, int b) {
		
		return LCA(root, a, b);
	}
	
	Node LCA(Node n, int a, int b) {
		
		if(n == null) return null;
		if(n.data == a || n.data == b) return n;
		
		Node lNode = LCA(n.left, a, b);
		Node rNode = LCA(n.right, a, b);
		
		if(lNode!= null && rNode!= null) return n;
		return (lNode != null)? lNode: rNode;
//		if(lNode != null) return LCA(n.left, a, b);
//		else return LCA(n.right, a, b);
	}
	
	public static void main(String args[]) {
		LCA tree = new LCA();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		tree.inorder(root);
		System.out.println("\nLCA of 4 and 5: "+tree.findLCA(4, 5).data);
		System.out.println("LCA of 4 and 6: "+tree.findLCA(4, 6).data);
		System.out.println("LCA of 4 and 3: "+tree.findLCA(4, 3).data);
		System.out.println("LCA of 4 and 2: "+tree.findLCA(4, 2).data);
	}
}
