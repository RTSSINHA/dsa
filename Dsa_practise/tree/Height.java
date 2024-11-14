package tree;
import java.util.*;

public class Height {
	
	Node root;
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	int height(Node n) {
		if(n == null) return -1;
		int lheight = height(n.left);
		int rheight = height(n.right);
		return 1 + Math.max(lheight, rheight);
	}
	
	int height2(Node n) {
		
		if(n == null) return -1;
		
		Queue q = new LinkedList<>();
		q.add(n);
		q.add(null);
		int count = -1;
		while(!q.isEmpty()) {
			
			n = (Node)q.remove();
			if(n == null) {
				count++;
			}
			
			if(n != null) {
				if(n.left != null) q.add(n.left);
				if(n.right != null) q.add(n.right);
			} else if(!q.isEmpty()) q.add(null);
			
		}
		return count;
	}
	
	public static void main(String args[]) {
		
		Height tree = new Height();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
//		tree.root.left.left.left = new Node(6);
		System.out.println(tree.height(tree.root));
		System.out.println(tree.height2(tree.root));
		
	}
}
