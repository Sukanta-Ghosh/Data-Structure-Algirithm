package Heap;

//Arr[(i-1)/2]	Returns the parent node
//Arr[(2*i)+1]	Returns the left child node
//Arr[(2*i)+2]	Returns the right child node

public class MinBinaryHeap{
	
	int[] arr;
	int size;
	int capacity;
	MinBinaryHeap(int c){
		arr = new int[c];
		size = 0;
		capacity = c;
	}
	
	int left(int i) { return (2 * i + 1); }
	int right(int i) { return (2 * i + 2); }
	int parent(int i) { return (i - 1) / 2; }
	
	void insert(int x) {
		if(size == capacity)
			return;
		
		size++;
		arr[size - 1] = x;
		for(int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; i = parent(i)) {
			swap(i, parent(i));	
			//i = parent(i);
		}
	}
	
	// Here i should be 0 if it is minHeapify
	// Time Complexity: O(log(n)) or O(h) 
	// h is height, n is number of elements
	void minHeapify(int i) {
		int lt = left(i);
		int rt = right(i);
		
		int smallest = i;
		if(lt < size && arr[lt] < arr[i])
			smallest = lt;
		if(rt < size && arr[rt] < arr[smallest])
			smallest = rt;
		
		if(smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}
	}
	
	// Time Complexity: O(log(n)) or O(h) 
	// h is height, n is number of elements
	int extractMin() {
		
		if(size == 0)
			return Integer.MAX_VALUE;
		
		if(size == 1) {
			size--;
			return arr[0];
		}
		
		swap(0, size - 1);
		size--;
		minHeapify(0);
		return arr[size];
	}
	
	int extractAnyIndex(int i) {
		
		if(size < i)
			return Integer.MAX_VALUE;
		
		int ele = arr[i];
		
		changeKey(i, Integer.MIN_VALUE);
		
		extractMin();
		
		return ele;
	}
	
	void changeKey(int i, int x) {
		arr[i] = x;
		
		while(i != 0 && arr[parent(i)] > arr[i])
		{
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	// Time Complexity: O(n)
	void buildHeap(){
		
//		index = size / 2 - 1
		for(int i = (size - 2) / 2; i >= 0; i--)
			minHeapify(i);
	}
	
	void swap(int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	void printArray() {
		for(int i = 0; i < size; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		MinBinaryHeap heap = new MinBinaryHeap(10);
		
//		 Array representation of Max-Heap
//              10
//            /    \
//           15     20
//          /  \    / \
//         40  50 100  25
//		  /
//		 45
		heap.insert(10);
		heap.insert(20);
		heap.insert(15);
		heap.insert(40);
		heap.insert(50);
		heap.insert(100);
		heap.insert(25);
		heap.insert(45);
		
		heap.printArray();
		//After inserting 12
		heap.insert(12);
		
		heap.printArray();
		
		System.out.println(heap.extractAnyIndex(4));
		//System.out.println(heap.extractMin());
		
		heap.printArray();
		
		heap.changeKey(4, 5);
		heap.printArray();
	}
}
