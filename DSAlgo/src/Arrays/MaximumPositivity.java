package Arrays;

/* Sacle Qs: https://www.scaler.com/academy/mentee-dashboard/class/40557/homework/problems/8515?navref=cl_tt_lst_sl */
public class MaximumPositivity {
    // T.C - O(n)
    // S.c - O(n)
    public int[] solve(int[] A) {
        int n = A.length;

        int max = 0;
        int count = 0;
        int s = 0; // Start index
        int e = 0; // End Index

        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                count++;
            } else {
                count = 0;
            }

            if (count > max) {
                max = count;
                s = i - count + 1;
                e = i;
            }
        }

        int[] arr = new int[max];
        int j = 0;
        for (int i = s; i <= e; i++) {
            arr[j++] = A[i];
        }

        return arr;
    }
}
