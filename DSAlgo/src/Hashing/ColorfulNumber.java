package Hashing;

import java.util.ArrayList;
import java.util.HashSet;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47542/homework/problems/275?navref=cl_tt_nv */
public class ColorfulNumber {
    /*
     * T.C: O(n ^ 2) //n = No of digits in A
     * S.C: O(n)
     */
    public int colorful(int A) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        /*
         * Iterate over number to store
         * single digits of number in list
         */
        while (A > 0) {
            int digit = A % 10;
            list.add(digit);
            A = A / 10;
        }

        // Define set to store products
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < list.size(); i++) {
            int product = 1;
            /* Iterate through list element to get consecutive digit product */
            for (int j = i; j < list.size(); j++) {
                product *= list.get(j);
                // if set contains products,
                // then number is not colorful
                if (set.contains(product)) {
                    return 0;
                }
                // else add no in set
                else {
                    set.add(product);
                }
            }
        }

        return 1;
    }
}
