package BinarySearch;

/* Qs: https://www.scaler.com/test/668ffe7e04/#/problem_5 */
public class MinElementRotatedArray {
    /*
     * T.C: O(log n)
     * S.C: O(1)
     */
    public int findMin(int[] A) {

        // Edge Case
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }

        // Binary Search
        int start = 0, end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;

            /* If mid index ele is less than its previous element */
            if (mid > 0 && A[mid] < A[mid - 1]) {
                return A[mid];
            }
            /*
             * If mid ele is greater than start ele and end element,
             * then move right
             */
            if (A[start] <= A[mid] && A[mid] > A[end]) {
                start = mid + 1;
            }
            /* else move right */
            else {
                end = mid - 1;
            }
        }

        /* return start element */
        return A[start];
    }
}
