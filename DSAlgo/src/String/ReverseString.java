package string;

public class ReverseString {

    // Reverse the string
    public static String[] revString(String[] s, int l) {

        int j = 0;

        // Check if number of words is even or odd and Find the middle word
        if (l % 2 == 0) {
            j = l / 2;
        } else {
            j = (l / 2) + 1;
        }

        // Starting from the middle start swapping words at jth position
        // and l-1-j position
        while (j <= l - 1) {
            String temp;
            temp = s[l - j - 1];
            s[l - j - 1] = s[j];
            s[j] = temp;
            j += 1;
        }

        // Return the reversed sentence
        return s;
    }

    public static void main(String[] args) {
        String s = "getting good at coding " + "needs a lot of practice";
        String[] words = s.split("\\s");

        words = revString(words, words.length);

        s = String.join(" ", words);

        System.out.println(s);
    }
}
