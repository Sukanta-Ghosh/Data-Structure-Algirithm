package Dynamic_Programming_Library;

import java.util.Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70865/assignment/problems/600?navref=cl_tt_nv */
public class MinNoSquare {
    /*
     * Iterative-Tabulation-Bottomup
     * T.C - O(n * sqrt(n))
     * S.C - O(n)
     */
    public int countMinSquares(int A) {
        int[] dpTable = new int[A + 1];
        // To use min function
        Arrays.fill(dpTable, Integer.MAX_VALUE);
        dpTable[0] = 0;

        for (int i = 1; i <= A; i++) {
            for (int x = 1; x * x <= i; x++) {
                /*
                 * dpTable[i - x * x] + 1:
                 * in this statement +1 is to include x in count
                 */
                dpTable[i] = Math.min(dpTable[i], dpTable[i - x * x] + 1);
            }
        }

        return dpTable[A];
    }
}
