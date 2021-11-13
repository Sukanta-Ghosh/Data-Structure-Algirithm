package arrays;

/* Practise Link 
https://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1 
Qs. Move all zeros to the end */

public class ZeroToEnd {

	public static void main(String[] args) {

		int[] arr = { 10, 8, 0, 0, 12, 0 };
		int n = arr.length;

		moveToEndEfficient(arr, n);
		for (int i : arr)
			System.out.print(i + " ");
	}

	// Method 2 : Efficient
	// Time Complexity: O(n)
	// Auxiliary Space: O(1)
	static void moveToEndEfficient(int[] arr, int n) {

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				swap(arr, i, count);
				count++;

			}
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Method 1 : Naive
	// Time Complexity: O(n^2)
	// Auxiliary Space: O(1)
	void moveToEndNaive(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < n; j++) {
					if (arr[i] != 0)
						swap(arr, i, j);
				}
			}
		}
	}

}
