package Arrays;

/* Sacle Qs: https://www.scaler.com/academy/mentee-dashboard/class/40558/homework/problems/67?navref=cl_tt_lst_sl */
public class N3RepeatNo {
    /*
     * At max 2 majority elements can be present
     */
    public int repeatedNumber(int[] A) {
        int n = A.length;

        // Element 1 and its frequency
        int ele1 = 0;
        int freq1 = 0;

        // Element 2 and its frequency
        int ele2 = 0;
        int freq2 = 0;

        // Iterate through array
        for (int i = 0; i < n; i++) {
            // Count element 1 freq if element 1 matches with current ele
            if (ele1 == A[i]) {
                freq1++;
            }
            // Count element 1 freq if element 2 matches with current ele
            else if (ele2 == A[i]) {
                freq2++;
            }
            /*
             * If element 1 freq is 0 then assign current element and set
             * current element freq as 1
             */
            else if (freq1 == 0) {
                ele1 = A[i];
                freq1 = 1;
            }
            /*
             * If element 2 freq is 0 then assign current element and set
             * current element freq as 1
             */
            else if (freq2 == 0) {
                ele2 = A[i];
                freq2 = 1;
            }
            /*
             * If current element dont match with both element and
             * any one element frequency is not zero then decrease both element frequency
             */
            else {
                freq1--;
                freq2--;
            }
        }

        /* Reset both frequency to get majority element actual frequncy */
        int ans = -1;
        freq1 = 0;
        freq2 = 0;

        // Calculate both majority element frequncy
        for (int i = 0; i < n; i++) {
            if (ele1 == A[i]) {
                freq1++;
            }

            if (ele2 == A[i]) {
                freq2++;
            }
        }

        /* Check if any one element is majority element */
        if (freq1 > (n / 3)) {
            ans = ele1;
        } else if (freq2 > (n / 3)) {
            ans = ele2;
        } else {
            ans = -1;
        }

        return ans;
    }
}
