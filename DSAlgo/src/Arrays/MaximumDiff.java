package Arrays;

/* Practise Link 
https://www.geeksforgeeks.org/maximum-difference-between-two-elements/ */

public class MaximumDiff {

	/*
	 * Qs Statement: Given an array arr[] of integers, find out the maximum
	 * difference between any two elements such that larger element appears after
	 * the smaller number.
	 */

	public static void main(String[] args) {

		int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		int n = arr.length;

		System.out.println(maxDiffEffi(arr, n)); // O/p: 8
	}

	// Method 2 : Efficient
	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
	/*
	 * In this method, instead of taking difference of the picked element with every
	 * other element, we take the difference with the minimum element found so far.
	 */
	static int maxDiffEffi(int[] arr, int n) {

		int minVal = arr[0];
		// Difference b/w current element and min element
		int maxDiff = arr[1] - minVal;

		for (int i = 1; i < n; i++) {
			// Maximum difference found so far
			maxDiff = Math.max(maxDiff, arr[i] - minVal);
			// Minimum element visited so far
			minVal = Math.min(minVal, arr[i]);
		}
		return maxDiff;
	}

	// Method 1 : Naive
	// Time Complexity: O(n^2)
	// Auxiliary Space: O(1)
	int maxDiffNaive(int[] arr, int n) {

		int res = arr[1] - arr[0];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				res = Math.max(res, arr[j] - arr[i]);
			}
		}
		return res;
	}
}
