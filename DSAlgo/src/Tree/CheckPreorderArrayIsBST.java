package Tree;

import java.util.*;

/*For Recursive Approach*/
class Index { 
	  
    int index = 0; 
} 

public class CheckPreorderArrayIsBST {
	
	/*
	 * GFG link :
	   https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-
	   traversal-of-binary-search-tree/
	 */
	/* Iterative Approach */
	boolean canRepresentBST(int pre[], int n) { 
        // Create an empty stack 
        Stack<Integer> s = new Stack<Integer>(); 
  
        // Initialize current root as minimum possible 
        // value 
        int root = Integer.MIN_VALUE; 
  
        // Traverse given array 
        for (int i = 0; i < n; i++) { 
            // If we find a node who is on right side 
            // and smaller than root, return false 
            if (pre[i] < root) { 
                return false; 
            } 
  
            // If pre[i] is in right subtree of stack top, 
            // Keep removing items smaller than pre[i] 
            // and make the last removed item as new 
            // root. 
            while (!s.empty() && s.peek() < pre[i]) { 
                root = s.pop(); 
                //s.pop(); 
            } 
  
            // At this point either stack is empty or 
            // pre[i] is smaller than root, push pre[i] 
            s.push(pre[i]); 
        } 
        return true; 
    } 
	
	/* Iterative Approach */
	Node preorderToBST(int pre[], int size) { 
		  
        // The first element of pre[] is always root 
        Node root = new Node(pre[0]); 
  
        Stack<Node> s = new Stack<Node>(); 
  
        // Push root 
        s.push(root); 
  
        // Iterate through rest of the size-1 items of given preorder array 
        for (int i = 1; i < size; ++i) { 
            Node temp = null; 
  
            /* Keep on popping while the next value is greater than 
             stack's top value. */
            while (!s.isEmpty() && s.peek().key < pre[i]) { 
                temp = s.pop(); 
            } 
  
            // Make this greater value as the right child 
            // and push it to the stack 
            if (temp != null) { 
                temp.right = new Node(pre[i]); 
                s.push(temp.right); 
            }  
              
            // If the next value is less than the stack's top 
            // value, make this value as the left child of the  
            // stack's top node. Push the new node to stack 
            else { 
                temp = s.peek(); 
                temp.left = new Node(pre[i]); 
                s.push(temp.left); 
            } 
        } 
  
        return root; 
    }
	
	 
	  
    // A recursive function to construct BST from pre[]. preIndex is used 
    // to keep track of index in pre[]. 
	Index index = new Index();
    Node constructTreeUtil(int pre[], Index preIndex, int key, 
            int min, int max, int size) { 
  
        // Base case 
        if (preIndex.index >= size) { 
            return null; 
        } 
  
        Node root = null; 
  
        // If current element of pre[] is in range, then 
        // only it is part of current subtree 
        if (key > min && key < max) { 
  
            // Allocate memory for root of this  
            // subtree and increment *preIndex 
            root = new Node(key); 
            preIndex.index = preIndex.index + 1; 
  
            if (preIndex.index < size) { 
  
                // Construct the subtree under root 
                // All nodes which are in range {min .. key}  
                // will go in left subtree, and first such  
                // node will be root of left subtree. 
                root.left = constructTreeUtil(pre, preIndex,  
                            pre[preIndex.index], min, key, size); 
  
                // All nodes which are in range {key..max}  
                // will go in right subtree, and first such 
                // node will be root of right subtree. 
                root.right = constructTreeUtil(pre, preIndex,  
                             pre[preIndex.index], key, max, size); 
            } 
        } 
  
        return root; 
    } 
  
    // The main function to construct BST from given preorder traversal. 
    // This function mainly uses constructTreeUtil() 
    Node constructTreeRec(int pre[], int size) { 
        
        return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, 
                Integer.MAX_VALUE, size); 
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
		
		CheckPreorderArrayIsBST tree = new CheckPreorderArrayIsBST(); 
        int pre[] = {10, 5, 1, 7, 40, 50}; 
        int size = pre.length; 
        
        Node root = tree.preorderToBST(pre, size); 
        System.out.println("Inorder traversal(Iterative):"); 
        tree.inorderRec(root); 
        
        Node node = tree.constructTreeRec(pre, size); 
        System.out.println("\nInorder traversal(Recursive):"); 
        tree.inorderRec(node); 
    } 
}
