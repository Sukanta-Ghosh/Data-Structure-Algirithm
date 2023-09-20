package Arrays;

import java.util.HashMap;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/assignment/problems/5097/?navref=cl_pb_nv_tb */
public class PairwithSum {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int solve(int[] A, int B) {
        int n = A.length;
        /* Initialize s from start index and e from end index */
        int s = 0;
        int e = n - 1;
        long mod = 1000000007;
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        /* Iterate and calculate frequency of array elements */
        for (int i = 0; i < n; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        /* Iterate till start pointer reach end point */
        while (s < e) {
            long sum = A[s] + A[e];

            /* If totalSum is target B, calculate total count */
            if (sum == B) {
                /*
                 * If start and end point element is same,
                 * then count total no of pairs and break from loop
                 */
                if (A[s] == A[e]) {
                    long c = e - s + 1;
                    count = (count + (c * (c - 1) / 2)) % mod;
                    break;
                }
                /* else count from hasmap with no of possible pairs */
                count = (count + (map.get(A[s]) * map.get(A[e]))) % mod;
                s = s + map.get(A[s]);
                e = e - map.get(A[e]);
            }
            /* if sum less than target B, increase start point */
            else if (sum < B) {
                s++;
            }
            /* if sum greater than target B, decrease end pointer */
            else if (sum > B) {
                e--;
            }
        }

        return (int) count;
    }
}
