package Arrays;

public class LeadersInArray {

//	Method 1 : Naive
//	Time Complexity: O(n^2)
//	Auxiliary Space: O(1) 
	void leadersNaive(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			boolean flag = false;
			for(int j = i + 1; j < n; j++) {
				if(arr[i] <= arr[j]) {
					flag = true;
					break;
				}
			}
			if(!flag)
				System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

//	Method 2 : Efficient
//	Time Complexity: O(n)
//	Auxiliary Space: O(1) 
	void leadersEfficient(int[] arr, int n) {
		
		int currentLeader = arr[n - 1];
		System.out.print(currentLeader+" ");
		for(int i = n - 2; i >= 0; i--) {
			if(currentLeader < arr[i]) {
				currentLeader = arr[i];
				System.out.print(arr[i]+" ");
			}
		}
	}
	
	public static void main(String[] args) {
		
		int arr[] = {7, 10, 4, 10, 6, 5, 2};
		int n = arr.length;
		
		LeadersInArray obj = new LeadersInArray();
		obj.leadersEfficient(arr, n);
	}
	
}	

	


