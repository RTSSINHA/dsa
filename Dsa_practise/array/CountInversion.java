package array;
import java.util.*;

public class CountInversion {
	
	public static void main(String args[]) {
		
//		int[] arr = {8, 4, 2, 1};
		int[] arr = {3, 1, 2};
		System.out.println(Arrays.toString(arr));
		System.out.println(mergeSort(arr, 0, arr.length-1));
		System.out.println(Arrays.toString(arr));
	}
	static int mergeSort(int[] arr, int low, int high) {
		int swaps = 0;
		if(low >= high) return 0;
		int mid = low + (high - low)/2;
		swaps += mergeSort(arr, low, mid);
		swaps += mergeSort(arr, mid+1, high);
		swaps += merge(arr, low, mid, high);
		return swaps;
	}
	
	static int merge(int[] arr, int low, int mid, int high) {
		
		if(low > high) return 0;
		
		int[] left = Arrays.copyOfRange(arr, low, mid+1);
		int[] right = Arrays.copyOfRange(arr, mid+1, high + 1);
		
		int i = 0, j = 0, k = low, swaps = 0;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
				swaps += (mid +1) - (low + i);
			}
		}
		System.out.println("Low: "+low+" Mid: "+mid+" High: "+high);
		System.out.println("Debug 1");
		while(i < left.length) arr[k++] = left[i++];
		while(j < right.length) arr[k++] = right[j++];
		System.out.println("Debug 2");
		return swaps;
		
	}
}
