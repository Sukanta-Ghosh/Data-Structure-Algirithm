package Hashing;

import java.util.HashSet;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47542/assignment/problems/4202?navref=cl_tt_nv */
public class SubArrayZeroSum {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int solve(int[] A) {
        int n = A.length;

        /* Prefix sum used to get 0 sum for subarray */
        long[] pfSum = new long[n];
        pfSum[0] = A[0];

        /* hashSet to check if same eleemnt is present in prefixSum array or not */
        HashSet<Long> set = new HashSet<Long>();
        set.add(pfSum[0]);

        if (pfSum[0] == 0) {
            return 1;
        }

        /*
         * Iterate over array to evaluate prefix sum
         * and check
         */
        for (int i = 1; i < n; i++) {
            pfSum[i] = pfSum[i - 1] + A[i];

            /* if pfSum is zero then 0 sum subarray present */
            if (pfSum[i] == 0) {
                return 1;
            }

            /*
             * if set contain same eleemnt in pfSum, then
             * subaary with 0 sum present
             */
            if (set.contains(pfSum[i])) {
                return 1;
            }

            /* add pfSum element in hasset */
            set.add(pfSum[i]);
        }

        return 0;
    }
}
