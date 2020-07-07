package Dynamic_Programming;

public class LongestRepeatingSubsequence {
	
	/** 
	 * Bottom-up Approach  
	 * */
	public int bottomup(char[] X, int m) 
	{ 
	    int dp[][] = new int[m+1][m+1]; 
	    
	    for (int i = 0; i <= m; i++) { 
	    	for (int j = 0; j <= m; j++) { 
	    		if (i == 0 || j == 0) 
	    			dp[i][j] = 0; 
	    		else if (X[i-1] == X[j-1] && i != j) 
	    			dp[i][j] = dp[i-1][j-1] + 1; 
	    		else
	    			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
	    	} 
	  }
	  return dp[m][m];
	} 
	
	public static void main(String[] args) {
		
		char[] X = {'A', 'A', 'B', 'E', 'D', 'D', 'B', 'C'};
		int m = X.length;
		LongestRepeatingSubsequence obj = new LongestRepeatingSubsequence();
		System.out.println(obj.bottomup(X, m));
	}
}
