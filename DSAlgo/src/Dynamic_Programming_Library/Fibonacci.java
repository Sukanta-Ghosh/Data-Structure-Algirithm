package Dynamic_Programming_Library;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70865/assignment/problems/4035?navref=cl_tt_nv */
public class Fibonacci {

    /*
     * Recursive:Memorization:Top-down
     * T.C: O(n)
     * S.C: O(n)
     */
    public static int fibRecursive(int n, int[] dpTable) {
        if (n == 0 || n == 1) {
            return n;
        }

        // If dptable dosn't contain value calculate result
        if (dpTable[n] == 0) {
            dpTable[n] = fibRecursive(n - 1, dpTable) + fibRecursive(n - 2, dpTable);
        }

        // If dptable contains value return result directly
        return dpTable[n];
    }

    public static void main(String[] args) {
        int n = 6;

        int[] dpTable = new int[n + 1];

        System.out.println(fibRecursive(n, dpTable));
    }
}
