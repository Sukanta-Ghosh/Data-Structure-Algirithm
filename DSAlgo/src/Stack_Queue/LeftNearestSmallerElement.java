package Stack_Queue;

import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47558/assignment/problems/332/?navref=cl_pb_nv_tb */
public class LeftNearestSmallerElement {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            /*
             * if stack peek element is greater than or equal to
             * array ele, then pop stack ele till
             * stack peek ele is less than array ele
             */
            while (!st.empty() && st.peek() >= A[i]) {
                st.pop();
            }

            /*
             * After last iteration if stack is empty,
             * then no nearest smaller present
             */
            if (st.empty()) {
                ans[i] = -1;
            }
            /* else stack peek element is nearest smaller */
            else {
                ans[i] = st.peek();
            }

            /* Push current array element into stack */
            st.push(A[i]);
        }

        return ans;
    }
}
