package Dynamic_Programming;

public class LongestIncreasingSubsequence {
	
	/** 
	 * Length of Longest Increasing Subsequence
	 * **/
	public int lis(int arr[], int n){
		
        int T[] = new int[n];
        int actualSolution[] = new int[n];
        
        for(int i=0; i < n; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
            	
                if(arr[i] > arr[j] && T[j] + 1 > T[i]){
                	T[i] = T[j] + 1;
                    //set the actualSolution to point to guy before me
                    actualSolution[i] = j;
                    
                }
            }
        }
        
        //find the index of max number in T 
        int maxIndex = 0;
        for(int i=0; i < n; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }
        
        //printLis(maxIndex, actualSolution, arr)
        return T[maxIndex];
    }
	
	/** 
	 * Minimum Deletion to Make a Sequence Sorted
	 * **/
	public int minimumNumberOfDeletions(int arr[], int n) 
	{ 
		// Find longest increasing subsequence
		int len = lis(arr, n); 
		
		// After removing elements  
		// other than the lis, we get 
		// sorted sequence. 
		return (n - len); 
	}
	
	/** 
	 * Print Longest Increasing Subsequence
	 * **/
	public void printLis(int maxIndex, int[] actualSolution, int[] arr) {
		//lets print the actual solution
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();
	}
}
