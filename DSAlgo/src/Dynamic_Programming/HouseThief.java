package Dynamic_Programming;

public class HouseThief {
	
	int maxSum(int[] arr, int n){
        int temp = 0;
        int incl = arr[0];
        int excl = 0;
        
        for(int i = 1; i < n; i++){
            
            temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }
        
        return incl;
    }
}
