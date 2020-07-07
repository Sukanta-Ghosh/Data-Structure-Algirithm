package Dynamic_Programming;

public class LongestCommonSubstring {
	
	/** 
	 * Bottom-up Approach  
	 * */
	int bottomup( char[] X, char[] Y, int m, int n ) 
	{ 
	    int dp[][] = new int[m+1][n+1]; 
	    int max = 0;
	    
	    for (int i = 0; i <= m; i++) { 
	    	for (int j = 0; j <= n; j++) { 
	    		if (X[i-1] == Y[j-1]){ 
	    			dp[i][j] = dp[i-1][j-1] + 1; 
		    		if(max < dp[i][j])
	                    max = dp[i][j];
	    		}
	    	} 
	    } 
	    return max; 
	} 
}
