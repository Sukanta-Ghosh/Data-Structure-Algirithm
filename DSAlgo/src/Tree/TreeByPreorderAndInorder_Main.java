package Tree;

import java.util.ArrayList;
import java.util.HashMap;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47562/homework/problems/219?navref=cl_tt_lst_sl */
/* T.C: O(n ^ 2)
 * S.C: O(H)
 * H: Height of Tree
 */
public class TreeByPreorderAndInorder_Main {
    /* Map to store inorder element and their index */
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    // To store A
    ArrayList<Integer> preOrder;

    /*
     * A: Preorder traversal
     * B: Inorder traversal
     */
    public Node buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        preOrder = A;

        /* Add inorder element as key and their index as value */
        for (int i = 0; i < n; i++) {
            map.put(B.get(i), i);
        }

        /*
         * Initialize pre and in start end index to create recursive
         * function
         */
        int preStart = 0;
        int preEnd = n - 1;
        int inStart = 0;
        int inEnd = n - 1;

        return createTree(preStart, preEnd, inStart, inEnd);
    }

    /* Method to create Tree */
    public Node createTree(int preStart, int preEnd, int inStart, int inEnd) {
        /* Create and return null node if start is more than end */
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        /*
         * Get first element from preOrder ArrayList which is root node
         * of present tree
         */
        int rootData = preOrder.get(preStart);
        // Create a root node for present tree
        Node root = new Node(rootData);
        /* Find index of present root in map */
        int rootIndexInorder = map.get(rootData);

        // No of elements in left side of the tree
        int leftSideSize = rootIndexInorder - inStart;

        // Arguments list: preStart, preEnd, inStart, inEnd
        root.left = createTree(preStart + 1, preStart + leftSideSize, inStart, rootIndexInorder - 1);
        root.right = createTree(preStart + leftSideSize + 1, preEnd, rootIndexInorder + 1, inEnd);

        return root;
    }
}
