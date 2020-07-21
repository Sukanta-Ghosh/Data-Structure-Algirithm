package Tree;

import java.util.*;

class MergeTwoBSTs{
	
	Node root1;
	Node root2;
 
	public List<Integer> merge(Node root1,Node root2)
	 {
	     List<Integer> l = new ArrayList<>(); 
	     helper(root1,root2);
	     inorder(root1,l);
	     return l;
	 }

	 /* Recursive Approach */
	 Node helper(Node root1,Node root2){
	     if(root1 == null && root2 == null){
	         return null;    
	     }
	     if(root1==null){
	         return root2;
	     }
	     if(root2==null){
	         return root1;
	     }
	     
	     if(root1.key > root2.key){
	         Node right = root2.right;
	         root2.right = null;
	         
	         root1.left = helper(root1.left,root2);
	         helper(root1,right);
	     }
	     else{
	         Node left = root2.left;
	         root2.left = null;
	         root1.right = helper(root1.right,root2);
	         helper(root1,left);
	     }
	     return root1;
	     
	 }
	 static void inorder(Node root, List<Integer> l){
	     if(root==null){
	         return ;
	     }
	     inorder(root.left,l);
	     l.add(root.key);
	     inorder(root.right,l);
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
		
		void insert1(int key) { 
		       root1 = insertRec(root1, key); 
		    } 
		
		void insert2(int key) { 
		       root2 = insertRec(root2, key); 
		    } 
	 
	 public static void main(String[] args) { 
		 
		 MergeTwoBSTs tree = new MergeTwoBSTs(); 
	  
	        /* Let us create following BST
		          3 
	            /   \ 
	           1     5  
	       */
	        tree.insert1(3); 
	        tree.insert1(5); 
	        tree.insert1(1); 
	        
	        /* Let us create following BST 
                  4 
	            /   \ 
	           2     6 
	     */
	      tree.insert1(4); 
	      tree.insert1(2); 
	      tree.insert1(6); 
	         
	      List<Integer> list = tree.merge(tree.root1, tree.root2);
	      
	      for(int i : list)
	    	  System.out.print(i+" ");
	    } 
}
