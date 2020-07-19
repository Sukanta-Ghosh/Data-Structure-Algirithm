package Tree;

import java.util.*;

public class MirrorTree {
	
	Node root;
	
	Node mirrorRecursive(Node node)  
    { 
        if (node == null) 
            return node; 
  
        /* do the subtrees */
        Node left = mirrorRecursive(node.left); 
        Node right = mirrorRecursive(node.right); 
  
        /* swap the left and right pointers */
        node.left = right; 
        node.right = left; 
  
        return node; 
    }
	
	void mirrorIterative(Node node)
    {
	    // Your code here
	    Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(node); 
        while (!queue.isEmpty())  
        { 
            Node curr = queue.poll();
            
            Node tempNode = curr.left;
            curr.left = curr.right;
            curr.right = tempNode;
  
            if (curr.left != null) { 
                queue.add(curr.left); 
            } 
  
            if (curr.right != null) { 
                queue.add(curr.right); 
            } 
        } 
    }
}
