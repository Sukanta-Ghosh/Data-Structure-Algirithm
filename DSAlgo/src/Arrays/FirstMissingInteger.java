package Arrays;

/* Scale Qs: https://www.scaler.com/academy/mentee-dashboard/class/47512/assignment/problems/65?navref=cl_tt_lst_sl */
public class FirstMissingInteger {
    public int firstMissingPositive(int[] A) {
        int n = A.length;

        /* Iterate through input array */
        for (int i = 0; i < n; i++) {

            while (A[i] != i + 1) {
                /*
                 * A[A[i] - 1] == A[i], means if value
                 * is already present in its i - 1 th index
                 */
                if (A[i] <= 0 || A[i] > n || A[A[i] - 1] == A[i]) {
                    break;
                }
                /* Swap b/w current index i and A[i] - 1 th index */
                swap(A, i, A[i] - 1);
            }
        }

        /*
         * Check missing integer A[i], if it is not same as
         * i + 1 th index value
         */
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return (i + 1);
            }
        }

        /*
         * If no element found, then n + 1 number is outside
         * array number which is missing
         */
        return n + 1;
    }

    // i and j is index
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
