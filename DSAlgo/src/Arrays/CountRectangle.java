package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/homework/problems/4115?navref=cl_tt_lst_sl */
public class CountRectangle {
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public int solve(int[] A, int B) {
        int n = A.length;
        long count = 0;
        long mod = 1000000007;

        /*
         * Iterate through array and count
         * total no of rectangle can be formed using same
         * arr element
         */
        for (int i = 0; i < n; i++) {
            long area = 1l * A[i] * A[i];
            if (area >= B) {
                break;
            }
            count++;
        }

        /* Iterate with two pointer */
        int start = 0;
        int end = n - 1;
        while (start < end) {
            long area = 1l * A[start] * A[end];
            /* if area is less that target B, increase start pointer */
            if (area < B) {
                /*
                 * end - start, cuz we are counting no of pairs
                 * b/w start and end with sorted array
                 */
                long pairs = ((long) end - (long) start) * 2;
                count = (count % mod + pairs % mod) % mod;
                start++;
            }
            /* if area is greater that target B, decrease end pointer */
            else {
                end--;
            }
        }

        return (int) (count % mod);
    }
}
