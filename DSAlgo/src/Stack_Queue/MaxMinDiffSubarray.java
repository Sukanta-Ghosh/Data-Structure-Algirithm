package Stack_Queue;

import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47558/assignment/problems/7042?navref=cl_tt_nv
 * solved without mod
 */
public class MaxMinDiffSubarray {

    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int solve(int[] A) {
        int n = A.length;
        /* ans is total sum MAX - MIN */
        long ans = 0;

        // Left nearest smaller element index no
        int[] nsli = new int[n];
        // Right nearest smaller element index no
        int[] nsri = new int[n];
        // Left nearest greater element index no
        int[] ngli = new int[n];
        // Right nearest greater element index no
        int[] ngri = new int[n];

        /* Call functions to compute */
        nsli = nearestSmallerLeftIndex(nsli, A);
        nsri = nearestSmallerRightIndex(nsri, A);
        ngli = nearestGreaterLeftIndex(ngli, A);
        ngri = nearestGreaterRightIndex(ngri, A);

        /*  */
        for (int i = 0; i < n; i++) {
            /*
             * i : present index element
             * max/min element from window array: (i - start) * (end - i)
             */

            // Adding max element in no of subarray it occuring
            ans = ans + (i - ngli[i]) * (ngri[i] - i) * A[i];

            // Subtracting min element in no of subarray it occuring
            ans = ans - (i - nsli[i]) * (nsri[i] - i) * A[i];
        }

        return (int) ans;
    }

    public int[] nearestSmallerLeftIndex(int[] nsli, int[] A) {
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < A.length; i++) {
            while (!st.empty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            if (st.empty()) {
                nsli[i] = -1;
            } else {
                nsli[i] = st.peek();
            }
            st.push(i);
        }

        return nsli;
    }

    public int[] nearestGreaterLeftIndex(int[] ngli, int[] A) {
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < A.length; i++) {
            while (!st.empty() && A[st.peek()] < A[i]) {
                st.pop();
            }

            if (st.empty()) {
                ngli[i] = -1;
            } else {
                ngli[i] = st.peek();
            }
            st.push(i);
        }

        return ngli;
    }

    public int[] nearestSmallerRightIndex(int[] nsri, int[] A) {
        Stack<Integer> st = new Stack<Integer>();

        for (int i = A.length - 1; i >= 0; i--) {
            while (!st.empty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            if (st.empty()) {
                nsri[i] = A.length;
            } else {
                nsri[i] = st.peek();
            }
            st.push(i);
        }

        return nsri;
    }

    public int[] nearestGreaterRightIndex(int[] ngri, int[] A) {
        Stack<Integer> st = new Stack<Integer>();

        for (int i = A.length - 1; i >= 0; i--) {
            while (!st.empty() && A[st.peek()] > A[i]) {
                st.pop();
            }

            if (st.empty()) {
                ngri[i] = A.length;
            } else {
                ngri[i] = st.peek();
            }
            st.push(i);
        }

        return ngri;
    }
}
