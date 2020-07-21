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
	
	/* Check for Triplet Sum */
	boolean checkForTriplet(Node root, int sum) 
	{ 
	    // Vector to store the inorder traversal 
	    // of the BST 
	    Vector<Integer> vec = new Vector<Integer>(); 
	  
	    // Call inorder() to do the inorder 
	    // on the BST and store it in vec 
	    inorder(root, vec); 
	  
	    // Now, check if any triplet with given sum 
	    // exists in the BST or not 
	    int l, r; 
	  
	    // Now fix the first element one by one  
	    // and find the other two elements 
	    for (int i = 0; i < vec.size() - 2; i++) 
	    { 
	  
	        // To find the other two elements,  
	        // start two index variables from two corners  
	        // of the array and move them toward each other 
	        l = i + 1; // index of the first element in the 
	                   // remaining elements 
	  
	        // index of the last element 
	        r = vec.size() - 1; 
	        while (l < r)  
	        { 
	            if (vec.get(i) +  
	                vec.get(l) + vec.get(r) == sum)  
	            { 
	                return true; 
	            } 
	            else if (vec.get(i) +  
	                     vec.get(l) + vec.get(r) < sum) 
	                l++; 
	            else // vec[i] + vec[l] + vec[r] > sum 
	                r--; 
	        } 
	    } 
	  
	    // If we reach here,  
	    // then no triplet was found 
	    return false; 
	} 
	
	void inorder(Node root,  
            Vector<Integer> vec) 
	{ 
		if (root != null) 
		{ 
			inorder(root.left, vec); 
			vec.add(root.key); 
			inorder(root.right, vec); 
		} 
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
        System.out.println(tree.checkForTriplet(tree.root, 35)); 
        
    } 
}
