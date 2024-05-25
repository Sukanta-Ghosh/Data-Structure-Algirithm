package Arrays;

/* Practise Link
https://www.scaler.com/academy/mentee-dashboard/class/47512/assignment/problems/47?navref=cl_tt_lst_sl
https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1 
*/
public class TrappingRainWater {

	/*
	 * Method: Most Efficient
	 * T.C: O(n)
	 * S.C: O(1)
	 */
	public int trap(final int[] A) {
		int n = A.length;
		int totalWater = 0;

		/*
		 * Initialize variables left and right to point to the start and end of the
		 * input array A. left and right acts as two pointer
		 */
		int left = 0;
		int right = n - 1;

		/*
		 * maxleft and maxRight to store the maximum height seen from
		 * the left and right side
		 */
		int maxleft = 0, maxright = 0;

		while (left <= right) {
			/*
			 * If height of left side is lower, calculate height of water
			 * trapped in left bin
			 * else calculate for right bin
			 */
			if (A[left] <= A[right]) {
				/*
				 * This left index wont store any water as there is no index towards
				 * the left whose height is greater than this.
				 * 
				 * If A[left] >= maxleft then, update maxleft
				 * else A[left] is smaller than maxLeft, so update totalWater
				 */
				if (A[left] >= maxleft) {
					maxleft = A[left];
				} else {
					totalWater += maxleft - A[left];
				}
				left++;
			} else {
				/*
				 * This right index wont store any water as there is no index towards
				 * the right whose height is greater than this.
				 */
				if (A[right] >= maxright) {
					maxright = A[right];
				} else {
					totalWater += maxright - A[right];
				}
				right--;
			}
		}
		return totalWater;
	}

	// Method 2 : Efficient
	// Time Complexity: O(n)
	// Auxiliary Space: O(n)
	static int getWaterEffic(int[] arr, int n) {

		int totalWater = 0;

		/*
		 * lmax: Max elements array from left side
		 * rmax: Max elements array from right side
		 */
		int lmax[] = new int[n];
		int rmax[] = new int[n];

		// Precompute left max array
		lmax[0] = arr[0];
		for (int i = 1; i < n; i++) {
			// i - 1 is last max element from left side
			lmax[i] = Math.max(arr[i], lmax[i - 1]);
			/*
			 * or
			 * max = Math.max(max, A[i]);
			 * prefixArr[i] = max;
			 */
		}

		// Precompute right max array
		rmax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			// i + 1 is the last max element from right side
			rmax[i] = Math.max(arr[i], rmax[i + 1]);
		}

		// Loop to determine minimum water can stay in a block from lmax and rmax array
		for (int i = 1; i < n - 1; i++) {
			int height = Math.min(lmax[i], rmax[i]);
			totalWater += height - arr[i];

		}

		return totalWater;

	}

	// Method 1 : Naive
	// Time Complexity: O(n^2)
	// Auxiliary Space: O(1)
	int getWaterNaive(int[] arr, int n) {

		int res = 0;
		for (int i = 1; i < n - 1; i++) {

			int lmax = arr[i];
			for (int j = 0; j < i; j++)
				lmax = Math.max(lmax, arr[i]);

			int rmax = arr[i];
			for (int j = i + 1; j < n; j++)
				rmax = Math.max(rmax, arr[i]);

			res += Math.min(lmax, rmax) - arr[i];
		}
		return res;
	}

	public static void main(String[] args) {

		int[] arr = { 5, 0, 6, 2, 3 };
		int n = arr.length;

		System.out.println(getWaterEffic(arr, n));// 6
	}
}
