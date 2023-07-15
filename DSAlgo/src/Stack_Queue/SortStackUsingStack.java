package Stack_Queue;

import java.util.Stack;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47558/assignment/problems/4347?navref=cl_tt_lst_sl */
public class SortStackUsingStack {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int[] solve(int[] A) {
        Stack<Integer> stInput = new Stack<Integer>();
        Stack<Integer> stHelper = new Stack<Integer>();

        for (int i : A) {
            stInput.push(i);
        }

        /*
         * Iterate to fill stHelper stack in stack descending order(w.r.t pop)
         * st => 1 2 3 4 5(stack first ele).
         * After iteration stInput stack will be empty
         */
        while (!stInput.empty()) {
            int curr = stInput.pop();

            while (!stHelper.empty() && stHelper.peek() > curr) {
                stInput.push(stHelper.pop());
            }
            stHelper.push(curr);
        }

        /*
         * Pop stHelper stack item and push to stInput stack,
         * which now result in sorted stack in ascending order(w.r.t pop)
         * st => 5 4 3 2 1(stack first ele).
         */
        while (!stHelper.empty()) {
            stInput.push(stHelper.pop());
        }

        /* Pop stInput elements to create sorted arr */
        int[] arr = new int[A.length];
        int i = 0;
        while (!stInput.empty()) {
            arr[i++] = stInput.pop();
        }

        return arr;
    }
}
