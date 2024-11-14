package array;

import java.util.*;

public class DutchFlag {
	
	public static void main(String args[]) {
		
		int[] arr = {2, 0, 2, 1, 1, 0};
		int[] arr2 = {2, 1, 0, 1};
		int[] arr3 = {0};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		
		new DutchFlag().place012(arr);
		new DutchFlag().place012(arr2);
		new DutchFlag().place012(arr3);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
	}
	public void place012(int[] arr) {
		
		DutchFlag obj = new DutchFlag();
		
		int l = 0, m = 0, r = arr.length - 1;
		
		while(m <= r) {
			
			if(arr[m] == 2) {
				obj.swap(arr, m, r);
				r--;
				continue;
			} else if(arr[m] == 0) {
				obj.swap(arr, m, l);
				l++;
			}
			m++;
		}
	}
	
	void swap(int[] arr, int i, int j) {
		
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}
}
