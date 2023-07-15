package Linked_List;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
 * Qs:
 * https://www.scaler.com/academy/mentee-dashboard/class/47550/homework/problems
 * /380/?navref=cl_pb_nv_tb
 */
public class KReverseLL {
    public ListNode reverseList(ListNode A, int B) {
        /*
         * Define dummy node which will always point to
         * head node previous node
         */
        ListNode dummy = new ListNode(0);
        /* prev node will point to curr node previous node */
        ListNode prev = dummy;
        /* Set prev node as head previous node */
        prev.next = A;

        /* Iterate over A LL until last node */
        while (A != null) {
            // Denote number of nodes reversed
            int count = 1;
            /*
             * Set A node as curr node
             * Here A node will act as start/left pointer of reverse B size window
             */
            ListNode curr = A;

            /*
             * Iterate to find B th node in current window,
             * curr node will point to this node
             */
            while (curr.next != null && count < B) {
                count++;
                curr = curr.next;
            }

            /* Here count = B check in case last window has less number of elements */
            if (count == B) {
                /*
                 * In this step:
                 * curr node is point to B th node
                 * next node will point to B + 1 th node
                 */
                ListNode next = curr.next;
                /*
                 * curr node is pointing to B th node,
                 * assign as null as it will be first node after reverse
                 */
                curr.next = null;
                /* A is poinitng to 1st node of window */
                ListNode rev = reverse(A);
                /*
                 * In this step, rev is pointing to first node after reverse
                 * rev is curr/head node now, so prev next node
                 * is set as curr node
                 */
                prev.next = rev;
                /*
                 * next node(B + 1 th node) set as A node next node
                 * for next iteration
                 */
                A.next = next;
            }

            /*
             * In this step:
             * A is pointing to previous node
             * A points to A next node
             */
            prev = A;
            A = A.next;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode A) {
        ListNode prev = new ListNode(0), head = A;
        prev.next = A;
        while (A != null) {
            ListNode tmp = A.next;
            A.next = prev;
            prev = A;
            A = tmp;
        }
        head.next = null;
        return prev;
    }
}
