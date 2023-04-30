package Dynamic_Programming_Library;

/* https://www.scaler.com/academy/mentee-dashboard/class/70869/assignment/problems/9292?navref=cl_tt_lst_sl
 * https://www.scaler.com/academy/mentee-dashboard/class/70871/assignment/problems/9347?navref=cl_tt_lst_sl
 */
public class Knapsack01 {

    /*
     * Iterative Approach || Time Optimized(Based on constraints)
     * T.C: O(n * maxValue)
     * S.C: O(n * maxValues)
     */
    public int betterApproach(int[] A, int[] B, int C) {
        int n = A.length;
        int[] values = A;
        int[] weights = B;
        int maxValue = 50 * n;

        /*
         * DP State
         * dp[i][j] => Minimum weight required to get
         * value j with 0-i elements
         */
        // j represents weigth capacity
        int[][] dpTable = new int[n + 1][maxValue + 1];
        for (int j = 0; j <= maxValue; j++) {
            dpTable[0][j] = Integer.MAX_VALUE;
        }
        dpTable[0][0] = 0;

        /*
         * i represents values and weights index
         * j represents values upto highest can be achieved
         * 
         * i is taking from 1 index as for 0 capacity j
         * 0 value can be obtained
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxValue; j++) {
                /* If i - 1 th element is not selected */
                int rejection = dpTable[i - 1][j];

                /*
                 * If i - 1 th element is selected
                 * check if leftCapacity can be obtained or not
                 */
                int leftValue = j - values[i - 1];
                int selected = Integer.MAX_VALUE;
                if (leftValue >= 0 && dpTable[i - 1][leftValue] != Integer.MAX_VALUE) {
                    selected = weights[i - 1] + dpTable[i - 1][leftValue];
                }

                dpTable[i][j] = Math.min(selected, rejection);
            }
        }

        /*
         * Check <= weight in last row from maxValue, return j as max value
         * can be obtained to by min weight at dp[n][j] th cell
         */
        int ans = 0;
        for (int j = maxValue; j >= 0; j--) {
            if (dpTable[n][j] <= C) {
                ans = j;
                break;
            }
        }

        return ans;
    }

    /*
     * Iterative Approach || Time & Space Optimized(Based on constraints)
     * T.C: O(n * maxValue)
     * S.C: O(maxValues)
     */
    public int betterSpaceApproach(int[] A, int[] B, int C) {
        int n = A.length;
        int[] values = A;
        int[] weights = B;
        int maxValue = 50 * n;

        /*
         * DP State
         * TODO: dp[i][j] =>
         */
        // j represents weigth capacity
        int[] dpTable = new int[maxValue + 1];
        for (int j = 0; j <= maxValue; j++) {
            dpTable[j] = Integer.MAX_VALUE;
        }
        dpTable[0] = 0;

        /*
         * i represents values and weights index
         * j represents values upto highest can be achieved
         * 
         * i is taking from 1 index as for 0 capacity j
         * 0 value can be obtained
         */
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= maxValue; j++) {
                for (int val = maxValue; val >= A[i]; val--) {
                    dpTable[val] = Math.min(dpTable[val], weights[i] + dpTable[val - values[i]]);
                }
            }
        }

        /*
         * Check <= weight in last row from maxValue, return j as max value
         * can be obtained to by min weight at dp[n][j] th cell
         */
        int ans = 0;
        for (int j = maxValue; j >= 0; j--) {
            if (dpTable[j] <= C) {
                ans = j;
                break;
            }
        }

        return ans;
    }

    /*
     * Iterative Approach
     * T.C: O(n * k)
     * S.C: O(n * k)
     */
    public int iterative(int[] A, int[] B, int C) {
        int[] values = A;
        int[] weights = B;
        int n = values.length;

        int cap = C;
        /*
         * DP State: i denotes no of element, j denotes capacity
         * dp[i][j] => Max value we can get in a bag of capacity j, such that
         * you can choose array of i tiems.
         */
        int[][] dpTable = new int[n + 1][cap + 1];

        /*
         * i represents values and weights index
         * j represents capacity
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                /*
                 * i == 0 || j == 0 row by default contains 0
                 * 1. For i == 0: With 0 weight 0 profit can be achieve
                 * 2. For j == 0: With 0 capacity, 0 value can be achieve
                 */

                /*
                 * elements starts from 1 indexing in dp table,
                 * so, for present cell i converted to i - 1.
                 */
                // If present element is rejected then take
                // previous element max value
                int rejection = dpTable[i - 1][j];

                /*
                 * If present element is selected,
                 * j - weights[i - 1] capacity will remain
                 */
                int selection = 0;
                int leftCapacity = j - weights[i - 1];
                if (leftCapacity >= 0) {
                    selection = values[i - 1] + dpTable[i - 1][leftCapacity];
                }

                /* Select maximum values if we include present element or not */
                dpTable[i][j] = Math.max(selection, rejection);
            }
        }

        // Result will store at rightmost index
        return dpTable[n][cap];
    }
}
