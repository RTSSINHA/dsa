package collection;

public class Generics {
	
	static class Node <T>{
		
		T data;
		Node left;
		Node right;
		Node(T data) {
			this.data= data;
		}
	}
	
	void inorder(Node n) {
		
		if(n == null) return;
		inorder(n.left);
		System.out.print(n.data+" ");
		inorder(n.right);
	}
	
	public static void main(String args[]) {
		
		Generics tree = new Generics();
		Node root = new Node("one");
		root.left = new Node(2);
		root.right = new Node("three");
		tree.inorder(root);
		
	}

}
