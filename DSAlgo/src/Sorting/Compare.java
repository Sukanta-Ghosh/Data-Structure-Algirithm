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
        // Using Annonymus Class
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

        // Using Lambda Expression
        Comparator<Integer> compl = (o1, o2) -> {
            // Descendeing Sorting
            if (o1 < o2) {
                return 1;
            }
            return -1;
        };

        // Testing
        Integer[] arr = new Integer[] { 39, 13, 15, 19, 12, 10 };
        List<Integer> list = Arrays.asList(arr);
        Collections.sort(list, compl);

        for (Integer l : list) {
            System.out.print(l + " ");
        }

        Collections.sort(list, comp);

    }
}
