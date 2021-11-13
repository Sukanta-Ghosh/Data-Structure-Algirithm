package string;

public class PatternSearching {

    static final int d = 256;
    static final int q = 101;

    // Check if Strings are Rotations
    static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        return ((s1 + s1).indexOf(s2) >= 0);
    }

    // Action: Not Understand
    // Rabin Karp Algorithm
    static void RabinKarpAlgo(String pat, String txt, int M, int N) {

        // Compute (d^(M-1))%q
        int h = 1;
        for (int i = 1; i <= M - 1; i++)
            h = (h * d) % q;

        // Compute p and to
        int p = 0, t = 0;
        for (int i = 0; i < M; i++) {
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }

        for (int i = 0; i <= (N - M); i++) {
            // Check for hit
            if (p == t) {
                boolean flag = true;
                for (int j = 0; j < M; j++)
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        flag = false;
                        break;
                    }
                if (flag == true)
                    System.out.print(i + " ");
            }
            // Compute ti+1 using ti
            if (i < N - M) {
                t = ((d * (t - txt.charAt(i) * h)) + txt.charAt(i + M)) % q;
                if (t < 0)
                    t = t + q;
            }
        }

    }

    /*
     * Improved Naive Solution for only Distinct // Time: O(n)
     */
    public static void betterNaiveMethod(String str, String pat) {

        int n = str.length();
        int m = pat.length();
        for (int i = 0; i <= (n - m);) {

            int j;
            for (j = 0; j < m; j++) {
                if (pat.charAt(j) != str.charAt(i + j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("Index: " + i);
            }

            if (j == 0) {
                i++;
            } else {
                i = i + j;
            }

        }
    }

    /*
     * Naive Solution // Time: O((n - m + 1) * m)
     */
    public static void naiveMethod(String str, String pat) {

        int n = str.length();
        int m = pat.length();
        for (int i = 0; i <= (n - m); i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (pat.charAt(j) != str.charAt(i + j))
                    break;
            }

            if (j == m) {
                System.out.println("Index: " + i);
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "ABABABCD";
        String pattern1 = "ABAB";

        String str2 = "ABCABCD";
        String pattern2 = "ABCD";

        String str3 = "AAAAA";
        String pattern3 = "AAA";

        naiveMethod(str3, pattern3);
        betterNaiveMethod(str2, pattern2);
    }

}
