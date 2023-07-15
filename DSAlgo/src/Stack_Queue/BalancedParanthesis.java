package Stack_Queue;

import java.util.*;
import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47556/assignment/problems/678?navref=cl_tt_lst_sl */
public class BalancedParanthesis {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int solve(String A) {
        Stack<Character> st = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        /*
         * Put close bracket char as key
         * open bracket char as value
         */
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // Iterate over arr
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            /* If arr present char is open bracket, then push into stack */
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            /* else current char is close bracket */
            else {
                /*
                 * if char present and there is no present char in stack
                 * or map char value not match with stack peek element,
                 * return 0
                 */
                if (st.size() == 0 || map.get(ch) != st.peek()) {
                    return 0;
                }
                // else pop for next iteration
                else {
                    st.pop();
                }
            }
        }

        // If stack has remaining char then return false
        if (st.size() > 0) {
            return 0;
        }

        return 1;
    }
}
