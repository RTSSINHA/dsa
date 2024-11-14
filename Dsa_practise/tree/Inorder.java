package tree;
import java.util.Stack;
import tree.Height.Node;

//class Node {
//	int data;
//	Node left;
//	Node right;
//	Node(int data) {
//		this.data= data;
//	}
//}

public class Inorder {
	
	static Node root;
	
	void inorder(Node n) {
		if(n == null) return;
		inorder(n.left);
		System.out.print(n.data+" ");
		inorder(n.right);
	}
	
	void inorderItr(Node n) {
		
		if(n == null) return;
		Stack<Node> stk = new Stack<>();
		
		while(n != null || !stk.isEmpty()) {
			
			while(n != null) {
				
				stk.push(n);
				n = n.left;
			}
			
			Node top = stk.pop();
			System.out.print(top.data+" ");
			n = top.right;
			
		}
		
	}
	
	public static void main(String args[]) {
		Inorder tree = new Inorder();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		tree.inorder(root);
		System.out.println();
		tree.inorderItr(root);
	}

}
