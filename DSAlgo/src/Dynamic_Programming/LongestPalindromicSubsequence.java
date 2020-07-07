package Dynamic_Programming;

public class LongestPalindromicSubsequence{
	
	
	public int lps(char []str){
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][str.length-1];
    }
	
	/** 
	 * Using LCS concept
	 **/
	public int lpsBylcs(char[] X, int m) 
	{ 
	    int dp[][] = new int[m+1][m+1];
	    
	    // Reverse the array and store it into another array
	    char[] Y = new char[m];
	    int k = 0;
	    for(int i = m - 1; i >= 0; i--) {
	    	Y[k++] = X[i];
	    }
	    
	    for (int i = 0; i <= m; i++) { 
	    	for (int j = 0; j <= m; j++) { 
	    		if (i == 0 || j == 0) 
	    			dp[i][j] = 0; 
	    		else if (X[i-1] == Y[j-1]) 
	    			dp[i][j] = dp[i-1][j-1] + 1; 
	    		else
	    			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
	    	} 
	  } 
	  return dp[m][m];
	}
	
	
	
	public static void main(String[] args) {
		
		char[] X = {'A', 'G', 'B', 'C', 'B', 'A'};
		int m = X.length;
		
		LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
		System.out.println(obj.lps(X));
		// Minimum Deletions/Insertions in a String to make if a Palindrome
		// m - obj.lps(X)
	}
}
