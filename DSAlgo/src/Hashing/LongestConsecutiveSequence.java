package Hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
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
            int no = A[i]; // Define no variable to count prev and next consecutive ele
            /* If no var prev number is present in set */
            if (!set.contains(no - 1)) {
                // increase count as prev consecutive no is present
                count++;
                /* Iterate and check if next consecutive no is present */
                while (set.contains(no + 1)) {
                    count++;// increase present count
                    no++;// increase no var to check next consecutive element
                }
                // Update max count
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
