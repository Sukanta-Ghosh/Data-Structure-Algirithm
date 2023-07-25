package Dynamic_Programming_Library;

import java.util.Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70875/assignment/problems/4826?navref=cl_tt_lst_sl */
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
        /* For 0 th envelope, one way can be arrange */
        dpTable[0] = 1;

        /* Sorting array in increasing order based on height(A[i][0]) */
        Arrays.sort(A, (a, b) -> a[0] - b[0]);

        /* Iterate to find max envelope */
        for (int i = 1; i < n; i++) {
            int maxLen = 0;
            /* For i th envelope, how many envelope can fit b/w 0 to i th envelope */
            for (int j = 0; j < i; j++) {
                /* If jth envelope is small, then */
                if (A[j][0] < A[i][0] && A[j][1] < A[i][1]) {
                    maxLen = Math.max(maxLen, dpTable[j]);
                }
            }
            /* 1 is added to maxLen to include present envelope */
            dpTable[i] = maxLen + 1;

            /* Update ans as height envelope can fit */
            ans = Math.max(ans, dpTable[i]);
        }

        return ans;
    }
}
