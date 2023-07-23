package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70857/assignment/problems/989?navref=cl_tt_lst_sl */
public class AthLargestElement {
    /*
     * T.C: O(nLogA)
     * S.C: O(A)
     */
    public int[] solve(int A, int[] B) {
        int n = B.length;

        /*
         * Intilize an array and fill with -1 upto
         * A - 2 th position
         * Start array indx from A - 1 th index
         */
        int[] ans = new int[n];
        Arrays.fill(ans, 0, A - 1, -1);
        int idx = A - 1;

        /* Define a min heap as Ath largest element means min element */
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        /* First add A no of elements in min heap */
        for (int i = 0; i < A; i++) {
            pQueue.add(B[i]);
        }
        // Add min elment in present ans array idx position
        ans[idx++] = pQueue.element();

        /* In this iteration */
        for (int i = A; i < n; i++) {
            /*
             * If present element is greater than min heap min element,
             * then remove min elment and add present element to heap.
             * If prsent element is smaller than min heap min element then
             * it will never be Ath smallest element
             */
            if (B[i] > pQueue.element()) {
                pQueue.remove();
                pQueue.add(B[i]);
            }
            /* Add min heap min element in ans array */
            ans[idx++] = pQueue.element();
        }

        return ans;
    }
}
