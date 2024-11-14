package array;
import java.util.*;

public class Segregate01 {
	
	public static void main(String args[]) {
		
//		int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
//		int[] arr = {1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1};
		int[] arr = {0, 1, 2, 0, 1, 2};
//		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		System.out.println(Arrays.toString(arr));
		
//		segregate01(arr);
		segregate012(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void segregate012(int[] arr) {
		
		int m0=0, m2 = arr.length-1;
		
		for(int i=0; i<=m2; i++) {
			
			if(arr[i] == 0) {
				swap(arr, i, m0);
				m0++;
			} else if(arr[i] == 2) {
				swap(arr, i, m2);
				m2--;
				i--;
			}
		}
		
	}
	static void segregate01(int[] arr) {
		
		int min=0,  max=arr.length-1;
		
		for(int i=0; i<= max; i++) {
			if(arr[i] == 0) {
				swap(arr, i, min);
				min++;
			} else {
				swap(arr, i, max);
				max--;
				i--;
			}
		}
		
	}
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
