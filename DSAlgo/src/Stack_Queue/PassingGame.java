package Stack_Queue;

import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47556/assignment/problems/1064?navref=cl_tt_lst_sl */
public class PassingGame {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int solve(int A, int B, int[] C) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(A);
        st.push(B);

        for (int i : C) {
            if (i == 0) {
                st.pop();
            } else {
                st.push(i);
            }
        }

        return st.peek();
    }
}
