package Dynamic_Programming;

public class EditDistance {
	
	private int min(int a,int b, int c){
		int l = Math.min(a, b);
	    return Math.min(l, c);
	}
	
	public int dynamicEditDistance(char[] X, char[] Y, int m, int n){
        int dp[][] = new int[m + 1][n + 1];
        
        for(int i=0; i < m; i++){
            dp[0][i] = i;
        }
        
        for(int i=0; i < n; i++){
            dp[i][0] = i;
        }
        
        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                if(X[i-1] == Y[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];  
    }
}
