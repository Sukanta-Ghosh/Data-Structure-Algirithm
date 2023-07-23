package Heap;

import java.util.PriorityQueue;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70857/assignment/problems/9264?navref=cl_tt_lst_sl */
public class KPlacesApart {
    /*
     * T.C: O(nlogB)
     * S.C: O(B)
     */
    public int[] solve(int[] A, int B) {
        int n = A.length;

        int[] ans = new int[n];

        /* Define a min heap */
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        /* Add array elements to min heap upto B elements */
        for (int i = 0; i <= B; i++) {
            pQueue.add(A[i]);
        }

        /* Add first B sorted elements in ans array */
        int idx = 0;
        ans[idx++] = pQueue.remove();

        /*
         * In this iteration, add next item and get min item
         * from min heap as all the elements B places apart
         */
        for (int i = B + 1; i < n; i++) {
            pQueue.add(A[i]);
            ans[idx++] = pQueue.remove();
        }

        /* Add last B sorted elements into ans array */
        while (pQueue.size() > 0) {
            ans[idx++] = pQueue.remove();
        }

        return ans;
    }
}
