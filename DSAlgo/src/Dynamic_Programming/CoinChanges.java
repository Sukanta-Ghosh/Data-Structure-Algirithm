package Dynamic_Programming;

public class CoinChanges {
	
	/** Space efficient DP solution
     */
	
	public static int count( int coins[], int n, int total ) 
	{ 
		// n is coins[] array length 
	    int table[]=new int[total+1]; 
	  
	    table[0] = 1; 
	  
	    for(int i=0; i<n; i++) 
	        for(int j=coins[i]; j<=total; j++) 
	            table[j] += table[j-coins[i]]; 
	  
	    return table[total]; 
	} 
	
}
