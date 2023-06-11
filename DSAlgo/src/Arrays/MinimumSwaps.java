package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/40555/assignment/problems/4033?navref=cl_tt_lst_sl */
public class MinimumSwaps {
    /*
     * Topic: Sliding Window
     * T.C - O(n)
     * S.C - O(1)
     */
    public int solve(int[] A, int B) {
        int n = A.length;

        // Count no of elements less than B(Good elements)
        // K = good elements
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] <= B) {
                k++;
            }
        }

        /*
         * Edge Cases: NO Swaps required
         * 1. K = 0, No good elements
         * 2. k = 1, One good elements
         * 3. k = n, All good elements
         */
        if (k == 0 || k == 1 || k == n) {
            return 0;
        }

        // Caclulate no of bad elements for first window
        int bad = 0;

        for (int i = 0; i < k; i++) {
            if (A[i] > B) {
                bad++;
            }
        }

        // Apply Sliding window teqn
        int s = 1;
        int e = k;
        int swaps = bad;

        while (e < n) {
            // If new element is Bad, increase the count
            if (A[e] > B) {
                bad++;
            }

            // If old element is bad, decrease the count
            if (A[s - 1] > B) {
                bad--;
            }

            swaps = Math.min(swaps, bad);

            s++;
            e++;
        }

        return swaps;

    }
}
