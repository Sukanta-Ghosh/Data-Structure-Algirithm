package Arrays;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47508/homework/problems/329?navref=cl_tt_lst_sl */
public class Flip {
    /* Applying Kadane's Algorithm Concept */
    public int[] flip(String A) {
        int n = A.length();
        int[] lrArr = new int[2];

        /* Here we are checking max 0 can be flipped(if any) */
        int flipOne = 0, flipMaxOne = 0, l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            // If bit is 1, fliping will result negative
            if (A.charAt(i) == '1') {
                flipOne--;
            } else if (A.charAt(i) == '0') {
                flipOne++;
            }

            // if flipOne is bigger than flipMaxOne intialize start and end index
            if (flipOne > flipMaxOne) {
                flipMaxOne = flipOne;
                lrArr[0] = l + 1;
                lrArr[1] = r + 1;
            }

            // if flipOne negative, initialize next bit as potential
            // start flip bit
            if (flipOne < 0) {
                flipOne = 0;
                l = i + 1;
                r = i + 1;
            } else {
                r++; // if flipOne 0 or +ve increase end bit
            }
        }

        // if no flipMaxOne, then no fliping occur
        if (flipMaxOne == 0) {
            return new int[0];
        }

        return lrArr;
    }
}
