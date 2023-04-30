package Dynamic_Programming_Library;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathTriangle {

    /*
     * Iterative Solution (Space Optimized)
     * T.C - O(N) as we are not considering last row of triangle
     * other rows will contain tense to constant elements so, O(N * 1) + O(N * 2) +
     * O(N + nth row col size)
     * 
     * S.C - O(M) => M no of elements in last rows(which is very less)
     * 
     * Constraints: |A| <= 1000
     * A[i] <= 1000
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int N = a.size();
        int M = a.get(N - 1).size();

        /*
         * DP State:
         * dpTable[m] => Minimum path number required to
         * move from A[N - 1][M] th cell to A[N][M] && A[N][M + 1]
         * th cell
         * N = total rows, M = Total cols based on Nth row
         */
        int[] dpTable = new int[M];

        /* For storing last row elements in dpTable */
        for (int col = 0; col < M; col++) {
            dpTable[col] = a.get(N - 1).get(col);
        }

        /* Storing minpath for A[n - 1][m] th cell */
        for (int r = N - 2; r >= 0; r--) {
            for (int c = 0; c < a.get(r).size(); c++) {
                dpTable[c] = a.get(r).get(c) +
                        Math.min(dpTable[c], dpTable[c + 1]);
            }
        }

        return dpTable[0];
    }

    /* Recursive Solution - Top Down (Easy to Understand) */
    public int minimumTotalRecursive(ArrayList<ArrayList<Integer>> a) {
        int N = a.size();
        int M = a.get(N - 1).size();
        /*
         * dpTable[m] => Minimum path number required to
         * move from A[N - 1][M] th cell to A[N][M] && A[N][M + 1]
         * th cell
         */
        int[][] dpTable = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dpTable[i], -1);
        }

        /* Start from (0, 0) , Result will be store at (0, 0) index */
        // 2darray, dpTable, rowNo, colNo, totalRow
        int path = minPath(a, dpTable, 0, 0, N);

        return path;
    }

    public int minPath(ArrayList<ArrayList<Integer>> a, int[][] dpTable, int r, int c, int N) {

        if (r == N - 1) {
            return a.get(r).get(c);
        }

        if (dpTable[r][c] != -1) {
            return dpTable[r][c];
        }

        int downNo = a.get(r).get(c) + minPath(a, dpTable, r + 1, c, N);
        int rightDownNo = a.get(r).get(c) + minPath(a, dpTable, r + 1, c + 1, N);

        // Find min b/w them
        int ans = Math.min(downNo, rightDownNo);

        dpTable[r][c] = ans;

        return ans;
    }

}
