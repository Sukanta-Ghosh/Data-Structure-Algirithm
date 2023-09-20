package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/homework/problems/273/?navref=cl_pb_nv_tb */
public class MaxContinuousSeriesOne {
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public int[] maxone(int[] A, int B) {
        /*
         * Approach:
         * 1. We took two pointers p1 & p2, two answer index variable as head & tail, a
         * zero count variable, a max variable & answer arraylist.
         * 2. We will keep iterating till p2 < size of ArrayList. At every iteration we
         * increase p2.
         * 3. We check if the value is equal to zero and if zeroCount is less than B, we
         * increment zeroCount.
         * 4. Whenever zeroCount becomes more than B, we move the p1 till zeroCount
         * become equal to B.
         * 5. At every iteration, we check the max window length and accordingly set
         * head & tail index.
         * 6. Finally we store the index in the answer ArrayList.
         */
        int n = A.length;
        int zeroCount = 0;
        int max = Integer.MIN_VALUE;
        /* Took p1 and p2 pointers to iterate */
        int p1 = 0;
        int p2 = 0;
        /* start and end index for ans */
        int start = 0;
        int end = 0;

        /* Iterate second pointer p2 till size n */
        while (p2 < n) {
            /*
             * Check if the value of second pointer is equal to zero and
             * if zeroCount is less than B, increment zeroCount
             */
            if (A[p2] == 0 && zeroCount <= B) {
                zeroCount++;
            }

            /*
             * Whenever zeroCount becomes more than B,
             * move pointer p1 till zeroCount become equal to B
             */
            while (zeroCount > B) {
                if (A[p1] == 0) {
                    zeroCount--;
                }
                p1++;
            }

            /*
             * At every iteration, we check the max window length and
             * accordingly set start & end index
             * and increase pointer p2
             */
            int window = p2 - p1 + 1;
            if (window > max) {
                start = p1;
                end = p2;
                max = window;
            }
            p2++;
        }

        /* Evaluate ans array */
        int[] ans = new int[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            ans[index++] = i;
        }

        return ans;
    }
}
