package BinarySearch;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47532/assignment/problems/4131?navref=cl_tt_lst_sl */
public class SingleElementSortedArray {
    /*
     * T.C: O(logn)
     * S.C: O(1)
     */
    public int solve(int[] A) {
        int n = A.length;
        int low = 0;
        int high = n - 1;

        // Edge Cases
        if (n == 1) {
            return A[0];
        }

        if (A[0] != A[1]) {
            return A[0];
        }

        if (A[n - 1] != A[n - 2]) {
            return A[n - 1];
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            /* If A[mid] is unique */
            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1]) {
                return A[mid];
            }

            /* Find 1st occurance of duplicate mid element */
            if (A[mid] == A[mid - 1]) {
                mid = mid - 1;
            }

            /*
             * Case 1: If 1st occurance is even then go right,
             * as we consider first occurance so, mid + 2
             */
            if (mid % 2 == 0) {
                low = mid + 2;
            }
            /* Case 2: If 1st occurance is odd then go left */
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
