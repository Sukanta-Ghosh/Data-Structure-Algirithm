package Arrays.gfg;

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
     */
    static int[] preSum(int arr[], int n) {

        int prefix_sum[] = new int[n];

        prefix_sum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }

        return prefix_sum;
    }

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
     */
    static boolean checkEquilibrium(int arr[], int n) {

        // Computing total sum of the Array
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Check every point if it is Equilibrium point or not
        int leftSideSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSideSum == sum - arr[i])
                return true;

            leftSideSum += arr[i];

            // Here sum var will act as rightSideSum
            sum -= arr[i];
        }

        return false;
    }

    /**
     * Maximum Occuring Element || Application 3 || Practise Link:
     * https://practice.geeksforgeeks.org/problems/maximum-occured-integer4602/1
     */
    static int maxOcc(int L[], int R[], int n) {
        int arr[] = new int[1000];

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

        System.out.println(getSum(prefix_sum, 1, 3));
        System.out.println(getSum(prefix_sum, 0, 2));

        // Equilibrium Point
        int arr1[] = { 3, 4, 8, -9, 20, 6 }, n1 = 6;
        System.out.println(checkEquilibrium(arr1, n1));

        // Maximum Occuring Element
        int L[] = { 1, 2, 3 }, R[] = { 3, 5, 7 }, n2 = 3;
        System.out.println(maxOcc(L, R, n2));

    }
}
