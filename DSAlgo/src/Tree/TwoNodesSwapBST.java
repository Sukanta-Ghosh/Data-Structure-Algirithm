package Tree;

import java.util.ArrayList;
import java.util.Collections;


public class TwoNodesSwapBST {
	
	Node root;
	
	
	Node prev = null, first = null, second = null;	

	/* InOrder type traversal */ 
	void fixBSTUtil(Node root) {
		
		if(root == null)
			return;
		
		fixBSTUtil(root.left);
		
		if(prev != null && root.key < prev.key) {
			if(first == null) {
				first = prev;
			}
			second = root;
		}
		prev = root;
		fixBSTUtil(root.right);
	}
	
	void fixBST() {
		
		fixBSTUtil(root);
		
		if( first != null && second != null ) 
        { 
            int temp = first.key; 
            first.key = second.key; 
            second.key = temp;  
        } 
	}
	
	void inorder()  { 
	       inorderRec(root); 
	    } 
	  
	    // A utility function to do inorder traversal of BST 
	    void inorderRec(Node root) { 
	        if (root != null) { 
	            inorderRec(root.left); 
	            System.out.print(root.key+" "); 
	            inorderRec(root.right); 
	        } 
	    } 
	    
	
	public static void main(String[] args) 
	{ 
		TwoNodesSwapBST tree = new TwoNodesSwapBST();
		
		/* Constructed binary tree is 
	          20 
	        /    \ 
	      60      80 
	     /  \ 	 /  \
	    4   10  8   100
	    
	    4 _60 10 20 _8 80 100
	  */
		tree.root = new Node(20); 
		tree.root.left = new Node(60); 
		tree.root.right = new Node(80); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(10); 
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(100);
		
		tree.inorder();
		System.out.println();
		tree.fixBST();
		tree.inorder();
		
		TwoNodesSwapBST tree1 = new TwoNodesSwapBST();
		
		/* Constructed binary tree is 
	          60 
	        /    \ 
	       8      80 
	     /  \ 	 /  \
	    4   10  20   100
	    
	    4 8 10 _60 _20 80 100
	  */
		tree1.root = new Node(60); 
		tree1.root.left = new Node(8); 
		tree1.root.right = new Node(80); 
		tree1.root.left.left = new Node(4); 
		tree1.root.left.right = new Node(10); 
		tree1.root.right.left = new Node(20);
		tree1.root.right.right = new Node(100);
		
		System.out.println("\n-------------");
		tree1.inorder();
		System.out.println();
		tree1.fixBST();
		tree1.inorder();
		
	}
}
