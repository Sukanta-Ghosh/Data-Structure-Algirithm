package Arrays.easy;

public class WindowSlidingTechnique {

    public static void main(String args[]) {

        // Maximum Sum of K Consecutive elements(Efficient)
        int arr[] = { 1, 8, 30, -5, 20, 7 }, n = 6, k = 3;
        System.out.println(maxSum(arr, n, k)); // O/p: 45

        // Find subarray with given sum
        int arr1[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n1 = arr1.length;
        int sum = 23;
        subArraySum(arr1, n1, sum); // O/p: Sum found between indexes 1 and 4

        // Function to print bonacci series
        int N = 5, M = 15;
        nbonacciseries(N, M); // O/p: 0 0 0 1 1 2 4 8 16 31 61 120 236 464
    }

    /* Problem Statement: Maximum Sum of K Consecutive elements(Efficient) */
    static int maxSum(int arr[], int n, int k) {
        int curr_sum = 0;

        for (int i = 0; i < k; i++)
            curr_sum += arr[i];

        int max_sum = curr_sum;

        for (int i = k; i < n; i++) {
            curr_sum += (arr[i] - arr[i - k]);

            max_sum = Math.max(max_sum, curr_sum);
        }

        return max_sum;
    }

    /*
     * Problem Statement: Find subarray with given sum || Returns true if the there
     * is a subarray of arr[] with sum equal to 'sum' otherwise returns false. Also,
     * prints the result
     */
    static void subArraySum(int arr[], int n, int sum) {
        int curr_sum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum) {
                int p = i - 1;
                System.out.println("Sum found between indexes " + start + " and " + p);
                return;
            }

            // Add elements to curr_sum
            if (i < n)
                curr_sum = curr_sum + arr[i];

        }

        System.out.println("No subarray found");

    }

    /*
     * Problem Statement: Function to print N-Bonacci series // Print first m
     * numbers of N-bonacci numbers
     */
    // Time: O(m)
    // Space: O(m)
    /*
     * Reference Link:
     * https://chasmiccoder.medium.com/n-bonacci-numbers-a-detailed-analysis-
     * 951ad03d9bf2 // Iterative Solution (Optimized Algorithm) // 0 1 1 2 3 5 8 13
     * 21 … // For m = 8, we should get 21 = 8 + 13 // Now, the previous result got
     * computed like this, 13 = 8 + 5 // So, if we subtract 5 from the
     * 
     * // previous result (13), we will get 8. Now we just need to add the last
     * number. This way, we would have computed 21 from the previous result; 21 = 13
     * — 5 + 13 // As another example, for N = 5, m = 11, we get // 0 0 0 0 1 1 2 4
     * 8 16 31 61 … // The answer should be 61 = 2 + 4 + 8 + 16 + 31 // The previous
     * result was 31 = 1 + 2 + 4 + 8 + 16 // Computing 61 from the previous result,
     * 61 = 31–1 + 31 = 2(31) — 1 // This way, if we store all the previous results
     * in an array, we can just use the last value computed and the value N elements
     * before the current one to find the next result. // If m is lesser than N-1,
     * return 0. If it is equal to N-1, return 1 // Define an array previous, of
     * length m+1. The final answer will be in previous[m] // Set the values of
     * previous[N-1] and previous[N] as 1 // Loop over from N to m-1, with control
     * variable i. The (i+1)ᵗʰ element will be twice the previous element minus the
     * one that got discarded; (i-N)ᵗʰ element // Return previous[m]
     */
    static void nbonacciseries(int n, int m) {

        // Assuming m > n.
        int a[] = new int[m];

        // n th and n-1 th element always will be 1
        a[n - 1] = 1;
        a[n] = 1;

        // Uses sliding window
        // Loop start from n + 1 th element
        for (int i = n + 1; i < m; i++)
            a[i] = 2 * a[i - 1] - a[i - n - 1];

        // Printing result
        for (int i = 0; i < m; i++)
            System.out.print(a[i] + " ");
    }

}
