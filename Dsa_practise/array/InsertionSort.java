package array;
import java.util.*;

public class InsertionSort {
	
	public static void main(String args[]) {
		
		int[] arr = {4, 3, 5, 1, 2, 4};
		int[] arr1 = {84, 38, -5, 10, 298, 1, -10, -99};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr1));
		InsertionSort(arr);
		InsertionSort(arr1);
//		BubbleSort(arr);
//		BubbleSort(arr1);
//		SelectionSort(arr);
//		SelectionSort(arr1);
//		MergeSort(arr);
//		MergeSort(arr1);
//		QuickSort(arr);
//		QuickSort(arr1);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr1));
	}
	
	static void QuickSort(int[] arr) {
		
		QuickSort(arr, 0, arr.length-1);
	}
	
	static void QuickSort(int[] arr, int l, int r) {
		
		if(l < r) {
			
			int pivotPoint = partition(arr, l, r);
			QuickSort(arr, l, pivotPoint - 1);
			QuickSort(arr, pivotPoint + 1, r);
		}
	}
	
	static int partition(int[] arr, int l, int r) {
		
		
		int pivot = arr[r];
		int[] temp = new int[(r - l) + 1];
		int idx = 0;
		
		for(int i=l; i<= r; i++) {
			
			if(arr[i] < pivot) {
				temp[idx++] = arr[i];
			}
		}
		
		int point = idx;
		temp[idx++] = pivot;
		
		for(int i=l; i<=r; i++) {
			
			if(arr[i] > pivot) temp[idx++] = arr[i];
		}
		
		for(int i=l; i<=r; i++) {
			arr[i] = temp[i - l];
		}
		return point;
		
	}
	
	static void MergeSort(int[] arr) {
		
		mergeSortArr(arr, 0, arr.length - 1);
	}
	
	static void mergeSortArr(int[] arr, int l, int h) {
		
		if(l < h) {
			int mid = l + (h - l)/2;
			mergeSortArr(arr, l, mid);
			mergeSortArr(arr, mid+1, h);
			merge(arr, l, mid, h);
		}
	}
	
	static void merge(int[] arr, int l, int m, int h) {
		
		int[] l1 = new int[m - l + 1];
		int[] l2 = new int[h - m];
		
		for(int i=0; i< l1.length; i++) {
			l1[i] = arr[l + i];
		}
		for(int i=0; i<l2.length; i++) {
			l2[i] = arr[m + i + 1];
		}
		
		int k = l;
		int i = 0, j = 0;
		while(i < l1.length && j < l2.length) {
			
			if(l1[i] <= l2[j]) {
				arr[k++] = l1[i];
				i++;
			} else {
				arr[k++] = l2[j];
				j++;
			}
		}
		
		while(i < l1.length) {
			arr[k++] = l1[i++];
		}
		while(j < l2.length) {
			arr[k++] = l2[j++];
		}
	}
	
	static void SelectionSort(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			int min_idx = i;
			
			for(int j=i+1; j<arr.length; j++) {
				min_idx = arr[j] < arr[min_idx]? j: min_idx;
			}
			
			if(min_idx != i) {
			arr[i] = arr[i] + arr[min_idx];
			arr[min_idx] = arr[i] - arr[min_idx];
			arr[i] = arr[i] - arr[min_idx];
			}
		}
	}
	
	static void BubbleSort(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length - i; j++) {
				
//				Swap if alternate element is bigger fish
				if(j+1 < arr.length && arr[j+1] < arr[j]) {
					arr[j] = arr[j+1] + arr[j];
					arr[j+1] = arr[j] - arr[j+1];
					arr[j] = arr[j] - arr[j+1];
				}
			}
		}
	}
	
	static void InsertionSort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
}
