package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
	
//	Time Complexity: O(nlog(n))
	void printMedians(int arr[]) {
		
		PriorityQueue<Integer> s = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> g = new PriorityQueue<Integer>();
		
		s.add(arr[0]);
		System.out.print(arr[0]+" ");
		
		for(int i = 1; i < arr.length; i++)
		{
			int x = arr[i];
			if(s.size() > g.size()) {
				if(s.peek() > x) {
					g.add(s.poll());
					s.add(x);
				}
				else {
					g.add(x);
				}
				System.out.print((double)(s.peek() + g.peek()) / 2+" ");
			}
			else {
				if(x <= s.peek()) {
					s.add(x);
				}
				else {
					g.add(x);
					s.add(g.poll());
				}
				System.out.print(s.peek()+" ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {12, 15, 10, 5, 8, 7, 16};
		MedianOfStream heap = new MedianOfStream();
		heap.printMedians(arr);
	}
}
