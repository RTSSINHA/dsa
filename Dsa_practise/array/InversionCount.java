package array;
import java.util.*;

public class InversionCount {
	
	public static void main(String args[]) {
		
		int[] arr = {5, 4, 3, 2, 1};
//		int[] arr = {1, 2, 3, 4, 5};
//		int[] arr = {5, 3, 2, 1, 4};
		System.out.println(Arrays.toString(arr));
		
		int[] count = new int[]{0};
		int cnt = 0;
		InversionCount(arr, 0, arr.length - 1, count);
		System.out.println(Arrays.toString(count));
		System.out.println(cnt);
	}
	
	static void InversionCount(int[] arr, int l, int r, int[] count) {
			
			int cnt = 0;
			if(l >= r) return;
			int mid = l + (r - l)/2;
			InversionCount(arr, l, mid, count);
			InversionCount(arr, mid + 1, r, count);
			count[0] += Merge(arr, l, mid, r);
			
	}
	
	static int Merge(int[] arr, int l, int m, int r) {
	    
		
		
		int[] l1 = new int[m - l + 1];
		int[] l2 = new int[r - m];
		
		for(int i=0; i<l1.length; i++) {
			l1[i] = arr[l+i];
		}
		
		for(int i=0; i<l2.length; i++) {
			l2[i] = arr[m+i+1];
		}
		
		int i=0, j=0, count = 0, k=l;
		while(i <l1.length && j < l2.length) {
			
			if(l1[i] <= l2[j]) {
				arr[k++] = l1[i++];
			} else {
				count+= m +1 - (l+i);
				arr[k++] = l2[j++];
				
			}
		}
		
		while(i < l1.length) {
			arr[k++] = l1[i++];
		}
		while(j < l2.length) {
			arr[k++] = l2[j++];
			
		}
		System.out.println("count inside: "+count);
		return count;
	}
}
