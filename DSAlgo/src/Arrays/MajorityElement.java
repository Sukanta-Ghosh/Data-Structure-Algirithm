package Arrays;

/* 
Practise Link: 
https://www.scaler.com/academy/mentee-dashboard/class/40558/assignment/problems/2?navref=cl_tt_lst_nm
https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1 */
public class MajorityElement {

    /*
     * Question Statement: Find the majority element in the array.A majority element
     * in an array A of size N is an element that appears more than N/2 times in the
     * array.
     * 
     * Solution: If we cancel out each occurrence of an element X with all the other
     * elements that are different from X, then X will exist till the end if it is a
     * majority element.
     * Loop through each element and maintain a count of the element that has the
     * potential of being the majority element.
     * 
     * If the next element is the same, then increments the count, otherwise
     * decrements the count.
     * If the count reaches 0, then update the potential index to the current
     * element and reset the count to 1.
     */

    /*
     * Moore's Voting Algorithm
     * Time: O(n)
     * Space: O(1)
     */
    static int findMajority(int arr[], int n) {
        int majorElementIdx = 0, count = 1;

        // Find majority element candidate
        for (int i = 1; i < n; i++) {
            /*
             * Check if current element is matching with major element
             * then increase count else decrease
             */
            if (arr[majorElementIdx] == arr[i])
                count++;
            else
                count--;

            /*
             * if count is 0, then current major element is not major,
             * so assign current element as major and set count as 1
             */
            if (count == 0) {
                majorElementIdx = i;
                count = 1;
            }
        }

        // Check if the candidate is actually a majority
        count = 0;

        for (int i = 0; i < n; i++)
            if (arr[majorElementIdx] == arr[i])
                count++;

        if (count <= n / 2)
            return -1;

        return arr[majorElementIdx];
    }

    public static void main(String args[]) {
        int arr[] = { 8, 8, 6, 6, 6, 4, 6 }, n = 7;

        System.out.println(findMajority(arr, n)); // o/p: 6

    }
}
