package Tree;
 
class Height{
    int h = 0;
}

public class CheckBalancedTree {
	
	Node root;
    
	/* Time Complexity - O(n) */
    boolean isBalanced(Node root, Height height){
        
        if(root == null){
            height.h = 0;
            return true;
        }
        
        Height lheight = new Height();
        Height rheight = new Height();
        boolean l = isBalanced(root.left, lheight);
        boolean r = isBalanced(root.right, rheight);
        
        int lh = lheight.h;
        int rh = rheight.h;
        
        height.h = 1 + Math.max(lh, rh);
        
        if(Math.abs(lh - rh) >= 2)
            return false;
        
        return l && r;  
    }
    
	public static void main(String args[]) 
    { 
        Height height = new Height();
  
        /* Constructed binary tree is (True Case)
                   1 
                 /   \ 
                2      3 
               / \    / 
              4   5  6 
            / 
           7        
        */ 
        CheckBalancedTree tree = new CheckBalancedTree();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.right = new Node(6); 
        tree.root.left.left.left = new Node(7); 
        
        
        /* Constructed binary tree is (False Case)
		       1 
		      /    
		    10      
		    /  
		   5    
		*/ 
        CheckBalancedTree tree1 = new CheckBalancedTree();
		tree1.root = new Node(1); 
		tree1.root.left = new Node(10);  
		tree1.root.left.left = new Node(5); 
		
  
        if (tree.isBalanced(tree.root, height)) 
            System.out.println("Tree is balanced"); 
        else
            System.out.println("Tree is not balanced"); 
    } 
}
