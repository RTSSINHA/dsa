package tree;
import java.util.*;

class ThreadNode {
	
	int data;
	ThreadNode left;
	ThreadNode right;
	boolean rightThread;
	ThreadNode(int data) {
		this.data = data;
	}
}

public class Thread {
	
	static ThreadNode root;
	
	void inorder(ThreadNode n) {
		if(n == null) return;
		
		inorder(n.left);
		System.out.print(n.data+" ");
		inorder(n.right);
	}
	
	ThreadNode leftMost(ThreadNode n) {
		
		if(n == null) return null;
		while(n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	void thread(ThreadNode n) {
		if(n == null) return;
		ThreadNode curr = leftMost(n);
		System.out.println("Left most: "+n.data);
		
		while(curr != null) {
			System.out.print(curr.data+" ");
			
			if(curr.rightThread) {
				curr = curr.right;
			} else {
				curr = leftMost(curr.right);
				System.out.println("Left most: "+curr.data);
			}
		}
	}
	
	public static void main(String args[]) {
		
		Thread tree = new Thread();
		root = new ThreadNode(6);
		root.left = new ThreadNode(3);
		root.right = new ThreadNode(8);
		root.left.left = new ThreadNode(1);
		root.left.right = new ThreadNode(5);
		root.right.left = new ThreadNode(7);
		root.right.right = new ThreadNode(11);
		root.right.right.left = new ThreadNode(9);
		root.right.right.right = new ThreadNode(13);
		tree.inorder(root);
		System.out.println();
		tree.thread(root);
		
	}
}
