import java.util.*;

class Demo {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int longestStreak = 0;
        int currentStreak = 0;
        for (int i = 0; i < s.length(); i++) {

            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                currentStreak++;
            } else {
                set.clear();
                set.add(s.charAt(i));
                currentStreak = 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}