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
        int goodElements = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] <= B) {
                goodElements++;
            }
        }

        /*
         * Edge Cases: NO Swaps required
         * 1. goodElements = 0, No good elements
         * 2. goodElements = 1, One good elements
         * 3. goodElements = n, All good elements
         */
        if (goodElements == 0 || goodElements == 1 || goodElements == n) {
            return 0;
        }

        // Calculate no of bad elements for first window(size of goodElements)
        int badElements = 0;
        for (int i = 0; i < goodElements; i++) {
            if (A[i] > B) {
                badElements++;
            }
        }

        // Apply Sliding window teqn
        int sIdx = 1;
        int eIdx = goodElements;
        int swaps = badElements;

        while (eIdx < n) {
            // If new element is greater, increase the badElements count
            if (A[eIdx] > B) {
                badElements++;
            }

            // If old element is greater, decrease the badElements count
            if (A[sIdx - 1] > B) {
                badElements--;
            }

            // Find min b/w all swaps
            swaps = Math.min(swaps, badElements);

            sIdx++;
            eIdx++;
        }

        return swaps;

    }
}
