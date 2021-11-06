package string;

/* Practise Link
https://practice.geeksforgeeks.org/problems/anagram-1587115620/1 */

public class Anagram {

    /*
     * Efficient Soln Time: O(n) Space: O(CHAR)
     */
    static final int CHAR = 256;

    static boolean areAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[CHAR];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int i = 0; i < CHAR; i++) {
            if (count[i] != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abaac";
        String str2 = "aacba";
        if (areAnagram(str1, str2))
            System.out.println("The two strings are" + " anagram of each other");
        else
            System.out.println("The two strings are not" + " anagram of each other");
    }

}
