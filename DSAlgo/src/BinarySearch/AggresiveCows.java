package BinarySearch;

import java.util.Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47538/assignment/problems/4129/?navref=cl_pb_nv_tb */
public class AggresiveCows {
    /*
     * T.C: O(nlogn)
     * S.C: O(1)
     */
    public int solve(int[] A, int B) {
        int n = A.length;
        /* Sort the array to find high index only by A[n - 1] - A[0] */
        Arrays.sort(A);

        int low = 0;
        int high = A[n - 1] - A[0];
        int ans = 0;
        /* Evaluate low index by diff */
        for (int i = 0; i < n - 1; i++) {
            low = Math.min(low, A[i + 1] - A[i]);
        }

        /* Do binary search */
        while (low <= high) {
            int mid = (low + high) / 2;

            /* If possible store ans and move right */
            if (possible(mid, A, n, B)) {
                ans = mid;
                low = mid + 1;
            }
            /* else move left */
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    /*
     * Method to find current mid distance value is possible
     * to place cows
     */
    public boolean possible(int mid, int[] A, int n, int totalCows) {
        int lastPlaced = A[0];
        int noOfCows = 1;
        for (int i = 1; i < n; i++) {
            if ((A[i] - lastPlaced) >= mid) {
                noOfCows++;
                lastPlaced = A[i];
                if (noOfCows == totalCows) {
                    return true;
                }
            }
        }

        return false;
    }
}
