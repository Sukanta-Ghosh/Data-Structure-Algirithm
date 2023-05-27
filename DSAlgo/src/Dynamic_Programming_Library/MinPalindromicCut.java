package Dynamic_Programming_Library;

import java.util.Arrays;

public class MinPalindromicCut {
    /* Recursive Solution */
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

    /* Iterative Solution */
    public static int minCutsIterative(String input, boolean[][] isPalindrome) {
        int[] dp = new int[input.length()];
        dp[0] = 0;
        for (int i = 1; i < input.length(); ++i) {
            int ans = Integer.MAX_VALUE;
            for (int j = i; j >= 0; --j) {
                if (isPalindrome[j][i]) {
                    ans = Math.min(ans, j - 1 < 0 ? 0 : dp[j - 1] + 1);
                }
            }
            dp[i] = ans;
        }
        return dp[input.length() - 1];
    }

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

        boolean[][] isPalindrome = isPalindrome(input);
        int[] dp = new int[input.length()];
        Arrays.fill(dp, -1);
        // int minCutsRec = minCuts(input,dp,isPalindrome,input.length()-1);
        int ans = minCutsIterative(input, isPalindrome);
        System.out.println(ans);
    }
}
