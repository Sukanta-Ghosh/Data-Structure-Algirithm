package arrays;

/* Practise Link
https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1 */

public class LeadersInArray {

	/*
	 * Question Statement: Given an array A of positive integers. Find the leaders
	 * in the array. An element of array is leader if it is greater than or equal to
	 * all the elements to its right side. The rightmost element is always a leader.
	 */

	public static void main(String[] args) {

		int arr[] = { 7, 10, 4, 10, 6, 5, 2 };
		int n = arr.length;

		leadersEfficient(arr, n); // 2 5 6 10
	}

	// Method 2 : Efficient
	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
	static void leadersEfficient(int[] arr, int n) {

		int currentLeader = arr[n - 1];
		System.out.print(currentLeader + " ");

		for (int i = n - 2; i >= 0; i--) {
			if (currentLeader < arr[i]) {
				currentLeader = arr[i];
				System.out.print(arr[i] + " ");
			}
		}
	}

	// Method 1 : Naive
	// Time Complexity: O(n^2)
	// Auxiliary Space: O(1)
	void leadersNaive(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = i + 1; j < n; j++) {
				if (arr[i] <= arr[j]) {
					flag = true;
					break;
				}
			}
			if (!flag)
				System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
