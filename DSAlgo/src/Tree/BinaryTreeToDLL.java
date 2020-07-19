package Tree;

public class BinaryTreeToDLL {
	
	Node prev = null; 
	Node head;
	
	/* Left to Right */
	void leftToRight(Node root)  
    { 
        // Base case 
        if (root == null) 
            return; 
   
        // Recursively convert left subtree 
        leftToRight(root.left); 
   
        // Now convert this node 
        if (prev == null)  
            head = root; 
        else
        { 
            root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        // Finally convert right subtree 
        leftToRight(root.right); 
    } 
	
	/* Right to Left */
	void rightToLeft(Node root)  
    { 
        // Base cases 
        if (root == null) 
            return; 
  
        // Recursively convert right subtree 
        rightToLeft(root.right); 
  
        // insert root into DLL 
        root.right = head; 
  
        // Change left pointer of previous head 
        if (head != null) 
            (head).left = root; 
  
        // Change head of Doubly linked list 
        head = root; 
  
        // Recursively convert left subtree 
        rightToLeft(root.left); 
    } 
}
