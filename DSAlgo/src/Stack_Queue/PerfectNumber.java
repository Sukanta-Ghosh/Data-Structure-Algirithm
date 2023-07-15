package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47560/assignment/problems/3297?navref=cl_tt_lst_sl */
public class PerfectNumber {
    /*
     * T.C: O(A)
     * S.C: O(A)
     */
    public String solve(int A) {
        // Edge Case
        if (A == 1)
            return "11";
        else if (A == 2)
            return "22";

        /* Define queue to store 1 and 2 comprise numbers */
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        /*
         * Count is initialized as 2, cuz
         * 1 and 2 pushed to queue, which can form perfect
         * number in form of aa'
         * a' is reverse of a
         */
        int count = 2;
        String ans = new String();

        // Iterate over queue until its size is less than A
        while (queue.size() < A) {
            /* Define StringBuilder to use append function */
            StringBuilder sb = new StringBuilder(queue.remove());

            /* First append 1 and increase count */
            sb.append("1");
            count++;

            /* Add new string in queue */
            queue.add(sb.toString());

            /* After count == A, next iteration loop will end */
            if (count == A) {
                ans = sb.toString();
            }

            sb.deleteCharAt(sb.length() - 1);
            /* Now append 2 and increase count */
            sb.append("2");
            count++;
            /* Add new string in queue */
            queue.add(sb.toString());

            if (count == A) {
                ans = sb.toString();
            }
        }

        // ans has the first half of our final answer
        StringBuilder sb = new StringBuilder(ans);

        /* Reverse the string and add into ans string and return */
        return ans + sb.reverse().toString();
    }
}
