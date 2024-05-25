package Arrays;

/* Topic: Arrays: Carry Forward */
public class ClosestMinMax {
    /*
     * Recomemded Solution
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public int solve(int[] A) {

        int min_ele = Integer.MAX_VALUE;
        int max_ele = Integer.MIN_VALUE; // min and max value of the array
        int min_Index = -1;
        int max_Index = -1; // index of the last element having value equal to min_ele and max_ele

        int ans = Integer.MAX_VALUE;

        // Find Min and Max ele
        for (int x : A) {
            min_ele = Math.min(min_ele, x);
            max_ele = Math.max(max_ele, x);
        }

        /*
         * We can implement a sliding window kind of algorithm using two pointers. We
         * can slide over the array and keep track of every last occurrence of the
         * minimum and maximum element of the array.
         * In order to find the start point, we can simply remember the last occurrences
         * of a minimum and a maximum value, respectively. And for each min-max pair, we
         * check the length of the subarray that encloses them and then update out
         * overall based on that.
         */
        for (int i = 0; i < A.length; i++) {
            if (A[i] == min_ele) {
                min_Index = i;
            }
            if (A[i] == max_ele) {
                max_Index = i;
            }

            if (min_Index != -1 && max_Index != -1) {
                int len = Math.abs(max_Index - min_Index) + 1;
                ans = Math.min(ans, len);
            }
        }

        return ans;
    }
}
