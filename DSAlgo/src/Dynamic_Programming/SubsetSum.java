package Dynamic_Programming;

public class SubsetSum {
	
	/** 
	 * For Subset Sum Problem 
	*/
	public boolean subsetSum(int input[], int total) {

        boolean T[][] = new boolean[input.length + 1][total + 1];
        
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
            	T[i][j] = T[i-1][j];
                if (j >= input[i - 1]) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                }
            }
        }
        return T[input.length][total];
    }
	
	/** 
	 * For Count Subset Sum Problem 
	*/
	public int countSubsetSum(int input[], int total) {

        int T[][] = new int[input.length + 1][total + 1];
        
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = 1;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
            	T[i][j] = T[i-1][j];
                if (j >= input[i - 1]) {
                    T[i][j] = T[i - 1][j] + T[i - 1][j - input[i - 1]];
                }
            }
        }
        return T[input.length][total];
    }
	
	/** 
	 * For Equal Subset Sum / Partition Problem  
    */
	public boolean equalSubsetSum(int input[]) {

        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }

        if (sum % 2 != 0) {
            return false;
	    }
	    sum = sum / 2;
	    boolean[][] T = new boolean[input.length + 1][sum + 1];
         
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= sum; j++) {
            	T[i][j] = T[i-1][j];
                if (j >= input[i - 1]) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                }
            }
        }
        return T[input.length][sum];
    }
	
	/** 
	 * For Minimum Subset Sum Difference  
    */
	public int minSubsetSumDiff(int input[]) {

        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }

	    sum = sum / 2;
	    boolean[][] T = new boolean[input.length + 1][sum + 1];
         
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= sum; j++) {
            	T[i][j] = T[i-1][j];
                if (j >= input[i - 1]) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                }
            }
        }
        
        // Initialize difference of two sums.  
        int diff = Integer.MAX_VALUE; 
        int n = input.length;  
        // Find the largest j such that dp[n][j] 
        // is true where j loops from sum/2 t0 0 
        for (int j = sum; j >= 0; j--) 
        { 
            // Find the  
            if (T[n][j] == true) 
            { 
                diff = sum - 2 * j; 
                break; 
            } 
        } 
        return diff; 
    }
	
	/** 
	 * For Minimum Subset Sum Difference /
	 * Count number of subset with a given difference 
    */
	public int targetSum(int input[], int diff) {

        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }

	    int range = (sum + diff) / 2;
	    int[][] T = new int[input.length + 1][range + 1];
         
	    for (int i = 0; i <= input.length; i++) {
            T[i][0] = 1;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= range; j++) {
            	T[i][j] = T[i-1][j];
                if (j >= input[i - 1]) {
                    T[i][j] = T[i - 1][j] + T[i - 1][j - input[i - 1]];
                }
            }
        }
        return T[input.length][range];
    }


	/** Main Function
	 * 
	 */
	public static void main(String args[]) {
        SubsetSum ss = new SubsetSum();
        int arr[] = {2, 3, 5, 6, 8, 10};
        System.out.print(ss.subsetSum(arr, 11));
        System.out.println(ss.countSubsetSum(arr, 10));


    }
}
