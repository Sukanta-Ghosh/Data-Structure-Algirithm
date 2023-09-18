package BinarySearch;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47532/homework/problems/196?navref=cl_tt_lst_sl */
public class MatrixSearch {
    /*
     * T.C - O(log(nm))
     * S.C - O(1)
     */
    public int searchMatrix(int[][] A, int B) {
        int r = A.length;
        int c = A[0].length;

        /*
         * Assume all elements are added to a list and after that
         * it is sorted, so last index will be n * m - 1
         */
        int low = 0;
        int high = (r * c) - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            /*
             * We take the mid of the total search space (initially all elements), then
             * translate it to the indexes in the matrix
             * by row = int(mid / n) and col = int(mid % n). This is valid because every row
             * contains n elements.
             */
            int row = mid / c;
            int col = mid % c;

            if (A[row][col] == B) {
                return 1;
            } else if (A[row][col] < B) {
                low = mid + 1;
            } else if (A[row][col] > B) {
                high = mid - 1;
            }
        }
        return 0;
    }
}
