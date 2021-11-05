package Arrays;

/* Practise Link 
https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1 */

public class MaximumSubarraySum {

	/* Kadane's Algorithm	
	Method 2 : Efficient
	Time Complexity: O(n)
	Auxiliary Space: O(1) */	
	int kadaneAlgorithm(int[] arr, int n) {
		
		int res = 0;
		int maxEnding = arr[0];
		
		for(int i = 1; i < n; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			res = Math.max(maxEnding, res);
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {-3, 8, -2, 4, -5, 6};
		int n = arr.length;
		
		MaximumSubarraySum obj = new MaximumSubarraySum();
		System.out.println(obj.kadaneAlgorithm(arr, n));
	}

	/* Method 1 : Naive
	Time Complexity: O(n^2)
	Auxiliary Space: O(1) */
	int maxSum(int[] arr, int n) {
		
		int res = 0;
		for(int i = 0; i < n; i++) {
			
			int currentSum = 0;
			for(int j = i; j < n; j++) {
				
				currentSum += arr[i];
				res = Math.max(res, currentSum);
			}
		}
		return res;
	}	
}
