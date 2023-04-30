package Dynamic_Programming_Library;

public class MinSumPathMatrix {
    /*
     * Iterative Approach
     * T.C - O(m * n)
     * S.C - O(1) , as we are using same 2d array
     */
    public int minPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        /*
         * DP State:
         * dp[i][j] => Min path score to reach from (0, 0) to (i, j) th cell
         */
        // A will be used as dpTable
        int[][] dpTable = A;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    // same no is store 0, 0
                } else if (i == 0) {
                    dpTable[i][j] += dpTable[i][j - 1];
                } else if (j == 0) {
                    dpTable[i][j] += dpTable[i - 1][j];
                } else {
                    dpTable[i][j] += Math.min(dpTable[i - 1][j], dpTable[i][j - 1]);
                }
            }
        }

        return dpTable[n - 1][m - 1];
    }

    public int minPathSumRecursive(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        /*
         * DP State:
         * dp[i][j] => Min path score to reach from (0, 0) to (i, j) th cell
         */
        // A will be used as dpTable

        return 0;
    }
}
