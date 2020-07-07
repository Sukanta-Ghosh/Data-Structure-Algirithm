package Dynamic_Programming;

import java.util.*;
import java.lang.*;

public class LongestCommonSubsequence {
	
	/** 
	 * Bottom-up Approach  
	 * */
	public int bottomup( char[] X, char[] Y, int m, int n ) 
	{ 
	    int dp[][] = new int[m+1][n+1]; 
	    
	    for (int i = 0; i <= m; i++) { 
	    	for (int j = 0; j <= n; j++) { 
	    		if (i == 0 || j == 0) 
	    			dp[i][j] = 0; 
	    		else if (X[i-1] == Y[j-1]) 
	    			dp[i][j] = dp[i-1][j-1] + 1; 
	    		else
	    			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
	    	} 
	  }
	  //printlcs(dp, X, Y, m, n);
	  //printscs(dp, X, Y, m, n);  
	  return dp[m][n];
	} 
	/** 
	 * Recursive Approach  
	 * */
	int recursivelcs( char[] X, char[] Y, int m, int n ) 
	{ 
	    if (m == 0 || n == 0) 
	      return 0; 
	    
	    if (X[m-1] == Y[n-1]) 
	      return 1 + recursivelcs(X, Y, m-1, n-1); 
	    else
	      return Math.max(recursivelcs(X, Y, m, n-1), recursivelcs(X, Y, m-1, n)); 
	} 
	
	/** 
	 * Top-down Approach  
	 * */
	int topdown(char[] X, char[] Y, int m, int n, int[][] dp) 
	{ 
		if (m == 0 || n == 0) 
			return 0; 
	    
	    if(dp[m - 1][n - 1] != -1)
	    	return dp[m][n];
	    
	    if (X[m-1] == Y[n-1])  
	    	return dp[m - 1][n - 1] = 1 + topdown(X, Y, m-1, n-1, dp);
	    else
	      return dp[m - 1][n - 1] = Math.max(topdown(X, Y, m, n-1, dp), topdown(X, Y, m-1, n, dp)); 
	}
	
	/** 
	 * Printing LCS  
	 * */
	void printlcs(int[][] dp, char[] X, char[] Y, int m, int n) {
		char[] arr = new char[m];
		int i = 0;
		
		while(m > 0 && n > 0) {
			if(X[m - 1] == Y[n - 1]) {
				arr[i++] = X[m - 1];
				m--;
				n--;
			}
			else {
				if(dp[m][n - 1] > dp[m - 1][n])
					n--;
				else
					m--;
			}
		}
		for(int j = i - 1; j >= 0; j--) {
			System.out.print(arr[j]);
		}
		System.out.println();
	}
	
	/** 
	 * Printing Shortest Common Supersequence  
	 * */
	void printscs(int[][] dp, char[] X, char[] Y, int m, int n) {
		char[] arr = new char[m+n];
		int i = 0;
		
		while(m > 0 && n > 0) {
			if(X[m - 1] == Y[n - 1]) {
				arr[i++] = X[m - 1];
				m--;
				n--;
			}
			else {
				if(dp[m][n - 1] > dp[m - 1][n]) {
					arr[i++] = Y[n - 1];
					n--;
				}
				else {
					arr[i++] = X[m - 1];
					m--;
				}
			}
		}
		
		while(m > 0) {
			arr[i++] = X[m - 1]; 
		}
		while(n > 0) {
			arr[i++] = Y[n - 1]; 
		}
		
		for(int j = i - 1; j >= 0; j--) {
			System.out.print(arr[j]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		char[] X = {'A', 'G', 'G', 'T', 'A', 'B'};
		int m = X.length;
		char[] Y = {'G', 'X', 'T', 'X', 'A', 'Y', 'B'};
		int n = Y.length;
		int[][] dp = new int[m][n];
		//Arrays.fill(dp, -1);
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		System.out.println(obj.bottomup(X, Y, m, n));
		
		/** 
		 * Length of Shortest Common Supersequence
		 * m + n - lcs(X, Y, m, n); 
		 */
		//Shortest Common Supersequence
		System.out.println(m + n - obj.bottomup(X, Y, m, n));
	}
}
