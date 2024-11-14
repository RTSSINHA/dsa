package array;
import java.util.*;

public class ReversePairs {
	
	public static void main(String args[]) {
		
		int[] arr = {1, 3, 2, 3, 1};
		System.out.println(Arrays.toString(arr));
		
		countPairs(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	static void countPairs(int[] arr, int n) {
		
		int res = mergeSort(arr, 0, n-1);
		System.out.println(res);
	}
	
	static int mergeSort(int[] arr, int l, int r) {
		
		int cnt = 0;
		
		if(l < r) {
			
			int mid = l + (r - l)/2;
			
			cnt += mergeSort(arr, l, mid);
			cnt += mergeSort(arr, mid+1, r);
			cnt += countPairs(arr, l, mid, r);
			merge(arr, l, mid, r);
		}
		return cnt;
	}
	
	static void merge(int[] arr, int l, int mid, int r) {
		
		int n = mid - l + 1;
		int m = r - mid;
//		int[] temp = new int[n + m + 1];
		
		int[] a1 = new int[n];
		int[] a2 = new int[m];
		
		for(int i=0; i<a1.length; i++) a1[i] = arr[l+i];
		for(int i=0; i<a2.length; i++) a2[i] = arr[i+mid+1];
		
		int i=0, j=0, k=l;
		while(i < a1.length && j < a2.length) {
			
			if(a1[i] <= a2[j]) {
				arr[k++] = a1[i++];
			} else {
				arr[k++] = a2[j++];
			}
		}
		
		while(i < a1.length) arr[k++] = a1[i++];
		while(j < a2.length) arr[k++] = a2[j++];
		
		
	}
	
	static int countPairs(int[] arr, int l, int m, int h) {
		
		int count = 0;
		int r = m+1;
		
		for(int i = l; i<= m; i++) {
			while(r <= h && arr[i] > 2 * arr[r]) r++;
			count += r - (m + 1);
		}
		
		return count;
	}
}
