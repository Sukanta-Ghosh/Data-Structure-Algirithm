package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/homework/problems/4117?navref=cl_tt_lst_sl */
public class ClosestPairSortedArr {
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public int[] solve(int[] A, int[] B, int C) {
        int na = A.length;
        int nb = B.length;
        /* minDiff b/w array element and target C */
        long minDiff = Integer.MAX_VALUE;
        int[] ans = new int[2];
        /* ansl, ansr are index of l and r to evaluate first index */
        int ansl = 0;
        int ansr = 0;

        /*
         * l pointer start with 0 index of A array
         * r pointer start from end index of B array
         */
        int l = 0;
        int r = nb - 1;

        /* Iterate through A and B */
        while (l < na && r >= 0) {
            // sum b/w A and B array
            int sum = A[l] + B[r];

            /*
             * if absolute difference b/w target C and current sum
             * is less than target C and minDiff,
             * then update ans array and minDiff with sum
             */
            if (Math.abs(C - sum) < Math.abs(C - minDiff)) {
                ans[0] = A[l];
                ans[1] = B[r];
                ansl = l;
                ansr = r;
                minDiff = sum;
            }

            /*
             * if absolute difference b/w target C and sum equal to
             * target C and minDiff then update ans array from B array
             */
            if (Math.abs(C - sum) == Math.abs(C - minDiff) && l == ansl && r < ansr) {
                ans[1] = B[r];
            }

            /* if sum is equal to target C, then update ans array and return */
            if (sum == C) {
                ans[0] = A[l];
                ans[1] = B[r];
                return ans;
            }
            /*
             * if sum is less than C and left pointer l less than
             * A array length, increase left pointer
             */
            else if (sum < C && l < na) {
                l++;
            }
            /*
             * if sum is less than C and left pointer l less than
             * A array length, increase left pointer
             */
            else if (sum > C && r >= 0) {
                r--;
            }
        }

        return ans;
    }
}
