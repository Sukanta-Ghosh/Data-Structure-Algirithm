package Stack_Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47560/assignment/problems/4365/?navref=cl_pb_nv_tb */
public class FirstNonRepeatChar {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public String solve(String A) {
        /*
         * Define Queue to keep track of first non-repeating
         * element
         */
        Queue<String> queue = new LinkedList<>();
        /* StringBuilder to form answer string */
        StringBuilder sb = new StringBuilder("");
        /*
         * HashMap to store key as char String and value as
         * frequency
         */
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        /* Itearte over array to form answer string */
        for (int i = 0; i < A.length(); i++) {
            // Extract current String char
            String currStr = A.substring(i, i + 1);

            /* Store string and their frequency */
            if (!map.containsKey(currStr)) {
                map.put(currStr, 1);
            } else {
                map.put(currStr, map.get(currStr) + 1);
            }

            // Add current string char in queue
            queue.add(currStr);

            /*
             * While queue first element size is gretaer
             * than 1, remove from queue
             */
            while (queue.size() > 0 && map.get(queue.peek()) > 1) {
                queue.poll();
            }

            /* Naswer string logic */
            if (queue.size() == 0) {
                sb.append("#");
            } else {
                sb.append(queue.peek());
            }
        }

        return sb.toString();
    }
}
