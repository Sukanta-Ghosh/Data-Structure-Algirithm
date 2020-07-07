package Dynamic_Programming;

import java.util.Arrays;

public class PalindromicPartitioning {
	
	/**
	 * Bottom-up/Tabulation Approach
	 */
	public int bottomup(String str)
	{
        if (str.length() == 0){
            return 0;
        }

        int[] cut = new int[str.length()];
        boolean isPal[][] = new boolean[str.length()][str.length()];
        for (int i = 1; i < str.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1])) {
                    isPal[i][j] = true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
                }
            }
            cut[i] = min;
        }
        return cut[str.length() - 1];
    }
	
	/**
	 * Recursive Approach
	 */
	public int recursive(String str, int i, int j) {
		
		 if(i >= j)
			 return 0;
		 
		 if(isPalindrome(str, i, j))
			 return 0;
		 
		 int min = Integer.MAX_VALUE;
		 for(int k = i; k <= j - 1; k++) {
			 int ans = 1 + recursive(str, i, k) + recursive(str, k + 1, j);
			 min = Math.min(min, ans);
		 }
		 return min;
	}
	
	/**
	 * Top-down/Memorization Approach
	 */
	public int topdown(String str, int i, int j, int[][] dp) {
		
		 if(i >= j)
			 return 0;
		 
		 if(isPalindrome(str, i, j))
			 return 0;
		 
		 if(dp[i][j] != -1)
			 return dp[i][j];
		 
		 int min = Integer.MAX_VALUE;
		 for(int k = i; k <= j - 1; k++) {
			 int left = 0; 
			 int right = 0;
			 if(dp[i][k] != -1)
				 left = dp[i][k];
			 else {
				 left = topdown(str, i, k, dp);
				 dp[i][k] = left;
			 }
			 
			 if(dp[k+1][j] != -1)
				 right = dp[k+1][j];
			 else {
				 right = topdown(str, k + 1, j, dp);
				 dp[k + 1][j] = right;
			 }
				 
			 int ans = 1 + left + right;
			 min = Math.min(min, ans);
		 }
		 return dp[i][j] = min;
	}
	
	public boolean isPalindrome(String str, int i, int j) {
		while(i < j){
			if(str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "abcbm";
		PalindromicPartitioning obj = new PalindromicPartitioning();
		System.out.println(obj.recursive(str, 0, str.length() - 1));
		
		int[][] dp = new int[str.length()][str.length()];
		for(int[] row : dp)
			Arrays.fill(row, -1);
		System.out.println(obj.topdown(str, 0, str.length() - 1, dp));
	}
}
