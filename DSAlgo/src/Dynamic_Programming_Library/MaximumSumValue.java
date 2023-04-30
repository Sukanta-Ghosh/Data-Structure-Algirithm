package Dynamic_Programming_Library;

import java.util.Arrays;

/* Question Link: https://www.scaler.com/academy/mentee-dashboard/class/70865/homework/problems/10/?navref=cl_pb_nv_tb */
public class MaximumSumValue {

    /*
     * Iterative
     * T.C - O(n), S.C - O(n)
     */
    public int solveIterative(int[] A, int B, int C, int D) {
        int n = A.length;
        int[][] dpTable = new int[3][n];

        dpTable[0][0] = A[0] * B;
        for (int i = 1; i < A.length; i++) {
            dpTable[0][i] = Math.max(dpTable[0][i - 1], A[i] * B);
        }

        dpTable[1][0] = Math.max(A[0] * C + dpTable[0][0], dpTable[0][0]);
        for (int i = 1; i < A.length; i++) {
            dpTable[1][i] = Math.max(dpTable[1][i - 1], dpTable[0][i] + A[i] * C);
        }

        dpTable[2][0] = Math.max(A[0] * D + dpTable[1][0], dpTable[1][0]);
        for (int i = 1; i < A.length; i++) {
            dpTable[2][i] = Math.max(dpTable[2][i - 1], dpTable[1][i] + A[i] * D);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dpTable[2][i]);
        }

        return result;
    }

    /*
     * Recursive Solution
     * TODO: T.C -
     */
    int[][] dp;
    int[] p;

    public int solve(int[] A, int B, int C, int D) {

        dp = new int[A.length][3];
        p = new int[3];

        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        p[0] = B;
        p[1] = C;
        p[2] = D;

        return maxsum(A, p, 0, 0);
    }

    int maxsum(int[] A, int[] p, int i, int j) {
        if (i >= A.length)
            return Integer.MIN_VALUE;
        if (j == 3)
            return 0;

        if (dp[i][j] == Integer.MIN_VALUE) {
            int v = maxsum(A, p, i + 1, j);

            if (j <= 2) {
                v = Math.max(v, A[i] * p[j] + maxsum(A, p, i, j + 1));
            }

            dp[i][j] = v;
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        MaximumSumValue obj = new MaximumSumValue();
        int[] A = { 1, 5, -3, 4, -2 };
        int B = 2;
        int C = 1;
        int D = -1;
        System.out.println("Iterative:" + obj.solveIterative(A, B, C, D));
        System.out.println("Recursive:" + obj.solve(A, B, C, D));

    }
}
