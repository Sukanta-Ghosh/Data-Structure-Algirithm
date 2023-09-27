package Dynamic_Programming_Library;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70871/assignment/problems/9318?navref=cl_tt_lst_sl */
public class CuttingRod {
    /*
     * Note: Varity of Unbounded knapsack
     * T.C: O(n ^ 2)
     * S.C: O(n)
     */
    public int solve(int[] A) {
        int n = A.length;
        int[] unitPrice = A;
        /*
         * DP state:
         * dp[i] => Max value we can get by selling length of rod i
         */
        int[] dpTable = new int[n + 1];

        /*
         * i denoting rod length
         * j denoting (0-i) th rod length, iterate over each rod length and detemine
         * max value we can get
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                /*
                 * A[j - 1] + dpTable[i - j] means for jth len rod choose its value +
                 * remaining i - j rod length max value from dpTable
                 * Check for each length
                 * Note: A[j - 1] cuz in A array results store from 0 index here we consider j
                 * from 1 based index
                 */
                // i - j: Checking i - j len rod can be formed or not
                if (i - j >= 0) {
                    dpTable[i] = Math.max(dpTable[i], unitPrice[j - 1] + dpTable[i - j]);
                }
            }
        }

        /* Result will be stored at nth index as it has max value of all posibilities */
        return dpTable[n];
    }

    public static void main(String[] args) {
        int[] A = { 3, 4, 1, 6, 2 };
    }
}
