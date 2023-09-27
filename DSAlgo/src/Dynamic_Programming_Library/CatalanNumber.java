package Dynamic_Programming_Library;

/* 
Intersecting Chords in a Circle: https://www.scaler.com/academy/mentee-dashboard/class/70877/homework/problems/339?navref=cl_tt_lst_sl
Unique Binary Search Trees: https://www.scaler.com/academy/mentee-dashboard/class/70877/assignment/problems/22?navref=cl_tt_nv */
public class CatalanNumber {
    /*
     * T.C: O(n ^ 2)
     * S.C: O(n)
     * Catalan Number: Recurrence relation =>
     * T(n) = T(0) * T(n - 1) + T(1) * T(n - 2) + .... + T(n - 1) * T(0)
     * 
     * T(n, p) = Summation of (T(p) * T(n - p - 1))
     */
    public int catalanNumber(int A) {
        int mod = 1000000007;

        /*
         * DP State:
         * dp[i]: ith Catalan number is store at dp[i]
         */
        int[] dp = new int[A + 1];
        // 0 and 1 th Catalan no is 1
        dp[0] = 1;
        dp[1] = 1;

        /* Iterate to find recurrence relation */
        for (int i = 2; i <= A; i++) {
            long val = 0;
            /*
             * Iterate j from 0-i
             * i - j - 1 => Put in catalan no equation
             */
            for (int j = 0; j < i; j++) {
                val = (val + (long) dp[j] * dp[i - j - 1]) % mod;
            }
            dp[i] = (int) val;
        }

        return dp[A];
    }
}
