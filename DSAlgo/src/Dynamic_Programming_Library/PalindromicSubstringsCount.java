package Dynamic_Programming_Library;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70875/assignment/problems/4828/?navref=cl_pb_nv_tb */
public class PalindromicSubstringsCount {
    /*
     * Iterative Solution
     * T.C: O(n ^ 2)
     * S.C: O(n ^ 2)
     */
    public int solve(String A) {
        int n = A.length();
        int count = 0;
        /*
         * DP State:
         * dp[i][j]: Substring (i - j) is plaindrome or not
         */
        boolean[][] dp = new boolean[n][n];

        // g is gap
        for (int g = 0; g < n; g++) {
            /*
             * i representing row
             * j representing column
             */
            for (int i = 0, j = g; j < n; i++, j++) {
                /* For g = 0, len is 1 */
                if (g == 0) {
                    dp[i][j] = true;
                    count++;
                }
                /* For g = 1, len is 2 */
                else if (g == 1) {
                    /* If first and last char is equal then true */
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    }
                }
                /* if gap is greater than 2, means length greater than 2 */
                else {
                    /*
                     * if i and j th char match, then check if dp[i + 1][j - 1]
                     * is palindrome or not
                     */
                    if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
