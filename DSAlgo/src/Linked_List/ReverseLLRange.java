package Linked_List;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47550/homework/problems/45?navref=cl_tt_nv */
public class ReverseLLRange {
    /*
     * T.C: O(B + C)
     * S.C: O(1)
     */
    public ListNode reverseBetween(ListNode A, int B, int C) {
        // Pointing to head node
        ListNode curr = A;
        // pointing to curr prev node which is null
        ListNode prev = null;
        // BNode is Bth node
        ListNode BNode = null;
        // BPrevNode is B - 1 th node
        ListNode BPrevNode = null;
        // CNode is C th node
        ListNode CNode = null;
        // CNextNode is C + 1 th node
        ListNode CNextNode = null;

        // Iterate to find BPrevNode and BNode
        for (int i = 1; i < B; i++) {
            BPrevNode = curr;
            curr = curr.next;
        }
        BNode = curr;

        // Iterate to find CNode and CNextNode
        for (int i = 1; i <= C - B + 1; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        CNode = prev;
        CNextNode = curr;

        /*
         * After reverse BNode(B th node) will point to
         * CNextNode(C + 1 th node)
         */
        BNode.next = CNextNode;

        /*
         * Edge case: If BPrevNode is null,
         * then CNode will be the head node
         */
        if (BPrevNode == null) {
            return CNode;
        }

        /*
         * else BPrevNode(B - 1 th node) next node will
         * point to CNode(c th node)
         */
        BPrevNode.next = CNode;
        return A;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
