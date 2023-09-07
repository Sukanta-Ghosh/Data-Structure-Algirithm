package Misc;

import java.util.Arrays;
import java.util.Comparator;

/* Qs: https://www.scaler.com/test/668ffe7e04/#/cplus */
public class DisjointIntervals {
    /*
     * T.C: O(nlogn) //For sorting
     * S.C: O(1)
     */
    public int solve(int[][] A) {
        /* Sort the pair based on second element of pair */
        Arrays.sort(A, Comparator.comparingInt(x -> x[1]));

        int ans = 1;
        // End point of fist interval
        int r1 = A[0][1];

        for (int i = 1; i < A.length; i++) {
            int l1 = A[i][0];
            int r2 = A[i][1];

            /*
             * Check if given interval overlap ith previously included, if not
             * then include this interval and update the end point of last added interval
             */
            if (l1 > r1) {
                ans++;
                r1 = r2;
            }
        }

        return ans;
    }
}
