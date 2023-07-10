package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/assignment/problems/169/?navref=cl_pb_nv_tb */
public class WallContainWater {
    /*
     * T.C: O(n)
     */
    public int maxArea(int[] A) {
        int n = A.length;

        // Initialize two pointers "start" and "end" to the first and last indices of
        // the array respectively.
        int s = 0;
        int e = n - 1;
        // Initialize a variable "max_area" to 0.
        int maxwater = 0;

        // Loop while "start" is less than "end":
        while (s < e) {
            /*
             * Calculate the area of the current window using the formula: (end - start) *
             * min(height[start], height[end]).
             */
            int water = (e - s) * Math.min(A[s], A[e]);
            /*
             * If the height at "end" is less than the height at "start", decrement "end"
             * by 1.
             */
            if (A[e] < A[s]) {
                e--;
            }
            /*
             * If the height at "start" is less than the height at "end", increment "start"
             * by 1.
             */
            else if (A[e] > A[s]) {
                s++;
            } else {
                s++;
                e--;
            }
            /*
             * Update "maxarea" to the maximum value between "maxarea" and the calculated
             * area.
             */
            maxwater = Math.max(maxwater, water);
        }

        return maxwater;
    }
}
