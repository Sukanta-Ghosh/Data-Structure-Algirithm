package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/assignment/problems/169?navref=cl_tt_nv */
public class ContainerMostWater {
    /*
     * Initialize a variable "max_area" to 0.
     * Initialize two pointers "start" and "end" to the first and last indices of
     * the array respectively.
     * Loop while "start" is less than "end":
     * Calculate the area of the current window using the formula: (end - start) *
     * min(height[start], height[end]).
     * Update "maxarea" to the maximum value between "maxarea" and the calculated
     * area.
     * If the height at "start" is less than the height at "end", increment "start"
     * by 1.
     * Otherwise, decrement "end" by 1.
     * Return "max_area".
     * Note: The given code assumes that the input array "A" is passed as a
     * parameter to the function. The height array is initialized as a copy of "A"
     * (height = A) before performing the calculations.
     */
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public int maxArea(int[] A) {
        int n = A.length;
        /* Initialize s from start and e from end */
        int s = 0;
        int e = n - 1;
        int maxwater = 0;

        /* Iterate over array */
        while (s < e) {
            /* Calculate total contained water */
            int water = (e - s) * Math.min(A[s], A[e]);

            /*
             * If end point array element is less than
             * start point array element, decrease end pointer
             */
            if (A[e] < A[s]) {
                e--;
            }
            /*
             * If start point array element is less than
             * end point array element, increase start pointer
             */
            else if (A[e] > A[s]) {
                s++;
            } else {
                s++;
                e--;
            }

            /* Calculate maxwater can be contained */
            maxwater = Math.max(maxwater, water);
        }

        return maxwater;
    }
}
