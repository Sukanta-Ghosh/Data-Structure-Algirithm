package Arrays;

/* Reference Link: 
https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/ 
Questions to Explore:
Q1. Check if a given array can be divided into three parts with equal sum
Q2. Check if there is a subarray with 0 sum
Q3. Find the longest Subarray with equal 0's and 1's
*/

public class PrefixSum {

    /**
     * Prefix Sum Array // Application 1 // Time: O(n)
     * Given an array arr[] of size n, its prefix sum array is another array
     * prefixSum[] of the same size, such that the value of prefixSum[i] is arr[0] +
     * arr[1] + arr[2] … arr[i].
     */
    static int[] preSum(int arr[], int n) {

        int prefix_sum[] = new int[n];

        prefix_sum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }

        return prefix_sum;
    }

    /*
     * Given an array arr[] of size n. Given Q queries and in each query given L and
     * R, print sum of array elements from index L to R.
     */
    static int getSum(int prefix_sum[], int l, int r) {
        if (l != 0)
            return prefix_sum[r] - prefix_sum[l - 1];
        else
            return prefix_sum[r];
    }

    /**
     * Equilibrium Point(Efficient Method) || Time: O(n) || Space: O(1) ||
     * Application 2 || Practise_Link:
     * https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
     * 
     * QS. Given an array A of n positive numbers. The task is to find the first
     * Equilibium Point in the array. Equilibrium Point in an array is a position
     * such that the sum of elements
     * before it is equal to the sum of elements after it.
     */
    static boolean checkEquilibrium(int arr[], int n) {

        int sum = 0;

        // Computing total sum of the Array
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Check every point if it is Equilibrium point or not
        int leftSideSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSideSum == sum - arr[i])
                return true;

            leftSideSum += arr[i];

            // Here sum variable will act as rightSideSum
            sum -= arr[i];
        }

        return false;
    }

    /**
     * Maximum Occuring Element || Application 3 || Practise Link:
     * https://practice.geeksforgeeks.org/problems/maximum-occured-integer4602/1
     * 
     * Qs Statement: Given n integer ranges, the task is to find the maximum
     * occurring integer in these ranges. If more than one such integer exits, find
     * the smallest one. The ranges are given as two arrays L[] and R[]. L[i]
     * consists of starting point of range and R[i] consists of corresponding end
     * point of the range.
     */
    static int maxOcc(int L[], int R[], int n) {
        int arr[] = new int[1000];

        // TODO: Add comment
        for (int i = 0; i < n; i++) {
            arr[L[i]]++;

            arr[R[i] + 1]--;
        }

        int maxm = arr[0], res = 0;

        for (int i = 1; i < 1000; i++) {
            arr[i] += arr[i - 1];

            if (maxm < arr[i]) {
                maxm = arr[i];

                res = i;
            }
        }

        return res;
    }

    public static void main(String args[]) {

        // Prefix Sum Array
        int arr[] = { 2, 8, 3, 9, 6, 5, 4 }, n = 7;

        int prefix_sum[] = preSum(arr, n);

        System.out.println(getSum(prefix_sum, 1, 3)); // 20
        System.out.println(getSum(prefix_sum, 0, 2)); // 13

        // Equilibrium Point
        int arr1[] = { 3, 4, 8, -9, 20, 6 }, n1 = 6;
        System.out.println(checkEquilibrium(arr1, n1)); // true

        // Maximum Occuring Element
        int L[] = { 1, 2, 3 }, R[] = { 3, 5, 7 }, n2 = 3;
        System.out.println(maxOcc(L, R, n2)); // 3

    }
}
