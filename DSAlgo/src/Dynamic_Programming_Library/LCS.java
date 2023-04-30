package Dynamic_Programming_Library;

public class LCS {

    /*
     * Recursive Approach
     * T.C: O()
     * S.C:
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

    /*
     * Iterative Approach
     * T.C: O()
     * S.C:
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

        int i = 0;
        int j = 0;

        while (i < na && j < nb) {
            if (A.charAt(i) == B.charAt(j)) {
                dpTable[i][j] = 1;
            }
        }

        return 0;
    }

}
