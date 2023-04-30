package Greedy_Algorithm;

import java.util.Arrays;
import java.util.Comparator;

class FractionalKnapsack {
    static class Items {
        int val, wt;
        Double cost;

        public Items(int val, int wt) {
            this.val = val;
            this.wt = wt;
            cost = (double) ((double) val / (double) wt);
        }
    }

    static double func(int[] val, int[] wt, int n, int k) {
        Items[] item = new Items[n];
        for (int i = 0; i < n; i++) {
            item[i] = new Items(val[i], wt[i]);
        }

        // Sort items array descending order
        Arrays.sort(item, new Comparator<Items>() {
            @Override
            public int compare(Items o1, Items o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0;
        for (Items i : item) {
            int value = i.val;
            int weight = i.wt;

            if (k - weight >= 0) {
                k -= weight;
                totalValue += (value * 100);
            } else {
                double fraction = (double) k / weight;
                totalValue += (value * fraction * 100);
                k -= (weight * fraction);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        // code
        // int[] val = { 60, 40, 100, 120 };
        // int[] wt = { 10, 40, 20, 30 };
        // int capacity = 50;
        int[] val = { 16, 3, 3, 6, 7, 8, 17, 13, 7 };
        int[] wt = { 3, 10, 9, 18, 17, 17, 6, 16, 13 };
        int capacity = 11;
        int n = val.length;

        System.out.println(func(val, wt, n, capacity));

    }
}
