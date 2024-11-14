package heap;

import java.util.Arrays;

public class Implementation {
	
	void heapify(int[] arr, int n, int i) {
		
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < n && arr[left] > arr[largest]) largest = left;
		if(right < n && arr[right] > arr[largest]) largest = right;
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
		
		
		
	}
	
	void buildHeap(int[] arr, int n) {
		
		int startIdx = (n-2)/2;
		
		for(; startIdx >=0; startIdx--) {
			heapify(arr, n, startIdx);
		}
	}
	
//	void printHeap(int[] arr) {
//		
//		for(int i=0; i<arr.length; i++) {
//			System.out.print(arr[i]);
//		}
//	}

	public static void main(String args[]) {
		Implementation heap = new Implementation();
		
//		Implementing a max heap
		int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
		System.out.println(Arrays.toString(arr));
		
		heap.buildHeap(arr, arr.length);
		System.out.println(Arrays.toString(arr));
		
	}
}
