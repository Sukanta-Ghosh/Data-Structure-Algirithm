package Dynamic_Programming_Library;

/* Question Link: https://www.scaler.com/academy/mentee-dashboard/class/70867/assignment/problems/17?navref=cl_tt_lst_sl */
public class DungeonPrincess {

    /*
     * Note: Varity of
     * T.C - O(n * m)
     * S.C - O(n * m)
     */
    public int calculateMinimumHP(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        /*
         * DP State: dp[i][j] => Min health required to enter (i, j) cell to
         * reach last cell
         */
        int[][] dpTable = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    int health = 1 - A[i][j] > 0 ? 1 - A[i][j] : 1;
                    dpTable[i][j] = health;
                } else if (i == n - 1) {
                    int health = (dpTable[i][j + 1] - A[i][j]) > 0 ? (dpTable[i][j + 1] - A[i][j]) : 1;
                    dpTable[i][j] = health;
                } else if (j == m - 1) {
                    int health = (dpTable[i + 1][j] - A[i][j]) > 0 ? (dpTable[i + 1][j] - A[i][j]) : 1;
                    dpTable[i][j] = health;
                } else {
                    int minBlock = Math.min(dpTable[i + 1][j], dpTable[i][j + 1]);
                    int health = (minBlock - A[i][j]) > 0 ? (minBlock - A[i][j]) : 1;
                    dpTable[i][j] = health;
                }
            }
        }

        return dpTable[0][0];
    }
}
