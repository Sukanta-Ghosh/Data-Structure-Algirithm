package Linked_List;

public class InsertingNode {
	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	// Declaring them outside of all methods so that we can update them as we go
	// through all methods.
	// Make sure to update the length accordingly in each method. We will use it
	// while printing all values.
	static int length = 0;
	static ListNode head = null;
	// static ListNode tail = null;

	public static void insert_node(int position, int value) {
		// @params position, integer
		// @params value, integer
		ListNode node = new ListNode(value);

		// Edge case: If the position given is greater than the (length of the Linked
		// List) + 1 then we cannot create it.
		if (position > length + 1) {
			return;
		}

		if (position == 1) {
			node.next = head;
			head = node;
		} else {
			ListNode curr = head;
			for (int i = 1; i < position - 1; i++) {
				curr = curr.next;
			}
			node.next = curr.next;
			curr.next = node;
		}
		length++;
	}

	public static void delete_node(int position) {
		// @params position, integer
		// Edge case: if the position is given greater than the Linked
		// List's length, we can't delete it.
		if (position > length) {
			return;
		}

		if (position == 1) {
			head = head.next;
		} else {
			ListNode curr = head;
			for (int i = 1; i < position - 1; i++) {
				curr = curr.next;
			}
			curr.next = curr.next.next;
		}

		length--;
	}

	public static void print_ll() {
		// Output each element followed by a space
		if (length == 0) {
			return;
		}

		ListNode curr = head;
		while (curr.next != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.print(curr.val);
	}

}
