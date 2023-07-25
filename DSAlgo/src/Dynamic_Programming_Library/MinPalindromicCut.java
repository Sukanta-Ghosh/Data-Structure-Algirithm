package Dynamic_Programming_Library;

import java.util.Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70875/assignment/problems/18?navref=cl_tt_nv */
public class MinPalindromicCut {

    /*
     * T.C: O(n ^ 2)
     * S.C: O(n ^ 2 + n)
     * 
     * DP State:
     * dp[i]: Min cut required to make (0 - i) index string palindrome
     */

    /*
     * Recursive Solution
     */
    public int minCuts(String input, int[] dp, boolean[][] isPalindrome, int n) {
        // Base Case
        if (n < 0)
            return -1;
        if (dp[n] != -1)
            return dp[n];
        int ans = Integer.MAX_VALUE;
        for (int k = n; k >= 0; --k) {
            if (isPalindrome[k][n]) {
                ans = Math.min(ans, minCuts(input, dp, isPalindrome, k - 1) + 1);
            }
        }
        dp[n] = ans;
        return ans;
    }

    /*
     * Iterative Solution
     */
    public static int minCutsIterative(String input, boolean[][] isPalindrome) {
        int[] dp = new int[input.length()];
        // For 0 index 0 cut required
        dp[0] = 0;

        /* Iterate from 1 th index and fill dp table */
        for (int i = 1; i < input.length(); ++i) {
            /* ans initialized as max value, in order to find min value when compare */
            int ans = Integer.MAX_VALUE;
            /* Here j is iterating from i to 0 */
            for (int j = i; j >= 0; j--) {
                /*
                 * if i-j is palindrome it is one cut so + 1,
                 * with the previous index value
                 * j - 1 < 0: checking index valid or not
                 */
                if (isPalindrome[j][i]) {
                    ans = Math.min(ans, j - 1 < 0 ? 0 : dp[j - 1] + 1);
                }
            }
            /* Update min cut required for i length string */
            dp[i] = ans;
        }
        /* return min cut rquired upto last index */
        return dp[input.length() - 1];
    }

    /*
     * Helper Function: To create a 2d matrix, which store palindrome
     * possible or not b/w i-j th index of the string
     */
    public static boolean[][] isPalindrome(String input) {
        boolean[][] dp = new boolean[input.length()][input.length()];
        for (int i = 0; i < input.length(); ++i) {
            Arrays.fill(dp[i], true);
        }
        for (int length = 2; length <= input.length(); ++length) {
            for (int start = 0; start <= input.length() - length; ++start) {
                int end = start + length - 1;
                dp[start][end] = dp[start + 1][end - 1] && input.charAt(start) == input.charAt(end);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String input = "aab";

        /*
         * isPalindrome 2d matrix is store i-j th index palindrome formation possible or
         * not
         */
        boolean[][] isPalindrome = isPalindrome(input);
        int[] dp = new int[input.length()];
        Arrays.fill(dp, -1);

        // int minCutsRec = minCuts(input,dp,isPalindrome,input.length()-1);
        int ans = minCutsIterative(input, isPalindrome);
        System.out.println(ans);
    }
}
