package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/assignment/problems/4116/?navref=cl_pb_nv_tb */
public class SubarrayTargetSum {
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public int[] solve(int[] A, int B) {
        int n = A.length;
        /* Initialize both pointer from 0 */
        int fPointer = 0;
        int sPointer = 0;
        int subArraySum = A[0];

        /* Iterate till second pointer reaches arr end */
        while (sPointer < n) {
            /*
             * if subArraySum is equals to target B,
             * then add all array items from fPointer to
             * sPointer to new arr
             */
            if (subArraySum == B) {
                int[] arr = new int[sPointer - fPointer + 1];
                int index = 0;
                for (int i = fPointer; i <= sPointer; i++) {
                    arr[index++] = A[i];
                }
                return arr;
            }
            /*
             * if subArraySum is less than B, increase second pointer,
             * if it reaches end n then break
             */
            else if (subArraySum < B) {
                sPointer++;
                if (sPointer == n)
                    break;
                subArraySum += A[sPointer];
            }
            /*
             * if subArraySum is greater then target B, then
             * increase first pointer
             */
            else if (subArraySum > B) {
                subArraySum -= A[fPointer];
                fPointer++;
            }
        }

        int[] res = new int[] { -1 };
        return res;
    }
}
