package Dynamic_Programming;

import java.util.Arrays;

public class EggDropping {
	
	/* 
	 * Recursive Approach 
	 * */
	public int recursive(int e, int f){
		
		if(e == 1)
			return f;
		
		if(f == 0)
			return 0;
		
		int min = Integer.MAX_VALUE;
		for(int k = 1; k <= f; k++) {
			int ans = 1 + Math.max(recursive(e - 1, k - 1), recursive(e, f - k));
	
			min = Math.min(ans, min); 
		}
		
		return min;
	}
	
	/* 
	 * Top-down Approach 
	 * */
	public int topdown(int e, int f, int[][] dp){
		
		if(e == 1)
			return f;
		
		if(f == 0)
			return 0;
		
		if(dp[e][f] != -1)
			return dp[e][f];
		
		int min = Integer.MAX_VALUE;
		for(int k = 1; k <= f; k++) {
			
			int low = 0;
			int high = 0;
			if(dp[e - 1][k - 1] != -1)
				low = dp[e - 1][k - 1];
			else {
				low = topdown(e - 1, k - 1, dp);
				dp[e - 1][k - 1] = low;
			}
			if(dp[e][f - k] != -1)
				high = dp[e][f - k];
			else {
				high = topdown(e, f - k, dp);
				dp[e][f - k] = high;
			}
			
			int ans = 1 + Math.max(low, high);
			
			min = Math.min(ans, min); 
		}
		
		return dp[e][f] = min;
	}
	
	/* 
	 * Bottom-up Approach 
	 * */
	public int bottomup(int eggs, int floors){
        
        int T[][] = new int[eggs + 1][floors + 1];
        int c =0;
        
        for(int i=0; i <= floors; i++){
            T[1][i] = i;
        }
        
        for(int e = 2; e <= eggs; e++){
            for(int f = 1; f <=floors; f++){
                T[e][f] = Integer.MAX_VALUE;
                for(int k = 1; k <=f ; k++){
                    c = 1 + Math.max(T[e-1][k-1], T[e][f-k]);
                    if(c < T[e][f]){
                        T[e][f] = c;
                    }
                }
            }
        }
        return T[eggs][floors];
    }
	
	public static void main(String[] args) {
		
		int eggs = 2;
		int floors = 6;
		EggDropping obj = new EggDropping();
		
		System.out.println(obj.recursive(eggs, floors));
		
		int[][] dp = new int[eggs + 1][floors + 1];
		for(int[] row : dp)
			Arrays.fill(row, -1);
		System.out.println(obj.topdown(eggs, floors, dp));
		
		System.out.println(obj.bottomup(eggs, floors));
	}
}
