package Misc;

import java.util.Arrays;

/* Problem: https://www.scaler.com/academy/mentee-dashboard/class/47536/homework/problems/9155?navref=cl_tt_lst_sl */
public class FindSmallestBS {
    public static int solve(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        int low = A[0] + A[1] + A[2];
        int high = A[n - 1] + A[n - 2] + A[n - 3];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Doubt: why not <=
            if (checkPos(A, mid) <= B) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int checkPos(int[] A, int mid) {
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                // Doubt: why not sum <= mid
                if (sum < mid) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = { 18, 23, 11, 16, 5, 23, 7, 20, 20, 10 };
        int B = 105;

        System.out.println(solve(A, B));
    }
}
