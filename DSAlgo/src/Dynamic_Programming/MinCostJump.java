package Dynamic_Programming;

import java.util.Arrays;

// Bottom-up approach
public class MinCostJump {
	
	int minCostJumpsDP(int []A, int k) 
	{ 
		int size = A.length; 

		// Allocating Memo table and 
		// initializing with INT_MAX 
		int []x = new int[size]; 
		Arrays.fill(x, Integer.MAX_VALUE); 

		// Base case 
		x[0] = 0; 
		
		System.out.println(size);
		// For every element relax every reachable 
		// element ie relax next k elements 
		for (int i = 0; i < size; i++) 
		{ 
			// reaching next k element 
			for (int j = i + 1; j < i + k + 1 && j < size; j++) 
			{ 
				// Relaxing the element 
				x[j] = Math.min(x[j], x[i] + Math.abs(A[i] - A[j])); 
			} 
		} 
 
		return x[size - 1]; 
	} 
}
