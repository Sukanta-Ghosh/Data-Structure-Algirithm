package Misc;

import java.util.Arrays;

/* Qs: https://www.scaler.com/test/c119796a5e/#/problem_3 */
public class MaximumSumMatrixBS {
    /*
     * The idea is to use Binary Search.
     * Note: Sort the array A, since we need to find the maximum sum suffling of
     * rows don’t matter.
     * 
     * Fill each cell of ith row with value A[i].
     * Now the values in the ith coloumn should be less than equal to B[i].
     * 
     * This can be done by finding the first index, let’s say idx, such that
     * A[idx] > B[i]. All the elements right to this idx(including) should be equal
     * to B[i] and we have to sum all the values on left.
     * 
     * Add the above value in some variable and take modulo and return the answer.
     */

    /*
     * T.C: O(nlogn + mlogn)
     * S.C: O(n)
     */
    public int solve(int[] A, int[] B) {
        int totalSum = 0;
        int mod = 1000000007;
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);

        /* prefixSum to find totalsum of all rows */
        int[] prefixSum = new int[n];

        /* Find prefix sum of A */
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                prefixSum[i] += prefixSum[i - 1];
            }
            prefixSum[i] += A[i];
        }

        /* Iterate through B and find total Sum */
        for (int i = 0; i < m; i++) {
            /*
             * Do Binary Search and found upper index of
             * present col element
             */
            int index = upperBound(A, 0, n - 1, B[i]);
            /*
             * If index is last index, then simply add prefixSum of last index
             * for that particular row to add all elements
             */
            if (index == n) {
                totalSum += prefixSum[index - 1];
            }
            /*
             * if index is not last element, then present column element
             * if max element so, multiply element with remaining index
             * and add
             */
            else {
                if (index != 0) {
                    totalSum += prefixSum[index - 1];
                }
                totalSum += B[i] * (n - index);
            }
        }
        return totalSum;
    }

    /* Binary Search method to find upper bound of search element */
    public int upperBound(int[] A, int low, int high, int element) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] > element) {
                // high is taken as mid to take upperbound
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /*
     * T.C: O(m * n)
     * S.C: O(1)
     */
    public int bruteForce(int[] A, int[] B) {
        int totalSum = 0;
        int mod = 1000000007;
        int n = A.length;
        int m = B.length;

        int minColVal = 0;
        for (int j = 0; j < m; j++) {
            minColVal = Math.min(minColVal, B[j]);
        }

        for (int i = 0; i < n; i++) {
            if (A[i] <= minColVal) {
                totalSum += A[i];
            } else {

                for (int j = 0; j < m; j++) {
                    totalSum += Math.min(A[i], B[j]);
                }
            }

            totalSum %= mod;
        }

        return totalSum;
    }
}
