package Sorting;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47528/assignment/problems/260/?navref=cl_pb_nv_tb */
public class KthSmallestElement {
    /*
     * T.C: O(B * n)
     * S.C: O(1)
     */
    public int kthsmallest(final int[] A, int B) {
        int n = A.length;

        /* Start a loop from i = 0 to B - 1 for B swaps */
        for (int i = 0; i < B; i++) {
            // Set min_idx to i
            int minIndex = i;

            // Start loop from j = i + 1 to n - 1
            for (int j = i + 1; j < n; j++) {
                /*
                 * Check if a[j] is less than a[min_idx],
                 * update min_idx to j
                 */
                if (A[minIndex] > A[j]) {
                    minIndex = j;
                }
            }

            /*
             * If minIndex and i is not same,
             * swap the elements at indices min_idx and i in
             * array a, to swap small elements at array left side
             */
            if (i != minIndex) {
                swap(A, i, minIndex);
            }
        }

        /*
         * Return the element at index B - 1,
         * as B - 1 is Bth smallest element
         */
        return A[B - 1];
    }

    // Helper Function: Swap
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = { 2, 1, 4, 3, 2 };
        int B = 3;

        KthSmallestElement obj = new KthSmallestElement();
        System.out.println(obj.kthsmallest(A, B)); // 2
    }
}
/*
 * Algorithm:
 * -----------------------------------------
 * 1. Initialize variables i, j, and min_idx.
 * 2. Start a loop from i = 0 to B - 1.
 * a. Inside the loop, set min_idx to i.
 * b. Start another loop from j = i + 1 to n - 1.
 * - Inside the second loop, check if a[j] is less than a[min_idx].
 * - If the condition is true, update min_idx to j.
 * c. After the second loop ends, swap the elements at indices min_idx and i in
 * array a.
 * d. Repeat step 2 for B iterations.
 * 3. Return the element at index B - 1 in array a.
 */