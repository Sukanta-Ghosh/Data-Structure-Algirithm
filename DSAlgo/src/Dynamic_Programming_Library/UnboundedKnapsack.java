package Dynamic_Programming_Library;

/* https://www.scaler.com/academy/mentee-dashboard/class/70869/assignment/problems/9340?navref=cl_tt_lst_sl */
public class UnboundedKnapsack {
    /*
     * Iterative Approach
     * T.C: O(n * k)
     * S.C: O(capacity)
     */
    public static int solve(int A, int[] B, int[] C) {
        int cap = A;
        int[] values = B;
        int[] weights = C;
        int n = values.length;

        /*
         * DP State:
         * dp[i] => Max value in a bag full of capacity i
         */
        int[] dpTable = new int[cap + 1];
        // dpTable[0], 0 capacity will bring 0 value

        // i loop for iterating through dpTable
        for (int i = 0; i <= cap; i++) {
            int max = 0;
            // j loop for iterating through all the elements
            for (int j = 0; j < n; j++) {
                // if jth element taken capacity left
                int leftCapacity = i - weights[j];
                if (leftCapacity >= 0) {
                    // if jth element selected
                    max = Math.max(max, values[j] + dpTable[leftCapacity]);
                }
            }
            dpTable[i] = max;
        }

        return dpTable[cap];
    }

    public static void main(String[] args) {
        int A = 10;
        int[] B = { 5 };
        int[] C = { 10 };

        System.out.println(solve(A, B, C));
    }
}
