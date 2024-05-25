package Hashing;

import java.util.HashSet;

/* Practise Link: 
 * https://www.scaler.com/academy/mentee-dashboard/class/47542/assignment/problems/152?navref=cl_tt_lst_nm
https://www.geeksforgeeks.org/longest-consecutive-subsequence/
 */
public class LongestConsecutiveSequence {
    /*
     * T.C: O(n)
     * S.C: O(n)
     */
    public int longestConsecutive(final int[] A) {
        // Define HashSet to keep track of elements
        HashSet<Integer> set = new HashSet<Integer>();
        int n = A.length;
        int maxCount = 0;

        // Iterate over each element in the array A and add in hashMap
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
        }

        // Iterate over whole array
        for (int i = 0; i < n; i++) {
            int count = 0; // Define count variable to keep track of present count
            // Define currentElement variable to count prev and next consecutive element
            int currentElement = A[i];

            /* if current element is the starting element of a sequence */
            if (!set.contains(currentElement - 1)) {
                // increase count as prev consecutive number is present
                count++;
                /* Iterate and check if next consecutive no is present in the sequence */
                while (set.contains(currentElement + 1)) {
                    count++;// increase present count
                    currentElement++;// increase currentElement to check next consecutive element
                }
                // Update max count
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
