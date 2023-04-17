package Arrays;

public class TwoDArrayPFSum {
    /* Create new prefix array with 1 based indexing */
    public static int[][] prefix2D(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] pfSum = new int[n + 1][m + 1];

        // Prefix Sum of 2D array(starting with 1 index)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                /*
                 * -pfSum[i - 1][j - 1] cuz, in pfSum[i - 1][j] + pfSum[i][j - 1] coming
                 * 2 times
                 */
                pfSum[i][j] = A[i - 1][j - 1] + pfSum[i - 1][j] + pfSum[i][j - 1] - pfSum[i - 1][j - 1];
            }
        }

        return pfSum;
    }

    /* In place Prefix Sum, Change the original array */
    public static int[][] inPlace(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        // Prefix Sum of 2D array
        // Apply sum row wise
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                A[i][j] += A[i][j - 1];
            }
        }
        // Apply sum col wise
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] += A[i - 1][j];
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        int row = A.length;
        int col = A[0].length;

        System.out.println("Create new pf array with 1 indexing:");
        int[][] pfSum = prefix2D(A);
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.print(pfSum[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("In Place Prefix Sum:");
        int[][] pf = inPlace(A);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(pf[i][j] + " ");
            }
            System.out.println();
        }

    }
}
