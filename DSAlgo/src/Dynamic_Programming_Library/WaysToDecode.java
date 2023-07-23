package Dynamic_Programming_Library;

/* Question Link: https://www.scaler.com/academy/mentee-dashboard/class/70865/homework/problems/10?navref=cl_tt_lst_sl */
public class WaysToDecode {
    int dp[];
    int mod = 1000000007;

    /* Recursion: top down approach using memoization */
    public int numDecodings(String A) {
        int n = A.length();
        if (A.charAt(0) == '0')
            return 0;
        if (n == 1)
            return 1;
        dp = new int[A.length()];
        return findWays(0, n, A);
    }

    public int findWays(int index, int n, String A) {
        if (index >= n)
            return 1;
        if (A.charAt(index) == '0')
            return 0;
        if (dp[index] != 0)
            return dp[index];

        int a = findWays(index + 1, n, A);
        int b = 0;
        if ((index + 1) < n &&
                (A.charAt(index) == '1'
                        || (A.charAt(index) == '2' && A.charAt(index + 1) >= '0' && A.charAt(index + 1) <= '6'))) {
            b = findWays(index + 2, n, A);
        }
        dp[index] = (a + b) % mod;
        return dp[index] % mod;
    }

    /*
     * Bottom up approach : iterative
     * T.C - O(n), S.C - O(n)
     */
    public int numDecodingsIterative(String A) {
        int n = A.length();

        /*
         * DP State:
         * dp[i] => No of ways to decode string A upto
         * its i length from start
         */
        int dp[] = new int[n + 1];

        if (A.charAt(0) == '0')
            return 0;

        dp[0] = 1; // empty string
        dp[1] = 1; // a single will have 1 decoding possible

        for (int i = 2; i <= n; i++) {
            // Check for single character
            if (A.charAt(i - 1) >= '1') // && A.charAt(i - 1) <= '9'
                dp[i] = dp[i - 1];

            // check for double character
            if (A.charAt(i - 2) == '1' || (A.charAt(i - 2) == '2' && A.charAt(i - 1) >= 0 && A.charAt(i - 1) <= '6'))
                dp[i] = dp[i] + dp[i - 2];
        }

        return dp[n] % mod;
    }

    public static void main(String[] args) {
        String s = "4126";

        WaysToDecode object = new WaysToDecode();
        System.out.println("Recursive:" + object.numDecodings(s));
        System.out.println("Iterative:" + object.numDecodingsIterative(s));
    }

}
