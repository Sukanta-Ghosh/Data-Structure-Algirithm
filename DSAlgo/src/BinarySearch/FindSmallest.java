package BinarySearch;

import java.util.Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47536/homework/problems/9155/?navref=cl_pb_nv_tb */
public class FindSmallest {
    public int solve(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A); // Sort the input array A in ascending order
        int low = A[0] + A[1] + A[2]; // Initialize the lowest possible sum of a triplet
        int high = A[n - 1] + A[n - 2] + A[n - 3]; // Initialize the highest possible sum of a triplet
        int ans = 0; // Initialize the answer variable to store the B-th smallest element

        // Perform binary search on the possible sum of triplets
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle value for binary search

            // Check the number of triplets with sum less than or equal to mid
            if (checkPos(A, mid) <= B) {
                ans = mid; // Update the answer if the number of triplets is less than or equal to B
                low = mid + 1; // Update the lower bound for binary search
            } else {
                high = mid - 1; // Update the upper bound for binary search
            }
        }

        return ans; // Return the B-th smallest element
    }

    // Function to check the number of triplets with sum less than or equal to mid
    public int checkPos(int[] A, int mid) {
        int n = A.length;
        int count = 0; // Initialize the count of triplets

        // Iterate through all possible combinations of triplets
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k]; // Calculate the sum of the triplet
                if (sum < mid) {
                    count += (k - j); // Increment the count if the sum is less than mid
                    j++; // Move the pointer to the right
                } else {
                    k--; // Move the pointer to the left
                }
            }
        }

        return count; // Return the count of triplets
    }
}
