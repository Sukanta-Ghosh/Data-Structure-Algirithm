package BinarySearch;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47536/assignment/problems/203?navref=cl_tt_lst_sl */
public class RotatedSortedArraySearch {
    /*
     * T.C: O(log(n))
     */
    public int search(final int[] A, int B) {
        int n = A.length;

        int low = 0;
        int high = n - 1;

        // If Array is sorted
        if (A[0] < A[n - 1]) {
            // Do binary search
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (A[mid] == B) {
                    return mid;
                }
                if (A[mid] < B) {
                    low = mid + 1;
                } else if (A[mid] > B) {
                    high = mid - 1;
                }
            }
        }

        /* If array is rotated, then iterate */
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is target(B)
            if (A[mid] == B) {
                return mid;
            }

            /*
             * Check target(B) is present in first part
             * or second part. Check by comparing with A[0] element
             */
            // If B present in first part
            if (B >= A[0]) {
                // Check if mid is in 2nd part, move to 1st part
                if (A[mid] < A[0]) {
                    high = mid - 1;
                }
                /*
                 * Else mid in 1st part,
                 * do binary search in 1st part
                 */
                else {
                    if (A[mid] < B) {
                        low = mid + 1;
                    } else if (A[mid] > B) {
                        high = mid - 1;
                    }
                }
            }
            // If B present in 2nd part
            else if (B < A[0]) {
                // Check if mid is in 1st part, move to 2nd part
                if (A[mid] >= A[0]) {
                    low = mid + 1;
                }
                /*
                 * else mid in 2nd part,
                 * do binary search in 2nd part
                 */
                else {
                    if (A[mid] < B) {
                        low = mid + 1;
                    } else if (A[mid] > B) {
                        high = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}
