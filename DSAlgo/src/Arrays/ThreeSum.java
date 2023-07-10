package Arrays;

import java.util.Arrays;

public class ThreeSum {
    /* T.C: O(n ^ 2) */
    public int threeSumClosest(int[] A, int B) {
        int n = A.length;
        // Sort the array
        Arrays.sort(A);
        long minSum = Integer.MAX_VALUE;

        // base case
        if (n <= 3) {
            int sum = 0;
            for (int a : A)
                sum += a;
            return sum;
        }

        // Iterate through array, i is 1st pointer
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1; // l is 2nd pointer
            int r = n - 1; // r is 3rd pointer

            // escaping repeated values of i
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }

            // Iterate b/w 2nd and 3rd pointer
            while (l < r) {
                int sum = A[i] + A[l] + A[r];

                if (Math.abs(B - sum) < Math.abs(minSum - B)) {
                    minSum = sum;
                }

                if (sum == B) {
                    return sum;
                } else if (sum < B) {
                    l++;
                } else if (sum > B) {
                    r--;
                }
            }
        }

        return (int) minSum;
    }
}
