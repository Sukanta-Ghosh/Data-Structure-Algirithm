package string;

/* Practise Link: https://practice.geeksforgeeks.org/problems/rank-the-permutations2323/1 
*/

public class LexicographicRank_String {
    static final int CHAR = 256;

    static int fact(int n) {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }

    // For all distinct character
    // Time: O(n)
    static int lexRank(String str) {
        int res = 1;
        int n = str.length();
        int mul = fact(n);
        int[] count = new int[CHAR];

        // Counting the frequency of each char
        for (int i = 0; i < n; i++)
            count[str.charAt(i)]++;

        // Computing cumilative count,
        // Index i means sum of all the counts from 0 to i-1,
        // the purpose is to get counts of smaller character on right side of a
        // character in O(1)
        for (int i = 1; i < CHAR; i++)
            count[i] += count[i - 1];

        // Computing the result
        for (int i = 0; i < n - 1; i++) {
            mul = mul / (n - i);
            res = res + count[str.charAt(i) - 1] * mul;
            /*
             * Trick: Array is traversed from left to right and when a char is precessed
             * then we removed it from count array, so when we have come to a char, we
             * already remove the left char, so whatever we have is count of smaller char in
             * the right side only
             */
            // Update the count array, str.charAt(i) use as index, go to the right side of
            // it and reduce every value by 1
            for (int j = str.charAt(i); j < CHAR; j++)
                count[j]--;
        }
        return res;
    }

    public static void main(String args[]) {
        String str = "STRING";
        System.out.print(lexRank(str));
    }
}
