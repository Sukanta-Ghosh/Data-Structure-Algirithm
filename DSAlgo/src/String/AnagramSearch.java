package string;

/* Practise Link 
https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1 */

public class AnagramSearch {
    static final int CHAR = 256;

    /*
     * Qs: Given a word pat and a text txt. Return the count of the occurences of
     * anagrams of the word in the text.
     */

    public static void main(String args[]) {
        String txt = "geeksforgeeks";
        String pat = "frog";

        isPresent(txt, pat);
    }

    /*
     * Efficient Solution // Time Complexity: O(n) //CHAR constant Space: O(CHAR)
     */
    static void isPresent(String text, String pattern) {

        // CP[]: Store count of all characters of pattern
        // CT[]: Store count of current window of text
        int[] CT = new int[CHAR];
        int[] CP = new int[CHAR];
        for (int i = 0; i < pattern.length(); i++) {
            CT[text.charAt(i)]++;
            CP[pattern.charAt(i)]++;
        }

        // Traverse through remaining characters of text
        for (int i = pattern.length(); i < text.length(); i++) {

            // Compare counts of current window of text with counts of pattern[]
            if (areSame(CT, CP)) {
                System.out.println("Anagram search found");
                return;
            }

            // Add current character to current window
            CT[text.charAt(i)]++;

            // Remove the first character of previous window
            CT[text.charAt(i - pattern.length())]--;
        }

        System.out.println("Anagram search not found");
    }

    // This function returns true if contents of arr1[] and arr2[] are same,
    // otherwise false.
    static boolean areSame(int CT[], int CP[]) {
        for (int i = 0; i < CHAR; i++) {
            if (CT[i] != CP[i])
                return false;
        }
        return true;
    }

}
