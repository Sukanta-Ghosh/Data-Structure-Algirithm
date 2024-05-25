package Arrays;

import java.util.Arrays;
import java.util.HashMap;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/assignment/problems/9323/?navref=cl_pb_nv_tb */
public class PairwithDiff {

    /*
     * T.C: O(nlogn)
     * S.C: O(1)
     */
    public int solve(int[] A, int B) {
        int n = A.length;
        // Sort the array
        Arrays.sort(A);
        /*
         * i is first pointer and starts from 0
         * j is second pointer and start from 1
         */
        int i = 0;
        int j = 1;
        // Hashmap to store pairs
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        /* Iterate over array till i or j reach array end */
        while (i < n && j < n) {
            int diff = A[j] - A[i];

            if (diff == B) {
                /* If diff is same as B then put pair into the map */
                if (i != j) {
                    map.put(A[i], A[j]);
                    i++;
                    j++;
                }
                // else increment second pointer j
                else {
                    j++;
                }

            }
            /*
             * If diff is less than B, increase 2nd pointer
             * in order to increase diff
             */
            else if (diff < B) {
                j++;
            }
            /*
             * If diff is greater than B, increase 1st pointer
             * in order to decrease diff
             */
            else if (diff > B) {
                i++;
            }
        }

        return map.size();
    }
}
