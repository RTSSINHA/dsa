package array;
import java.util.*;

public class MergeOverlap {
	
	public static void main(String args[]) {
		
//		int[] a1 = {1, 4, 8, 10};
//		int[] a2 = {2, 3, 9};
		
		int[] a1 = {1, 3, 5, 7};
		int[] a2 = {0, 2, 6, 8, 9};
		
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		
		overlap(a1, a2);
		
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
	}
	
	static void overlap(int[] a, int[] b) {
		
		int i = 0, j = 0;
		
		while(i < a.length) {
			
			if(a[i] <= b[j]) {
				i++;
			} else {
				int temp = a[i];
				a[i] = b[j];
				b[j] = temp;
				int k = j;
				while(j+1 < b.length && b[j] > b[j+1]) {
					b[j] = b[j] + b[j+1];
					b[j+1] = b[j] - b[j+1];
					b[j] = b[j] - b[j+1];
					j++;
				}
				j=0;
			}
		}
	}
}
