package Arrays;

public class LeftRotateByd {
	
//	Method 1: Naive
//	Time Complexity: O(nd)
//	Auxiliary Space: O(1) 
	void leftRotateOne(int[] arr, int n) {
		int temp = arr[0];
		for(int i = 0; i < n; i++)
			arr[i - 1] = arr[i];
		arr[n - 1] = temp;
	}
	
	void leftRotateNaive(int[] arr, int n, int d) {
		
		for(int i = 0; i < d; i++)
			leftRotateOne(arr, n);
	}
	
//	Method 2: Better
//	Time Complexity: O(n)
//	Auxiliary Space: O(d)	
	void leftRotateMethod2(int[] arr, int n, int d) {
		
		int temp[] = new int[d]; 
		for(int i = 0; i < d; i++)
			temp[i] = arr[i];
		for(int i = d; i < n; i++)
			arr[i - d] = arr[i];
		for(int i = 0; i < d; i++)
			arr[n - d + i] = temp[i];
	}

//	Method 3: Efficient
//	Time Complexity: O(n)
//	Auxiliary Space: O(1)
	void leftRotateEfficient(int[] arr, int n, int d) {
		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);
	}
	
	void reverse(int[] arr, int low, int high) {
		while(low < high) {
			swap(arr, low, high);
			low++;
			high--;
		}
	}
	
	void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 4, 5};
		int n = arr.length;
		int d = 2;
		
		LeftRotateByd obj = new LeftRotateByd();
		obj.leftRotateEfficient(arr, n, d);
		for(int i : arr)
			System.out.print(i+" ");
	}
}
