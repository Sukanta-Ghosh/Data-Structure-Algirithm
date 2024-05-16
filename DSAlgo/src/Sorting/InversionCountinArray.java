package Sorting;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47528/assignment/problems/4190?navref=cl_tt_lst_sl */
public class InversionCountinArray {
    int mod = 1000000007;

    /*
     * T.C: O(nlogn)
     * S.C: (n)
     */
    public int solve(int[] A) {
        int n = A.length;
        return invert(A, 0, n - 1);
    }

    /* s = start, e = end */
    public int invert(int[] A, int s, int e) {
        if (s >= e) {
            return 0;
        }

        int mid = (s + e) / 2;
        int left = invert(A, s, mid);
        int right = invert(A, mid + 1, e);
        int count = merge(A, s, mid, e);

        /*
         * Total inversion pairs: Count Pair(left) + Count Pair(right) + Count Pairs
         * within left & right
         */
        return ((left + right) % mod + count) % mod;
    }

    /* Apply Merge sort */
    public int merge(int[] A, int s, int m, int e) {
        int p1 = s;
        int p2 = m + 1;
        int p3 = 0;
        int[] tempArr = new int[e - s + 1];
        int count = 0;

        while (p1 <= m && p2 <= e) {
            if (A[p1] <= A[p2]) {
                tempArr[p3++] = A[p1++];
            } else {
                tempArr[p3++] = A[p2++];
                count = (count + (m - p1 + 1)) % mod;
            }
        }

        while (p1 <= m) {
            tempArr[p3++] = A[p1++];
        }

        while (p2 <= e) {
            tempArr[p3++] = A[p2++];
        }

        /* Change/Sort the original array */
        for (int i = 0; i <= (e - s); i++) {
            /*
             * Start index will change in every recursion
             * call
             */
            A[s + i] = tempArr[i];
        }

        return count;
    }
}
