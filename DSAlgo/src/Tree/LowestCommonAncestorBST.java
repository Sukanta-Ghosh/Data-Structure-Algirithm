package Tree;
 
public class LowestCommonAncestorBST 
{ 
	// Root of the Binary Tree 
	Node root; 
	
	/* Iterative Approach */
	Node lcaIte(Node root, int n1, int n2)  
	{  
	    while (root != null)  
	    {  
	        // If both n1 and n2 are smaller  
	        // than root, then LCA lies in left  
	        if (root.key > n1 && root.key > n2)  
	        	root = root.left;  
	  
	        // If both n1 and n2 are greater  
	        // than root, then LCA lies in right  
	        else if (root.key < n1 && root.key < n2)  
	        	root = root.right;  
	  
	        else break;  
	    }  
	    return root;  
	} 
	
	/* Recursive Approach */
	Node lcaRec(Node node, int n1, int n2)  
    { 
        if (node == null) 
            return null; 
   
        // If both n1 and n2 are smaller than root, then LCA lies in left 
        if (node.key > n1 && node.key > n2) 
            return lcaRec(node.left, n1, n2); 
   
        // If both n1 and n2 are greater than root, then LCA lies in right 
        if (node.key < n1 && node.key < n2)  
            return lcaRec(node.right, n1, n2); 
   
        return node; 
    } 
	
	
	public static void main(String args[]) 
	{ 
		LowestCommonAncestorBST tree = new LowestCommonAncestorBST();
	}	
} 

