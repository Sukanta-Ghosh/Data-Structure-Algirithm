package Dynamic_Programming_Library;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70871/assignment/problems/319?navref=cl_tt_lst_sl */
public class CoinSumInfinite {
    /*
     * Note: Varity of Unbounded knapsack
     * Iterative Approach
     * T.C: O(sum * n)
     * S.C: O(sum)
     */
    public int coinchange2(int[] A, int B) {
        int n = A.length;
        int[] coinValues = A;
        int sum = B;

        /*
         * DP State:
         * dp[j] => In how many combinations we can pay sum j
         */
        int[] dpTable = new int[sum + 1];
        /* 0 sum can be formed as 1 way so dp[0] = 1 */
        dpTable[0] = 1;

        /*
         * j denotes array index
         * i denotes sum to pay
         */
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= sum; i++) {
                /*
                 * If A[i] amount coin is selected then no ways sum can be formed
                 * i - A[j] >= 0 check if sum possible or not
                 */
                int leftCapacity = i - coinValues[j];
                if (leftCapacity >= 0) {
                    dpTable[i] = dpTable[i] + dpTable[leftCapacity];
                    dpTable[i] %= 1000007;
                }
            }
        }

        return dpTable[sum];
    }
}
