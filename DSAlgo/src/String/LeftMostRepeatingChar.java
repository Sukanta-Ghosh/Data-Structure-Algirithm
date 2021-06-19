package String;

import java.util.Arrays;

public class LeftMostRepeatingChar {

    static final int CHAR = 256;

    /*
     * Efficient Solution 2 
     * Time: O(n) 
     * Space: O(1)
     */
    public static int leftMost(String str) {
        boolean[] visited = new boolean[CHAR];
        int res = -1;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (visited[str.charAt(i)]) {
                res = i;
            } else {
                visited[str.charAt(i)] = true;
            }
        }

        return res;
    }

    /*
     * Efficient Solution 1 Time: O(n) Space: O(1)
     */
    public static int leftmost(String str) {
        int[] fIndex = new int[CHAR];
        Arrays.fill(fIndex, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int fi = fIndex[str.charAt(i)];
            if (fi == -1) {
                fIndex[str.charAt(i)] = i;
            } else {
                res = Math.min(res, fi);
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static void main(String[] args) {
        String str = "abccbd";
        System.out.println("Char is: " + str.charAt(leftmost(str)));
        System.out.println("Char is: " + str.charAt(leftMost(str)));

    }
}
