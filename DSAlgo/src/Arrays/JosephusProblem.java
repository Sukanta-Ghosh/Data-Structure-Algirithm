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
        // Find the nearest power of 2 ^ y <= A
        int y = 1;
        while ((y * 2) <= A) {
            y *= 2;
        }

        /*
         * A - x = y
         * A = Total people
         * x = No of people got killed
         * y = Nearest power of 2 ^ y <= A
         */
        int x = A - y;

        /* 2x + 1 => Starting place */
        return 2 * x + 1;
    }
}
/*
 * For A = 1, 2, 4, 8,... the answer is always 1.
 * If A is a true power of 2 then the answer is always 1.
 * For every A greater than that power of 2 the answer is
 * incremented by 2.
 */
