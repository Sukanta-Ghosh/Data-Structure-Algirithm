package Dynamic_Programming;

public class UnboundedKnapsack {
	
	public static int unboundedKnapsack(int W, int n,  
	            int[] val, int[] wt) { 
	
		// dp[i] is going to store maximum value 
		// with knapsack capacity i. 
		int dp[] = new int[W + 1]; 
		
		// Fill dp[] using above recursive formula 
		for(int i = 0; i <= W; i++){ 
			for(int j = 0; j < n; j++){ 
				if(wt[j] <= i){ 
					dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]); 
				} 
			} 
		} 
		return dp[W]; 
	} 
}
