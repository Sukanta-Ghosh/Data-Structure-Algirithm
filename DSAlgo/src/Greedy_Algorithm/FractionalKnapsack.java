package Greedy_Algorithm;

import java.util.*;
import java.lang.*;
class FractionalKnapsack
 {
    static class Items{
        int val, wt;
        Double cost;
        public Items(int val, int wt){
            this.val = val;
            this.wt = wt;
            cost = new Double(val / wt); 
        }
    }
    
    static double func(int[] val, int[] wt, int n, int k){
        Items[] item = new Items[n];
        for(int i = 0; i < n; i++){
            item[i] = new Items(val[i], wt[i]);
        }
        
        Arrays.sort(item, new Comparator<Items>()  
        { 
            @Override
            public int compare(Items o1, Items o2)  
            { 
                return o2.cost.compareTo(o1.cost) ; 
            } 
        });
        
        double totalValue = 0;
        for(Items i : item){
            int value = i.val;
            int weight = i.wt;
            
            if(k - weight >= 0){
                k -= weight;
                totalValue += value;
            }
            else
            {
                double fraction = (double)k / weight;
                totalValue += (value * fraction);
                k -= (weight * fraction);
                break;
            }
        }
        return totalValue;
    }
    
	public static void main (String[] args)
	{
	    //code 
        int[] val = {60, 40, 100, 120};
        int[] wt = {10, 40, 20, 30};
        int capacity = 50;
        int n = val.length;
        
        System.out.println(func(val, wt, n, capacity));
	        
	    
	}
}
