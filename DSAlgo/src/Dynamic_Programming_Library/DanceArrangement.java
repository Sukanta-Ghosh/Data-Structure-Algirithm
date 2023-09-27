package Dynamic_Programming_Library;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70871/homework/problems/1065?navref=cl_tt_nv */
public class DanceArrangement {
    /*
     * Variation of 0-1 knapsack
     * Iterative Solution
     * T.C - O(A)
     * S.C - O(A)
     */
    public int solve(int A) {
        /*
         * DP State:
         * dp[i] => no of ways i people can be choose
         * if they dance alone or in pair
         */
        int[] dpTable = new int[A + 1];
        /*
         * For 0 people, 1 ways only possible
         * For 1 people, 1 ways we can arrange
         */
        dpTable[0] = 1;
        dpTable[1] = 1;
        for (int i = 2; i <= A; i++) {
            /*
             * Here i is taken as i - 1
             * Here, dp[i - 1] represents the number of ways to party if the ith person
             * parties alone.
             * ((i - 1) % mod * dp[i - 2] % mod) represents the number of ways to party if
             * the ith person pairs up with any one of the i - 1 people.
             */
            dpTable[i] = (i - 1) * dpTable[i - 2] + dpTable[i - 1];
            dpTable[i] %= 10003;
        }

        return dpTable[A];

    }
    /*
     * Note:
     * First, we declare an array dp of size A + 1 to store the values of
     * subproblems.
     * 
     * We initialize the base conditions of the problem:
     * 
     * dp[0] = 0 (no one in Danceland, so no ways to party)
     * dp[1] = 1 (one person in Danceland, can only party alone)
     * dp[2] = 2 (two people in Danceland, they can either party alone or as a pair)
     * We start a loop from i = 3 to A (inclusive) to solve the subproblems.
     * 
     * Inside the loop, we use the recurrence relation to calculate the number of
     * ways to party for i people:
     * 
     * dp[i] = (dp[i - 1] + (i - 1) % mod * dp[i - 2] % mod) % mod
     * Here, dp[i - 1] represents the number of ways to party if the ith person
     * parties alone.
     * ((i - 1) % mod * dp[i - 2] % mod) represents the number of ways to party if
     * the ith person pairs up with any one of the i - 1 people.
     * Finally, we return dp[A], which represents the number of ways people in
     * Danceland can party.
     */

    /*
     * Variation of 0-1 knapsack
     * Iterative Solution || Space Optimized
     * T.C - O(A)
     * S.C - O(A)
     */
    public int spaceOptimized(int A) {
        /*
         * DP State:
         * dp[i] => no of ways i people can be choose
         * if they dance alone or in pair
         */

        /*
         * For 0 people, 1 ways only possible, so prevChoices = 1
         * For 1 people, 1 ways we can arrange, so recentChoices = 1
         */
        int prevChoices = 1;
        int recentChoices = 1;
        for (int i = 2; i <= A; i++) {
            int choices = (i - 1) * prevChoices;
            prevChoices = recentChoices;
            choices += recentChoices;
            recentChoices = choices;

            recentChoices %= 10003;
        }

        return recentChoices;

    }
}
