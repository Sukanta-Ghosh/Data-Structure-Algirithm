package Heap;

import java.util.*;

public class MergeKSortedArray {
	
	class Triplet implements Comparable<Triplet>{
		
		int val, aPos, vPos;
		Triplet(int v, int ap, int vp){
			val = v;
			aPos = ap;
			vPos = vp;
		}
		
		public int compareTo(Triplet t) {
			
			if(val <= t.val)
				return -1;
			else return 1;
		}
	}
	
//	Time Complexity: O(nklog(k))
//	n = highest number of element in a array
	List<Integer> mergeArr(int[][] arr){
		
		List<Integer> res = new ArrayList<Integer>();
		PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>();
		
		for(int i = 0; i < arr.length; i++)
			pq.add(new Triplet(arr[i][0], i, 0));
		
		while(!pq.isEmpty()) {
			
			Triplet curr = pq.poll();
			res.add(curr.val);
			int ap = curr.aPos;
			int vp = curr.vPos;
			
			if(vp + 1 < arr[ap].length)
				pq.add(new Triplet(arr[ap][vp + 1], ap, vp + 1));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{10, 20}, 
					   {5, 15},
					   {4, 9, 11}};
		MergeKSortedArray heap = new MergeKSortedArray();
		
		for(int i : heap.mergeArr(arr))
			System.out.print(i+" ");
	}
}
