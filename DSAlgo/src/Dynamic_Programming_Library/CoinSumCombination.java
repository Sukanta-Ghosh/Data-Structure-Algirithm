package Dynamic_Programming_Library;

/* Qs check in DP 4: Applications of Knapsack notes in DP */
public class CoinSumCombination {
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
         * dp[j] => In how many combinations we can pay sum j
         */
        int[] dpTable = new int[sum + 1];
        /* ) sum can be as 1 way so dp[0] = 1 */
        dpTable[0] = 1;

        /*
         * j denotes array index
         * i denotes sum to pay
         */
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= sum; i++) {
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
