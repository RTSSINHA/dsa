package tree;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;
	Node(int data) {
		this.data = data;
	}
}

public class Views {
	
	static Node root;
	void preorder(Node n) {
		if(n == null) return;
		System.out.print(n.data+" ");
		preorder(n.left);
		preorder(n.right);
	}
	
	void leftView(Node n) {
		
		if(n == null) return;
		
		boolean left = true;
		Queue q = new LinkedList<>();
		q.add(n);
		q.add(null);
		
		while(!q.isEmpty()) {
			
			n = (Node) q.remove();
			if(left && n != null) {
				System.out.print(n.data+" ");
				left = false;
			}
			if(n == null) {
				left = true;
				if(!q.isEmpty()) q.add(null);
				continue;
			}
			if(n.left != null) q.add(n.left);
			if(n.right != null) q.add(n.right);
			
		}
		
	}
	
	void rightView(Node n) {
		
		if(n == null) return;
		boolean left = true;
		Queue q = new LinkedList<>();
		q.add(n);
		q.add(null);
		
		while(!q.isEmpty()) {
			
			n = (Node) q.remove();
			if(left && n != null) {
				System.out.print(n.data+" ");
				left = false;
			}
			if(n == null) {
				left = true;
				if(!q.isEmpty()) q.add(null);
				continue;
			}
			if(n.right != null) q.add(n.right);
			if(n.left != null) q.add(n.left);
			
		}
		
	}
	
	class NodeLevel {
		Node node;
		int level;
		NodeLevel(Node n, int l) {
			this.node = n;
			this.level = l;
		}
	}
	
	void topView(Node n) {
		
		if(n == null) return;
		Queue<NodeLevel> q = new LinkedList<>();
		q.add(new NodeLevel(n, 1));
		Map<Integer, Node> map = new TreeMap<>();
		
		while(!q.isEmpty()) {
			
			NodeLevel nl = (NodeLevel) q.remove();
			if(!map.containsKey(nl.level)) {
				map.put(nl.level, nl.node);
			}
			
			if(nl.node.left != null) {
				q.add(new NodeLevel(nl.node.left, nl.level - 1));
			}
			if(nl.node.right != null) {
				q.add(new NodeLevel(nl.node.right, nl.level + 1));
				
			}
		}
		
		for(Map.Entry<Integer, Node> entry: map.entrySet()) {
			
			int key = entry.getKey();
			Node value = entry.getValue();
			System.out.print(value.data+" ");
		}
 	}
	
	public static void main(String args[]) {
		
		Views tree = new Views();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		tree.preorder(root);
		System.out.println("\nLeft view");
		tree.leftView(root);
		System.out.println("\nRight view\n");
		tree.rightView(root);
		System.out.println("\nTop view\n");
		tree.topView(root);
	}
}
