package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

/* Qs: https://leetcode.com/problems/3sum/description/
 */
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

        // Sort the arraylist
        Collections.sort(A);
        int n = A.size();

        /* Iterate from 0 to n - 2 */
        for (int low = 0; low < n - 2; low++) {
            int mid = low + 1;
            int high = n - 1;
            int thirdNum = -A.get(low);

            /* Check for duplicate values, if found increase low index */
            if (low > 0 && A.get(low).intValue() == A.get(low - 1).intValue()) {
                continue;
            }

            // Binary Search
            while (mid < high) {
                int twoNumSum = A.get(mid) + A.get(high);

                if (twoNumSum == thirdNum) {
                    /* Add elements to temp list array */
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
                /* If mid + high sum is less than low index(thirdNum) then increase mid */
                else if (twoNumSum < thirdNum) {
                    mid++;
                }
                /* If mid + high sum is greater than low index(thirdNum) then decrease high */
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
