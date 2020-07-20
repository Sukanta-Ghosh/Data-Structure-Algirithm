package Tree;

public class CheckBST {
	
	Node root;
	
	/* PreOrder Traversal using Range*/
	boolean isBST(Node root, int min, int max) {
		
		if(root == null)
			return true;
		
//		if(root.key <= min || root.key >= max)
//			return false;
		
		return (root.key > min && root.key < max &&
				isBST(root.left, min, root.key) && isBST(root.right, root.key, max));
	}
	
	/* InOrder traversal, check if Tree is sorted. */
	int prev = Integer.MIN_VALUE;
	boolean isBSTInOrder(Node root) {
		
		if(root == null)
			return true;
		
		if(!isBSTInOrder(root.left))
			return false;
		
		if(root.key <= prev)
			return false;
		
		prev = root.key;
		
		return isBSTInOrder(root.right);
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
	
	/* Another Way */
	boolean isBST1(Node root, Node l, Node r)  
	{  
	    // Base condition  
	    if (root == null)  
	        return true;  
	  
	    if (l != null && root.key <= l.key)  
	        return false;  
	  
	    if (r != null && root.key >= r.key)  
	        return false;  
	  
	    // check recursively for every node.  
	    return isBST1(root.left, l, root) &&  
	        isBST1(root.right, root, r);  
	}  
	
	public static void main(String[] args) { 
		 
		CheckBST tree = new CheckBST(); 
		
	        /* Let us create following BST 
	              50 
	           /     \ 
	          30      70 
	         /  \    /  \ 
	       20   40  60   80 */
	        tree.insert(50); 
	        tree.insert(30); 
	        tree.insert(20); 
	        tree.insert(40); 
	        tree.insert(70); 
	        tree.insert(60); 
	        tree.insert(80);
	        
	        /* Let us create following Binary Tree 
	            20 
	          /    \ 
	         8      30 
	           	   /  \ 
	       		 18   35 */
	        CheckBST tree1 = new CheckBST();
	        tree1.root = new Node(20);
	        tree1.root.left = new Node(8);
	        tree1.root.right = new Node(30);
	        tree1.root.right.left = new Node(18);
	        tree1.root.right.right = new Node(35);
	        

	        System.out.println(
	        		tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	        
	        System.out.println(
	        		tree1.isBST(tree1.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	    } 
}
