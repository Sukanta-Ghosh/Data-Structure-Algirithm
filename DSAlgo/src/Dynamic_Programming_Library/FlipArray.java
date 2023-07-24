package Dynamic_Programming_Library;

/* https://www.scaler.com/academy/mentee-dashboard/class/70869/assignment/problems/373?navref=cl_tt_lst_sl  */
public class FlipArray {
    /*
     * Note: Varity of 0-1 knapsack
     * Iterative Approach
     * T.C - O(n * sum / 2)
     * S.C - O(n * sum / 2)
     */
    public int solve(int[] A) {
        int n = A.length;
        int sum = 0;

        /* Find total array sum */
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }

        /*
         * DP State:
         * dp[i][j] => Min elements needed to form the sum j with (0 - i)
         * elements
         */
        /*
         * j space is taken as half to find min elements needed to
         * flip the sign
         */
        int[][] dpTable = new int[n + 1][sum / 2 + 1];

        /*
         * i denoting no of element
         * j denoting sum /2
         */
        for (int i = 0; i < dpTable.length; i++) {
            for (int j = 0; j < dpTable[0].length; j++) {

                /* With min elements min sum can form 0 */
                if (i == 0 && j == 0) {
                    dpTable[i][j] = 0;
                }
                /*
                 * i == 0, for 0 selected elements sum can not be formed,
                 * so store infinite value
                 */
                else if (i == 0) {
                    dpTable[i][j] = Integer.MAX_VALUE;
                }
                /* j == 0, to make 0 sum 0 elements needed */
                else if (j == 0) {
                    dpTable[i][j] = 0;
                }
                /* if i and j not 0 */
                else {
                    // If we don't include present element
                    int exclude = dpTable[i - 1][j];

                    /*
                     * MAX value is taken if sum cannot be cannot possible
                     * if we include the current element
                     */
                    int include = Integer.MAX_VALUE;

                    /*
                     * j - A[i - 1] => remaining sum,
                     * if remaining sum greater than 0
                     */
                    if (j - A[i - 1] >= 0) {
                        int restSum = j - A[i - 1];

                        /*
                         * if dpTable[i - 1][restSum] is infinite then, sum cannot
                         * be formed
                         */
                        if (dpTable[i - 1][restSum] == Integer.MAX_VALUE) {
                            include = Integer.MAX_VALUE;
                        } else {
                            include = dpTable[i - 1][restSum] + 1;
                        }
                    }

                    /* Set dp value min b/w exlude and include present element */
                    dpTable[i][j] = Math.min(include, exclude);
                }
            }
        }

        /*
         * Traverse last row from sum / 2 to 0, some sum cannot be formed with selected
         * elements
         * so when we get first possible sum formed with k elements, we return the value
         */
        for (int j = dpTable[0].length - 1; j >= 0; j--) {
            if (dpTable[dpTable.length - 1][j] != Integer.MAX_VALUE) {
                return dpTable[dpTable.length - 1][j];
            }
        }

        return 0;
    }
}
