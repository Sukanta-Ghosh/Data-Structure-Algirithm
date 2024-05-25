package Linked_List;

/* Qs:
 * https://www.scaler.com/academy/mentee-dashboard/class/47550/homework/problems/39/?navref=cl_pb_nv_tb
 */
public class RemoveNthNodeFromEnd {
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int size = 0;
        ListNode curr = A;

        // Calculates the size of the linked list
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        // This condition is mentioned in Qs
        if (size <= B) {
            A = A.next;
            return A;
        }

        /*
         * Traverse from 0 to (size - 1) - B element,
         * (size - 1) - B is B th element from last
         */
        curr = A;
        for (int i = 0; i < size - 1 - B; i++) {
            curr = curr.next;
        }

        // Here curr is (B - 1) th element from end
        curr.next = curr.next.next;

        return A;
    }
}
