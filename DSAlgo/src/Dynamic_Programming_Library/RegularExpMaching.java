package Dynamic_Programming_Library;

import java.util.Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70873/assignment/problems/16/?navref=cl_pb_nv_tb */
public class RegularExpMaching {
    /*
     * Recursive Solution
     * T.C: O(n * m)
     * S.C: O(n * m)
     */
    int[][] dpArr; // define a 2D integer array to store the results of subproblems

    public int isMatch(final String A, final String B) {
        int l1 = A.length();
        int l2 = B.length();

        // In order to avoid heap memory exception/error create a StringBuilder to
        // remove consecutive asterisks(*) from B
        StringBuilder strB = new StringBuilder();
        strB.append(B.charAt(0)); // append the first character of B
        for (int i = 1; i < B.length(); i++) {
            if (B.charAt(i) != '*') { // if the current character is not an asterisk, append it
                strB.append(B.charAt(i));
            } else if (B.charAt(i) == '*' && B.charAt(i - 1) != '*') {
                // if the current character is an asterisk and the previous character is not an
                // asterisk, append it to the StringBuilder
                strB.append('*');
            }
        }

        /*
         * DP State:
         * dpArr[i][j] => For i length string A, j length B string is matching or not
         */
        // initialize 2D integer array with -1 to detect previously computed or not
        dpArr = new int[A.length() + 1][strB.toString().length() + 1];
        for (int[] x : dpArr) {
            Arrays.fill(x, -1);
        }

        l2 = strB.toString().length();
        return isMatchStr(A, strB.toString(), l1, l2);
    }

    /* Recursive function */
    public int isMatchStr(String s, String p, int ns, int np) {
        // Base Case
        /* If both string is empty, then match */
        if (ns == 0 && np == 0) {
            return 1;
        }
        /* If pattern empty, zero string length left, then return false(0) */
        if (np == 0) {
            return 0;
        }
        /* If matching string empty, then we will check in pattern (*) present or not */
        if (ns == 0) {
            for (int i = 0; i < np; i++) {
                if (p.charAt(i) != '*') {
                    return 0;
                }
            }
            return 1;
        }

        // if the result of the current subproblem has already been computed, return it
        if (dpArr[ns][np] != -1) {
            return dpArr[ns][np];
        }

        /* Check if last char is matching or ? */
        if (s.charAt(ns - 1) == p.charAt(np - 1) || p.charAt(np - 1) == '?') {
            dpArr[ns][np] = isMatchStr(s, p, ns - 1, np - 1);
        }
        /*
         * If pattern last char is * then check with all possibility
         * rec(ns, np - 1) => When from string A nothing is included for pattern *
         * rec(ns - 1, np) => When from string A last char is included for pattern *
         */
        else if (p.charAt(np - 1) == '*') {
            dpArr[ns][np] = isMatchStr(s, p, ns, np - 1) | isMatchStr(s, p, ns - 1, np);
        }
        /* Case: for string abc pattern pq */
        else {
            dpArr[ns][np] = 0;
        }

        return dpArr[ns][np];
    }
}
