package Arrays;

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

    /*
     * Topic: QS: Maximum Sum of K Consecutive elements(Efficient)
     * T.C: O(n)
     * S.C: O(1)
     */
    static int maxSum(int arr[], int n, int k) {
        int curr_sum = 0;

        // Derive sum for first k elements
        for (int i = 0; i < k; i++)
            curr_sum += arr[i];

        int max_sum = curr_sum;

        // Using window sliding technique
        for (int i = k; i < n; i++) {
            /* Include current element and exclude i - k the element */
            curr_sum += (arr[i] - arr[i - k]);

            // Finding max sum for every k elements
            max_sum = Math.max(max_sum, curr_sum);
        }

        return max_sum;
    }

    /*
     * Topic: QS: Find subarray with given sum. Returns true if
     * there is a subarray of arr[] with sum equal to 'sum' otherwise returns false.
     * Also, prints the result
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
     * Topic: QS: Function to print N-Bonacci series
     * Print first m numbers of N-bonacci numbers
     * Iterative Solution (Optimized Algorithm)
     * Time: O(m)
     * Space: O(m)
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
