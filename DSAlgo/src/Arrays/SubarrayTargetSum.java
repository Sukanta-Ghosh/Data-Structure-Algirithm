package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47540/assignment/problems/4116/?navref=cl_pb_nv_tb */
public class SubarrayTargetSum {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        int fPointer = 0;
        int sPointer = 0;
        int subArraySum = A[0];

        while (sPointer < n) {
            if (subArraySum == B) {
                int[] arr = new int[sPointer - fPointer + 1];
                int index = 0;
                for (int i = fPointer; i <= sPointer; i++) {
                    arr[index++] = A[i];
                }
                return arr;
            } else if (subArraySum < B) {
                sPointer++;
                if (sPointer == n)
                    break;
                subArraySum += A[sPointer];
            } else if (subArraySum > B) {
                subArraySum -= A[fPointer];
                fPointer++;
            }
        }

        int[] res = new int[] { -1 };
        return res;
    }
}
