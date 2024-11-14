package tree;
import java.util.*;

class MirrorNode {
	
	int data;
	MirrorNode left, right;
	MirrorNode(int data) {
		this.data = data;
	}
}

public class Mirror {
	
	static MirrorNode root;
	void preorder(MirrorNode n) {
		if(n == null) return;
		
		System.out.print(n.data+" ");
		preorder(n.left);
		preorder(n.right);
	}
	
	void MirrorTree(MirrorNode n) {
		if(n == null) return;
		
		MirrorTree(n.left);
		MirrorTree(n.right);
		
		MirrorNode temp = n.left;
		n.left = n.right;
		n.right = temp;
	}

	
	
	
	public static void main(String args[]) {
		
		Mirror tree = new Mirror();
		root = new MirrorNode(1);
		root.left = new MirrorNode(3);
		root.right = new MirrorNode(2);
		root.right.left = new MirrorNode(5);
		root.right.right = new MirrorNode(4);
		tree.preorder(root);
		System.out.println();
		tree.MirrorTree(root);
		tree.preorder(root);
	}
	
}
