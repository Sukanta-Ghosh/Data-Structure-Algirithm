package BinarySearch;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47532/assignment/problems/4132?navref=cl_tt_lst_sl */
public class PeakElement {
    /*
     * T.C: O(logn)
     * S.C: O(1)
     */
    public static int solve(int[] A) {
        int n = A.length;

        // Edge Cases
        if (n == 1) {
            return A[0];
        }

        if (A[0] >= A[1]) {
            return A[0];
        }

        if (A[n - 1] >= A[n - 2]) {
            return A[n - 1];
        }

        // Binary Search
        int low = 0;
        int high = n - 1;
        int mid = -1; // if no peak element
        while (low <= high) {
            mid = (low + high) / 2;

            /* Case 1: A[mid - 1] <= A[mid] >= A[mid + 1] */
            if (A[mid - 1] <= A[mid] && A[mid] >= A[mid + 1]) {
                return A[mid];
            }
            /* Case 2: A[mid] < A[mid + 1] go to right */
            else if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            }
            /* Case 3: A[mid] < A[mid - 1] go to left */
            else if (A[mid - 1] > A[mid]) {
                high = mid - 1;
            }
        }

        // return -1
        return mid;
    }

    public static void main(String[] args) {
        int[] A = { 5, 17, 100, 11 };

        System.out.println(solve(A));
    }
}
