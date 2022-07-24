package Arrays.easy;

/* 
Practise Link: https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1 */

public class MajorityElement {

    /*
     * Question Statement: Find the majority element in the array.A majority element
     * in an array A of size N is an element that appears more than N/2 times in the
     * array.
     */
    public static void main(String args[]) {
        int arr[] = { 8, 8, 6, 6, 6, 4, 6 }, n = 7;

        System.out.println(findMajority(arr, n)); // o/p: 6

    }

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
            return -1;

        return arr[res];
    }

}
