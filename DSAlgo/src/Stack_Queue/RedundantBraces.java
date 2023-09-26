package Stack_Queue;

import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47556/homework/problems/274?navref=cl_tt_lst_sl */
public class RedundantBraces {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int braces(String A) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            if (ch == '(' || ch == '+' || ch == '-'
                    || ch == '*' || ch == '/') {
                st.push(ch);
            } else if (ch == ')') {
                /*
                 * if for close bracket, open bracket present,
                 * then redundant braces present
                 */
                if (st.peek() == '(') {
                    return 1;
                }
                /* else pop stack elements */
                else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    /*
                     * after removing all operator than '(',
                     * remove '(' operator
                     */
                    st.pop();
                }
            }
        }

        return 0;
    }
}
