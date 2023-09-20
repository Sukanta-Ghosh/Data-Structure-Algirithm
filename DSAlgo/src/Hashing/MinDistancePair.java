package Hashing;

import java.util.HashMap;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47542/assignment/problems/1302?navref=cl_tt_lst_sl */
public class MinDistancePair {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int solve(int[] A) {
        int n = A.length;
        // check if there is no special pair
        int minLen = n + 1;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        /*
         * Iterate over array, if eleemnt contain in hashmap count minLen
         * from hashmap previous element
         * Then put element in map
         */
        for (int i = 0; i < n; i++) {
            if (map.containsKey(A[i])) {
                minLen = Math.min(minLen, i - map.get(A[i]));
            }
            map.put(A[i], i);
        }

        /* if minLen is n + 1, then no special pair exist */
        if (minLen == n + 1) {
            minLen = -1;
        }

        return minLen;
    }
}
