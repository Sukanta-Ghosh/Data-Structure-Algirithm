package Stack_Queue;

import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47558/assignment/problems/332/?navref=cl_pb_nv_tb */
public class LeftNearestSmallerElement {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public static int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            /*
             * if stack peek element is greater than or equal to
             * array element, then pop stack element till
             * stack peek element is less than array element
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

    public static void main(String[] args) {
        int[] A = { 4, 5, 2, 10, 8 };
        prevSmaller(A); // [-1, 4, -1, 2, 2]
    }
}
