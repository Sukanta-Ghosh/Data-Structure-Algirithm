package Dynamic_Programming_Library;

public class MaxRectangleBinaryMatrix {

    /*
     * Iterative Approach:
     * T.C - O(n * m)
     * S.C - O(1) , in place 2d matrix used
     */
    public int maximalRectangle(int[][] A) {
        int n = A.length; // total rows
        int m = A[0].length;// total cols
        int maxArea = 0;

        /*
         * DP State:
         * dpTable[i][j] => Max width rectangle can be formed row wise
         */
        int[][] dpTable = A;

        // Added row wise max rectangle
        for (int row = 0; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (A[row][col] != 0) {
                    A[row][col] += A[row][col - 1];
                }
            }
        }

        // Compute Area
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (A[row][col] == 0) {
                    continue;
                }

                /*
                 * every A[row][col] is representing width need to figure out height of
                 * rectangle
                 */
                int width = A[row][col];
                int height = 1; // One cell height is 1

                // for first row height will be 1 and width will be A[row][col] only
                if (row == 0) {
                    maxArea = Math.max(maxArea, width * height);
                } else {// for rest of rows need to compute max available width and max height
                    int tempRow = row;

                    // considering height till 0 encounters (bottom to top) iterating
                    while (tempRow >= 0 && A[tempRow][col] != 0) {
                        // min width of previous row and present row
                        width = Math.min(width, A[tempRow][col]);

                        maxArea = Math.max(maxArea, width * height);

                        height++; // as we are decrementing row
                        tempRow--;
                    }
                }

            }
        }

        return maxArea;
    }
}
