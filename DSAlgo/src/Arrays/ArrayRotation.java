package Arrays;

import java.util.ArrayList;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/40548/assignment/problems/29098?navref=cl_tt_lst_nm */
public class ArrayRotation {
    /*
     * T.C: O(n)
     * S.C: O(1)
     */
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        // Calculate the effective number of rotations needed by taking B % N
        B = B % n;

        // Reverse the whole Array
        reverse(A, 0, n - 1);

        // Reverse first B elements
        reverse(A, 0, B - 1);

        // Reverse last n - B elements
        reverse(A, B, n - 1);

        return A;
    }

    public ArrayList<Integer> reverse(ArrayList<Integer> A, int p1, int p2) {
        while (p1 < p2) {
            int temp = A.get(p1);
            A.set(p1, A.get(p2));
            A.set(p2, temp);

            p1++;
            p2--;
        }

        return A;
    }
}
/*
 * To solve this problem, you can use the concept of reversing subarrays. Here's
 * a pseudo-code outline that you can follow:
 * 
 * 1. Define a function reverse(arr, start, end) that takes an array arr,a start
 * index start, and an end index end. This function reverses the elements of arr
 * in the subarray from index start to index end.
 * 
 * 2. In your main function:
 * - Calculate the effective number of rotations needed by taking B % N, where N
 * is the size of the array.
 * - Reverse the entire array.
 * - Reverse the subarray from index 0 to B - 1.
 * - Reverse the subarray from index B to N - 1.
 * 
 * 3. Return the modified array.
 */