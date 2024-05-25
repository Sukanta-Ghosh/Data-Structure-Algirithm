package Linked_List;

import Linked_List.InsertingNode.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
/*
 * Qs: https://www.scaler.com/academy/mentee-dashboard/class/47550/assignment/
 * problems/40?navref=cl_tt_lst_sl
 */
public class ReverseLL {
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;

        // Iterate through original linked list
        while (curr != null) {
            // Store current node next node in "next" node
            ListNode next = curr.next;
            // Connect current node next node as prev node in order to reverse
            curr.next = prev;
            // Change prev node to curr node
            prev = curr;
            // Change current node to previous current node next node in order to iterate
            curr = next;
        }

        A = prev;
        return A;
    }
}
