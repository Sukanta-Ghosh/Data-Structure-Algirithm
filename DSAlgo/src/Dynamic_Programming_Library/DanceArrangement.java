package Dynamic_Programming_Library;

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
            dpTable[i] = (i - 1) * dpTable[i - 2] + dpTable[i - 1];
            dpTable[i] %= 10003;
        }

        return dpTable[A];

    }

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
         * For 0 people, 1 ways only possible so reaminChoices
         * For 1 people, 1 ways we can arrange, so prevChoices 1
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
