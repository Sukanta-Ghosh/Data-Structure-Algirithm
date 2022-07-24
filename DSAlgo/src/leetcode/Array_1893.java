package leetcode;

/* 
Problem: https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/
*/
public class Array_1893 {

    /**
     * Doubt: Line Sweep Algorithm
     * https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/discuss/1267923/Line-Sweep-O(n-%2B-m)
     */
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] line = new int[52];
        for (int[] r : ranges) {
            line[r[0]] += 1;
            line[r[1] + 1] -= 1;
        }
        for (int i = 1, overlaps = 0; i <= right; ++i) {
            overlaps += line[i];
            if (i >= left && overlaps == 0)
                return false;
        }
        return true;
    }

    /**
     * Doubt: Range Updates
     * https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/discuss/1267402/Short-and-Easy-Solution-w-Explanation-or-C%2B%2B-Clean-Code
     */
    public static boolean isCoveredRangeUpdate(int[][] ranges, int left, int right) {
        int[] seen = new int[52];
        for (int[] r : ranges) {
            seen[r[0]]++;
            seen[r[1] + 1]--;
        }

        for (int i = 1; i < 52; i++)
            seen[i] += seen[i - 1];
        for (int i = left; i <= right; i++)
            if (seen[i] == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        int[][] ranges = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int left = 2;
        int right = 5;

        isCovered(ranges, left, right);
        isCoveredRangeUpdate(ranges, left, right);
    }
}
