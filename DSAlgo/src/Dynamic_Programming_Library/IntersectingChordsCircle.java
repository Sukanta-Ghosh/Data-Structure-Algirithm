package Dynamic_Programming_Library;

/* 
Intersecting Chords in a Circle: https://www.scaler.com/academy/mentee-dashboard/class/70877/homework/problems/339?navref=cl_tt_lst_sl
Unique Binary Search Trees: https://www.scaler.com/academy/mentee-dashboard/class/70877/assignment/problems/22?navref=cl_tt_nv */
public class IntersectingChordsCircle {
    /*
     * Catalan Number: Recurrence relation =>
     * T(n) = T(0) * T(n - 1) + T(1) * T(n - 2) ....T(n - 1) * T(0)
     */
    public int chordCnt(int A) {
        int mod = 1000000007;
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            long val = 0;
            for (int j = 0; j < i; j++) {
                val = (val + (long) dp[j] * dp[i - j - 1]) % mod;
            }
            dp[i] = (int) val;
        }

        return dp[A];
    }
}
