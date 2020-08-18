package Arrays;

public class MaximumDiff {

//	Method 1 : Naive
//	Time Complexity: O(n^2)
//	Auxiliary Space: O(1) 
	int maxDiffNaive(int[] arr, int n) {
		
		int res = arr[1] - arr[0];
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				res = Math.max(res, arr[j] - arr[i]);
			}
		}
		return res;
	}

//	Method 2 : Efficient
//	Time Complexity: O(n)
//	Auxiliary Space: O(1) 
	int maxDiffEffi(int[] arr, int n) {
		
		int res = arr[1] - arr[0];
		int minVal = arr[0];
		for(int i = 1; i < n; i++) {
			res = Math.max(res, arr[i] - minVal);
			minVal = Math.min(minVal, arr[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2, 3, 10, 6, 4, 8, 1};
		int n = arr.length;
		
		MaximumDiff obj = new MaximumDiff();
		System.out.println(obj.maxDiffEffi(arr, n));
	}
}
