package Tree;

//Java program for different tree traversals 

/* Class containing left and right child of current 
node and key value*/ 
class TreeTraversalsRecursive 
{ 
	// Root of Binary Tree 
	Node root; 

	TreeTraversalsRecursive() 
	{ 
		root = null; 
	} 

	/* Recursive method to print its nodes in postOrder. */
	void postorder(Node node) 
	{ 
		if (node == null) 
			return; 

		postorder(node.left); 

		postorder(node.right); 

		System.out.print(node.key + " "); 
	} 

	/* Recursive method to print its nodes in inOrder*/
	void inorder(Node node) 
	{ 
		if (node == null) 
			return; 

		inorder(node.left); 

		System.out.print(node.key + " "); 

		inorder(node.right); 
	} 

	/* Recursive method to print its nodes in preOrder*/
	void preorder(Node node) 
	{ 
		if (node == null) 
			return; 

		System.out.print(node.key + " "); 

		preorder(node.left); 

		preorder(node.right); 
	}
	
	
	/* Height of the Tree */
	public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight  = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

	// Wrappers over above recursive functions for static call
	void postorder() {	 postorder(root); } 
	void inorder() {	 inorder(root); } 
	void preorder() {	 preorder(root); } 

	// Driver method 
	public static void main(String[] args) 
	{ 
		TreeTraversalsRecursive tree = new TreeTraversalsRecursive();
		
		/* Constructed binary tree is 
	          1 
	        /   \ 
	       2      3 
	     /   \ 
	    4     5 
	  */
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		System.out.println("Preorder traversal:"); 
		tree.preorder(); 

		System.out.println("\nInorder traversal:"); 
		tree.inorder(); 

		System.out.println("\nPostorder traversal:         "); 
		tree.postorder(); 
		
		System.out.println("\nHeight of the Tree is: "+tree.height(tree.root));
	} 
} 
