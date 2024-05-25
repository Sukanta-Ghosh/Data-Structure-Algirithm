package Arrays;

/* Scale Qs: https://www.scaler.com/academy/mentee-dashboard/class/40558/assignment/problems/12828?navref=cl_tt_lst_sl */
public class SpecialIndex {
    /*
     * T.C: O(n)
     * S.C: O(2n)
     */
    public int solve(int[] A) {
        int n = A.length;
        int specialIdxs = 0;

        int[] pfEven = new int[n];
        int[] pfOdd = new int[n];

        // Prefix Sum of Even indices array elements
        pfEven[0] = A[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                pfEven[i] = pfEven[i - 1] + A[i];
            } else {
                pfEven[i] = pfEven[i - 1];
            }
        }

        // Prefix Sum of Odd indices array elements
        pfOdd[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                pfOdd[i] = pfOdd[i - 1] + A[i];
            } else {
                pfOdd[i] = pfOdd[i - 1];
            }
        }

        /* Iterate through array to find special index */
        for (int i = 0; i < n; i++) {
            /*
             * If i is special index element
             * Here when i is deleted, right side even index change to odd index
             * and vice versa.
             * 
             * So, find sumEven and sumOdd for right side indices
             */
            int sumEven = pfOdd[n - 1] - pfOdd[i];
            int sumOdd = pfEven[n - 1] - pfEven[i];

            /*
             * If ith index is not 0 then all the left even or odd elements
             * prefix sum is added till i - 1 index
             */
            if (i != 0) {
                sumEven += pfEven[i - 1];
                sumOdd += pfOdd[i - 1];
            }

            // If both are matched then i th index is special index
            if (sumEven == sumOdd) {
                specialIdxs++;
            }
        }

        return specialIdxs;
    }
}
