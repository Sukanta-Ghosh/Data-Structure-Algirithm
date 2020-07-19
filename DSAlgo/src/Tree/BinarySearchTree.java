package Tree;

public class BinarySearchTree {
	
	Node root; 
	
	/* Recursive Approach */
	boolean searchRec(Node root, int x) {
		
		if(root == null)
			return false;
		else if(root.key == x)
			return true;
		else if(root.key > x)
			return searchRec(root.left, x);
		else
			return searchRec(root.right, x);
	}
	
	/* Iterative Approach */
	boolean searchIte(Node root, int x) {
		
		while(root != null) {
			
			if(root.key == x)
				return true;
			else if(root.key > x)
				root = root.left;
			else
				root = root.right;
		}
		return false;
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
	
	/* Iterative Approach */
	Node insertIte(Node root, int x) {
		
		Node temp = new Node(x);
		Node parent = null, curr = root;
		
		while(curr != null) {
			
			parent = curr;
			
			if(curr.key > x)
				curr = curr.left;
			else if(curr.key < x)
				curr = curr.right;
			else
				return root;		
		}
		
		if(parent == null)
			return temp;
		
		if(parent.key > x)
			parent.left = temp;
		else
			parent.right = temp;
		
		return root;
	}
	
	Node delNode(Node root, int x) {
		
		if(root == null)
			return null;
		
		if(root.key > x)
			root.left = delNode(root.left, x);
		else if(root.key < x)
			root.right = delNode(root.right, x);
		else {
			
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
//				/* Inorder Successor Code */
//				Node succParent = null;
//				Node curr = root.right;
//				while(curr != null && curr.left != null) {
//					succParent = curr;
//					curr = curr.left;
//				}
				
				//Node succ = curr;
				Node succ = getSucc(root);
				root.key = succ.key;
				
				//succParent.left = null; 
				root.right = delNode(root.right, succ.key);
			}
		}
		return root;
	}
	
	Node getSucc(Node root) {
		Node curr = root.right;
		while(curr != null && curr.left != null)
			curr = curr.left;
		return curr;
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
	
	 public static void main(String[] args) { 
		 
	        BinarySearchTree tree = new BinarySearchTree(); 
	  
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
 
	        tree.inorder(); 
	        tree.delNode(tree.root, 70);
	        System.out.println();
	        tree.inorder();
	    } 
}
