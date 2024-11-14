package bit;

import java.util.Arrays;

public class MaxOr {
	
	public static void main(String args[]) {
		
//		int[] arr = {3, 1};
//		int[] arr = {2, 2, 2};
		int[] arr = {3, 2, 1, 5}; 	
		System.out.println(Arrays.toString(arr));
		int maxOr = 0;
		for(int i: arr) maxOr = maxOr | i;
		System.out.println(maxOr);
	}
}
