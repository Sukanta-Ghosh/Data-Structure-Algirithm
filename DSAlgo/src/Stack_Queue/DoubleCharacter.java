package Stack_Queue;

import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47556/assignment/problems/968/?navref=cl_pb_nv_tb */
public class DoubleCharacter {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public String solve(String A) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (!st.empty() && st.peek() == ch) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();
    }
}
