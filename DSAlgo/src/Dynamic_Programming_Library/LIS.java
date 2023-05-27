package Dynamic_Programming_Library;

public class LIS {
    /*
     * Iterative Solution
     * T.C: O(n ^ 2)
     * S.C: O(n)
     */
    public int lis(final int[] A) {
        int n = A.length;
        int ans = 0;
        /*
         * DP State:
         * dp[i]: Max subsequence len in (0-i) containing ith element
         */
        int[] dpTable = new int[n];

        /* First element LIS is 1 */
        dpTable[0] = 1;

        /* Loop is starting from 1, as 0 len string LIS is 1 */
        for (int i = 1; i < n; i++) {
            int maxLen = 0;
            /* Check for all elements before ith element */
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    maxLen = Math.max(maxLen, dpTable[j]);
                }
            }
            dpTable[i] = maxLen + 1;
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dpTable[i]);
        }

        return ans;
    }
}
