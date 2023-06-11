package Arrays;

/* Scale Qs: https://www.scaler.com/academy/mentee-dashboard/class/40557/assignment/problems/26771?navref=cl_tt_lst_sl */
public class JosephusProblem {
    /*
     * T.C: O(log(A))
     * S.C: O(1)
     */
    public int solve(int A) {
        /*
         * Only odd can be ans
         * For N, 2 ^ n, ans is 1
         */
        // Find the nearest power of 2 <= A(y)
        int y = 1;
        while ((y * 2) <= A) {
            y *= 2;
        }

        /*
         * A - x = y
         * A = Total people
         * x = No of people got killed
         * y = Nearest power of 2 <= A
         */
        int x = A - y;

        /* 2x + 1 => Starting place */
        return 2 * x + 1;
    }
}
