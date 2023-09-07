package Misc;

import java.util.ArrayList;
import java.util.Collections;

/* Qs: https://www.scaler.com/test/668ffe7e04/#/problem_1 */
public class ThreeSumZero {
    /*
     * Binary Search
     * T.C: O(nlogn)
     * S.C: O(1)
     */
    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        if (A == null) {
            return res;
        }

        Collections.sort(A);
        int n = A.size();

        /* Iterate through low */
        for (int low = 0; low < n - 2; low++) {
            int mid = low + 1;
            int high = n - 1;
            int sum = -A.get(low);

            /* Check for duplicate values, if found increase low index */
            if (low > 0 && A.get(low).intValue() == A.get(low - 1).intValue()) {
                continue;
            }

            // Binary Search
            while (mid < high) {
                int num = A.get(mid) + A.get(high);

                if (num == sum) {
                    temp.add(A.get(low));
                    temp.add(A.get(mid));
                    temp.add(A.get(high));
                    res.add(new ArrayList<Integer>(temp));
                    temp.clear();

                    /* Checking if mid has duplicate values */
                    int prev = mid;
                    while (mid <= high && A.get(mid).intValue() == A.get(prev).intValue()) {
                        mid++;
                    }
                }
                /* If mid + high sum is less than low index(sum) then increase mid */
                else if (num < sum) {
                    mid++;
                }
                /* If mid + high sum is greater than low index(sum) then decrease high */
                else {
                    high--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(-1);
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(-1);
        A.add(4);

        ArrayList<ArrayList<Integer>> res = threeSum(A);

        for (ArrayList<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
