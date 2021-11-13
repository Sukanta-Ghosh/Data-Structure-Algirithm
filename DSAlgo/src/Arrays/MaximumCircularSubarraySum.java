package arrays;

/* Practise Link 
https://practice.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1 */

public class MaximumCircularSubarraySum {

	// Method 2 : Efficient
	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
	static int maxCircularSumEffic(int[] arr, int n) {

		// If all values are negative, then this code will return maximum sum
		int maxNormal = normalMaxSum(arr, n);
		if (maxNormal < 0)
			return maxNormal;

		/*
		 * Circular Sum: For this we need to find Minimum sum subarray(which will be the
		 * middle elements of the array) and subtract that sum from total array sum of
		 * normal array || Maximum sum in a inverted array is equal to find minimum sum
		 * in a normal array, so instead of subtracting we are adding the minimum sum
		 * with total sum of the array
		 */
		int arraySum = 0;
		for (int i = 0; i < n; i++) {
			arraySum += arr[i];
			arr[i] = -arr[i];
		}
		int maxCircular = arraySum + normalMaxSum(arr, n);

		return Math.max(maxNormal, maxCircular);
	}

	// Kadane's Algorithm
	static int normalMaxSum(int[] arr, int n) {

		int res = 0;
		int maxEnding = arr[0];

		for (int i = 1; i < n; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			res = Math.max(maxEnding, res);
		}
		return res;
	}

	public static void main(String[] args) {

		int[] arr = { 8, -4, 3, -5, 4 };
		int n = arr.length;

		System.out.println(maxCircularSumEffic(arr, n));
	}

	// Method 1 : Naive
	// Time Complexity: O(n^2)
	// Auxiliary Space: O(1)
	int maxCircularSumNaive(int[] arr, int n) {

		int res = 0;
		for (int i = 0; i < n; i++) {

			int currentSum = arr[i];
			int currentMax = arr[i];
			for (int j = 1; j < n; j++) {
				int index = (i + j) % n;
				currentSum += arr[index];
				currentMax = Math.max(currentSum, currentMax);
			}
			res = Math.max(res, currentMax);
		}
		return res;
	}

}
