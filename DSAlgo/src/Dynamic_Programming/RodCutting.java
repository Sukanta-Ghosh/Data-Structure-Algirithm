package Dynamic_Programming;

public class RodCutting {
	
	/** Bottom-up approach 
	 * 
	 **/
	public int maxValue(int price[]){
		
        int max[] = new int[price.length+1];
        
        for(int i=1; i <= price.length; i++){
            for(int j=i; j <= price.length; j++){
                max[j] = Math.max(max[j], max[j-i] + price[i-1]);
            }
        }
        return max[price.length];
    }
}
