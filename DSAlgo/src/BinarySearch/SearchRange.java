package BinarySearch;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47532/assignment/problems/199?navref=cl_tt_lst_sl */
public class SearchRange {
    /*
     * T.C: O(logn)
     * S.C: O(1)
     */
    public int[] searchRange(final int[] A, int B) {
        int[] ans = new int[2];
        int n = A.length;
        int low = 0;
        int high = n - 1;
        int fIndex = -1;
        int lIndex = -1;

        /* Loop for finding first occurance */
        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] == B) {
                fIndex = mid;
                // Go to left to find if it has first occurance
                high = mid - 1;
            } else if (A[mid] > B) {
                high = mid - 1;
            } else if (A[mid] < B) {
                low = low + 1;
            }
        }

        low = 0;
        high = n - 1;
        /* Loop for finding last occurance */
        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] == B) {
                lIndex = mid;
                // Go to right to find if it have last occurance
                low = low + 1;
            } else if (A[mid] > B) {
                high = mid - 1;
            } else if (A[mid] < B) {
                low = low + 1;
            }
        }

        ans[0] = fIndex;
        ans[1] = lIndex;

        return ans;
    }
}
