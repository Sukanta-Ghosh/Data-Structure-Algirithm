package Hashing;

import java.util.ArrayList;
import java.util.TreeMap;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/47542/homework/problems/4808?navref=cl_tt_lst_sl */
public class SortByGivenOrder {
    /*
     * T.C: O()
     * S.C: O()
     */
    public int[] solve(int[] A, int[] B) {
        /**
         * Step 1: create a TreeMap & add elements of A(Main Array) as key and count as
         * Value
         * Step 2 : Create ArrayList ans
         * Step 3: Iterate the List B and if the element is present in A, get the count
         * of it and add that element as many as count
         * Step 4: once all the elements are added to ans, the remaining will be the
         * elements which are not present in B do same as step 3 ,
         * no need to check for the presence in B
         **/

        int na = A.length;
        int nb = B.length;
        // Create ArrayList ans
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Step 1: create a TreeMap to add elements of A(Main Array)
        // as key and count as Value
        TreeMap<Integer, Integer> mapA = new TreeMap<Integer, Integer>();
        for (int i = 0; i < na; i++) {
            mapA.put(A[i], mapA.getOrDefault(A[i], 0) + 1);
        }

        // Iterate the List B and if the element is present in A,
        // get the count of it and add that element as many as count
        for (int i = 0; i < nb; i++) {
            if (mapA.containsKey(B[i])) {
                int count = mapA.get(B[i]);
                while (count > 0) {
                    list.add(B[i]);
                    count--;
                }
                mapA.remove(B[i]);
            }
        }

        /*
         * once all the elements are added to ans, the remaining will be the elements
         * which are not present in B do same as step 3 ,
         * no need to check for the presence in B
         */
        mapA.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                list.add(k);
            }
        });

        /* Convert arraylist to array */
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
