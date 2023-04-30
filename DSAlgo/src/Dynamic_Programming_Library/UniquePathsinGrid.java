package Dynamic_Programming_Library;

/* Question Link: https://www.scaler.com/academy/mentee-dashboard/class/70867/assignment/problems/8?navref=cl_tt_lst_sl */
public class UniquePathsinGrid {

    /*
     * Iterative Approach
     * T.C: O(n * m)
     * S.C: O(n * m)
     */
    public int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dpTable = new int[n][m];

        // Base case
        if (A[0][0] == 1) {
            return 0;
        }

        /*
         * DP State:
         * dp[i][j] => No of ways to reach from (0, 0) to (i, j)
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dpTable[i][j] = 1;
                } else if (i == 0) {
                    dpTable[i][j] = dpTable[i][j - 1];
                } else if (j == 0) {
                    dpTable[i][j] = dpTable[i - 1][j];
                } else {
                    dpTable[i][j] = dpTable[i][j - 1] + dpTable[i - 1][j];
                }
            }
        }

        return dpTable[n - 1][m - 1];
    }
}
