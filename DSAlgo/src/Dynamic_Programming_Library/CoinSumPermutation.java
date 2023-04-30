package Dynamic_Programming_Library;

public class CoinSumPermutation {
    /*
     * Note: Varity of Unbounded Knapsack
     * Iterative Approach
     * T.C: O(sum * n)
     * S.C: O(sum)
     */
    public int coinchange2(int[] A, int B) {
        int n = A.length;
        int sum = B;

        /*
         * DP State:
         * dp[i] => In how many combinations we can pay sum i
         */
        int[] dpTable = new int[sum + 1];
        /* ) sum can be as 1 way so dp[0] = 1 */
        dpTable[0] = 1;

        /*
         * i denotes array index
         * j denotes sum to pay
         */
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                /*
                 * If A[i] amount coin is selected thenways sum can be formed
                 * i - A[j] >= 0 check if sum possible or not
                 */
                if (i - A[j] >= 0) {
                    dpTable[i] = dpTable[i] + dpTable[i - A[j]];
                    dpTable[i] %= 1000007; // If number is big
                }
            }
        }

        return dpTable[sum];
    }
}
