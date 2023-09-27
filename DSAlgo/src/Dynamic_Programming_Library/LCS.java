package Dynamic_Programming_Library;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70873/assignment/problems/4438?navref=cl_tt_lst_sl */
public class LCS {

    /*
     * Iterative Approach
     * T.C: O(n * m)
     * S.C: O(n * m)
     */
    public int solve(String A, String B) {
        int na = A.length();
        int nb = B.length();

        /*
         * DP State:
         * dp[i][j]: Longest common subsequence of string s1 from 0-i,
         * to string s2 from 0-j
         */
        int[][] dpTable = new int[na][nb];

        int i, j;
        for (i = 0; i <= na; i++) {
            for (j = 0; j <= nb; j++) {
                // Base condition
                if (i == 0 || j == 0)
                    dpTable[i][j] = 0;
                else if (A.charAt(i - 1) == B.charAt(j - 1))
                    dpTable[i][j] = dpTable[i - 1][j - 1] + 1;
                else
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
            }
        }
        return dpTable[na][nb];
    }

    /*
     * Recursive Approach
     * T.C: O(n * m)
     * S.C: O(n * m)
     */
    public int solveRecursive(String A, String B) {
        int na = A.length();
        int nb = B.length();

        /*
         * DP State:
         * dp[i][j]: Longest common subsequence of string s1 from 0-i,
         * to string s2 from 0-j
         */
        int[][] dpTable = new int[na][nb];
        for (int i = 0; i < na; i++) {
            for (int j = 0; j < nb; j++) {
                dpTable[i][j] = -1;
            }
        }

        return lcs(A, B, na - 1, nb - 1, dpTable);
    }

    public int lcs(String s1, String s2, int i, int j, int[][] dpTable) {
        if (i == -1 || j == -1) {
            return 0;
        }

        if (dpTable[i][j] != -1) {
            return dpTable[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dpTable[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dpTable);
        } else {
            return dpTable[i][j] = Math.max(lcs(s1, s2, i - 1, j, dpTable),
                    lcs(s1, s2, i, j - 1, dpTable));
        }

    }

}
