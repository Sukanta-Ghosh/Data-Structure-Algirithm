package Dynamic_Programming_Library;

import java.util.HashMap;

/* https://www.scaler.com/academy/mentee-dashboard/class/70871/homework/problems/4824/?navref=cl_pb_nv_tb */
public class LongestFibSubSequence {
    /*
     * Varity of 0-1 knapsack || Iterative Solution
     * T.C: O(n ^ 2)
     * S.C: O(n ^ 2)
     */
    public int solve(int[] A) {
        int n = A.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Set array value as map key
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }

        /*
         * DP State:
         * dp[i][j] => Longest fibonacci length can be formed from
         * i index to j index elements
         */
        int[][] dpTable = new int[n][n];

        /*
         * k represents 3rd fib element which we want to find by adding i and j.
         * j represents 2nd fib element
         */
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                /*
                 * A[i] + A[j] = A[k], so replace A[i] with A[k] - A[j]
                 * (i) check if it is smaller than 2nd fib element(A[j])
                 * (ii) check if A[k] - A[j] element index is present in map or not
                 */
                if (A[k] - A[j] < A[j] && map.containsKey(A[k] - A[j])) {
                    // Find index of A[i]
                    int i = map.get(A[k] - A[j]);
                    /*
                     * B/w element j and k, total fib series can be formed
                     * 1 + for including k idx element and total fib series b/w i and j
                     */
                    dpTable[j][k] = 1 + dpTable[i][j];

                    /* + 2 for including first 2 elements */
                    ans = Math.max(ans, dpTable[j][k] + 2);
                }
            }
        }

        if (ans >= 3) {
            return ans;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
