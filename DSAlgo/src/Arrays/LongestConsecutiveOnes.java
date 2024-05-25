package Arrays;

/* Scale Qs: https://www.scaler.com/academy/mentee-dashboard/class/40557/assignment/problems/4256?navref=cl_tt_lst_sl 
 * Similar Qs: Christmas Tree: https://www.scaler.com/academy/mentee-dashboard/class/40557/homework/problems/1083?navref=cl_tt_lst_sl
*/
public class LongestConsecutiveOnes {
    /*
     * T.C: O(n^2)
     * S.C: O(1)
     */
    public int solve(String A) {
        char[] ch = A.toCharArray();
        int n = ch.length;
        int maxOne = 0;

        // Count total no of ones
        int totalOneCount = 0;
        for (char c : ch) {
            if (c == '1') {
                totalOneCount++;
            }
        }

        // Edge Case: If all elements are 1 then return arr length
        if (totalOneCount == n) {
            return n;
        }

        // Iterate through whole array
        for (int i = 0; i < n; i++) {
            /*
             * Consider i as middle element and iterate to left side
             * if present element is 0 then check
             */
            if (ch[i] == '0') {
                int leftOneCount = 0;
                for (int j = i - 1; j >= 0; j--) {
                    /*
                     * If left element is 1 then increase leftOneCount,
                     * if 0 encounter then break loop as onw swap is possible
                     */
                    if (ch[j] == '1') {
                        leftOneCount++;
                    } else {
                        break;
                    }
                }

                /* Consider i as middle element and iterate to right side */
                int rightOneCount = 0;
                for (int j = i + 1; j < n; j++) {
                    /*
                     * If right element is 1 then increase rightOneCount,
                     * if 0 encounter then break loop as onw swap is possible
                     */
                    if (ch[j] == '1') {
                        rightOneCount++;
                    } else {
                        break;
                    }
                }

                /*
                 * If totalOneCount is greater than left + right one count then swap is possible
                 * , so add +1
                 */
                if (totalOneCount > (leftOneCount + rightOneCount)) {
                    maxOne = Math.max(maxOne, leftOneCount + rightOneCount + 1);
                }
                /*
                 * If totalOneCount is same or less than (left + right) one count then swap is
                 * not possible
                 */
                else {
                    maxOne = Math.max(maxOne, leftOneCount + rightOneCount);
                }
            }
        }

        return maxOne;
    }
}
