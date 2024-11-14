package tree;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class NodeAtDistanceK {
	
	static Node root;
	static class Node {
		
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}
	
	void inorder(Node n) {
		if(n == null) return;
		
		inorder(n.left);
		System.out.print(n.data+" ");
		inorder(n.right);
	}
	
	void printLevel(int level, Node n) {
		
		if(n == null) return;
		
		Queue q = new LinkedList<>();
		q.add(n);
		q.add(null);
		int count = 0;
		
		while(!q.isEmpty()) {
			
			n = (Node)q.remove();
			System.out.println("Count: "+count);
			if(n == null) {
				count++;
				if(count == level) {
					while(!q.isEmpty()) {
						Node temp = (Node)q.remove();
						if(temp != null)
						System.out.print(temp.data+" ");
					}
					return;
				}
				if(!q.isEmpty()) q.add(null);
				
			} else {
				if(n.left != null) q.add(n.left);
				if(n.right != null) q.add(n.right);
			}
		}
	}
	
	void printLevelRec(int num, Node n) {
		
		if(num < 0 || n == null) return;
		
		if(num == 0) {
			System.out.print(n.data+" ");
		}
		printLevelRec(num-1, n.left);
		printLevelRec(num-1, n.right);
	}
	
	int size(Node n) {
		
		if(n == null) return 0;
		
		int lsize = size(n.left);
		int rsize = size(n.right);
		return lsize + rsize + 1;
	}
	
	int max(Node n) {
		if(n == null) return 0;
		
		int lmax = max(n.left);
		int rmax = max(n.right);
		return Math.max(Math.max(lmax, n.data), rmax);
	}
	
	public static void main(String args[]) {
		NodeAtDistanceK tree = new NodeAtDistanceK();
		root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(9);
		root.right.left = new Node(8);
		tree.inorder(root);
		System.out.println();
//		tree.printLevel(2, root);
//		tree.printLevelRec(0, root);
		System.out.println("Size: ");
		System.out.println(tree.size(root));
		System.out.println("Maximum: ");
		System.out.println(tree.max(root));
		
		
	}
}
