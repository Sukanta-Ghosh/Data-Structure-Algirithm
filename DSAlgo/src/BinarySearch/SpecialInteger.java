package BinarySearch;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47536/homework/problems/4133?navref=cl_tt_nv */
public class SpecialInteger {
    /*
     * Two Pointer Approach
     * T.C - O(n)
     * S.C - O(1)
     */
    public static int solve(int[] A, int B) {
        int n = A.length;
        int maxLen = n;
        int sum = 0;
        int start = 0;
        int end = 0;

        /* Loop till end index is less than total length */
        while (end <= n) {
            /* Sum should not exceed B and if end is last index then break */
            if (sum <= B && end == n) {
                break;
            }

            /*
             * If sum less than target B, then add end index element
             * with current sum
             */
            if (sum <= B) {
                sum += A[end];
                end++;
            }
            /*
             * If sum is greater than target B, then subtract start index element
             * from current sum
             */
            else {
                sum -= A[start];
                start++;
                // Compute maxLen for every length
                maxLen = Math.min(maxLen, end - start);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5 };
        int B = 10;

        System.out.println(solve(A, B));
    }
}
