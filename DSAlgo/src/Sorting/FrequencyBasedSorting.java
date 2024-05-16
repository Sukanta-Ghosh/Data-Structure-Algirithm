package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* Qs: https://www.scaler.com/test/e64a6793dc/#/java */
public class FrequencyBasedSorting {
    class Items {
        char ch;
        int freq;

        public Items(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    /*
     * Own implemented method
     * T.C: O(nlogn)
     * S.C: O(n)
     */
    public String solve(String A) {
        int n = A.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        ArrayList<Items> list = new ArrayList<Items>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(new Items(entry.getKey(), entry.getValue()));
        }

        Comparator<Items> sortingLogic = new Comparator<Items>() {

            @Override
            public int compare(Items obj1, Items obj2) {

                // Descendeing Sorting
                if (obj1.freq < obj2.freq) {
                    return 1;
                } else if (obj1.freq == obj2.freq) {
                    return (int) obj1.ch - (int) obj2.ch;
                }

                return -1;
            }
        };

        Collections.sort(list, sortingLogic);

        for (int i = 0; i < list.size(); i++) {
            int frequency = list.get(i).freq;
            while (frequency > 0) {
                sb.append(list.get(i).ch);
                frequency--;
            }
        }

        return sb.toString();

    }

}
