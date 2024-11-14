package tree;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;
	Node(int num) {
		this.data = num;
	}
}

public class Traversal {
	
	static Node root;
	
	void inorder() {
		
		traverseInorder(root);
	}
	
	void traverseInorder(Node n) {
		
		if(n == null) return;
		traverseInorder(n.left);
		System.out.print(n.data+" ");
		traverseInorder(n.right);
		
	}
	
	void traversePostorder(Node n) {
		if(n == null) return;
		traversePostorder(n.left);
		traversePostorder(n.right);
		System.out.print(n.data+" ");
		
	}
	
	void postOrder() {
		traversePostorder(root);
	}
	
	void traversePreorder(Node n) {
		
		if(n == null) return;
		System.out.print(n.data+" ");
		traversePreorder(n.left);
		traversePreorder(n.right);
		
	}
	
	void preOrder() {
		traversePreorder(root);
	}
	
	void insert(int num) {
		
		insert(num, root);
	}
	
	void insert(int num, Node n) {
		
		if(n == null) {
			root = new Node(num);
			return;
		}
		
		Queue q = new LinkedList<>();
		Node newNode = new Node(num);
		q.add(n);
		while(!q.isEmpty()) {
			
			n = (Node)q.remove();
			
			if(n.left == null) {
				n.left = newNode;
				break;
			} else {
				q.add(n.left);
			}
			
			if(n.right == null) {
				n.right = newNode;
				break;
			} else q.add(n.right);
		}
	}
	
	Node getRightDeepest(Node n) {
		
		if(n == null) return null;
		
		Queue q = new LinkedList<>();
		q.add(n);
		
		Node last = null;
		while(!q.isEmpty()) {
			
			n = (Node)q.remove();
			last = n;
			if(n.left != null) q.add(n.left);
			if(n.right != null) q.add(n.right);
		}
		return last;
		
	}
	
	void deleteDeepest(Node deepest) {
		
		Queue q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			
			Node temp = (Node)q.remove();
			if(temp.left != null) {
				if(temp.left == deepest) {
					temp.left = null;
					deepest = null;
					return;
				} else {
					q.add(temp.left);
					
				}
			}
			
			if(temp.right != null) {
				if(temp.right == deepest) {
					temp.right = null;
					deepest = null;
					return;
				} else {
					q.add(temp.right);
				}
			}
			
		}
	}
	
	void delete(int num) {
		
//		Node rightMost = getRightDeepest(root);
		Queue q = new LinkedList<>();
		q.add(root);
		Node temp = null;
		Node delNode = null;
		while(!q.isEmpty()) {
			
			temp = (Node)q.remove();
			if(temp.left != null) {
				q.add(temp.left);
				if(temp.data == num) {
					delNode = temp;
				}
			}
			if(temp.right != null) {
				q.add(temp.right);
				if(temp.data == num) {
					delNode = temp;
				}
			}
				
		}
		
		int valueRightMostNode = temp.data;
		if(temp == delNode) {
			temp = null;
			return;
		}
		deleteDeepest(temp);
		delNode.data = valueRightMostNode;
		
	}
	
	
	
	public static void main(String args[]) {
		
		Traversal tree = new Traversal();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println("Inorder");
		tree.inorder();
		System.out.println("\nPreorder\n");
		tree.preOrder();
		System.out.println("\nPostorder\n");
		tree.postOrder();
		tree.insert(6);
		System.out.println("\nPreorder\n");
		tree.preOrder();
		tree.delete(6);
		System.out.println("\nPreorder\n");
		tree.preOrder();
		
	}
}
