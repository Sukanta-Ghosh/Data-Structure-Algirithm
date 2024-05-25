package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/40553/assignment/problems/14363/?navref=cl_pb_nv_tb */
public class SumofAllSubarray {
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public long subarraySum(int[] A) {
        int n = A.length;

        long sum = 0;

        for (int i = 0; i < n; i++) {
            // frequency of i th element in all subarraySum
            long freq = (long) (i + 1) * (n - i);
            // totalSum is freq of i th element * element value
            sum += (long) (A[i] * freq);
        }

        return sum;
    }
}
