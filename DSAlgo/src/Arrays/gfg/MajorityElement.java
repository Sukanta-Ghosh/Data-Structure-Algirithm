package arrays.gfg;

/* Practise Link: https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1 */

public class MajorityElement {

    // Moore's Voting Algorithm
    // Time: O(n)
    // Space: O(1)
    static int findMajority(int arr[], int n) {
        int res = 0, count = 1;

        // Find a Candidate
        for (int i = 1; i < n; i++) {
            if (arr[res] == arr[i])
                count++;
            else
                count--;

            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        // Check if the candidate is actually a majority
        count = 0;

        for (int i = 0; i < n; i++)
            if (arr[res] == arr[i])
                count++;

        if (count <= n / 2)
            res = -1;

        return res;
    }

    public static void main(String args[]) {
        int arr[] = { 8, 8, 6, 6, 6, 4, 6 }, n = 7;

        System.out.println(findMajority(arr, n));

    }
}
