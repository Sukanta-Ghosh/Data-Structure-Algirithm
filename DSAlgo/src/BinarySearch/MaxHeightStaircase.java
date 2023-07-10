package BinarySearch;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47532/homework/problems/4101/?navref=cl_pb_nv_tb */
public class MaxHeightStaircase {
    public int solve(int A) {
        long low = 0;
        long high = A;
        long ans = 0;

        // Edge Case
        if (A == 1) {
            return 1;
        }

        // Binary search to find the maximum height of the staircase
        while (low <= high) {
            // Calculate the middle value
            long mid = (high - low) / 2 + low;

            // Check if the sum of 1 to mid is less than or equal to A
            if ((mid * (mid + 1)) / 2 <= (long) A) {
                // If true, update the answer and move the low pointer
                ans = mid;
                low = mid + 1;
            } else {
                // If false, move the high pointer
                high = mid - 1;
            }
        }
        // Return the maximum height of the staircase
        return (int) ans;
    }
}
