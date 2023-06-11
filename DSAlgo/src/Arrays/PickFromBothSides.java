package Arrays;

/* Topic: Prefix Sum 
 * Qs: https://www.scaler.com/academy/mentee-dashboard/class/40552/homework/problems/9900/?navref=cl_pb_nv_tb
*/
public class PickFromBothSides {
    /*
     * T.C - O(n)
     * S.C - O(n)
     */
    public int solve(int[] A, int b) {
        int n = A.length;
        int[] pfSum = new int[n];

        // Calculate Prefix Array
        pfSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            pfSum[i] = pfSum[i - 1] + A[i];
        }
        int totalArraySum = pfSum[n - 1];

        // If b == n then all element need to be included
        if (n == b) {
            return totalArraySum;
        }

        int windowSize = n - b; // this window size is for elements that need to be unpicked
        int maxSum = Integer.MIN_VALUE;
        int ws = 0; // window start
        int we = windowSize - 1; // window end

        while (we < n) {
            int unpickedElementsSum = 0;
            if (ws == 0) {
                unpickedElementsSum = pfSum[we];
            } else {
                unpickedElementsSum = pfSum[we] - pfSum[ws - 1];
            }

            int currSum = totalArraySum - unpickedElementsSum;
            maxSum = Math.max(maxSum, currSum);
            ws++;
            we++;
        }

        return maxSum;

    }
}
