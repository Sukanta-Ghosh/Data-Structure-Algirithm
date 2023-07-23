package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinMaxHeapDefine {

	// Time Complexity: O(k + (n - k)log(n))
	void minHeap(int[] arr, int n, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++)
			pq.add(arr[i]);

		for (int i = k; i < n; i++) {

			if (arr[i] > pq.peek()) {
				pq.poll();
				pq.add(arr[i]);
			}
		}

		while (!pq.isEmpty())
			System.out.print(pq.poll() + " ");
		System.out.println();
	}

	// Time Complexity: O(n + klog(n))
	void maxHeap(int[] arr, int n, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : arr)
			pq.add(i);

		while (k-- > 0)
			System.out.print(pq.poll() + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		int[] arr = { 5, 15, 10, 20, 8 };
		int k = 2;

		MinMaxHeapDefine heap = new MinMaxHeapDefine();
		heap.maxHeap(arr, arr.length, k);
		heap.minHeap(arr, arr.length, k);
	}
}
