package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70857/assignment/problems/4369/?navref=cl_pb_nv_tb */
public class MedianOfStream {

	/*
	 * T.C: O(nlogn)
	 * S.C: O(n)
	 */
	public int[] solve(int[] A) {
		int n = A.length;
		int[] ans = new int[n];
		ans[0] = A[0];

		/* In max heap, first n/2 no elements will be added */
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		/* In minHeap, last n/2 no elements will be added */
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		/* Iterate over array to find median */
		maxHeap.add(A[0]);
		for (int i = 1; i < n; i++) {
			int ele = A[i];
			if (ele < maxHeap.element()) {
				maxHeap.add(ele);
			} else {
				minHeap.add(ele);
			}

			/*
			 * 1. If maxminSizeDiff is greater than 1, then
			 * maxHeap has more items than minHeap + 1 item,
			 * so remove element from maxHeap to minHeap
			 * 2. If maxminSizeDiff is less than 0, then
			 * minHeap has more items than maxHeap + 1 item,
			 * so remove element from minHeap to maxHeap
			 */
			int maxminSizeDiff = maxHeap.size() - minHeap.size();
			if (maxminSizeDiff > 1) {
				minHeap.add(maxHeap.remove());
			}

			if (maxminSizeDiff < 0) {
				maxHeap.add(minHeap.remove());
			}

			/*
			 * Add maxHeap max element into ans array,
			 * which is the median of all number
			 */
			ans[i] = maxHeap.element();
		}

		return ans;
	}

	public static void main(String[] args) {

		int[] arr = { 12, 15, 10, 5, 8, 7, 16 };
		MedianOfStream heap = new MedianOfStream();
		for (int i : heap.solve(arr)) {
			System.out.print(i + " ");
		}
	}
}
