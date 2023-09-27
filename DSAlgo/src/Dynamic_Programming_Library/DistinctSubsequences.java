package Dynamic_Programming_Library;

/* https://www.scaler.com/academy/mentee-dashboard/class/70871/homework/problems/7/?navref=cl_pb_nv_tb */
public class DistinctSubsequences {
    /*
     * Varity of 0-1 Knapsack
     * T.C: O(na * nb)
     * S.C: O(na * nb)
     */
    public int numDistinct(String A, String B) {
        int na = A.length();
        int nb = B.length();

        /*
         * DP State:
         * dp[i][j] => No of ways j len string can be
         * formed by selecting 0 - i element
         */
        int[][] dpTable = new int[na + 1][nb + 1];

        for (int i = 0; i <= na; i++) {
            for (int j = 0; j <= nb; j++) {
                /*
                 * If choose string is empty and form string is also empty, then 1 way it can be
                 * formed
                 */
                if (i == 0 && j == 0) {
                    dpTable[i][j] = 1;
                }
                /*
                 * If choose string is empty, then no char can be formed, So for i == 0 && j !=
                 * 0, dp[i][j] = 0
                 */
                else if (i == 0) {
                    // dp[i][j] = 0
                }
                /*
                 * If form string is empty, then we can choose 1 ways from choose string for any
                 * type of string with 0 char selection
                 */
                else if (j == 0) {
                    dpTable[i][j] = 1;
                }
                /* if i and j != 0 */
                else {

                    // include previous A char result
                    dpTable[i][j] = dpTable[i - 1][j];

                    /*
                     * if i - 1 th char in A and B is same, then add/include dpTable[i - 1][j - 1]
                     * in dpTable[i][j]
                     */
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        dpTable[i][j] = dpTable[i - 1][j - 1] + dpTable[i - 1][j];
                    }
                }
            }
        }

        return dpTable[na][nb];
    }
}
