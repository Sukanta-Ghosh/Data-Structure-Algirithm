package string;

/* Question link: 
https://www.geeksforgeeks.org/longest-common-prefix-using-character-by-character-matching/
https://www.geeksforgeeks.org/longest-common-prefix-using-word-by-word-matching/ */
public class LongestCommonPrefix {

    /*
     * TODO: Wrong Method, Review Later
     * Method 2: Character by Character Matching
     * T.C: O(n * m)
     * S.C: O(m)
     */
    // Function returns the longest common prefix from the array of strings
    static String commonPrefixBetter(String arr[], int n) {
        int minlen = 0;
        for (int i = 0; i < n; i++) {
            minlen = Math.min(minlen, arr[0].length());
        }

        String result = ""; // Our resultant string

        for (int i = 0; i < minlen; i++) {
            // Current character (must be same in all strings to be a part of result)
            char currentChar = arr[0].charAt(i);

            /*
             * Here, check if next array element same position character
             * is not matching with currentChar then return the result
             */
            for (int j = 1; j < n; j++) {
                if (arr[j].charAt(i) != currentChar) {
                    return result;
                }
            }

            // Append to result
            result += (currentChar);
        }

        return (result);
    }

    /*
     * Method 1: Word by Word Matching
     * T.C: O(n * m)
     * S.C: O(m)
     * Function that returns the longest common prefix from the array of strings
     */
    static String commonPrefix(String arr[], int n) {
        String prefix = arr[0];

        for (int i = 1; i <= n - 1; i++) {
            prefix = commonPrefixUtil(prefix, arr[i]);
        }

        return (prefix);
    }

    // Utility Function to find the common prefix between strings- str1 and str2
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
/*
 * Advantage over Word by Word Matching algo: If there is no common prefix
 * string, then By the“Word by Word Matching” algorithm , we come to the
 * conclusion that there is no common prefix string by traversing all the
 * strings. But if we use this algorithm, then in the first iteration itself we
 * will come to know that there is no common prefix string, as we don’t go
 * further to look for the second character of each strings. This algorithm has
 * a huge advantage when there are too many strings.
 */