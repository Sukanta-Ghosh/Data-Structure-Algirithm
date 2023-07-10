package Hashing;

import java.util.HashSet;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47542/homework/problems/1226?navref=cl_tt_lst_sl */
public class CountSubarray {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int solve(int[] A) {
        int n = A.length;
        int mod = 1000000007;
        long count = 0;

        int l = 0;
        int r = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        while (r < n) {
            /*
             * If right index element is present in hashset, then left index arr ele
             * and right index arr element will be same, so remove left index element
             */
            if (set.contains(A[r])) {
                set.remove(A[l]);
                l++;
            } else {
                set.add(A[r]);
                count += r - l + 1;// calculate subaarays end with r index element
                r++;
            }
        }

        return (int) (count % mod);

    }
}
