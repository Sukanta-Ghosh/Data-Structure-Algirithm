package Tree;

public class DiameterOfBinaryTree {
	 
	Node root;
	
	/* Concept is Dynamic Programming */
	class A 
	{ 
	    int ans = Integer.MIN_VALUE; 
	} 
	  
	int diameterUtil(Node root, A a)  
	{  
	    if (root == null)  
	        return 0;  
	  
	    int left_height = diameterUtil(root.left, a);  
	  
	    int right_height = diameterUtil(root.right, a);  
	  
	    // update the answer, because diameter of a  
	    // tree is nothing but maximum value of  
	    // (left_height + right_height + 1) for each node  
	    a.ans = Math.max(a.ans, 1 + left_height + 
	                    right_height);  
	  
	    return 1 + Math.max(left_height, right_height);  
	}  
	
	public int diameter(){
		A a = new A();
		diameterUtil(root, a); 
		return a.ans;
	}
	
	public static void main(String[] args)  
	{  
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
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
		
		
	    System.out.println("Diameter is " + tree.diameter());  
	} 
	  
}
