package Dynamic_Programming;

public class MatrixChainMultiplication {
	
	/**
	 * Recursive Approach
	 */
	public int recursive(int[] arr, int i, int j) {
		 if (i == j) 
	            return 0; 
	  
        int min = Integer.MAX_VALUE; 
  
        // place parenthesis at different places between first 
        // and last matrix, recursively calculate count of 
        // multiplications for each parenthesis placement and 
        // return the minimum count 
        for (int k=i; k<j; k++) 
        { 
            int count = recursive(arr, i, k) + recursive(arr, k+1, j) + 
                        arr[i-1] * arr[k] * arr[j]; 
  
            if (count < min) 
                min = count; 
        } 
        return min; 
	}
	
	/**
	 * Top-down/Memorization Approach
	 */
	 public int topdown(int[] arr, int i, int j, int[][] dp){
		 if (i == j) 
			 return 0; 
		 
		 if(dp[i][j] != 0)
			 return dp[i][j];
	  
	     int min = Integer.MAX_VALUE; 
	
	     for (int k=i; k<j; k++) 
	     { 
	         int count = recursive(arr, i, k) + recursive(arr, k+1, j) + 
	                     arr[i-1] * arr[k] * arr[j]; 
	
	         if (count < min) 
	             min = count; 
	     } 
	     
	     return dp[i][j] = min; 
	 }
	
	/**
	 * Bottom-up/Tabulation Approach
	 */
	 public int bottomup(int arr[], int n){
		 int[][] dp = new int[n][n];
		 
		 for(int l = 2; l < n; l++) {
			 for(int i = 1; i <= n - l; i++) {
				 int j = i + l - 1;
				 dp[i][j] = Integer.MAX_VALUE;
				 
				 for(int k = i; k < j; k++) {
					 dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + 
							 						arr[i - 1] * arr[j] * arr[k]);
				 }
			 }
		 }
		 return dp[1][n - 1];
	 }
	 
	 public static void main(String[] args) {
		 int arr[] = {40, 20, 30, 10, 30};
		 int n = arr.length;
		 MatrixChainMultiplication obj = new MatrixChainMultiplication();
		 
		 System.out.println(obj.recursive(arr, 1, n - 1));
		 
		 int[][] dp = new int[n + 1][n + 1];
		 System.out.println(obj.topdown(arr, 1, n - 1, dp));
		 
		 System.out.println(obj.bottomup(arr, n));
	}
}
