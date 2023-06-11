package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/40555/assignment/problems/27363?navref=cl_tt_lst_sl */
public class CoutingTriplets {
    /*
     * Topic: Sliding Window Concept
     * T.C: O(n ^ 2)
     * S.C: O(1)
     */
    public int solve(int[] A) {
        int n = A.length;

        /*
         * For every j, L * R
         * L: No of elements less than arr[j] in 0 to j - 1
         * R: No of elements greater than arr[j] in j + 1 to n - 1
         */
        int count = 0;
        for (int j = 1; j < n - 1; j++) {
            // j is middle element
            int left = 0;
            for (int i = j - 1; i >= 0; i--) {
                if (A[i] < A[j]) {
                    left++;
                }
            }

            int right = 0;
            for (int i = j + 1; i < n; i++) {
                if (A[i] > A[j]) {
                    right++;
                }
            }

            /*
             * For every no left small elements there is right greater elements
             * so left * right
             * Then add for total count
             */
            count += (left * right);
        }

        return count;
    }

}
