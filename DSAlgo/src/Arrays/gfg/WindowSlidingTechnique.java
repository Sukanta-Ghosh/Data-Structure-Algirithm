package arrays.gfg;

public class WindowSlidingTechnique {

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
    static int subArraySum(int arr[], int n, int sum) {
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
                return 1;
            }

            // Add this element to curr_sum
            if (i < n)
                curr_sum = curr_sum + arr[i];

        }

        System.out.println("No subarray found");
        return 0;
    }

    /* Problem Statement: Function to print bonacci series */
    static void bonacciseries(int n, int m) {

        // Assuming m > n.
        int a[] = new int[m];
        for (int i = 0; i < m; i++)
            a[i] = 0;

        a[n - 1] = 1;
        a[n] = 1;

        // Uses sliding window
        for (int i = n + 1; i < m; i++)
            a[i] = 2 * a[i - 1] - a[i - n - 1];

        // Printing result
        for (int i = 0; i < m; i++)
            System.out.print(a[i] + " ");
    }

    public static void main(String args[]) {

        // Maximum Sum of K Consecutive elements(Efficient)
        int arr[] = { 1, 8, 30, -5, 20, 7 }, n = 6, k = 3;
        System.out.println(maxSum(arr, n, k));

        // Find subarray with given sum
        int arr1[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n1 = arr1.length;
        int sum = 23;
        subArraySum(arr1, n1, sum);

        // Function to print bonacci series
        int N = 5, M = 15;
        bonacciseries(N, M);
    }
}
