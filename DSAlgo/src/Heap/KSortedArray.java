package Heap;

import java.util.PriorityQueue;

public class KSortedArray {
	
//	Time Complexity: O((n+k)log(k))
	void sortK(int[] arr, int n, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i <= k; i++) {
			pq.add(arr[i]);
		}
		
		int index = 0;
		for(int i= k + 1; i < n; i++) {
			arr[index++] = pq.poll();
			pq.add(arr[i]);
		}
		
		while(!pq.isEmpty()) {
			arr[index++] = pq.poll();
		}
	}
	
	public static void main(String[] args) {
		
		KSortedArray heap = new KSortedArray();
		int[] arr = {9, 8, 7, 19, 18};
		int k = 2;
		
		heap.sortK(arr, arr.length, k);
		
		for(int i : arr)
			System.out.print(i+" ");
		
	}
}
