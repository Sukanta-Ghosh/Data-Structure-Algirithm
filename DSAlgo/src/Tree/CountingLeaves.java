package Tree;

import java.util.Stack;

/*Leaf nodes are those, which have no left child and right child*/
public class CountingLeaves {
	
	Node root; 
	
	/* Recursive Method */
	public int getLeafCount(Node node) {
		
		if(node == null)
			return 0;
		if(node.left == null && node.right == null)
			return 1;
		else
			return getLeafCount(node.left) + getLeafCount(node.right);
	}
	
	/* Iterative Method in preorder manner*/
	public int iterative() { 
        
        // Base Case 
        if (root == null) { 
            return 0; 
        } 
  
        // Create an empty stack and push root to it 
        Stack<Node> stack = new Stack<Node>(); 
        stack.push(root);
        int count = 0;
        
        while(!stack.isEmpty()) { 
              
        	Node curr = stack.pop();
        	
        	if(curr.right != null) {
        		stack.push(curr.right);
        	}
        	if(curr.left != null) {
        		stack.push(curr.left);
        	}
        	
        	if(curr.left == null && curr.right == null) {
        		//System.out.print(curr.key+" ");
        		count++;
        	}
            
        }
        return count;
    }
	
	int getLeafCount() {return getLeafCount(root);}
	
	public static void main(String args[])  
    { 
        /* create a tree */
		CountingLeaves tree = new CountingLeaves();
		
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
           
        System.out.println("The leaf count "
        		+ "recursively: " 
                             + tree.getLeafCount()); 
        
        System.out.println("The leaf count iteratively: " 
                + tree.iterative());
    } 
}
