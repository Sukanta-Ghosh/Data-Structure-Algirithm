package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47562/assignment/problems/206?navref=cl_tt_lst_sl */
public class LevelOrderTraversal {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public ArrayList<ArrayList<Integer>> solve(Node A) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

        /* Define Queue to store level by level */
        Queue<Node> q = new LinkedList<>();
        // Add root node in queue
        q.add(A);

        /* Until queue size is 0 */
        while (q.size() > 0) {
            /* Store size */
            int n = q.size();
            /* list is defined to store all elements in any one level only */
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                Node node = q.remove();
                // Add queue first value in list
                list.add(node.key);

                /*
                 * Check if left or right child is present,
                 * then add
                 */
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            /* Add any level all elements into 2d Arraylist */
            resultList.add(list);
        }

        return resultList;
    }
}
