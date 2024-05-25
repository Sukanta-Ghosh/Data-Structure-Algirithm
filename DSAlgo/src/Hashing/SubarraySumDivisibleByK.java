package Hashing;

import java.util.HashMap;

/* Practise Link:
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 * https://www.geeksforgeeks.org/longest-subarray-sum-divisible-k/
 * https://www.youtube.com/watch?v=10wbS3uk2F8&t=488s&ab_channel=CrackingFAANG
 */
public class SubarraySumDivisibleByK {
    /*
     * T.C: O(n)
     * S.C: O(min(n, k))
     */
    public static int subarraysDivByK(int[] nums, int k) {
        // Create a HashMap to store the remainder count
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        // Initialize the count of 0 remainder to 1
        remainderCount.put(0, 1);

        // Initialize the sum to 0
        int sum = 0;
        // Initialize the result to 0
        int result = 0;

        // Iterate through the array
        for (int a : nums) {
            // Add the current element to the sum
            sum += a;

            int rem = sum % k;
            // If the rem is negative, add k to make it positive
            if (rem < 0)
                rem += k;
            /*
             * If the remainder count map contains the current remainder,
             * add the count to the result
             */
            if (remainderCount.containsKey(rem)) {
                result += remainderCount.get(rem);
            }

            // Add the current remainder to the remainder count map
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }
        // Return the result
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 4, 5, 0, -2, -3, 1 };
        int k = 5;

        System.out.println(subarraysDivByK(A, k));// 7
    }
}
