package Arrays;

/* Practise Link:
Scale link: https://www.scaler.com/academy/mentee-dashboard/class/47508/assignment/problems/56/chatgpt-help?navref=cl_pb_nv_tb
https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1 

Problem Statement: Given an array Arr[] of N integers. 
Find the contiguous sub-array(containing at least one number) which has the maximum sum 
and return its sum.*/

public class MaximumSubarraySum {

	/*
	 * Kadane's Algorithm
	 * Method 2 : Efficient
	 * T.C: O(n)
	 * S.c: O(1)
	 */
	static int kadaneAlgorithm(int[] A, int n) {
		// Take maxSum as min value
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = 0; i < A.length; i++) {
			// currentSum is recent element
			currentSum += A[i];
			/*
			 * Find max b/w existing maxSum and currentSum,
			 * if currentSum is greater, then include current A[i]
			 */
			maxSum = Math.max(maxSum, currentSum);

			/*
			 * if currentSum is less than 0, then reset currentSum
			 * then discard array elements till now in maxSum
			 */
			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		return maxSum;
	}

	/*
	 * Kadane's Algorithm
	 * Method 3 : Less line code
	 * T.C: O(n)
	 * S.c: O(1)
	 */
	static int kadaneAlgorithm_Method2(int[] arr, int n) {

		int currSum = arr[0];
		int maxSum = arr[0];

		for (int i = 1; i < n; i++) {
			/*
			 * Checking condition b/w include currentSum and next element
			 * or consider only next element
			 */
			currSum = Math.max(currSum + arr[i], arr[i]);
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {

		// int[] arr = { -3, 8, -2, 4, -5, 6 };
		int[] arr = { -2, -3, -1, -4, -6 };
		int n = arr.length;

		System.out.println(kadaneAlgorithm(arr, n)); // 11
	}

	/*
	 * Method 1 : Naive
	 * T.C: O(n ^ 2)
	 * S.C: O(1)
	 */
	int maxSum(int[] arr, int n) {

		int res = 0;
		for (int i = 0; i < n; i++) {

			int currentSum = 0;
			for (int j = i; j < n; j++) {

				currentSum += arr[i];
				res = Math.max(res, currentSum);
			}
		}
		return res;
	}
}
