package Stack_Queue;

import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47558/assignment/problems/49/?navref=cl_pb_nv_tb */
public class LargestRectangleHistogram {
    /*
     * T.C: O(n)
     * S.C: O(n)
     * 
     * Catch:
     * 1. Create left nearest smaller element and right nearest smaller element arr
     * 2. Compute width for every index of arr by getting difference b/w
     * left small ele and right small ele.
     * 3. Find max area by width * height(arr ele at index i)
     */
    public int largestRectangleArea(int[] A) {
        int n = A.length;
        /* nslIdx array used to store left nearest smaller element index no */
        int[] nslIdx = new int[n];
        /* nsrIdx array used to store right nearest smaller element index no */
        int[] nsrIdx = new int[n];
        int maxArea = A[0];

        /* stLeft Stack used to store left nearest smaller element */
        Stack<Integer> stLeft = new Stack<Integer>();
        /* stLeft Stack used to store right nearest smaller element */
        Stack<Integer> stRight = new Stack<Integer>();

        /*
         * Iterate over arr to find left nearest smaller elements
         * arr
         */
        for (int i = 0; i < n; i++) {
            while (!stLeft.empty() && A[stLeft.peek()] >= A[i]) {
                stLeft.pop();
            }

            /*
             * If stack is empty, for nslidx put length as we will
             * count -1 + 1
             */
            if (stLeft.empty()) {
                nslIdx[i] = -1;
            } else {
                nslIdx[i] = stLeft.peek();
            }
            stLeft.push(i);
        }

        /*
         * Iterate over arr to find right nearest smaller elements
         * arr
         */
        for (int i = n - 1; i >= 0; i--) {
            while (!stRight.empty() && A[stRight.peek()] >= A[i]) {
                stRight.pop();
            }

            /*
             * If stack is empty, for nsridx put length as we will
             * count n - 1
             */
            if (stRight.empty()) {
                nsrIdx[i] = n;
            } else {
                nsrIdx[i] = stRight.peek();
            }
            stRight.push(i);
        }

        /*
         * For every index of left nearest smaller arr and
         * right nearest smaller arr,
         * compute width differenceb/w left nearest smaller and right nearest smaller
         * element.
         * Original arr element is height
         */
        for (int i = 0; i < n; i++) {
            int width = nsrIdx[i] - nslIdx[i] - 1;
            int height = A[i];
            // find maximum area for histogram
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }
}
