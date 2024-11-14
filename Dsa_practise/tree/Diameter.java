package tree;

class Node {
	int data;
	ThreadNode left;
	ThreadNode right;
	Node(int data) {
		this.data = data;
	}
}

public class Diameter {

	static ThreadNode root;
	void inorder(ThreadNode n) {
		if(n == null) return;
		inorder(n.left);
		System.out.print(n.data+" ");
		inorder(n.right);
	}
	
	int height(ThreadNode n) {
		if(n == null) return 0;
		int lheight = height(n.left);
		int rheight = height(n.right);
		return 1+Math.max(lheight, rheight);
	}
	
	int diameter(ThreadNode n, int mdia) {
		if(n == null) return 0;
		int lheight = height(n.left);
		int rheight = height(n.right);
		int ldia = diameter(n.left, 0);
		int rdia = diameter(n.right, 0);
		return Math.max(1 + lheight+rheight, Math.max(ldia, rdia));
//		mdia = Math.max(mdia, 1 + ldia + rdia);
//		System.out.println("Mdia: "+mdia);
//		return mdia;
	}
	
	public static void main(String args[]) {
		Diameter tree = new Diameter();
		root = new ThreadNode(1);
		root.left = new ThreadNode(2);
		root.left.left = new ThreadNode(3);
		root.left.right = new ThreadNode(4);
		root.left.right.right = new ThreadNode(5);
		root.right = new ThreadNode(6);
		root.right.right = new ThreadNode(7);
		root.right.right.right = new ThreadNode(8);
		root.right.right.right.left = new ThreadNode(9);
		root.right.right.right.left.right = new ThreadNode(10);
		tree.inorder(root);
		System.out.println("DIameter: "+tree.diameter(root, 0));
		
	}
}
