package Greedy_Algorithm;
 
import java.util.*;
import java.io.*;

class Activities implements Comparable<Activities>{
        Integer start;
        Integer finish;
        //Sorting in ascending order
        public int compareTo(Activities o){
            return finish.compareTo(o.finish);
        }
}

public class ActivitySelection
{
    
    
    public static int func(Activities act[], int n){
        int res = 1;
        int fT = act[0].finish;
        
        for(int i = 1; i < n; i++){
            if(act[i].start >= fT){
                res++;
                fT = act[i].finish;
            }
        }
        return res;
    }
    
	public static void main (String[] args) throws IOException
	{   
		int[] start = {1, 3, 2, 5, 8, 5};
		int[] finish = {2, 4, 6, 7, 9, 9};
		int n = start.length;
		Activities act[] = new Activities[n];
		
		for(int i = 0; i < n; i++) {
		    
			act[i] = new Activities();
			act[i].start = start[i];
			act[i].finish = finish[i];
		}
        Collections.sort(Arrays.asList(act));
        System.out.println(func(act, n));
	}
}
