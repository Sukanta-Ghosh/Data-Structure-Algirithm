package Tree;

import java.util.*;

public class PairSumBST {
	
	Node root;
	
	/* InOrder type of Traversal */
	boolean isPairSumUtil(Node root, int sum, HashSet<Integer> set) {
		
		if(root == null)
			return false;
		
		if(isPairSumUtil(root.left, sum, set))
			return true;
		
		if(set.contains(sum - root.key))
			return true;
		else
			set.add(root.key);
		
		return isPairSumUtil(root.right, sum, set);
	}
	
	boolean isPairSum(int sum) {
		
		HashSet<Integer> set = new HashSet<Integer>();	
		
		return isPairSumUtil(root, sum, set);
	}
	
	/* Recursive Approach */
	Node insertRec(Node root, int x) {
		
		if(root == null)
			return new Node(x);
		
		if(root.key > x)
			root.left = insertRec(root.left, x);
		else if(root.key < x)
			root.right = insertRec(root.right, x);
		
		return root;
	}
	
	void insert(int key) { 
	       root = insertRec(root, key); 
	    } 
	
	public static void main(String[] args) { 
		 
		PairSumBST tree = new PairSumBST(); 
  
        /* Let us create following BST 
              10 
            /    \ 
           5     20 
             	/  \ 
         	   16   40 
        */
        tree.insert(10); 
        tree.insert(5); 
        tree.insert(20); 
        tree.insert(16); 
        tree.insert(40);  

        System.out.println(tree.isPairSum(21)); 
        
    } 
}
