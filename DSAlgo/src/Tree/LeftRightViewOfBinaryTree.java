package Tree;

import java.util.*;

public class LeftRightViewOfBinaryTree {
	
	Node root; 
	
	/* Recursive Approach */
	int maxLevel = 0;
	void leftViewRecursiveUtil(Node node, int level) 
    { 
        // Base Case 
        if (node == null) 
            return; 
  
        // If this is the first node of its level 
        if (maxLevel < level) { 
            System.out.print(" " + node.key); 
            maxLevel = level; 
        } 
  
        // Recur for left and right subtrees 
        leftViewRecursiveUtil(node.left, level + 1); 
        leftViewRecursiveUtil(node.right, level + 1); 
    } 
  
    // A wrapper over leftViewRecursiveUtil() 
    void leftViewRecursive() 
    { 
    	leftViewRecursiveUtil(root, 1); 
    } 
    
	/* Iterative Approach */
    void leftViewIterative(Node root) 
    { 
        if (root == null) 
            return; 
      
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);  
        queue.add(null); 
      
        while (queue.size() > 0)  
        { 
            Node temp = queue.peek(); 
      
            if (temp != null) 
            {       
                System.out.print(temp.key + " "); 

                while (queue.peek() != null) 
                { 
                    if (temp.left != null) 
                    	queue.add(temp.left); 
                    if (temp.right != null) 
                    	queue.add(temp.right); 

                    queue.remove(); 
                    temp = queue.peek(); 
                }       
                queue.add(null); 
            } 
            queue.remove(); 
        } 
    }
    
	/* Recursive Approach */
    class Max_level { 
    	  
        int max_level; 
    }
    
    void rightViewRecursiveUtil(Node node, int level, Max_level max_level) { 
    	  
        // Base Case 
        if (node == null)  
            return; 
  
        // If this is the last Node of its level 
        if (max_level.max_level < level) { 
            System.out.print(node.key + " "); 
            max_level.max_level = level; 
        } 
  
        // Recur for right subtree first, then left subtree 
        rightViewRecursiveUtil(node.right, level + 1, max_level); 
        rightViewRecursiveUtil(node.left, level + 1, max_level); 
    } 
  
    void rightViewRecursive() 
    { 
    	Max_level max = new Max_level();
    	rightViewRecursiveUtil(root, 1, max); 
    } 
    
	/* Iterative Approach */
    void rightViewIterative(Node root)  
    { 
        if (root == null) 
            return; 
              
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root); 
          
        while (!queue.isEmpty())  
        {    
            int n = queue.size(); 
 
            for (int i = 1; i <= n; i++) { 
                Node temp = queue.poll(); 

                if (i == n) 
                    System.out.print(temp.key + " "); 

                if (temp.left != null) 
                    queue.add(temp.left); 
 
                if (temp.right != null) 
                    queue.add(temp.right); 
            } 
        } 
    } 
    
    public static void main(String[] args) {
		
    	
    	LeftRightViewOfBinaryTree tree = new LeftRightViewOfBinaryTree();
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
		
		tree.leftViewRecursive();
		tree.leftViewIterative(tree.root);
		tree.rightViewRecursive();
		tree.rightViewIterative(tree.root);
	}
}
