package Dynamic_Programming_Library;

import java.util.Arrays;

public class RussianDollEnvelopes {
    /*
     * Iterative Solution
     * T.C: O(n ^ 2)
     * S.C: O(n)
     */
    public int solve(int[][] A) {
        int n = A.length;
        int ans = 1;
        /*
         * DP State:
         * dp[i]: Max subsequence len in (0-i) containing ith element
         */
        int[] dpTable = new int[n];
        dpTable[0] = 1;

        /* Sorting array in increasing order based on A[i][0] height */
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < n; i++) {
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (A[j][0] < A[i][0] && A[j][1] < A[i][1]) {
                    maxLen = Math.max(maxLen, dpTable[j]);
                }
            }
            dpTable[i] = maxLen + 1;
            ans = Math.max(ans, dpTable[i]);
        }

        return ans;
    }
}
