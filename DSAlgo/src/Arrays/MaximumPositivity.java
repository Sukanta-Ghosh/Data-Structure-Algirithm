package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/40557/homework/problems/8515?navref=cl_tt_lst_sl */
public class MaximumPositivity {
    /*
     * T.C - O(n)
     * S.C - O(n)
     */
    public int[] solve(int[] A) {
        int n = A.length;

        int maxSize = 0; // Max subarray size
        int currentSize = 0; // Current subarray size
        int sIdx = 0; // Start index
        int eIdx = 0; // End Index

        // Loop through Array
        for (int i = 0; i < n; i++) {
            // if current element is +ve, then increase count
            // else reset count
            if (A[i] > 0) {
                currentSize++;
            } else {
                currentSize = 0;
            }

            // if currentCount is greater than exising maxSize then
            // update maxSize and set start and end index
            if (currentSize > maxSize) {
                maxSize = currentSize;
                sIdx = i - currentSize + 1;
                eIdx = i;
            }
        }

        int[] arr = new int[maxSize];
        int j = 0;
        for (int i = sIdx; i <= eIdx; i++) {
            arr[j++] = A[i];
        }

        return arr;
    }
}
