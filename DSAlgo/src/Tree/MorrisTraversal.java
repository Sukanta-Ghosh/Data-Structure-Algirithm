package Tree;

/**
 * Date 03/08/2016
 * @author Tushar Roy 
 *
 * Morris inorder/preorder traversals
 *
 * Time complexity O(n) 
 * Space complexity O(1)
 */
public class MorrisTraversal {
	
	// Root of Binary Tree 
	Node root; 

	MorrisTraversal() 
	{ 
		root = null; 
	} 

    public void inorder(Node root) {
        Node current = root;
        while(current != null) {
            //left is null then print the node and go to right
            if (current.left == null) {
                System.out.print(current.key + " ");
                current = current.right;
            }
            else {
                //find the predecessor.
                Node predecessor = current.left;
                //To find predecessor keep going right till right node is not null or right node is not current.
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                //if right node is null then go left after establishing link from predecessor to current.
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }
                else
                { //left is already visit. Go right after visiting current.
                    predecessor.right = null;
                    System.out.print(current.key + " ");
                    current = current.right;
                }
            }
        }
    }

    public void preorder(Node root) {
        Node current = root;
        while (current != null) {
            if(current.left == null) {
                System.out.print(current.key + " ");
                current = current.right;
            }
            else {
                Node predecessor = current.left;
                while(predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    System.out.print(current.key + " ");
                    current = current.left;
                }else{
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
    
    void inorder() { inorder(root); } 
	void preorder() { preorder(root); }

    public static void main(String args[]) {
    	MorrisTraversal tree = new MorrisTraversal();
    	
//    	/* Constructed binary tree is 
//		        1 
//		      /   \ 
//		     2      3 
//		   /   \ 
//		  4     5 
//		*/
//      tree.root = new Node(1); 
//		tree.root.left = new Node(2); 
//		tree.root.right = new Node(3); 
//		tree.root.left.left = new Node(4); 
//		tree.root.left.right = new Node(5); 
		
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
		tree.root = new Node(10); 
		tree.root.left = new Node(5); 
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(40); 
		tree.root.left.left = new Node(-2);
		tree.root.left.left.right = new Node(2);
		tree.root.left.left.right.left = new Node(-1);
		tree.root.left.right = new Node(6);
		tree.root.left.right.right = new Node(8);
		
		System.out.println("Inorder:");
        tree.inorder();
        System.out.println("\nPreorder:");
        tree.preorder();
    }
}
