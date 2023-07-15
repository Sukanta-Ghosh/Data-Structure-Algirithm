package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47560/assignment/problems/50?navref=cl_tt_nv */
public class SlidingWindowMaximum {
    /*
     * T.C: O(n)
     * S.C: O(B)
     */
    public int[] slidingMaximum(final int[] A, int B) {
        int n = A.length;
        int size = (A.length - B) + 1;
        int[] ansArr = new int[size];
        int index = 0;

        // Edge Case
        if (n == 1) {
            ansArr[index++] = A[0];
            return ansArr;
        }

        /* To Store B window array elements */
        Deque<Integer> deque = new ArrayDeque<>();

        /* Computing for first B window elements */
        for (int i = 0; i < B; i++) {
            /*
             * Until deque is empty and
             * Array current element is greater than deque last elements,
             * remove last elements from deque
             */
            while (!deque.isEmpty() && A[i] >= deque.peekLast()) {
                deque.removeLast();
            }

            /* Add current array element at deque last position */
            deque.addLast(A[i]);
        }
        // Adding first B window max element in array
        ansArr[index++] = deque.getFirst();

        /* Iterating and computing for every next B window max */
        for (int i = B; i < A.length; i++) {
            /*
             * If deque first element is same as last slided window element,
             * then remove deque first element
             */
            if (deque.peekFirst() == A[i - B]) {
                deque.removeFirst();
            }

            /* Same logic a before */
            while (!deque.isEmpty() && A[i] > deque.peekLast()) {
                deque.removeLast();
            }

            /* Add current array element at deque last position */
            deque.addLast(A[i]);

            /* Update ans arr with every deque first element */
            ansArr[index++] = deque.getFirst();
        }

        return ansArr;
    }
}
