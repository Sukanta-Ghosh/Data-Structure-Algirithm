package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Comparator Logic::
    If (first argument should come second in sorted data)
        return 1;  // +1 means swap
    else
        return -1; // -1 means do not swap
*/
public class Compare {

    public static void main(String[] args) {
        // Testing
        Integer[] arr = new Integer[] { 39, 13, 15, 19, 12, 10 };
        String[] strArr = new String[] { "Ram", "Sam", "Dhan" };
        List<Integer> list = Arrays.asList(arr);

        // Using Annonymus Class: Both for Array and Collection
        Comparator<Integer> comp = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                // Descendeing Sorting
                if (o1 < o2) {
                    return 1;
                }

                return -1;
            }
        };
        Collections.sort(list, comp);

        // Using Lambda Expression
        Comparator<Integer> compl = (o1, o2) -> {
            // Descendeing Sorting
            if (o1 < o2) {
                return 1;
            }
            return -1;
        };
        Collections.sort(list, compl);

        // Descending Order: Using in Place Lambda Expression
        Collections.sort(list, (i1, i2) -> i2 - i1);

        for (Integer l : list) {
            System.out.print(l + " ");
        }

        // Array Custom Sorting
        Arrays.sort(arr, (a, b) -> a - b);

        // Using compareTo method: Ascending order
        Arrays.sort(strArr, (s1, s2) -> s1.compareTo(s2));

    }
}
