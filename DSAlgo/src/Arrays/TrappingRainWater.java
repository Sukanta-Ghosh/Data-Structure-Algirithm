package Arrays;

public class TrappingRainWater {
	
//	Method 1 : Naive
//	Time Complexity: O(n^2)
//	Auxiliary Space: O(1)	
	int getWaterNaive(int[] arr, int n) {
		
		int res = 0;
		for(int i = 1; i < n - 1; i++) {
			
			int lmax = arr[i];
			for(int j = 0; j < i; j++)
				lmax = Math.max(lmax, arr[i]);
			
			int rmax = arr[i];
			for(int j = i + 1; j < n; j++)
				rmax = Math.max(rmax, arr[i]);
			
			res += Math.min(lmax, rmax) - arr[i];
		}
		return res;
	}
	
//	Method 2 : Efficient
//	Time Complexity: O(n)
//	Auxiliary Space: O(n) 	
	int getrWaterEffic(int[] arr, int n) {
		
		int res = 0;
		
		int lmax[] = new int[n];
		int rmax[] = new int[n];
		
		lmax[0] = arr[0];
		for(int i = 1; i < n; i++)
			lmax[i] = Math.max(arr[i], lmax[i - 1]);
		
		rmax[n - 1] = arr[n - 1];
		for(int i = n - 2; i >= 0; i--)
			rmax[i] = Math.max(arr[i], rmax[i + 1]);
		
		for(int i = 1; i < n; i++)
			res += Math.min(lmax[i], rmax[i]) - arr[i];
		
		return res;
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {5, 0, 6, 2, 3};
		int n = arr.length;
		
		TrappingRainWater obj = new TrappingRainWater();
		System.out.println(obj.getrWaterEffic(arr, n));
	}
}
