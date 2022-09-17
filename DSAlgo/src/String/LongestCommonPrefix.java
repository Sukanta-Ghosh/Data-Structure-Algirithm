package string;

/* Question link: https://www.geeksforgeeks.org/longest-common-prefix-using-character-by-character-matching/
                https://www.geeksforgeeks.org/longest-common-prefix-using-word-by-word-matching/ */

public class LongestCommonPrefix {

    // Method 2: Character by Character Matching(Better Soln)
    // Time: O(n * m)
    // Space: O(m)
    /*
     * Advantage over Word by Word Matching algo: If there is no common prefix
     * string, then By the“Word by Word Matching” algorithm , we come to the
     * conclusion that there is no common prefix string by traversing all the
     * strings. But if we use this algorithm, then in the first iteration itself we
     * will come to know that there is no common prefix string, as we don’t go
     * further to look for the second character of each strings. This algorithm has
     * a huge advantage when there are too many strings.
     */
    // A Function that returns the longest common prefix from the array of strings
    static String commonPrefixBetter(String arr[], int n) {
        int minlen = findMinLength(arr, n);

        String result = ""; // Our resultant string
        char current; // The current character

        for (int i = 0; i < minlen; i++) {
            // Current character (must be same in all strings to be a part of result)
            current = arr[0].charAt(i);

            for (int j = 1; j < n; j++) {
                if (arr[j].charAt(i) != current) {
                    return result;
                }
            }

            // Append to result
            result += (current);
        }

        return (result);
    }

    // A Function to find the string having the minimum length and returns that
    // length
    static int findMinLength(String arr[], int n) {
        int min = arr[0].length();

        for (int i = 1; i < n; i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
            }
        }

        return (min);
    }

    /*
     * // Method 1: Word by Word Matching // Time: O(n * m) // Space: O(m) // A
     * Function that returns the longest common prefix from the array of strings
     */
    static String commonPrefix(String arr[], int n) {
        String prefix = arr[0];

        for (int i = 1; i <= n - 1; i++) {
            prefix = commonPrefixUtil(prefix, arr[i]);
        }

        return (prefix);
    }

    // A Utility Function to find the common prefix between strings- str1 and str2
    static String commonPrefixUtil(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();

        // Compare str1 and str2
        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }

        return (result);
    }

    // Driver program to test above function
    public static void main(String[] args) {
        String arr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
        int n = arr.length;

        String ans = commonPrefixBetter(arr, n);

        if (ans.length() > 0) {
            System.out.printf("The longest common prefix is - %s", ans);
        } else {
            System.out.printf("There is no common prefix");
        }

    }
}
