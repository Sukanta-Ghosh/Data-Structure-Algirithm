package Dynamic_Programming_Library;

import java.util.Arrays;
import java.util.Comparator;

/* Qs: https://www.scaler.com/academy/mentee-dashboard/class/70869/assignment/problems/35883/?navref=cl_pb_nv_tb */
public class FractionalKnapsack {
    class Items {
        int value, weight;
        Double costPerUnit;

        public Items(int value, int weight) {
            this.value = value;
            this.weight = weight;
            costPerUnit = (double) ((double) value / (double) weight);
        }
    }

    /*
     * T.C: O(nlogn)
     * S.C: O(n)
     */
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[] values = A;
        int[] weights = B;
        int capacity = C;

        /* Define array of class */
        Items[] items = new Items[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Items(values[i], weights[i]);
        }

        // Sort items array descending order
        Arrays.sort(items, new Comparator<Items>() {
            @Override
            public int compare(Items i1, Items i2) {
                return i2.costPerUnit.compareTo(i1.costPerUnit);
            }
        });

        double totalValue = 0;
        /* Iterate over Items array in descending order */
        for (Items it : items) {
            int presentValue = it.value;
            int presentWeight = it.weight;

            /* If present weight is selected */
            int leftCapacity = capacity - presentWeight;
            if (leftCapacity >= 0) {
                // Decrease capacity
                capacity -= presentWeight;

                // Add to total value
                totalValue += (presentValue * 100);
            } else { // select fractional weight
                /*
                 * Based on left capacity evaluate total cost with
                 * costPerUnit
                 */
                totalValue += (capacity * it.costPerUnit * 100);
                break;
            }
        }

        return (int) totalValue;
    }
}
