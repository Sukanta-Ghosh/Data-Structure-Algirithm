package Stack_Queue;

import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47556/homework/problems/4353/?navref=cl_pb_nv_tb */
public class InfixToPostfix {
    /* Function to get precedence */
    public int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public String solve(String A) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<Character>();

        // Iterate over string
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            // If the current character is an operand, add it to output string.
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
            // If the current character is an '(', push it to the stack.
            else if (ch == '(') {
                st.push(ch);
            }
            /*
             * If the current character is an ')', pop from stack
             * and add to output string from the stack until
             * an '(' is encountered.
             */
            else if (ch == ')') {
                while (!st.empty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                /* then pop '(' char */
                if (st.peek() == '(') {
                    st.pop();
                }
            }
            /*
             * If current operator is from below characters,
             * check if current char precedence is less than equal to stack last element,
             * pop until and add to answer string
             */
            else if (ch == '^' || ch == '+' || ch == '-' || ch == '*' ||
                    ch == '/') {
                while (!st.empty() && prec(ch) <= prec(st.peek())) {
                    sb.append(st.pop());
                }
                /*
                 * push present element to stack for
                 * future store in postfix section
                 */
                st.push(ch);
            }
        }

        /*
         * Pop all the remaining elements from the stack and
         * add to answer string
         */
        while (!st.empty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }
}
