package Dynamic_Programming_Library;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70873/assignment/problems/21?navref=cl_tt_nv */
public class EditDistance {
    /*
     * Recursive Solution
     * T.C: O(n * m)
     * S.C: O(n * m)
     */
    int[][] dpTable;

    public int minDistance(String A, String B) {
        int n1 = A.length();
        int n2 = B.length();
        /*
         * DP State:
         * dpTable[i][j]: Min operation required to convert len i of string s1
         * to len j of string s2
         */
        dpTable = new int[n1 + 1][n2 + 1];

        return minOperation(A, B, n1, n2);
    }

    /*
     * l1 length of string 1
     * l2 length of string 2
     */
    public int minOperation(String s1, String s2, int l1, int l2) {
        // Base Condition
        /* if string 1 len is 0, then have to insert remaining string 2 len(l2) */
        if (l1 == 0) {
            return l2;
        }
        /* if string 2 len is 0, then have to delete remaining string 1 len(l1) */
        if (l2 == 0) {
            return l1;
        }

        /* If dpTable value is not default 0, then reuse */
        if (dpTable[l1][l2] != 0) {
            return dpTable[l1][l2];
        }

        /* If strings are matching, check for remaining string */
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            return dpTable[l1][l2] = minOperation(s1, s2, l1 - 1, l2 - 1);
        } else {
            /*
             * Operations on String s1, len l1
             * Insert: minOperation(l1, l2 - 1) => String s2 len will be decreased by 1 as
             * added char is equal to l2 char of string s2.
             * Replace: minOperation(l1 - 1, l2 - 1) => Both strings len will be decreased
             * Delete: minOperation(l1 - 1, l2) => String s1 char is deleted, so l1 len will
             * be decreased by 1
             */
            int ifInsert = minOperation(s1, s2, l1, l2 - 1);
            int ifReplaced = minOperation(s1, s2, l1 - 1, l2 - 1);
            int ifDelete = minOperation(s1, s2, l1 - 1, l2);

            /* Find min operation we can find from above 3 actions */
            return dpTable[l1][l2] = 1 + Math.min(ifInsert, Math.min(ifReplaced, ifDelete));
        }
    }
}
