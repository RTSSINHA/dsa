package array;
import java.util.*;

public class Sort {
	
	public static void main(String args[]) {
		
		int[] arr = {5, 1, 4, 2, 8};
		System.out.println(Arrays.toString(arr));
		
//		BubbleSort(arr);
		SelectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void SelectionSort(int[] arr) {
		
		if(arr.length <= 1) return;
		int minIdx = -1;
		
		for(int i=0; i<arr.length-1; i++) {
			minIdx = i;
			for(int j=i; j<arr.length; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			swap(arr, i, minIdx);
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; 
		arr[i] = arr[j];
		arr[j] = temp;
//		arr[i] = arr[i] + arr[j];
//		arr[j] = arr[i] - arr[j];
//		arr[i] = arr[i] - arr[j];
	}
	
	static void BubbleSort(int[] arr) {
		
		if(arr.length <= 1) return;
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[j-1]) {
//					int temp = arr[j];
//					arr[j] = arr[j-1];
//					arr[j-1] = temp;
					
//					Swap without using a temp variable
					arr[j] = arr[j]+arr[j-1];
					arr[j-1] = arr[j] - arr[j-1];
					arr[j] = arr[j] - arr[j-1];
				}
			}
		}
	}
}
