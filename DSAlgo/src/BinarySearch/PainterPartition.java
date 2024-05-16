package BinarySearch;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47538/assignment/problems/271/?navref=cl_pb_nv_tb */
public class PainterPartition {
    /*
     * T.C: O(n * log(totalSum - max + 1))
     * S.C: O(1)
     */
    public int paint(int A, int B, int[] C) {
        int n = C.length;
        int totalRodSum = 0;
        int maxRod = 0;
        int mod = 10000003;
        int ans = -1;

        /* Find totalSum and max rod len */
        for (int i = 0; i < n; i++) {
            maxRod = Math.max(maxRod, C[i]);
            totalRodSum += C[i];
        }

        int low = maxRod;
        int high = totalRodSum;

        /*
         * Do Binary search b/w lowest time required
         * and highest time required and check whether
         * selected time is possible to achieve or not
         */
        while (low <= high) {
            int mid = (low + high) / 2;

            /*
             * if mid possible, search for less time
             * so go left
             */
            if (possible(C, A, mid)) {
                ans = mid;
                high = mid - 1;
            }
            /*
             * if mid time not possible then search for more time,
             * so go right
             */
            else {
                low = mid + 1;
            }
        }

        /* Multiply by B to get total time */
        return (int) (ans * (long) B % mod);
    }

    /*
     * Function to find whether current midTime is possible or
     * not against available painter
     */
    public boolean possible(int[] C, int A, int midTime) {
        // first start with 1 painter
        int painter = 1;
        int totalPaintedTime = 0;

        /* Iterate to find required painter */
        for (int i = 0; i < C.length; i++) {
            totalPaintedTime += C[i];

            /*
             * If totalPaintedTime is greater than selected
             * midTime then:
             * 1. Increase painter no
             * 2. Assign current arr element as new totalPaintedTime
             * against new added painter
             */
            if (totalPaintedTime > midTime) {
                painter++;
                totalPaintedTime = C[i];
            }
        }

        /*
         * If painter less than or equal to total available
         * painter A, then return true
         */
        return painter <= A;
    }

    public static void main(String[] args) {

    }
}
