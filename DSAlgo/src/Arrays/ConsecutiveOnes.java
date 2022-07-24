package Arrays;

/* Parctise Link
https://leetcode.com/problems/max-consecutive-ones/ */

// QS: Given a binary array nums, return the maximum number of consecutive 1's in the array.
public class ConsecutiveOnes {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 1, 0, 1, 1, 1, 1 };
		int n = arr.length;

		System.out.println(maxOnesEfficient(arr, n)); // O/p: 4
	}

	// Method 2 : Efficient
	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
	static int maxOnesEfficient(int[] arr, int n) {

		int res = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {

			if (arr[i] == 1) {
				count++;
				res = Math.max(res, count);
			} else
				count = 0;
		}
		return res;
	}

	// Method 1 : Naive
	// Time Complexity: O(n^2)
	// Auxiliary Space: O(1)
	int maxOnesNaive(int[] arr, int n) {

		int res = 0;
		for (int i = 0; i < n; i++) {

			int count = 0;
			for (int j = i; j < n; j++) {
				if (arr[i] == 1)
					count++;
				else
					break;
			}
			res = Math.max(res, count);
		}
		return res;
	}

}
