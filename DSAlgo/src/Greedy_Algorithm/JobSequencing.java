package Greedy_Algorithm;

import java.util.*;

class Job implements Comparable<Job>{
    Integer id;
    Integer deadline;
    Integer profit;
    
    public int compareTo(Job o){
        return this.profit.compareTo(o.profit);
    }
}

class JobSequencing
 {
    static void func(Job[] job, int n){
        
        int result[] = new int[n];
        boolean slot[] = new boolean[n];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = Math.min(n, job[i].deadline) - 1;
                j >= 0; j--)
            {
                    
                if(!slot[j])
                {
                    result[j] = i;
                    slot[j] = true;
                    break;
                }
            }
        }
        
        int numberOfJob = 0;
        int totalProfit = 0;
        for(int i = 0; i < n; i++){
            if(slot[i]){
                totalProfit += job[result[i]].profit;
                numberOfJob++;
            }
        }
        System.out.println(numberOfJob+" "+totalProfit);
    }
    
	public static void main (String[] args)
	{
	    //code
	    int[] id = {1, 2, 3, 4};
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};
        int n = id.length;
        
        Job[] job = new Job[n];
        for(int i = 0; i < n; i++){
            job[i] = new Job();
            job[i].id = id[i];
            job[i].deadline = deadline[i];
            job[i].profit = profit[i];
        }
        
        Collections.sort(Arrays.asList(job), Collections.reverseOrder());
        func(job, n);
	    
	}
}