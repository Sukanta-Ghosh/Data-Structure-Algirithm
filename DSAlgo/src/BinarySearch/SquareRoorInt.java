package BinarySearch;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47536/assignment/problems/200?navref=cl_tt_lst_sl */
public class SquareRoorInt {
    /*
     * T.C: O(logn)
     * S.C: O(1)
     */
    public int sqrt(int A) {
        long low = 1;
        long high = A;
        long ans = 1;

        // Edge Case
        if (A == 0) {
            return 0;
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid == A) {
                return (int) mid;
            } else if (mid * mid > A) {
                high = mid - 1;
            } else if (mid * mid < A) {
                ans = mid;
                low = mid + 1;
            }
        }

        return (int) ans;
    }
}
