package Arrays;

import java.util.Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/assignment/problems/165?navref=cl_tt_lst_sl */
public class ThreeSum {
    /*
     * T.C: O(n ^ 2)
     * S.C: O(1)
     */
    public int threeSumClosest(int[] A, int B) {
        int n = A.length;
        // Sort the array
        Arrays.sort(A);
        // closest sum to target B
        long minSum = Integer.MAX_VALUE;

        // Base case
        if (n <= 3) {
            int sum = 0;
            for (int a : A)
                sum += a;
            return sum;
        }

        // Iterate through array, i is 1st pointer
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1; // l is 2nd pointer
            int r = n - 1; // r is 3rd pointer

            // escaping repeated values of i
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }

            // Iterate b/w 2nd and 3rd pointer
            while (l < r) {
                int sum = A[i] + A[l] + A[r];

                /*
                 * check if difference b/w sum and target B
                 * less than minSum and target B, update minSum with sum
                 */
                if (Math.abs(B - sum) < Math.abs(minSum - B)) {
                    minSum = sum;
                }

                /* If sum is equal to B, return sum */
                if (sum == B) {
                    return sum;
                }
                /* if sum is less than B, increase left pointer */
                else if (sum < B) {
                    l++;
                }
                /* if sum is greater than B, decrease right pointer */
                else if (sum > B) {
                    r--;
                }
            }
        }

        return (int) minSum;
    }
}
