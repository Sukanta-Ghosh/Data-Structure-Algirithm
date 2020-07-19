package Tree;

import java.util.*;

public class TreeTraversalsIterative {
	Node root; 
	
	// An iterative process to print InOrder traversal of Binary tree 
    void inorder() 
    { 
        if (root == null) 
            return; 
    
        Stack<Node> stack = new Stack<Node>(); 
        Node curr = root; 
   
        while (curr != null || !stack.isEmpty()) 
        { 
            while (curr !=  null) 
            { 
            	stack.push(curr); 
                curr = curr.left; 
            } 
  
            curr = stack.pop(); 
            System.out.print(curr.key + " "); 

            curr = curr.right; 
        } 
    }
    
    // An iterative process to print PreOrder traversal of Binary tree 
    void preorder() { 
          
        // Base Case 
        if (root == null) { 
            return; 
        } 
  
        // Create an empty stack and push root to it 
        Stack<Node> stack = new Stack<Node>(); 
        stack.push(root);
  
        while(!stack.isEmpty()) { 
              
        	Node curr = stack.pop();
        	System.out.print(curr.key+" ");
        	
        	if(curr.right != null) {
        		stack.push(curr.right);
        	}
        	
        	if(curr.left != null) {
        		stack.push(curr.left);
        	}
            
        } 
    }
    
    /* An iterative process to print PostOrder traversal of Binary tree 
	 * using one Stack*/ 
    void postOrder(){
    	if(root == null)
    		return;
    	
    	Stack<Node> stack = new Stack<Node>();
    	Node current = root;
    	
    	while(!stack.isEmpty() || current != null) {
    		
    		if(current != null) 
    		{
    			stack.push(current);
    			current = current.left;
    		}
    		else
    		{
    			Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.key + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) 
                    {
                        temp = stack.pop();
                        System.out.print(temp.key + " ");
                    }
                } 
                else {
                    current = temp;
                }
    		}
    	}
    	
    }
    
	/* An iterative process to print PostOrder traversal of Binary tree 
	 * using Two Stack*/ 
    void postOrderTwoStack(){
    	if(root == null)
    		return;
    	
    	Stack<Node> stack1 = new Stack<Node>();
    	Stack<Node> stack2 = new Stack<Node>();
    	stack1.push(root);
    	
    	while(!stack1.isEmpty()) {
    		
    		Node curr = stack1.pop();
    		if(curr.left != null) {
    			stack1.push(curr.left);
    		}
    		if(curr.right != null) {
    			stack1.push(curr.right);
    		}
    		
    		stack2.push(curr);
    	}
    	
    	while(!stack2.isEmpty()) {
    		System.out.print(stack2.pop().key+" ");
    	}
    	
    }
    
    /* Given a binary tree, print its nodes in levelOrder*/
	void levelOrder()  
    { 
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        while (!queue.isEmpty())  
        { 
        	
            Node tempNode = queue.poll(); 
            System.out.print(tempNode.key + " "); 
  
            /*Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
            } 
  
            /*Enqueue right child */
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
            } 
        } 
    }
  
    public static void main(String args[]) 
    { 
  
        /* creating a binary tree and entering 
        the nodes */
    	TreeTraversalsIterative tree = new TreeTraversalsIterative();
    	
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
        
        
        /* Constructed binary tree is 
		        10 
		      /    \ 
		     5      30 
		   /   \ 	  \
		 -2     6 	   40
		   \	 \
		 	2	  8
		   /
		  -1
		*/
//		tree.root = new Node(10); 
//		tree.root.left = new Node(5); 
//		tree.root.right = new Node(30);
//		tree.root.right.right = new Node(40); 
//		tree.root.left.left = new Node(-2);
//		tree.root.left.left.right = new Node(2);
//		tree.root.left.left.right.left = new Node(-1);
//		tree.root.left.right = new Node(6);
//		tree.root.left.right.right = new Node(8);

        System.out.println("Inorder iterative Traversal:");
        tree.inorder();
        System.out.println("\nPreorder iterative Traversal:");
        tree.preorder();
        System.out.println("\nPostorder iterative Traversal:");
        tree.postOrderTwoStack();
        System.out.println("\nLevelorder iterative Traversal:");
        tree.levelOrder();
    } 
}
