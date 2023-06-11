package Arrays;

/* Scale Qs: https://www.scaler.com/academy/mentee-dashboard/class/40557/assignment/problems/4256?navref=cl_tt_lst_sl 
 * Similar Qs: Christmas Tree: https://www.scaler.com/academy/mentee-dashboard/class/40557/homework/problems/1083?navref=cl_tt_lst_sl
*/
public class LenOfLongestConsOnes {
    public int solve(String A) {
        char[] ch = A.toCharArray();
        int n = ch.length;
        int maxOne = 0;

        // Count no of zeros
        int oneCount = 0;
        for (char c : ch) {
            if (c == '1') {
                oneCount++;
            }
        }

        if (oneCount == n) {
            return n;
        }

        // Iterate through whole array
        for (int i = 0; i < n; i++) {
            /* Consider i as middle element and iterate left side */
            if (ch[i] == '0') {
                int left = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (ch[j] == '1') {
                        left++;
                    } else {
                        break;
                    }
                }

                /* Consider i as middle element and iterate right side */
                int right = 0;
                for (int j = i + 1; j < n; j++) {
                    if (ch[j] == '1') {
                        right++;
                    } else {
                        break;
                    }
                }

                /*
                 * If oneCount is greater than left + right one count then swap is possible
                 * , so add +1
                 */
                if (oneCount > (left + right)) {
                    maxOne = Math.max(maxOne, left + right + 1);
                }
                /* If oneCount is same as left + right one count then swap is not possible */
                else {
                    maxOne = Math.max(maxOne, left + right);
                }
            }
        }

        return maxOne;
    }
}
