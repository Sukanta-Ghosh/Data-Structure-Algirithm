package Sorting;

/* Qs: https://leetcode.com/problems/merge-sorted-array/description/ */
public class MergeSortedArrays {
    /*
     * T.C: O(nA + nB)
     * S.C: O(nA + mB)
     */
    public int[] solve(final int[] A, final int[] B) {
        int nA = A.length;
        int nB = B.length;
        int[] resArr = new int[nA + nB];

        /* 3 pointer index to traverse arrays */
        int idxA = 0;
        int idxB = 0;
        int idxR = 0;

        /*
         * Traverse 2 arrays and check greater element,
         * add into new array
         */
        while (idxA < nA && idxB < nB) {
            if (A[idxA] <= B[idxB]) {
                resArr[idxR++] = A[idxA++];
            } else {
                resArr[idxR++] = B[idxB++];
            }
        }

        /* B/W A and B, only 1 array elements will left */
        /* Traverse 1st array, if any element is left */
        while (idxA < nA) {
            resArr[idxR++] = A[idxA++];
        }
        /* Traverse 2nd array, if any element is left */
        while (idxB < nB) {
            resArr[idxR++] = B[idxB++];
        }

        return resArr;
    }
}
