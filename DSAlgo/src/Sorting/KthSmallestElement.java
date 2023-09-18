package Sorting;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47528/assignment/problems/260/?navref=cl_pb_nv_tb */
public class KthSmallestElement {
    /*
     * T.C: O(B * n)
     * S.C: O(1)
     */
    /*
     * pseudo-code for the given code snippet:
     * -----------------------------------------
     * Initialize a new vector a with the same elements as the input vector A.
     * Initialize variables i, j, and min_idx.
     * Initialize variable n with the size of vector A.
     * Start a loop from i = 0 to B - 1.
     * Inside the loop, set min_idx to i.
     * Start another loop from j = i + 1 to n - 1.
     * Inside the second loop, check if a[j] is less than a[min_idx].
     * If the condition is true, update min_idx to j.
     * After the second loop ends, swap the elements at indices min_idx and i in
     * vector a.
     * Repeat steps 4-9 for B iterations.
     * Return the element at index B - 1 in vector a.
     */
    public int kthsmallest(final int[] A, int B) {
        int n = A.length;

        for (int i = 0; i < B; i++) {
            int minValue = A[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (minValue > A[j]) {
                    minValue = A[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                swap(A, i, minIndex);
            }
        }

        return A[B - 1];
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
